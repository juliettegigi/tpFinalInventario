/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.entidades;

/**
 *
 * @author julie
 */
public class Compra {
    private int idCliente;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String telefono;

    public Compra(){
        
    }
    
    public Compra(String apellido, String nombre, String domicilio, String telefono) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    
    public Compra(int idCliente, String apellido, String nombre, String domicilio, String telefono) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    
    
}
