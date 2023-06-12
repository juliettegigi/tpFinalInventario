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
import tpfinalinventario.entidades.Cliente;

/**
 *
 * @author julie
 */
public class ClienteData {

    private Connection c = null;

    public ClienteData() {
        c = Conexion.getConexion();
    }

    public void guardar(Cliente cliente) {

        String sql = "INSERT INTO cliente(dni, apellido,nombre,domicilio,telefono,estado) values(?,?,?,?,?,true);";
        try {
            PreparedStatement p = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            p.setInt(1, cliente.getDni());
            p.setString(2, cliente.getApellido());
            p.setString(3, cliente.getNombre());
            p.setString(4, cliente.getDomicilio());
            p.setString(5, cliente.getTelefono());
            
            p.executeUpdate();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("idCliente"));
                JOptionPane.showMessageDialog(null, "Cliente añadido con éxito");
            }

            p.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El cliente no fue añadido" + ex.getMessage());
        }
    }
    
     public void borrarLog(Cliente cliente) {
        try {
            PreparedStatement p = c.prepareStatement("UPDATE FROM cliente SET estado=? WHERE idCliente=?");
            p.setBoolean(1, cliente.isEstado());
            p.setInt(2, cliente.getIdCliente());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en borrado lógico Cliente, " + ex.getMessage());
        }
    }

    public void eliminar(int id) {

        String sql = "DELETE FROM cliente WHERE idCliente=?;";
        try {
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente, " + ex.getMessage());
        }
    }

      public void eliminarLogico(int id) {

        String sql = "UPDATE cliente set estado=false WHERE idCliente=? and estado=true ;";
        try {
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            int filasAfectadas=p.executeUpdate();
            p.close();
            if(filasAfectadas>0)
                JOptionPane.showMessageDialog(null,"Cliente eliminado");
            else JOptionPane.showMessageDialog(null,"No existe cliente con id="+id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente, " + ex.getMessage());
        }
    }
    
    public Cliente buscar(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE idCliente=? and estado=true;";

        try {
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(id);
                cliente.setDni(r.getInt("dni"));
                cliente.setApellido(r.getString("apellido"));
                cliente.setNombre(r.getString("nombre"));
                cliente.setDomicilio(r.getString("domicilio"));
                cliente.setTelefono(r.getString("telefono"));
            }
            r.close();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente, " + ex.getMessage());
        }

        return cliente;
    }

    public void update(Cliente cliente) {

        try {
            PreparedStatement p = c.prepareStatement("UPDATE  cliente SET nombre=?,dni=?,apellido=?, domicilio=?, telefono=? WHERE idCliente=? and estado=true");
            p.setString(1, cliente.getNombre());
            p.setInt(2, cliente.getDni());
            p.setString(3, cliente.getApellido());
            p.setString(4, cliente.getDomicilio());
            p.setString(5, cliente.getTelefono());
            p.setInt(6, cliente.getIdCliente());
            p.executeUpdate();
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al update clientes, " + ex.getMessage());
        }

    }

    public List<Cliente> lista() {
        ArrayList<Cliente> lista = new ArrayList();
        try {
            PreparedStatement p = c.prepareStatement("SELECT * FROM cliente;");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Cliente cliente = new Cliente();
                cliente.setDni(r.getInt("dni"));
                cliente.setIdCliente(r.getInt("idCliente"));
                cliente.setApellido(r.getString("apellido"));
                cliente.setNombre(r.getString("nombre"));
                cliente.setDomicilio(r.getString("domicilio"));
                cliente.setTelefono(r.getString("telefono"));
            }
            p.close();
            r.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes, " + ex.getMessage());
        }
        return lista;
    }

}
