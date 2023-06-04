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
import tpfinalinventario.entidades.Cliente;

/**
 *
 * @author julie
 */
public class ClienteData {
     private static Connection c;
     private static PreparedStatement p;
    
    
    public static void insertar(Cliente cliente) throws ClassNotFoundException, SQLException,Exception{
        
        c = Conexion.getConexion();
        String sql="INSERT into cliente(apellido,nombre,domicilio,telefono) values(?,?,?,?)";
        p=c.prepareStatement(sql);
        p.setString(1, cliente.getApellido());
        p.setString(2,cliente.getNombre());
        p.setString(3, cliente.getDomicilio());
        p.setString(4, cliente.getTelefono());
        p.execute();
        p.close();
        c.close();
    }
    
    
     public static void eliminar(int id) throws ClassNotFoundException, SQLException,Exception{
        
        c = Conexion.getConexion();
        String sql="DELETE FROM cliente WHERE idCliente=?";
        p=c.prepareStatement(sql);
        p.setInt(1,id);
        p.execute();
        p.close();
        c.close();
    }
     
    public static Cliente buscar(int id) throws ClassNotFoundException, SQLException,Exception{
        Cliente cliente = null;
        c = Conexion.getConexion();
        String sql="SELECT * FROM cliente WHERE idCliente=?";
        p=c.prepareStatement(sql);
        p.setInt(1,id);
        ResultSet r=p.executeQuery();
        if(r.next()){
            cliente=new Cliente();
            cliente.setIdCliente(id);
            cliente.setApellido(r.getString("apellido"));
            cliente.setNombre(r.getString("nombre"));
            cliente.setNombre(r.getString("domicilio"));
            cliente.setNombre(r.getString("telefono"));
        }
        return cliente;
    }
    
    
}
