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
import tpfinalinventario.entidades.DetalleCompra;
import tpfinalinventario.entidades.DetalleVenta;

/**
 *
 * @author julie
 */
public class DetalleVentaData {
    
    
     private static Connection c;
     private static PreparedStatement p;
     private static ResultSet r;
        
       public static void guardar(DetalleVenta dv) throws ClassNotFoundException, SQLException,Exception{
        c=Conexion.getConexion();
        p=c.prepareStatement("insert into detalleventa(cantidad,precioVenta,idVenta,idProducto) values(?,?,?,?)");
        p.setInt(1, dv.getCantidad());
        p.setDouble(2, dv.getPrecioVenta());
        p.setInt(3,dv.getVenta().getIdVenta());
        p.setInt(4, dv.getProducto().getIdProducto());
        p.execute();
        cerrar2();
    }
       
       
           public static void eliminar(int id) throws ClassNotFoundException, SQLException,Exception{
        
        c = Conexion.getConexion();
        p=c.prepareStatement("DELETE FROM detalleventa WHERE idDetalleVenta=?;");
        p.setInt(1,id);
        p.execute();
        cerrar2();
    }
     
    public static DetalleVenta buscar(int id) throws ClassNotFoundException, SQLException,Exception{
        DetalleVenta dv = null;
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM detalleventa WHERE idDetalleVenta=?;");
        p.setInt(1,id);
       ResultSet r=p.executeQuery();
        if(r.next()){
            dv=new DetalleVenta();
            dv.setIdDetalleVenta(id);
            dv.setCantidad(r.getInt("cantidad"));
            dv.setPrecioVenta(r.getDouble("precioVenta"));
            dv.setVenta(VentaData.buscar(r.getInt("idVenta")));
            dv.setProducto(ProductoData.buscarPorId(r.getInt("idProducto")));      
          
        }
        cerrar3();
        return dv;
    }
   
    
    
  
       public static List<DetalleVenta> lista() throws ClassNotFoundException, SQLException,Exception {
        ArrayList<DetalleVenta> lista=new ArrayList();
        c=Conexion.getConexion();
        p=c.prepareStatement("select * from DetalleVenta;");
        ResultSet r=p.executeQuery();
        while(r.next()){
            DetalleVenta dv= new DetalleVenta(); 
            dv.setIdDetalleVenta(r.getInt("idDetalleVenta"));
            dv.setCantidad(r.getInt("cantidad"));
            dv.setPrecioVenta(r.getDouble("precioVenta"));
            dv.setVenta(VentaData.buscar(r.getInt("idVenta")));
            dv.setProducto(ProductoData.buscarPorId(r.getInt("idProducto")));  
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
