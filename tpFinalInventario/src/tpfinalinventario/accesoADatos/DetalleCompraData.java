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
import tpfinalinventario.entidades.DetalleCompra;

/**
 *
 * @author julie
 */
public class DetalleCompraData {
    
     private static Connection c;
     private static PreparedStatement p;
     private static ResultSet r;
    
    public static void guardar(DetalleCompra dc) throws ClassNotFoundException, SQLException,Exception{
        c=Conexion.getConexion();
        p=c.prepareStatement("insert into detallecompra(cantidad,precioCosto,idCompra,idProducto) values(?,?,?,?)");
        p.setInt(1, dc.getCantidad());
        p.setDouble(2, dc.getPrecioCosto());
        p.setInt(3,dc.getCompra().getIdCompra());
        p.setInt(4, dc.getProducto().getIdProducto());
        p.execute();
        cerrar2();
    }
    
      
     public static void eliminar(int id) throws ClassNotFoundException, SQLException,Exception{
        
        c = Conexion.getConexion();
        p=c.prepareStatement("DELETE FROM detallecompra WHERE idDetalle=?;");
        p.setInt(1,id);
        p.execute();
        cerrar2();
    }
     
    public static DetalleCompra buscar(int id) throws ClassNotFoundException, SQLException,Exception{
        DetalleCompra dc = null;
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM detallecompra WHERE idDetalle=?;");
        p.setInt(1,id);
        r=p.executeQuery();
        if(r.next()){
            dc=new DetalleCompra();
            dc.setIdDetalle(r.getInt("idDetalle"));
            dc.setCantidad(r.getInt("cantidad"));
            dc.setPrecioCosto(r.getDouble("precioCosto"));
            dc.setCompra(CompraData.buscar(r.getInt("idCompra")));
            dc.setProducto(ProductoData.buscar(r.getInt("idProducto")));          
          
        }
        cerrar3();
        return dc;
    }
   
    
    
  
       public static List<DetalleCompra> lista() throws ClassNotFoundException, SQLException,Exception {
        ArrayList<DetalleCompra> lista=new ArrayList();
        c=Conexion.getConexion();
        p=c.prepareStatement("select * from DetalleCompra;");
        r=p.executeQuery();
        while(r.next()){
            DetalleCompra dc= new DetalleCompra(); 
            dc.setIdDetalle(r.getInt("idDetalle"));
            dc.setCantidad(r.getInt("cantidad"));
            dc.setPrecioCosto(r.getDouble("precioCosto"));
            dc.setCompra(CompraData.buscar(r.getInt("idCompra")));
            dc.setProducto(ProductoData.buscar(r.getInt("idProducto")));  
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
