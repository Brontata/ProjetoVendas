package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Clientes;

/**
 *
 * @author aluno
 */
public class DaoCliente extends Clientes {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        //Note que as "?" abaixo são os parámetros e
        //que a sentença "set dateformat dmy" só funciona no SQLServer
        String sql = "set dateformat dmy INSERT INTO pc_cliente ("
                + "Nome, Endereco, Cidade, bairro, "
                + "UF, CEP, telefone, DataNasc) VALUES "
                + "(?,?,?,?,?,?,?,?)";

        // Usando o método estático criado em BancoSql
        this.conexao = BancoSql.getConnection();
        // Aplicando a intrução sql no PreparedStatement
        comandoSQL = conexao.prepareStatement(sql);
        //Preenchendo os parâmetros
        comandoSQL.setString(1, this.getNome());
        comandoSQL.setString(2, this.getEndereco());
        comandoSQL.setString(3, this.getCidade());
        comandoSQL.setString(4, this.getBairro());
        comandoSQL.setString(5, this.getUf());
        comandoSQL.setString(6, this.getCep());
        comandoSQL.setString(7, this.getTelefone());

        /**
         * Use as linhas abaixo para incluir a data formatada OBS: O
         * SimpleDateFormat declarado abaixo com o nome e "sdf" Retorna a data
         * formatada com uma String, por isso ela é inclusa assim:
         * comandoSQL.setString(9, sdf.format(data)); se fosse do tipo Date,
         * seria assim: comandoSQL.setDate(9, data);
         */
        //comandoSQL.setDate(9, (Date) getDatDataNasc());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDataNasc().getTime());
        comandoSQL.setString(8, sdf.format(data));
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        
        String sql = "set dateformat dmy "
                + "UPDATE pc_cliente SET "
                + "Nome=?, "
                + "Endereco=?, "
                + "Cidade=?, "
                + "bairro=?, "
                + "UF=?, "
                + "CEP=?, "
                + "Telefone=?, "
                + "DataNasc=? "
                + "WHERE CodCli = ?";
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setString(1, this.getNome());
        comandoSQL.setString(2, this.getEndereco());
        comandoSQL.setString(3, this.getCidade());
        comandoSQL.setString(4, this.getBairro());
        comandoSQL.setString(5, this.getUf());
        comandoSQL.setString(6, this.getCep());
        comandoSQL.setString(7, this.getTelefone());
        
        SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
        data = new Date(this.getDataNasc().getTime());
        comandoSQL.setString(8, sdf.format(data));
        comandoSQL.setInt(9, this.getCodCli());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM pc_cliente "
                + "WHERE CODCLI = ?";

        //Note que o bloco try--catch é DESNECESÁRIO no exemplo, pois a cláusa 
        // 'throws' na assinatura do método já "lança" as Exceptions possiveis.
        // O try--catch abaixo está ai só para demonstrar outra maneira.
        try { //exemplo de "lançameno" manual de Exception
            this.conexao = BancoSql.getConnection();
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, this.getCodCli());
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
    public  ArrayList<DaoCliente> pesquisar (DaoCliente cliente) throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno = null;
        String sql = "SELECT * FROM pc_cliente WHERE NOME LIKE ?";
      
        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();
        
        this.conexao = BancoSql.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setString(1, "%" + cliente.getNome() + "%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            clienteRetorno = new DaoCliente();
            clienteRetorno.setCodCli(rs.getInt("CODCLI"));
            clienteRetorno.setNome(rs.getString("NOME"));
            clienteRetorno.setEndereco(rs.getString("ENDERECO"));
            clienteRetorno.setCidade(rs.getString("CIDADE"));
            clienteRetorno.setBairro(rs.getString("BAIRRO"));
            clienteRetorno.setUf(rs.getString("UF"));
            clienteRetorno.setCep(rs.getString("CEP"));
            clienteRetorno.setTelefone(rs.getString("TELEFONE"));
            clienteRetorno.setDataNasc(rs.getDate("DATANASC"));
            
            listaClientes.add(clienteRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaClientes;
    }
}