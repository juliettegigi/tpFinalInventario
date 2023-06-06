/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tpfinalinventario.entidades.DetalleVenta;

/**
 *
 * @author julie
 */
public class DetalleVentaData {
       public static void guardar(DetalleVenta dv) throws ClassNotFoundException, SQLException,Exception{
        Connection c=Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("insert into detalleventa(cantidad,precioVenta,idVenta,idProducto) values(?,?,?,?)");
        p.setInt(1, dv.getCantidad());
        p.setDouble(2, dv.getPrecioVenta());
        p.setInt(3,dv.getVenta().getIdVenta());
        p.setInt(4, dv.getProducto().getIdProducto());
        p.execute();
        p.close();
        c.close();
    }
}
