/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tpfinalinventario.entidades.DetalleCompra;
import tpfinalinventario.entidades.Venta;

/**
 *
 * @author julie
 */
public class VentaData {
    
    private static Connection c;
    private static PreparedStatement p;
    private static ResultSet r;
    
       public static void guardar(Venta v) throws ClassNotFoundException, SQLException,Exception{
        c=Conexion.getConexion();
        p=c.prepareStatement("insert into venta(fecha,idCliente) values(?,?)");
        p.setDate(1,Date.valueOf(v.getFecha()));
        p.setDouble(2, v.getCliente().getIdCliente());
        p.execute();
        cerrar2();
    }
       
       public static void eliminar(int id) throws ClassNotFoundException, SQLException,Exception{
        
        Connection c = Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("DELETE FROM venta WHERE idVenta=?;");
        p.setInt(1,id);
        p.execute();
        cerrar2();
    }
     
    public static Venta buscar(int id) throws ClassNotFoundException, SQLException,Exception{
        Venta v = null;
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM venta WHERE idVenta=?;");
        p.setInt(1,id);
        r=p.executeQuery();
        if(r.next()){
            v=new Venta();
            v.setIdVenta(id);
            v.setFecha(r.getDate("fecha").toLocalDate());
            v.setCliente(ClienteData.buscar(r.getInt("idCliente")));        
          
        }
        cerrar3();
        return v;
    }
   
    
    
  
       public static List<DetalleCompra> lista() throws ClassNotFoundException, SQLException,Exception {
        ArrayList<DetalleCompra> lista=new ArrayList();
        c=Conexion.getConexion();
       p=c.prepareStatement("select * from venta;");
        r=p.executeQuery();
        while(r.next()){
            Venta v=new Venta();
            v.setIdVenta(r.getInt("idVenta"));
            v.setFecha(r.getDate("fecha").toLocalDate());
            v.setCliente(ClienteData.buscar(r.getInt("idCliente")));  
        }
        cerrar3();
        return lista;
    }
       
       
       private static void cerrar2() throws SQLException{
           p.close();
           c.close();
       }
       
       private static void cerrar3() throws SQLException{
           p.close();
           r.close();
           c.close();
       }
}
