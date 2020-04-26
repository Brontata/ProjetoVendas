/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class ItemVendas implements IMetodosPadrao {
    private int numVenda;
    private int codPro;
    private String descricao;
    private int quantidade;
    private double precoUnit;
    private double subtotal;
    
    public ItemVendas() {
        this(0, 0, "", 0, 0, 0);
    }

    public ItemVendas(int numVenda, int codPro, String descricao, int quantidade,
            double precoUnit, double subtotal) {
    this.numVenda = numVenda;
    this.codPro = codPro;
    this.descricao = descricao;
    this.quantidade = quantidade;
    this.precoUnit = precoUnit;
    this.subtotal = subtotal;
    }
    

    public int getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
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
    public String toString(){
        return "\nItem: "
                + "\n Número da venda: " +getNumVenda()
                + "\n Código do produto: " + getCodPro()
                + "\n Descrição: " + getDescricao()
                + "\n Quantidade: " + getQuantidade()
                + "\n Preço Unitário; " + getPrecoUnit()
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
