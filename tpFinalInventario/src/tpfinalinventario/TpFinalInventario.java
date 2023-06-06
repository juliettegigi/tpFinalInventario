/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import tpfinalinventario.accesoADatos.ClienteData;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class TpFinalInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Cliente c=new Cliente("Apellido1","Nombre1","Domicilio1","Telefono1");
        try {
            ClienteData.guardar(c);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
*/
        Producto p=new Producto("nombre1","descripcion1",2.5,2,true);
        try {
            ProductoData.guardar(p);
            ArrayList<Producto> l=(ArrayList<Producto>) ProductoData.buscarCampoValor("precioActual", "dos pesos");
            
            for(Producto pp:l){
                System.out.println(pp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TpFinalInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TpFinalInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
}
    
}
