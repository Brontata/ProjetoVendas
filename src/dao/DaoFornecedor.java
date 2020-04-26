/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Fornecedores;

/**
 *
 * @author aluno
 */
/**
 *
 * @author aluno
 */
public class DaoFornecedor extends Fornecedores {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        //Note que as "?" abaixo são os parámetros e
        //que a sentença "set dateformat dmy" só funciona no SQLServer
        String sql = "set dateformat dmy INSERT INTO pc_fornecedor ("
                //+ "Nome, Endereco, Cidade, bairro, "
                + "razao, fantasia, endereco, cidade, bairro, "
                + "UF, CEP, telefone, fax, cnpj, ie, datacad) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?)";

        // Usando o método estático criado em BancoSql
        this.conexao = BancoSql.getConnection();
        // Aplicando a intrução sql no PreparedStatement
        comandoSQL = conexao.prepareStatement(sql);
        //Preenchendo os parâmetros
        comandoSQL.setString(1, this.getRazao());
        comandoSQL.setString(2, this.getFantasia());
        comandoSQL.setString(3, this.getEndereco());
        comandoSQL.setString(4, this.getCidade());
        comandoSQL.setString(5, this.getBairro());
        comandoSQL.setString(6, this.getUf());
        comandoSQL.setString(7, this.getCep());
        comandoSQL.setString(8, this.getTelefone());
        comandoSQL.setString(9, this.getFax());
        comandoSQL.setString(10, this.getCnpj());
        comandoSQL.setString(11, this.getIe());
        
         
        //comandoSQL.setDate(9, (Date) getDatDataNasc());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDataCad().getTime());
        comandoSQL.setString(12, sdf.format(data));
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        
        String sql = "set dateformat dmy "
                + "UPDATE pc_fornecedor SET "
                + "razao=?, "
                + "fantasia=?, "
                + "endereco=?, "
                + "cidade=?, "
                + "bairro=?, "
                + "uf=?, "
                + "cep=?, "
                + "telefone=?, "
                + "fax=?, "
                + "cnpj=?, "
                + "ie=?, "
                + "datacad=? "
                + " WHERE codfor = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setString(1, this.getRazao());
        comandoSQL.setString(2, this.getFantasia());
        comandoSQL.setString(3, this.getEndereco());
        comandoSQL.setString(4, this.getCidade());
        comandoSQL.setString(5, this.getBairro());
        comandoSQL.setString(6, this.getUf());
        comandoSQL.setString(7, this.getCep());
        comandoSQL.setString(8, this.getTelefone());
        comandoSQL.setString(9, this.getFax());
        comandoSQL.setString(10, this.getCnpj());
        comandoSQL.setString(11, this.getIe());
        
        
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
        data = new Date(this.getDataCad().getTime());
        comandoSQL.setString(12, sdf.format(data));
        comandoSQL.setInt(13, this.getCodFor());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM pc_fornecedor "
                + "WHERE CODFOR = ?";

        //Note que o bloco try--catch é DESNECESÁRIO no exemplo, pois a cláusa 
        // 'throws' na assinatura do método já "lança" as Exceptions possiveis.
        // O try--catch abaixo está ai só para demonstrar outra maneira.
        try { //exemplo de "lançameno" manual de Exception
            this.conexao = BancoSql.getConnection();
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, this.getCodFor());
            boolean apagou = comandoSQL.execute();
            comandoSQL.close();
            this.conexao.close();
            return apagou;

        } catch (SQLException ex) { // Captura SQLException
            throw ex; //"Lança SQLException"
        } catch (ClassNotFoundException ex) { //Captura ClassNotFoundException
            throw ex; //"Lança ClassNotFoundException"
        }

    }
    public  ArrayList<DaoFornecedor> pesquisar (DaoFornecedor fornecedor) throws SQLException, ClassNotFoundException {
        DaoFornecedor fornecedorRetorno = null;
        String sql = "SELECT * FROM pc_fornecedor WHERE RAZAO LIKE ?";
      
        ArrayList<DaoFornecedor> listaFornecedores = new ArrayList<DaoFornecedor>();
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setString(1, "%" + fornecedor.getRazao()+ "%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            fornecedorRetorno = new DaoFornecedor();
            fornecedorRetorno.setCodFor(rs.getInt("CODFOR"));
            fornecedorRetorno.setRazao(rs.getString("RAZAO"));
            fornecedorRetorno.setFantasia(rs.getString("FANTASIA"));
            fornecedorRetorno.setEndereco(rs.getString("ENDERECO"));
            fornecedorRetorno.setCidade(rs.getString("CIDADE"));
            fornecedorRetorno.setBairro(rs.getString("BAIRRO"));
            fornecedorRetorno.setUf(rs.getString("UF"));
            fornecedorRetorno.setCep(rs.getString("CEP"));
            fornecedorRetorno.setTelefone(rs.getString("TELEFONE"));
            fornecedorRetorno.setFax(rs.getString("FAX"));
            fornecedorRetorno.setCnpj(rs.getString("CNPJ"));
            fornecedorRetorno.setIe(rs.getString("IE"));
            fornecedorRetorno.setDataCad(rs.getDate("DATACAD"));
            
            listaFornecedores.add(fornecedorRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaFornecedores;
    
}
}
