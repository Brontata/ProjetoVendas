/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Vendas;

/**
 *
 * @author aluno
 */
public class DaoVenda extends Vendas {
    
   private Connection conexao;
   private PreparedStatement comandoSQL;
   private Date data;
    
   @Override
   public void incluir() throws SQLException, ClassNotFoundException{
   String sql = "set dateformat dmy INSERT INTO pc_venda "
           + "( codCli, dataVenda, dataEntrega, obs) "
           + "VALUES "
           + "(?,?,?,?)";
   
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   this.conexao = BancoSql.getConnection();
   comandoSQL = conexao.prepareStatement(sql);
   
   comandoSQL.setInt(1, this.getCodCli());
   comandoSQL.setString(2, sdf.format(this.getDataVenda()));
   comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
   comandoSQL.setString(4, this.getObs());
   
   comandoSQL.execute();
   comandoSQL.close();
   this.conexao.close();
   }
   @Override
   public void alterar() throws SQLException, ClassNotFoundException{
   String sql = "set dateformat dmy "
           + "UPDATE pc_venda SET "
           + "codCli = ?, "
           + "dataVenda = ?, "
           + "dataEntrega = ?, "
           + "obs = ? "
           + "WHERE numVenda = ? ";
   
   this.conexao = BancoSql.getConnection();
   comandoSQL = conexao.prepareStatement(sql);
   comandoSQL.setInt(1, this.getCodCli());
   
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   comandoSQL.setString(2, sdf.format(this.getDataVenda()));
   comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
   comandoSQL.setString(4, this.getObs());
   
   comandoSQL.setInt(5, this.getNumVenda());
   comandoSQL.execute();
   comandoSQL.close();
   this.conexao.close();
   }
   @Override
   public boolean excluir() throws SQLException, ClassNotFoundException{
   String sql = "DELETE FROM pc_venda WHERE numvenda = ?";
   this.conexao = BancoSql.getConnection();
   comandoSQL = conexao.prepareStatement(sql);
   comandoSQL.setInt(1, this.getNumVenda());
   boolean apagou = comandoSQL.execute();
   comandoSQL.close();
   this.conexao.close();
   return apagou;
        
   }
   public ArrayList<DaoVenda> pesquisar (DaoVenda venda) throws  SQLException, ClassNotFoundException{
   DaoVenda vendaRetorno = null;
   String sql = "";
   
       if (venda.getNumVenda() > 0) {
           sql = "set dateformat dmy SELECT numVenda, pc_venda.codcli, nome, dataVenda, dataEntrega, obs "
                   + "FROM pc_venda INNER JOIN pc_cliente ON pc_venda.codcli = pc_cliente.codcli "
                   + "WHERE numVenda = ?";
       } else {
           sql = "set dateformat dmy SELECT numVenda, pc_venda.codcli, nome, dataVenda, dataEntrega, obs "
                   + "FROM pc_venda INNER JOIN pc_cliente ON pc_venda.codcli = pc_cliente.codcli";
           
       }
       ArrayList<DaoVenda> listaVendas = new ArrayList<DaoVenda>();
       this.conexao = BancoSql.getConnection();
       comandoSQL = conexao.prepareStatement(sql);
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       if (venda.getNumVenda() > 0) {
           comandoSQL.setInt(1, venda.getNumVenda());
       } 
       ResultSet rs = comandoSQL.executeQuery();
       
       while (rs.next()) {
           vendaRetorno = new DaoVenda();
           vendaRetorno.setNumVenda(rs.getInt("numvenda"));
           vendaRetorno.setCodCli(rs.getInt("codcli"));
           vendaRetorno.setNome(rs.getString("nome"));
           vendaRetorno.setDataVenda(rs.getDate("datavenda"));
           vendaRetorno.setDataEntrega(rs.getDate("dataentrega"));
           vendaRetorno.setObs(rs.getString("obs"));

           listaVendas.add(vendaRetorno);
           
       }
       rs.close();
       
       comandoSQL.close();
       this.conexao.close();
       
       return listaVendas;
   }
}
