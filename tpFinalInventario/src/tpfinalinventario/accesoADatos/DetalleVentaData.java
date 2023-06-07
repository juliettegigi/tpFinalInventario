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
import tpfinalinventario.entidades.DetalleVenta;

/**
 *
 * @author julie
 */
public class DetalleVentaData {

    private Connection c = null;

    public DetalleVentaData() {
        c = Conexion.getConexion();
    }

    public void guardar(DetalleVenta dv) {

        try {
            PreparedStatement p = c.prepareStatement("insert into detalleventa(cantidad,precioVenta,idVenta,idProducto) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, dv.getCantidad());
            p.setDouble(2, dv.getPrecioVenta());
            p.setInt(3, dv.getVenta().getIdVenta());
            p.setInt(4, dv.getProducto().getIdProducto());
            p.executeUpdate();
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {
                dv.setIdDetalleVenta(r.getInt("idDetalleVenta"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en guardar DetalleVentaData, " + ex.getMessage());
        }
    }

    public void update(DetalleVenta dV) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM detalleventa SET cantidad=?,precioVenta=?,idVenta=?,idProducto=? WHERE idDetalleVenta=?");
            p.setInt(1, dV.getCantidad());
            p.setDouble(2, dV.getPrecioVenta());
            p.setInt(3, dV.getVenta().getIdVenta());
            p.setInt(4, dV.getProducto().getIdProducto());
            p.setInt(5, dV.getIdDetalleVenta());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al update detalleVenta, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {
        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM detalleventa WHERE idDetalleVenta=?;");
            p.setInt(1, id);
            p.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en eliminar DetalleVentaData, " + ex.getMessage());
        }

    }

    public DetalleVenta buscar(int id) {
        DetalleVenta dv = null;
        VentaData ventaData = new VentaData();
        ProductoData productoData = new ProductoData();
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM detalleventa WHERE idDetalleVenta=?;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                dv = new DetalleVenta();
                dv.setIdDetalleVenta(id);
                dv.setCantidad(r.getInt("cantidad"));
                dv.setPrecioVenta(r.getDouble("precioVenta"));
                dv.setVenta(ventaData.buscar(r.getInt("idVenta")));
                dv.setProducto(productoData.buscarPorId(r.getInt("idProducto")));

            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar DetalleVentaData, " + ex.getMessage());
        }
        return dv;
    }

    public List<DetalleVenta> lista() {
        ArrayList<DetalleVenta> lista = new ArrayList();
        VentaData ventaData = new VentaData();
        ProductoData productoData = new ProductoData();
        try {
            PreparedStatement p = c.prepareStatement("select * from DetalleVenta;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                DetalleVenta dv = new DetalleVenta();
                dv.setIdDetalleVenta(r.getInt("idDetalleVenta"));
                dv.setCantidad(r.getInt("cantidad"));
                dv.setPrecioVenta(r.getDouble("precioVenta"));
                dv.setVenta(ventaData.buscar(r.getInt("idVenta")));
                dv.setProducto(productoData.buscarPorId(r.getInt("idProducto")));
            }
            r.close();
            p.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en lista DetalleVentaData, " + ex.getMessage());
        }
        return lista;
    }

}
