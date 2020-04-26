/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author aluno
 */
public abstract class Fornecedores implements IMetodosPadrao {

    private int codFor;
    private String razao;
    private String fantasia;
    private String endereco;
    private String cidade;
    private String bairro;
    private String uf;
    private String cep;
    private String telefone;
    private String fax;
    private String cnpj;
    private String ie;
    private Date dataCad;

    public Fornecedores() {
      this(0, "", "", "", "", "", "", "", "", "", "", "", new Date ());
    }

    
    public Fornecedores(int codFor, String razao, String fantasia, 
     String endereco, String cidade, String bairro, String uf, String cep,
    String telefone, String fax, String cnpj, String ie, Date dataCad) {
        this.codFor = codFor;
        this.razao = razao;
        this.fantasia = fantasia;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.fax = fax;
        this.cnpj = cnpj;
        this.ie = ie;
        this.dataCad = dataCad;
    }

    public int getCodFor() {
        return codFor;
    }

    public void setCodFor(int codFor) {
        this.codFor = codFor;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    
}

