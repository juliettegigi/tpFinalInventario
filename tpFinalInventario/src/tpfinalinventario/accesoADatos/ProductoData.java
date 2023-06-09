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
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class ProductoData {

    private Connection c = null;

    public ProductoData() {
        c = Conexion.getConexion();
    }

    public void guardar(Producto producto) {
        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO producto(nombre,descripcion,precioActual,stock,estado) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            p.setString(1, producto.getNombre());
            p.setString(2, producto.getDescripcion());
            p.setDouble(3, producto.getPrecioActual());
            p.setInt(4, producto.getStock());
            p.setBoolean(5, producto.isEstado());
            p.executeUpdate();
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {
                producto.setIdProducto(r.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "Producto añadido con éxito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto, " + ex.getMessage());
        }
    }
    
    public void borrarLog(Producto producto) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM producto SET estado=? WHERE idProducto=?");
            p.setBoolean(1, producto.isEstado());
            p.setInt(2, producto.getIdProducto());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico Producto, " + ex.getMessage());
        }
    }

    public void eliminadoFisico(int id) {

        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM producto WHERE idProducto=?;");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en eliminar producto "+ex.getMessage());
        }
    }

    
        public void eliminadoLogico(int id) {

        try {
            PreparedStatement p = c.prepareStatement("UPDATE producto SET estado=false WHERE idProducto=?;");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en eliminar producto "+ex.getMessage());
        }
    }
    
    
    public List<Producto> buscarCampoValor(String campo, String valor) {
        ArrayList<Producto> lista = new ArrayList();
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM producto WHERE " + campo + "=?;");
            p.setString(1, valor);

            ResultSet r = p.executeQuery();
            while (r.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(r.getInt("idProducto"));
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
            JOptionPane.showMessageDialog(null, "Error al buscar en producto, " + ex.getMessage());
        }
        return lista;
    }

    public Producto buscarPorId(int id) {
        Producto producto = null;
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM producto WHERE idProducto=? AND  estado=1;");
            p.setInt(1, id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                producto = new Producto();
                producto.setIdProducto(r.getInt("idProducto"));
                producto.setNombre(r.getString("nombre"));
                producto.setDescripcion(r.getString("descripcion"));
                producto.setPrecioActual(r.getDouble("precioActual"));
                producto.setStock(r.getInt("stock"));
                producto.setEstado(r.getBoolean("estado"));

            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar en producto, " + ex.getMessage());
        }
        return producto;
    }

    
    public boolean existe(Producto producto){
            try {
            PreparedStatement p = c.prepareStatement("SELECT nombre FROM producto WHERE nombre=? and descripcion=? and precioActual=? and stock=? and estado=?;");
            p.setString(1,producto.getNombre() );
            p.setString(2,producto.getDescripcion());
            p.setDouble(3,producto.getPrecioActual() );
            p.setInt(4, producto.getStock());
            p.setBoolean(5, producto.isEstado());

            ResultSet r = p.executeQuery();
            
            if (r.next()) {
                p.close();
                r.close();
                return true;
            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en existe producto, " + ex.getMessage());
        }
            
            return false;
    }
    
    
    public void update(Producto producto) {

        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM producto set nombre=?,descripcion=?,precioActual=?, stock=?, estado=? WHERE id=?");
            p.setString(1, producto.getNombre());
            p.setString(2, producto.getDescripcion());
            p.setDouble(3, producto.getPrecioActual());
            p.setInt(4, producto.getStock());
            p.setBoolean(5, producto.isEstado());
            p.setInt(6, producto.getIdProducto());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al update clientes, " + ex.getMessage());
        }

    }

    public List<Producto> lista() {

        ArrayList<Producto> lista = new ArrayList();

        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM producto;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Producto producto = new Producto();
                producto.setNombre(r.getString("nombre"));
                producto.setIdProducto(r.getInt("idProducto"));
                producto.setDescripcion(r.getString("descripcion"));
                producto.setPrecioActual(r.getDouble("precioActual"));
                producto.setStock(r.getInt("stock"));
                producto.setEstado(r.getBoolean("estado"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la lista de producto, " + ex.getMessage());
        }
        return lista;
    }

}
