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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tpfinalinventario.entidades.DetalleCompra;
import tpfinalinventario.entidades.Venta;

/**
 *
 * @author julie
 */
public class VentaData {
    
       Connection c=null;
       
       public VentaData(){
           c=Conexion.getConexion();
       }
    
       public  void guardar(Venta v) {
           
           try {
               PreparedStatement p=c.prepareStatement("insert into venta(fecha,idCliente) values(?,?)",Statement.RETURN_GENERATED_KEYS);
               p.setDate(1,Date.valueOf(v.getFecha()));
               p.setDouble(2, v.getCliente().getIdCliente());
               p.executeUpdate();
               ResultSet r=p.getGeneratedKeys();
               if(r.next()){
                   v.setIdVenta(r.getInt("idVenta"));
               }
               p.close();
               r.close();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error en guardar venta, "+ex.getMessage());
           }
       
    }
       
       public void eliminar(int id) {
        
      
           try {
               PreparedStatement p=c.prepareStatement("DELETE FROM venta WHERE idVenta=?;");
               p.setInt(1,id);
               p.execute();
               p.close();
           } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en eliminar venta, "+ex.getMessage());
           }
        
    }
     
    public Venta buscar(int id){
        Venta v = null;   
        ClienteData clienteData=new ClienteData();
        try {
               
               PreparedStatement p=c.prepareStatement("SELECT * FROM venta WHERE idVenta=?;");
               p.setInt(1,id);
               ResultSet r=p.executeQuery();
               if(r.next()){
                   v=new Venta();
                   v.setIdVenta(id);
                   v.setFecha(r.getDate("fecha").toLocalDate());
                   v.setCliente(clienteData.buscar(r.getInt("idCliente")));
                   
               }
               p.close();
               r.close();
              
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error en buscar venta, "+ex.getMessage());
           }
         return v;
    }
   
    
    
  
       public List<DetalleCompra> lista() {
           
               ArrayList<DetalleCompra> lista=new ArrayList();
               ClienteData clienteData=new ClienteData();
           try {
               
               PreparedStatement p=c.prepareStatement("select * from venta;");
               ResultSet r=p.executeQuery();
               while(r.next()){
                   Venta v=new Venta();
                   v.setIdVenta(r.getInt("idVenta"));
                   v.setFecha(r.getDate("fecha").toLocalDate());
                   v.setCliente(clienteData.buscar(r.getInt("idCliente")));
               }
               p.close();
               r.close();
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error en lista venta, "+ex.getMessage());
           }
           return lista;
    }
       
       
    
}
