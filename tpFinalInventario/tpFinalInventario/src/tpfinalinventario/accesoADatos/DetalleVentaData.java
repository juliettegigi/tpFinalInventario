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
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class DetalleVentaData {

    private Connection c = null;

    public DetalleVentaData() {
        c = Conexion.getConexion();
    }

    public boolean guardar(DetalleVenta dv) {

        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO detalleventa(cantidad,precioVenta,idVenta,idProducto,estado) values(?,?,?,?,true)", Statement.RETURN_GENERATED_KEYS);
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
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en guardar DetalleVentaData, " + ex.getMessage());
            return false;
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
    
    public void borrarLog(DetalleVenta dV) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM detalleVenta SET estado=? WHERE idDetalleVenta=?");
            p.setBoolean(1, dV.isEstado());
            p.setInt(2, dV.getIdDetalleVenta());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico detalleVenta, " + ex.getMessage());
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
            PreparedStatement p = c.prepareStatement("SELECT * FROM DetalleVenta;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                DetalleVenta dv = new DetalleVenta();
                dv.setIdDetalleVenta(r.getInt("idDetalleVenta"));
                dv.setCantidad(r.getInt("cantidad"));
                dv.setPrecioVenta(r.getDouble("precioVenta"));
                dv.setVenta(ventaData.buscar(r.getInt("idVenta")));
                dv.setProducto(productoData.buscarPorId(r.getInt("idProducto")));
                lista.add(dv);
            }
            r.close();
            p.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en lista DetalleVentaData, " + ex.getMessage());
        }
        return lista;
    }
    
    
    
            
        ///*productos que están en detalle venta*/
//select * from producto where idProducto in(select idProducto from detalleVenta);

    public List<Producto> productosEnDetalleVenta() {
        ArrayList<Producto> lista = new ArrayList();
        try { 
            PreparedStatement p = c.prepareStatement("select * from producto where idProducto in(select idProducto from detalleVenta);");
          

            ResultSet r = p.executeQuery();
            while (r.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(r.getInt("idProducto"));
                producto.setCategoria(r.getString("categoria"));
                producto.setNombre(r.getString("nombre"));
                producto.setDescripcion(r.getString("descripcion"));
                producto.setPrecioActual(r.getDouble("precioActual"));
                producto.setStock(r.getInt("stock"));
                producto.setEstado(r.getBoolean("estado"));
                lista.add(producto);
            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error productosEnDetalleVenta, " + ex.getMessage());
        }
        return lista;
    }


}
