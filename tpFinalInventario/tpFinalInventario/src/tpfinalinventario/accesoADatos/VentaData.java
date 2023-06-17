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

    private Connection c = null;
    private  ClienteData clienteData = new ClienteData();
    
    public VentaData() {
        c = Conexion.getConexion();
    }

    public void guardar(Venta v) {

        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO venta(numeroDeVenta,fecha,idCliente,estado) values(?,?,?,true)", Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, v.getNumeroDeVenta());
            p.setDate(2, Date.valueOf(v.getFecha()));
            p.setDouble(3, v.getCliente().getIdCliente());
            p.executeUpdate();
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {
                v.setIdVenta(r.getInt("idVenta"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en guardar venta, " + ex.getMessage());
        }

    }

    public void update(Venta venta) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM venta SET fecha=?,idCliente=? WHERE idVenta=?");
            p.setDate(1, Date.valueOf(venta.getFecha()));
            p.setInt(2, venta.getCliente().getIdCliente());
            p.setInt(3, venta.getIdVenta());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al update venta, " + ex.getMessage());
        }
    } 

    public void borrarLog(Venta venta) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM venta SET estado=? WHERE idVenta=?");
            p.setBoolean(1, venta.isEstado());
            p.setInt(2, venta.getIdVenta());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico Venta, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {

        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM venta WHERE idVenta=?;");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en eliminar venta, " + ex.getMessage());
        }

    }

    public Venta buscar(int id) {
        Venta v = null;
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM venta WHERE idVenta=? and estado=true;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                 v = new Venta();
                v.setIdVenta(r.getInt("idVenta"));
                v.setNumeroDeVenta(r.getInt("numeroDeVenta"));
                v.setFecha(r.getDate("fecha").toLocalDate());
                v.setCliente(clienteData.buscar(r.getInt("idCliente")));
                v.setEstado(r.getBoolean("estado"));

            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar venta, " + ex.getMessage());
        }
        return v;
    }

    public List<Venta> lista() {

        ArrayList<Venta> lista = new ArrayList();
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM venta where estado=true;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Venta v = new Venta();
                v.setIdVenta(r.getInt("idVenta"));
                v.setNumeroDeVenta(r.getInt("numeroDeVenta"));
                v.setFecha(r.getDate("fecha").toLocalDate());
                v.setCliente(clienteData.buscar(r.getInt("idCliente")));
                v.setEstado(r.getBoolean("estado"));
            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en lista venta, " + ex.getMessage());
        }
        return lista;
    }
    
    
    public int numeroVenta() {
        int numeroCompra=1;
       try {
            PreparedStatement p = c.prepareStatement("SELECT max(numeroDeVenta) as max from venta;");
            ResultSet r = p.executeQuery();
            if (r.next()) {
               numeroCompra=r.getInt("max")+1;
            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en numeroVenta, " + ex.getMessage());
        }
       return numeroCompra;
    }
    
    
    public Venta buscarPorNumeroDeVenta(int numero) {
       Venta v = null;
       try {

           PreparedStatement p = c.prepareStatement("SELECT * FROM venta WHERE numeroDeVenta=? and estado=true;");
           p.setInt(1, numero);
           ResultSet r = p.executeQuery();
           if (r.next()) {
               v = new Venta();
               v.setIdVenta(r.getInt("idVenta"));
               v.setNumeroDeVenta(r.getInt("numeroDeVenta"));
               v.setFecha(r.getDate("fecha").toLocalDate());
               v.setCliente(clienteData.buscar(r.getInt("idCliente")));
               v.setEstado(r.getBoolean("estado"));

           }
           p.close();
           r.close();

       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en buscar venta, " + ex.getMessage());
       }
       return v;
    }

}
