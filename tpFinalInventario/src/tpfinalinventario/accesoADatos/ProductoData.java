/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class ProductoData {
       public static void guardar(Producto producto) throws ClassNotFoundException, SQLException,Exception{
        Connection c=Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("insert into producto(descripcion,precioActual,stock,estado) values(?,?,?,?)");
        p.setString(1,producto.getDescripcion());
        p.setDouble(2, producto.getPrecioActual());
        p.setInt(3,producto.getStock());
        p.setBoolean(4, producto.isEstado());
        p.execute();
        p.close();
        c.close();
    }
}
