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
import tpfinalinventario.entidades.Compra;

/**
 *
 * @author julie
 */
public class CompraData {
    
    public static void guardar(Compra compra) throws ClassNotFoundException, SQLException,Exception{
        Connection c=Conexion.getConexion();
        PreparedStatement p=c.prepareStatement("insert into compra (idproveedor,fecha) values(?,?)");
        p.setInt(1,compra.getProveedor().getIdProveedor());        
        p.setDate(2,Date.valueOf(compra.getFecha()));
        p.execute();
        p.close();
        c.close();
    }
    
    
}
