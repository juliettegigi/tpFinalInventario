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
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author julie
 */
public class ProveedorData {
    
    public static void guardar(Proveedor proveedor) throws ClassNotFoundException, SQLException{
        Connection c=Conexion.getConexion();
        String sql="INSERT INTO proveedor(razonSocial,domicilio,telefono)VALUES(?,?,?)";
        PreparedStatement p=c.prepareStatement(sql);
        p.setString(1, proveedor.getRazonSocial());
        p.setString(2, proveedor.getDomicilio());
        p.setString(3, proveedor.getTelefono());
        p.execute();
        p.close();
        c.close();
    }
    
        public static void eliminar(int id) throws ClassNotFoundException, SQLException{
        Connection c=Conexion.getConexion();
        String sql="DELETE FROM proveedor WHERE idProveedor=?";
        PreparedStatement p=c.prepareStatement(sql);
        p.setInt(1,id);
        p.execute();
        p.close();
        c.close();
    }
        
        public static Proveedor buscar(int id) throws ClassNotFoundException, SQLException{
        Connection c=Conexion.getConexion();
        String sql="SELECT * FROM proveedor WHERE idProveedor=?";
        PreparedStatement p=c.prepareStatement(sql);
        p.setInt(1,id);
        ResultSet r=p.executeQuery();
        Proveedor proveedor=null;
        if(r.next()){
            proveedor=new Proveedor();
            proveedor.setRazonSocial(r.getString("razonSocila"));
            proveedor.setDomicilio(r.getString("domicilio"));
            proveedor.setTelefono(r.getString("telefono"));
            proveedor.setIdProveedor(id);
        }
        p.close();
        c.close();
        return proveedor;
    }
    
}
