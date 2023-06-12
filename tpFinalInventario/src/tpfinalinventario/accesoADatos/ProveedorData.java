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

    public String guardar(Proveedor proveedor){
       
        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO proveedor(razonSocial,domicilio,telefono,estado)VALUES(?,?,?,true)",Statement.RETURN_GENERATED_KEYS);
            p.setString(1, proveedor.getRazonSocial());
            p.setString(2, proveedor.getDomicilio());
            p.setString(3, proveedor.getTelefono());
            int filasAfectadas=p.executeUpdate();
            ResultSet r=p.getGeneratedKeys();
            if(r.next()){
                proveedor.setIdProveedor(r.getInt("idProveedor"));
            }
            p.close();
            r.close();
            if(filasAfectadas>0)
                return "Proveedor guardado.";
            else return "Proveedor no guardado";            
        } catch (SQLException ex) {
           return "Error en guardar proveedor, "+ex.getMessage();
        }
        
    }
    
    public String update(Proveedor proveedor){
        try {
            PreparedStatement p=c.prepareStatement("UPDATE proveedor SET razonsocial=?,domicilio=?,telefono=? WHERE idProveedor=? and estado=true;");
            p.setString(1, proveedor.getRazonSocial());
            p.setString(2, proveedor.getDomicilio());
            p.setString(3, proveedor.getTelefono());
            p.setInt(4, proveedor.getIdProveedor());
            int filasAfectadas=p.executeUpdate();
            p.close();
            if (filasAfectadas>0)
                return "Proveedor actualizado";
            else return "No se encuentra un proveedor con id="+proveedor.getIdProveedor();
        } catch (SQLException ex) {
           return "Error al update proovedor, "+ex.getMessage();
           
        }
    }
    
    public String eliminarLogico(int id) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE proveedor SET estado=false WHERE idProveedor=? and estado=true;");
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
            p.close();
            if(filasAfectadas>0)
               return "Proveedor eliminado.\n";
            else return "Proveedor no eliminado,no se encuentra proveedor con id="+id;
        } catch (SQLException ex) {
           
            return "Error en Proveedor borradoLogico";
        }
    }

    public void eliminar(int id) {
        
        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM proveedor WHERE idProveedor=?;");
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
            PreparedStatement p = c.prepareStatement("SELECT * FROM proveedor WHERE idProveedor=? and estado=true;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
           
            if (r.next()) {
                proveedor = new Proveedor();
                proveedor.setRazonSocial(r.getString("razonSocial"));
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
