package model;

import java.sql.SQLException;
import java.util.Date;

public class Compras implements IMetodosPadrao{
    private int numCompra;
    private int codFor;
    private String fantasia;
    private Date dataCompra;
    private Date dataEntrega;
    private String obs;

    public Compras() {
        this(0, 0, "", new Date(), new Date(), "");
    }

    public Compras(int numCompra, int codFor, String fantasia, Date dataCompra, Date dataEntrega, String obs) {
        this.numCompra = numCompra;
        this.codFor = codFor;
        this.fantasia = fantasia;
        this.dataCompra = dataCompra;
        this.dataEntrega = dataEntrega;
        this.obs = obs;
    }

    

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getCodFor() {
        return codFor;
    }

    public void setCodFor(int codFor) {
        this.codFor = codFor;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Compras:" 
                + "\n Número da Compra: " + getNumCompra()
                + "\n Código do Fornecedor: " + getCodFor()
                + "\n Fantasia: " + getFantasia()
                + "\n Data da Compra: " + getDataCompra()
                + "\n Data da Entrega: " + getDataEntrega()
                + "\n Obs: " + getObs() + "\n";
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
