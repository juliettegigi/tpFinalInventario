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
import tpfinalinventario.accesoADatos.ProveedorData;
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.Producto;
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author julie
 */
public class TpFinalInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ClienteData clienteData=new ClienteData();
        ProductoData productoData=new ProductoData();
        ProveedorData proveedorData=new ProveedorData();
        Cliente c1=new Cliente(1,"apellido1","nombre1","domicilio1","telefono1");
        Producto p1=new Producto("nombre1","descripcion1",1.1,1,true);
        Producto p2=new Producto("nombre3","descripcion2",1.1,1,true);
        
        
        Proveedor proveedor=new Proveedor("razon social 1","domicilio1","telefono1");
        proveedorData.guardar(proveedor);
        clienteData.guardar(c1);
        productoData.guardar(p1);
        
        
        
        
}
    
}
