/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tpfinalinventario.entidades.DetalleCompra;

/**
 *
 * @author julie
 */
public class DetalleCompraData {
    
    public static void guardar(DetalleCompra dc) throws ClassNotFoundException, SQLException,Exception{
        Connection c=Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("insert into detallecompra(cantidad,precioCosto,idCompra,idProducto) values(?,?,?,?)");
        p.setInt(1, dc.getCantidad());
        p.setDouble(2, dc.getPrecioCosto());
        p.setInt(3,dc.getCompra().getIdCompra());
        p.setInt(4, dc.getProducto().getIdProducto());
        p.execute();
        p.close();
        c.close();
    }
}
