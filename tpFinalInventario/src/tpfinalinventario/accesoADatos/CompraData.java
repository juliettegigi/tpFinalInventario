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
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.Compra;

/**
 *
 * @author julie
 */
public class CompraData {
    
     private static Connection c;
     private static PreparedStatement p;
     private static ResultSet r;
    
    
    public static void guardar(Compra compra) throws ClassNotFoundException, SQLException,Exception{
        c=Conexion.getConexion();
        p=c.prepareStatement("insert into compra (idproveedor,fecha) values(?,?)");
        p.setInt(1,compra.getProveedor().getIdProveedor());        
        p.setDate(2,Date.valueOf(compra.getFecha()));
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
     
    public static Compra buscar(int id) throws ClassNotFoundException, SQLException,Exception{
        Compra compra = null;
        c = Conexion.getConexion();
        p=c.prepareStatement("SELECT * FROM compra WHERE idCompra=?;");
        p.setInt(1,id);
        r=p.executeQuery();
        if(r.next()){
            compra=new Compra();
            compra.setIdCompra(id);
            compra.setProveedor(ProveedorData.buscar(r.getInt("idProveedor")));
            compra.setFecha(r.getDate("fecha").toLocalDate());
          
        }
        cerrar3();
        return compra;
    }
   
    
    
  
       public static List<Compra> lista() throws ClassNotFoundException, SQLException,Exception {
        ArrayList<Compra> lista=new ArrayList();
        c=Conexion.getConexion();
        p=c.prepareStatement("select * from compra;");
        r=p.executeQuery();
        while(r.next()){
            Compra compra= new Compra();
            compra.setIdCompra(r.getInt("idCompra"));
            compra.setProveedor(ProveedorData.buscar(r.getInt("idProveedor")));
            compra.setFecha(r.getDate("fecha").toLocalDate());
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
