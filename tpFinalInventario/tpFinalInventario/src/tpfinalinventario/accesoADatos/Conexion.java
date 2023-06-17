/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author julie
 */
public class Conexion {

    private final static String URL = "jdbc:mariadb://localhost/";
    private final static String DB = "fravemax_gp8";
    private final static String USER = "root";
    private final static String PASS = "";

    private static Connection connection;

    private Conexion() {

    }

    public static Connection getConexion() {
        if (connection == null) {

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB+"?useLegacyDataTimeCode=false&serverTimeZone=UTC"+"&user="+USER+"&password="+PASS);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar los drivers, "+ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse a la DB, "+ex.getMessage());
            }
        }

        return connection;  //retorno la conexion 

    }
}
