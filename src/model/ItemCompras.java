package model;

import java.sql.SQLException;

public class ItemCompras implements IMetodosPadrao{
    private int numCompra;
    private int codPro;
    private String descricao;
    private int quantidade;
    private double precoUnit;
    private double subtotal;

    public ItemCompras() {
        this(0, 0, "", 0, 0, 0);
    }

    public ItemCompras(int numCompra, int codPro, String descricao, int quantidade, double precoUnit, double subtotal) {
        this.numCompra = numCompra;
        this.codPro = codPro;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.subtotal = subtotal;
    }
    

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }
    
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "ItemCompras:" 
                + "\n Número da Compra: " + getNumCompra()
                + "\n Código do Produto: " + getCodPro()
                + "\n Descrição: " + getCodPro()
                + "\n Quantidade: " + getQuantidade()
                + "\n Preço Unitário: " + getPrecoUnit()
                + "\n Subtotal: " + getSubtotal() + "\n";
    }

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
