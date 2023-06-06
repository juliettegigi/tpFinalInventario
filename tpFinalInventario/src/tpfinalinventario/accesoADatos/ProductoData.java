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
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class ProductoData {
    
    
    
    
     private static Connection c;
     private static PreparedStatement p;
     private static ResultSet r;
    
     
       public static void guardar(Producto producto) throws ClassNotFoundException, SQLException,Exception{
        c=Conexion.getConexion();
        p=c.prepareStatement("insert into producto(nombre,descripcion,precioActual,stock,estado) values(?,?,?,?,?)");
        p.setString(1, producto.getNombre());
        p.setString(2,producto.getDescripcion());
        p.setDouble(3, producto.getPrecioActual());
        p.setInt(4,producto.getStock());
        p.setBoolean(5, producto.isEstado());
        p.execute();
        cerrar2();
    }
       
         
     public static void eliminar(int id) throws ClassNotFoundException, SQLException,Exception{
        
        c = Conexion.getConexion();
        p=c.prepareStatement("DELETE FROM compra WHERE idCompra=?;");
        p.setInt(1,id);
        p.execute();
        cerrar2();
    }
     
    public static List<Producto> buscar(String campo,String valor) throws ClassNotFoundException, SQLException,Exception{
        ArrayList<Producto> lista= new ArrayList();
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM producto WHERE "+campo+"=?;");
        p.setString(1,valor);
        
        
        r=p.executeQuery();
        while(r.next()){
            Producto producto=new Producto();
            producto.setIdProducto(r.getInt("idProducto"));
            producto.setNombre(r.getString("nombre"));
            producto.setDescripcion(r.getString("descripcion"));
            producto.setPrecioActual(r.getDouble("precioActual"));
            producto.setStock(r.getInt("stock"));
            producto.setEstado(r.getBoolean("estado"));
            lista.add(producto);
        }
        cerrar3();
        return lista;
    }
   
    
        public static Producto buscarPorId(int id) throws ClassNotFoundException, SQLException,Exception{
        Producto producto = null;
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM producto WHERE idCompra=?;");
        p.setInt(1,id);
        r=p.executeQuery();
        if(r.next()){
            producto=new Producto();
            producto.setIdProducto(id);
            producto.setNombre(r.getString("nombre"));
            producto.setDescripcion(r.getString("descripcion"));
            producto.setPrecioActual(r.getDouble("precioActual"));
            producto.setStock(r.getInt("stock"));
            producto.setEstado(r.getBoolean("estado"));
          
        }
        cerrar3();
        return producto;
    }
  
       public static List<Producto> lista() throws ClassNotFoundException, SQLException,Exception {
        ArrayList<Producto> lista=new ArrayList();
        c=Conexion.getConexion();
        p=c.prepareStatement("select * from producto;");
        r=p.executeQuery();
        while(r.next()){
            Producto producto= new Producto();
            producto.setNombre(r.getString("nombre"));
            producto.setIdProducto(r.getInt("idProducto"));
            producto.setDescripcion(r.getString("descripcion"));
            producto.setPrecioActual(r.getDouble("precioActual"));
            producto.setStock(r.getInt("stock"));
            producto.setEstado(r.getBoolean("estado"));
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
