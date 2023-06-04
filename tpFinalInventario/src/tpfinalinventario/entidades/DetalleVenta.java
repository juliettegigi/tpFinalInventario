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
public class DetalleVenta {
    private int idDetalleVenta;
    private int cantidad;
    private double precioVenta;
    private Venta venta;
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(int detalleVenta, int cantidad, double precioVenta, Venta venta, Producto producto) {
        this.idDetalleVenta = detalleVenta;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.venta = venta;
        this.producto = producto;
    }
    
     public DetalleVenta(int cantidad, double precioVenta, Venta venta, Producto producto) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.venta = venta;
        this.producto = producto;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", venta=" + venta + ", producto=" + producto + '}';
    }
    
     
    
}
