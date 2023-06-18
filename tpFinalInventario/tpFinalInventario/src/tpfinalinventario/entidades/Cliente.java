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
public class Cliente {

    private int idCliente;
    private int dni;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String telefono;
    private boolean estado;

    public Cliente() {

    }

    public Cliente(int idCliente, int dni, String apellido, String nombre, String domicilio, String telefono, boolean estado) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Cliente(int dni, String apellido, String nombre, String domicilio, String telefono, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "dni=" + dni + ", " + apellido + ", nombre=" + nombre ;
    }

}
