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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author julie
 */
public class ProveedorData {
    private Connection c;
    public ProveedorData(){
        c=Conexion.getConexion();
    }

    public void guardar(Proveedor proveedor){
       
        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO proveedor(razonSocial,domicilio,telefono)VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            p.setString(1, proveedor.getRazonSocial());
            p.setString(2, proveedor.getDomicilio());
            p.setString(3, proveedor.getTelefono());
            p.executeUpdate();
            ResultSet r=p.getGeneratedKeys();
            if(r.next()){
                proveedor.setIdProveedor(r.getInt("idProveedor"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en guardar proveedor, "+ex.getMessage());
        }
    }
    
    public void update(Proveedor proveedor){
        try {
            PreparedStatement p=c.prepareStatement("UPDATE FROM proveedor SET razonsocial=?,domicilio=?,telefono=? WHERE idProveedor=?");
            p.setString(1, proveedor.getRazonSocial());
            p.setString(2, proveedor.getDomicilio());
            p.setString(3, proveedor.getTelefono());
            p.setInt(4, proveedor.getIdProveedor());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al update proovedor, "+ex.getMessage());
        }
    }
    
    public void borrarLog(Proveedor proveedor) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM proveedor SET estado=? WHERE idProveedor=?");
            p.setBoolean(1, proveedor.isEstado());
            p.setInt(2, proveedor.getIdProveedor());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico Proveedor, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {
        
        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM proveedor WHERE idProveedor=?");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en eliminar proveedor, "+ex.getMessage());
        }
    }

    public Proveedor buscar(int id){
       
        Proveedor proveedor = null;
        
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM proveedor WHERE idProveedor=?");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
           
            if (r.next()) {
                proveedor = new Proveedor();
                proveedor.setRazonSocial(r.getString("razonSocila"));
                proveedor.setDomicilio(r.getString("domicilio"));
                proveedor.setTelefono(r.getString("telefono"));
                proveedor.setIdProveedor(id);
            }
            p.close();
            r.close();
            
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error en buscar proveedor, "+ex.getMessage());
        }
        return proveedor;
    }

    public  List<Proveedor> lista() {
       
          ArrayList<Proveedor> lista = new ArrayList();
        try {
       
            
            PreparedStatement p = c.prepareStatement("select * from proveedor;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(r.getInt("idProveedor"));
                proveedor.setRazonSocial(r.getString("razonSocial"));
                proveedor.setDomicilio(r.getString("domicilio"));
                proveedor.setTelefono(r.getString("telefono"));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en lista proveedor, "+ex.getMessage());
        }
        return lista;
    }



}
