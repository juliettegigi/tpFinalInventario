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
import tpfinalinventario.entidades.Compra;
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author julie
 */
public class ProveedorData {

    private static Connection c;
    private static PreparedStatement p;
    private static ResultSet r;

    public static void guardar(Proveedor proveedor) throws ClassNotFoundException, SQLException {
        c = Conexion.getConexion();
        String sql = "INSERT INTO proveedor(razonSocial,domicilio,telefono)VALUES(?,?,?)";
        p = c.prepareStatement(sql);
        p.setString(1, proveedor.getRazonSocial());
        p.setString(2, proveedor.getDomicilio());
        p.setString(3, proveedor.getTelefono());
        p.execute();
        cerrar2();
    }

    public static void eliminar(int id) throws ClassNotFoundException, SQLException {
        c = Conexion.getConexion();
        String sql = "DELETE FROM proveedor WHERE idProveedor=?";
        p = c.prepareStatement(sql);
        p.setInt(1, id);
        p.execute();
        cerrar2();
    }

    public static Proveedor buscar(int id) throws ClassNotFoundException, SQLException {
        c = Conexion.getConexion();
        String sql = "SELECT * FROM proveedor WHERE idProveedor=?";
        p = c.prepareStatement(sql);
        p.setInt(1, id);
        r = p.executeQuery();
        Proveedor proveedor = null;
        if (r.next()) {
            proveedor = new Proveedor();
            proveedor.setRazonSocial(r.getString("razonSocila"));
            proveedor.setDomicilio(r.getString("domicilio"));
            proveedor.setTelefono(r.getString("telefono"));
            proveedor.setIdProveedor(id);
        }
        cerrar3();
        return proveedor;
    }

    public static List<Proveedor> lista() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Proveedor> lista = new ArrayList();
        c = Conexion.getConexion();
        p = c.prepareStatement("select * from proveedor;");
        r = p.executeQuery();
        while (r.next()) {
            Proveedor proveedor = new Proveedor();
            proveedor.setIdProveedor(r.getInt("idProveedor"));
            proveedor.setRazonSocial(r.getString("razonSocial"));
            proveedor.setDomicilio(r.getString("domicilio"));
            proveedor.setTelefono(r.getString("telefono"));
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
