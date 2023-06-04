/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author julie
 */
public class Conexion {
    
    private final static String URL = "jdbc:mariadb://localhost/fravemax_gp8";
    private final static String USER = "root";
    private final static String PASS = "";

    private static Connection con;


    public static Connection getConexion() throws ClassNotFoundException, SQLException {

      
        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(URL, USER, PASS);
        return con;  //retorno la conexion o una excepción

    }
}
