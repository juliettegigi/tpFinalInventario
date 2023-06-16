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
import tpfinalinventario.entidades.Compra;

/**
 *
 * @author julie
 */
public class CompraData {

    private Connection c = null;

    public CompraData() {
        c = Conexion.getConexion();
    }

    public void guardar(Compra compra) {
        try {
            PreparedStatement p = c.prepareStatement("INSERT INTO compra (fecha,idproveedor) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            p.setDate(1, Date.valueOf(compra.getFecha()));
            p.setInt(2, compra.getProveedor().getIdProveedor());
            p.executeUpdate();
            ResultSet r = p.getGeneratedKeys();
            if (r.next()) {
                compra.setIdCompra(r.getInt("idCompra"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en guardar CompraData, " + ex.getMessage());
        }
    }

    public void borrarLog(Compra compra) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM compra SET estado=? WHERE idCompra=?");
            p.setBoolean(1, compra.isEstado());
            p.setInt(2, compra.getIdCompra());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico Compra, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {

        try {
            PreparedStatement p = c.prepareStatement("DELETE FROM compra WHERE idCompra=?;");
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en eliminar CompraData, " + ex.getMessage());
        }
    }

    public Compra buscar(int id) {
        ProveedorData proveedorData = new ProveedorData();
        Compra compra = null;
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM compra WHERE idCompra=?;");
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                compra = new Compra();
                compra.setIdCompra(id);
                compra.setFecha(r.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedorData.buscar(r.getInt("idProveedor")));
            }

            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar CompraData, " + ex.getMessage());
        }
        return compra;
    }

    public void update(Compra compra) {

        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM compra SET idProveedor=? WHERE id=?");
            p.setInt(1, compra.getProveedor().getIdProveedor());
            p.setInt(2, compra.getIdCompra());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en update compra, " + ex.getMessage());
        }

    }

    public List<Compra> lista() {
        ProveedorData proveedorData = new ProveedorData();
        ArrayList<Compra> lista = new ArrayList();
        try {

            PreparedStatement p = c.prepareStatement("SELECT * FROM compra;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(r.getInt("idCompra"));
                compra.setFecha(r.getDate("fecha").toLocalDate());
                compra.setProveedor(proveedorData.buscar(r.getInt("idProveedor")));
                lista.add(compra);
            }
            p.close();
            r.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar CompraData, " + ex.getMessage());
        }
        return lista;
    }

}