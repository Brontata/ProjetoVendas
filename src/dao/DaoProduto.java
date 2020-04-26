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
import java.util.ArrayList;
import java.util.Date;
import model.Produtos;


public class DaoProduto extends Produtos {
    
    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;
    
    @Override
    public void incluir() throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO pc_produto("
                + "descricao, quantidade, precounit) "
                + " VALUES (?,?,?)";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL= conexao.prepareStatement(sql);
        comandoSQL.setString(1,this.getDescricao());
        comandoSQL.setInt(2, this.getQuantidade());
        comandoSQL.setDouble(3, this.getPrecoUnit());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
    String sql= "UPDATE pc_produto SET "
            + "descricao= ?, "
            + "quantidade= ?, "
            + "precounit=? "
            + "WHERE codpro = ?";
    this.conexao = BancoSql.getConnection();
    comandoSQL = conexao.prepareStatement(sql);
    comandoSQL.setString(1, this.getDescricao());
    comandoSQL.setInt(2, this.getQuantidade());
    comandoSQL.setDouble(3, this.getPrecoUnit());
    comandoSQL.setInt(4, this.getCodPro());
    comandoSQL.execute();
    comandoSQL.close();
   this.conexao.close();
    }
    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
    String sql = "DELETE FROM pc_produto "
            + "WHERE codpro = ? ";
        try {
            this.conexao = BancoSql.getConnection();
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, this.getCodPro());
            boolean apagou = comandoSQL.execute();
            comandoSQL.close();
            this.conexao.close();
            return apagou;
        } catch (SQLException ex) {
            throw ex;
        }catch (ClassNotFoundException ex) {
            throw  ex;
        }
    }
    public ArrayList<DaoProduto> pesquisar(DaoProduto produto) throws SQLException, ClassNotFoundException{
    DaoProduto produtoRetorno;
    String sql = "Select * FROM pc_produto WHERE descricao LIKE ?";
     
        ArrayList<DaoProduto> listaProdutos = new ArrayList<DaoProduto>();
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setString(1, "%" + produto.getDescricao() + "%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) { 
            produtoRetorno = new DaoProduto();
            produtoRetorno.setCodPro(rs.getInt("CODPRO"));
            produtoRetorno.setDescricao(rs.getString("DESCRICAO"));
            produtoRetorno.setQuantidade(rs.getInt("QUANTIDADE"));
            produtoRetorno.setPrecoUnit(rs.getDouble("PRECOUNIT"));
            listaProdutos.add(produtoRetorno);
            
        }
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaProdutos;
    }
}

