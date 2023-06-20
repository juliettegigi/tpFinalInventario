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
public class Venta {

    private int idVenta;
    private int numeroDeVenta;
    private LocalDate fecha;
    private Cliente cliente;
    private boolean estado;

    public Venta() {
    }

    public Venta(int idVenta, int numeroDeCompra, LocalDate fecha, Cliente cliente, boolean estado) {
        this.idVenta = idVenta;
        this.numeroDeVenta = numeroDeCompra;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
    }

    public Venta(int numeroDeCompra, LocalDate fecha, Cliente cliente, boolean estado) {
        this.numeroDeVenta = numeroDeCompra;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getNumeroDeVenta() {
        return numeroDeVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setNumeroDeVenta(int numeroDeVenta) {
        this.numeroDeVenta = numeroDeVenta;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", numeroDeVenta=" + numeroDeVenta + ", fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado + '}';
    }

}
