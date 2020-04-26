package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.ItemCompras;

public class DaoItemCompra extends ItemCompras{
    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;
    
    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pc_itemcompra "
                + "(numcompra, codpro, quantidade, precounit) "
                + "VALUES "
                + "(?, ?, ?, ?)";
        
        this.conexao = BancoSql.getConnection();
        
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setInt(1, getNumCompra());
        comandoSQL.setInt(2, getCodPro());
        comandoSQL.setInt(3, getQuantidade());
        comandoSQL.setDouble(4, getPrecoUnit());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pc_itemcompra SET "
                + "codpro = ?, "
                + "quantidade = ?, "
                + "precounit = ? "
                + "WHERE numcompra = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodPro());
        comandoSQL.setInt(2, this.getQuantidade());
        comandoSQL.setDouble(3, this.getPrecoUnit());
        
        comandoSQL.setInt(4, this.getNumCompra());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
    public boolean excluir() throws SQLException, ClassNotFoundException {
        
        String sql = "DELETE FROM pc_itemcompra "
                + "WHERE numcompra = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumCompra());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }
    
    public ArrayList<DaoItemCompra> pesquisar(DaoItemCompra item) throws SQLException, ClassNotFoundException {
        DaoItemCompra itemRetorno = null;
        String sql = "";
        
        if (item.getCodPro() >= 1) {
            sql = "SELECT numcompra, pc_itemcompra.codpro, pc_Produto.descricao, pc_itemcompra.quantidade, pc_itemcompra.precounit, "
                    + "(pc_itemcompra.quantidade * pc_itemcompra.precounit) AS Subtotal "
                    + "FROM pc_itemcompra INNER JOIN pc_Produto ON pc_itemcompra.codpro = pc_Produto.codpro "
                    + "WHERE pc_itemcompra.numcompra = ? and pc_itemcompra.codpro = ?";
        } else {
            sql = "SELECT numcompra, pc_itemcompra.codpro, pc_Produto.descricao, pc_itemcompra.quantidade, pc_itemcompra.precounit, "
                    + "(pc_itemcompra.quantidade * pc_itemcompra.precounit) AS Subtotal "
                    + "FROM pc_itemcompra INNER JOIN pc_Produto ON pc_itemcompra.codpro = pc_Produto.codpro "
                    + "WHERE numcompra = ?";
        }
        
        ArrayList<DaoItemCompra> listaItens = new ArrayList<DaoItemCompra>();
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        if (item.getCodPro()>= 1) {
            comandoSQL.setInt(1, item.getNumCompra());
            comandoSQL.setInt(2, item.getCodPro());
        } else {
            comandoSQL.setInt(1, item.getNumCompra());
        }
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            itemRetorno = new DaoItemCompra();
            itemRetorno.setNumCompra(rs.getInt("numcompra"));
            itemRetorno.setCodPro(rs.getInt("codpro"));
            itemRetorno.setDescricao(rs.getString("descricao"));
            itemRetorno.setQuantidade(rs.getInt("quantidade"));
            itemRetorno.setPrecoUnit(rs.getDouble("precounit"));
            itemRetorno.setSubtotal(rs.getDouble("subtotal"));
            
            listaItens.add(itemRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaItens;
    }
    
    public ArrayList<DaoItemCompra> pesquisarItem(DaoItemCompra item) throws SQLException, ClassNotFoundException {
        DaoItemCompra itemRetorno = null;
        String sql = "";
        
            sql = "SELECT numcompra, pc_itemcompra.codpro, pc_Produto.descricao, pc_itemcompra.quantidade, pc_itemcompra.precounit, "
                    + "(pc_itemcompra.quantidade * pc_itemcompra.precounit) AS Subtotal "
                    + "FROM pc_itemcompra INNER JOIN pc_Produto ON pc_itemcompra.codpro = pc_Produto.codpro "
                    + "WHERE numcompra = ? AND pc_itemcompra.codpro = ?";
        
        
        ArrayList<DaoItemCompra> listaItens = new ArrayList<DaoItemCompra>();
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

            comandoSQL.setInt(1, item.getNumCompra());
            comandoSQL.setInt(2, item.getCodPro());

        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            itemRetorno = new DaoItemCompra();
            itemRetorno.setNumCompra(rs.getInt("numcompra"));
            itemRetorno.setCodPro(rs.getInt("codpro"));
            itemRetorno.setDescricao(rs.getString("descricao"));
            itemRetorno.setQuantidade(rs.getInt("quantidade"));
            itemRetorno.setPrecoUnit(rs.getDouble("precounit"));
            itemRetorno.setSubtotal(rs.getDouble("subtotal"));
            
            listaItens.add(itemRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaItens;
    }
}
