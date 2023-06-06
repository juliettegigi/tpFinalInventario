/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tpfinalinventario.entidades.Venta;

/**
 *
 * @author julie
 */
public class VentaData {
       public static void guardar(Venta v) throws ClassNotFoundException, SQLException,Exception{
        Connection c=Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("insert into detallecompra(fecha,idCliente) values(?,?)");
        p.setDate(1,Date.valueOf(v.getFecha()));
        p.setDouble(2, v.getCliente().getIdCliente());
        p.execute();
        p.close();
        c.close();
    }
}
