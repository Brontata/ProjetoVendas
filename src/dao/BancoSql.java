/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author aluno
 */
    public class BancoSql {       
    private static String servidor = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private static String urlBanco = "jdbc:sqlserver://motorhead;";                     
    private static String urlBanco = "jdbc:sqlserver://GUILHERME\\MOTOREHEAD;";          //casa           
    private static String nomeBanco = "databaseName=db_05405_14_A_1_2017;";
    private static String usuario = "user=05405_14_A_1_2017;";
    private static String senha = "password=Mayara@123";
    
    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName(servidor);
        return DriverManager.getConnection(urlBanco + nomeBanco + usuario + senha);
    }
    
}
