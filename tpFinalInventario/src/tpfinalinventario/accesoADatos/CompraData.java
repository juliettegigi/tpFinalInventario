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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.Compra;

/**
 *
 * @author julie
 */
public class CompraData {
    
     private Connection c=null;
     public CompraData(){
          c=Conexion.getConexion();
     }
    

    
    public void guardar(Compra compra){
         try {
             PreparedStatement p=c.prepareStatement("insert into compra (idproveedor,fecha) values(?,?)",Statement.RETURN_GENERATED_KEYS);
             p.setInt(1,compra.getProveedor().getIdProveedor());
             p.setDate(2,Date.valueOf(compra.getFecha()));
             p.executeUpdate();
             ResultSet r=p.getGeneratedKeys();
             if(r.next()){
                 compra.setIdCompra(r.getInt("idCompra"));
             }
             p.close();
             r.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error en guardar CompraData, "+ex.getMessage());
         }
    }
    
    
     public  void eliminar(int id){
         
         try {
             PreparedStatement p=c.prepareStatement("DELETE FROM compra WHERE idCompra=?;");
             p.setInt(1,id);
             p.execute();
             p.close();
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error en eliminar CompraData, "+ex.getMessage());
         }
    }
     
    public Compra buscar(int id){
        ProveedorData proveedorData=new ProveedorData();
        Compra compra = null; 
        try {
             
             PreparedStatement p=c.prepareStatement("SELECT * FROM compra WHERE idCompra=?;");
             p.setInt(1,id);
             ResultSet r=p.executeQuery();
             if(r.next()){
                 compra=new Compra();
                 compra.setIdCompra(id);
                 compra.setProveedor(proveedorData.buscar(r.getInt("idProveedor")));
                 compra.setFecha(r.getDate("fecha").toLocalDate());
                 
             }
             
            p.close();
            r.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar CompraData, "+ex.getMessage());
         }
        return compra;
    }
   
    
    
  
       public List<Compra> lista(){
            ProveedorData proveedorData=new ProveedorData();
             ArrayList<Compra> lista=new ArrayList();
           try {
             
             PreparedStatement p=c.prepareStatement("select * from compra;");
             ResultSet r=p.executeQuery();
             while(r.next()){
                 Compra compra= new Compra();
                 compra.setIdCompra(r.getInt("idCompra"));
                 compra.setProveedor(proveedorData.buscar(r.getInt("idProveedor")));
                 compra.setFecha(r.getDate("fecha").toLocalDate());
             }
             p.close();
             r.close();
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error en buscar CompraData, "+ex.getMessage());
         }
           return lista;
    }
    
     
    
}
