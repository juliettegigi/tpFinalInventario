/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.entidades;

import java.time.LocalDate;

/**
 *
 * @author julie
 */
public class Compra {

    private int idCompra;
    private int numeroDeCompra;
    private LocalDate fecha;
    private Proveedor proveedor;
    private boolean estado;

    public Compra() {
    }

    public Compra(int idCompra, int numeroDeCompra, LocalDate fecha, Proveedor proveedor, boolean estado) {
        this.idCompra = idCompra;
        this.numeroDeCompra = numeroDeCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.estado = estado;
    }

    public Compra(int numeroDeCompra, LocalDate fecha, Proveedor proveedor, boolean estado) {
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.estado = estado;
        this.numeroDeCompra = numeroDeCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getNumeroDeCompra() {
        return numeroDeCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setNumeroDeCompra(int numeroDeCompra) {
        this.numeroDeCompra = numeroDeCompra;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", numeroDeCompra=" + numeroDeCompra + ", fecha=" + fecha + ", proveedor=" + proveedor + '}';
    }

}
