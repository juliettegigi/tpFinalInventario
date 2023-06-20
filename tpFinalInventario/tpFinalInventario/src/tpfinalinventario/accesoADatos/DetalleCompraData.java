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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tpfinalinventario.entidades.DetalleCompra;

/**
 *
 * @author julie
 */
public class DetalleCompraData {

    private Connection c = null;

    public DetalleCompraData() {
        c = Conexion.getConexion();
    }

    public void guardar(DetalleCompra dc) {

        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO detallecompra(cantidad,precioCosto,idCompra,idProducto,estado) values(?,?,?,?,true)", Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, dc.getCantidad());
            p.setDouble(2, dc.getPrecioCosto());
            p.setInt(3, dc.getCompra().getIdCompra());
            p.setInt(4, dc.getProducto().getIdProducto());
            p.executeUpdate();
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {
                dc.setIdDetalle(r.getInt("idDetalleCompra"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar en DetalleCompraData, " + ex.getMessage());
        }
    }

    public void update(DetalleCompra dC) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM detallecompra SET cantidad=?,precioVenta=?,idCompra=?,idProducto=? WHERE idDetalleCompra=?");
            p.setInt(1, dC.getCantidad());
            p.setDouble(2, dC.getPrecioCosto());
            p.setInt(3, dC.getCompra().getIdCompra());
            p.setInt(4, dC.getProducto().getIdProducto());
            p.setInt(5, dC.getIdDetalle());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al update detalleCompra, " + ex.getMessage());
        }
    }

    public void borrarLog(DetalleCompra dC) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM detalleCompra SET estado=? WHERE idDetalle=?");
            p.setBoolean(1, dC.isEstado());
            p.setInt(2, dC.getIdDetalle());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico detalleCompra, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {

        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM detallecompra WHERE idDetalle=?;");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar en DetalleCompraData, " + ex.getMessage());
        }
    }

    public DetalleCompra buscar(int id) {
        CompraData compraData = new CompraData();
        ProductoData productoData = new ProductoData();
        DetalleCompra dc = null;
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM detallecompra WHERE idDetalle=?;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                dc = new DetalleCompra();
                dc.setIdDetalle(r.getInt("idDetalle"));
                dc.setCantidad(r.getInt("cantidad"));
                dc.setPrecioCosto(r.getDouble("precioCosto"));
                dc.setCompra(compraData.buscar(r.getInt("idCompra")));
                dc.setProducto(productoData.buscarCampoValor("idProducto", r.getString("idProducto")).get(0));

            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            Logger.getLogger(DetalleCompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dc;
    }

    public List<DetalleCompra> lista() {
        CompraData compraData = new CompraData();
        ProductoData productoData = new ProductoData();
        ArrayList<DetalleCompra> lista = new ArrayList();
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM DetalleCompra;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                DetalleCompra dc = new DetalleCompra();
                dc.setIdDetalle(r.getInt("idDetalle"));
                dc.setCantidad(r.getInt("cantidad"));
                dc.setPrecioCosto(r.getDouble("precioCosto"));
                dc.setCompra(compraData.buscar(r.getInt("idCompra")));
                dc.setProducto(productoData.buscarCampoValor("idProducto", r.getString("idProducto")).get(0));
                lista.add(dc);
            }
            r.close();
            p.close();

        } catch (SQLException ex) {
            Logger.getLogger(DetalleCompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<DetalleCompra> buscarPorIdCompra(int idCompra) {
        CompraData compraData = new CompraData();
        ProductoData productoData = new ProductoData();
        ArrayList<DetalleCompra> lista = new ArrayList();
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM DetalleCompra where idCompra=? and estado=true;");
            p.setInt(1, idCompra);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                DetalleCompra dc = new DetalleCompra();
                dc.setIdDetalle(r.getInt("idDetalle"));
                dc.setCantidad(r.getInt("cantidad"));
                dc.setPrecioCosto(r.getDouble("precioCosto"));
                dc.setCompra(compraData.buscar(r.getInt("idCompra")));
                dc.setProducto(productoData.buscarPorIdSinEstado(r.getInt("idProducto")));
                lista.add(dc);
            }
            r.close();
            p.close();

        } catch (SQLException ex) {
            Logger.getLogger(DetalleCompraData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
