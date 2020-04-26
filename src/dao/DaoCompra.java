package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Compras;

public class DaoCompra extends Compras{
    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;
    
    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy INSERT INTO pc_compra "
                + "( codfor, datacompra, dataentrega, obs) "
                + "VALUES "
                + "(?, ?, ?, ?)";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setInt(1, this.getCodFor());
        comandoSQL.setString(2, sdf.format(this.getDataCompra()));
        comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
        comandoSQL.setString(4, this.getObs());
        
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy "
                + "UPDATE pc_compra SET "
                + "codfor = ?, "
                + "dataCompra = ?, "
                + "dataEntrega = ?, "
                + "obs = ? "
                + "WHERE numcompra = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodFor());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        comandoSQL.setString(2, sdf.format(this.getDataCompra()));
        comandoSQL.setString(3, sdf.format(this.getDataEntrega()));
        comandoSQL.setString(4, this.getObs());
        comandoSQL.setInt(5, this.getNumCompra());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM pc_compra "
                + "WHERE numcompra = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumCompra());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }
    
    public ArrayList<DaoCompra> pesquisar(DaoCompra compra) throws SQLException, ClassNotFoundException {
        DaoCompra compraRetorno = null;
        String sql = "";
        
        if (compra.getNumCompra()> 0) {
            sql = "set dateformat dmy SELECT numcompra, pc_compra.codfor, fantasia, dataCompra, dataEntrega, obs "
                    + "FROM pc_compra INNER JOIN pc_fornecedor ON pc_compra.codfor = pc_fornecedor.codfor "
                    + "WHERE numcompra = ?";
        } else {
            sql = "set dateformat dmy SELECT numcompra, pc_compra.codfor, fantasia, dataCompra, dataEntrega, obs "
                    + "FROM pc_compra INNER JOIN pc_fornecedor ON pc_compra.codfor = pc_fornecedor.codfor ";
        }
        
        ArrayList<DaoCompra> listaCompras = new ArrayList<DaoCompra>();
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if (compra.getNumCompra()> 0) {
            comandoSQL.setInt(1, compra.getNumCompra());
        } else {
            
        }
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            compraRetorno = new DaoCompra();
            compraRetorno.setNumCompra(rs.getInt("numcompra"));
            compraRetorno.setCodFor(rs.getInt("codfor"));
            compraRetorno.setFantasia(rs.getString("fantasia"));
            compraRetorno.setDataCompra(rs.getDate("datacompra"));
            compraRetorno.setDataEntrega(rs.getDate("dataentrega"));
            compraRetorno.setObs(rs.getString("obs"));
            
            listaCompras.add(compraRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaCompras;
    }
    
    public ArrayList<DaoCompra> aparecer() throws SQLException, ClassNotFoundException {
        DaoCompra compraRetorno = null;
        String sql = "";
        
            sql = "set dateformat dmy SELECT numcompra, pc_compra.codfor, fantasia, dataCompra, dataEntrega, obs "
                    + "FROM pc_compra INNER JOIN pc_fornecedor ON pc_compra.codfor = pc_fornecedor.codfor";
        
        ArrayList<DaoCompra> listaCompras = new ArrayList<DaoCompra>();
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ResultSet rs = comandoSQL.executeQuery();
        while (rs.next()) {
            compraRetorno = new DaoCompra();
            compraRetorno.setNumCompra(rs.getInt("numcompra"));
            compraRetorno.setCodFor(rs.getInt("codfor"));
            compraRetorno.setFantasia(rs.getString("fantasia"));
            compraRetorno.setDataCompra(rs.getDate("datacompra"));
            compraRetorno.setDataEntrega(rs.getDate("dataentrega"));
            compraRetorno.setObs(rs.getString("obs"));
            listaCompras.add(compraRetorno);
        }
        rs.close();
        comandoSQL.close();
        this.conexao.close();
        return listaCompras;
    }
}
