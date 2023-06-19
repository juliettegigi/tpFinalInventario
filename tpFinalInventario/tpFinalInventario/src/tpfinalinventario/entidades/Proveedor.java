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
public class Proveedor {

    private int idProveedor;
    private String razonSocial;
    private String domicilio;
    private String telefono;
    private boolean estado;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String razonSocial, String domicilio, String telefono, boolean estado) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Proveedor(String razonSocial, String domicilio, String telefono, boolean estado) {
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
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

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return razonSocial;
    }

}
