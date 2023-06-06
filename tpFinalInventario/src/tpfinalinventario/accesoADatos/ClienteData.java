/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tpfinalinventario.entidades.Cliente;

/**
 *
 * @author julie
 */
public class ClienteData {

    private static Connection c;
    private static PreparedStatement p;
    private static ResultSet r;

    public static void guardar(Cliente cliente) throws ClassNotFoundException, SQLException, Exception {

        c = Conexion.getConexion();
        String sql = "INSERT into cliente(dni, apellido,nombre,domicilio,telefono) values(?,?,?,?,?);";
        p = c.prepareStatement(sql);
        p.setInt(1,cliente.getDni());
        p.setString(2, cliente.getApellido());
        p.setString(3, cliente.getNombre());
        p.setString(4, cliente.getDomicilio());
        p.setString(5, cliente.getTelefono());
        p.execute();
        cerrar2();
    }

    public static void eliminar(int id) throws ClassNotFoundException, SQLException, Exception {

        c = Conexion.getConexion();
        String sql = "DELETE FROM cliente WHERE idCliente=?;";
        p = c.prepareStatement(sql);
        p.setInt(1, id);
        p.execute();
        cerrar2();
    }

    public static Cliente buscar(int id) throws ClassNotFoundException, SQLException, Exception {
        Cliente cliente = null;
        c = Conexion.getConexion();
        String sql = "SELECT * FROM cliente WHERE idCliente=?;";
        p = c.prepareStatement(sql);
        p.setInt(1, id);
        r = p.executeQuery();
        if (r.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(id);
            cliente.setDni(r.getInt("dni"));
            cliente.setApellido(r.getString("apellido"));
            cliente.setNombre(r.getString("nombre"));
            cliente.setNombre(r.getString("domicilio"));
            cliente.setNombre(r.getString("telefono"));
        }
        cerrar3();
        return cliente;
    }

    public static List<Cliente> lista() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Cliente> lista = new ArrayList();
        c = Conexion.getConexion();
        p = c.prepareStatement("select * from cliente;");
        r = p.executeQuery();
        while (r.next()) {
            Cliente cliente = new Cliente();
            cliente.setDni(r.getInt("dni"));
            cliente.setIdCliente(r.getInt("idCliente"));
            cliente.setApellido(r.getString("apellido"));
            cliente.setNombre(r.getString("nombre"));
            cliente.setDomicilio(r.getString("domicilio"));
            cliente.setTelefono(r.getString("telefono"));

        }
        cerrar3();
        return lista;
    }

    private static void cerrar2() throws SQLException {
        p.close();
        c.close();
    }

    private static void cerrar3() throws SQLException {
        p.close();
        r.close();
        c.close();
    }

}
