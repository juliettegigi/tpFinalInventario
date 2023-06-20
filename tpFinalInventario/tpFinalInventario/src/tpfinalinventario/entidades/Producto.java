/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.entidades;

import java.util.Objects;

/**
 *
 * @author julie
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private String categoria;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, String categoria, String descripcion, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombre, String categoria, String descripcion, double precioActual, int stock, boolean estado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public int getStock() {
        return stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        boolean retorno = stock == other.stock
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(categoria, other.categoria)
                && Objects.equals(descripcion, other.descripcion)
                && precioActual == other.precioActual;

        return retorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, categoria, descripcion, precioActual, stock);
    }

}
