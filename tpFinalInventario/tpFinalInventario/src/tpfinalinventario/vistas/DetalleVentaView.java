/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tpfinalinventario.accesoADatos.ClienteData;
import tpfinalinventario.accesoADatos.DetalleVentaData;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.accesoADatos.VentaData;
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.DetalleVenta;
import tpfinalinventario.entidades.Producto;
import tpfinalinventario.entidades.Venta;

/**
 *
 * @author santi
 */
public class DetalleVentaView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ProductoData productoData = new ProductoData();
    private DetalleVentaData detalleVentaData = new DetalleVentaData();
    private ClienteData clienteData = new ClienteData();
    private ArrayList<Producto> lista;
    private VentaData ventaData = new VentaData();

    /**
     * Creates new form DetalleVentaView
     */
    public DetalleVentaView() {
        initComponents();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        lista = (ArrayList<Producto>) productoData.lista();
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtf_numVenta = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Detalle de Venta");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("N° Venta");

        jtf_numVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_numVentaActionPerformed(evt);
            }
        });

        btBuscar.setBackground(new java.awt.Color(0, 153, 0));
        btBuscar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btSalir.setBackground(new java.awt.Color(255, 0, 0));
        btSalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btSalir.setForeground(new java.awt.Color(255, 255, 255));
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cliente: nombre");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Fecha: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jtf_numVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jtf_numVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalir)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // ACCION BOTON BUSCAR

        if (jtf_numVenta.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de venta.");
            return;
        }
        int numero = 0;
        try {
            numero = Integer.parseInt(jtf_numVenta.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número.");
            return;
        }

        // lista de Venta, con un numero de venta, es uno solo
        Venta venta = ventaData.buscarPorNumeroDeVenta(numero);
        if (venta == null) {
            JOptionPane.showMessageDialog(this, "No existe ese número de venta.");
            return;
        }

        String fecha = venta.getFecha().toString();
        Cliente cliente = venta.getCliente();
        jLabel3.setText("Cliente: " + cliente.getNombre());
        jLabel4.setText("Fecha: " + fecha);
        // buscar en detalleVenta por idVenta
        ArrayList<DetalleVenta> listaDetalleVenta = (ArrayList<DetalleVenta>) detalleVentaData.detalleVentaPorIdVenta(venta.getIdVenta());

        llenarTabla(listaDetalleVenta);

        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jtf_numVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_numVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_numVentaActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void armarCabeceraTabla() {
        //creo las columnas de la tabla
        ArrayList<Object> columns = new ArrayList();
        columns.add("PRODUCTO");
        columns.add("CANTIDAD");
        columns.add("PRECIO");
        //columns.add("FECHA");
        //columns.add("CLIENTE");

        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo.addColumn(it);
        }
        jTable1.setModel(modelo);
    }

    private void llenarTabla(ArrayList<DetalleVenta> listaDetalleVenta) {
        borrarFilas();
        if (listaDetalleVenta.isEmpty()) {
            return;
        }
        double total = 0;
        for (DetalleVenta dv : listaDetalleVenta) {
            Producto p = productoData.buscarPorId(dv.getProducto().getIdProducto());
            modelo.addRow(new Object[]{p.getNombre(), dv.getCantidad(), p.getPrecioActual()});
            total += dv.getPrecioVenta();
        }

        modelo.addRow(new Object[]{"", "", total});
    }

    public void borrarFilas() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtf_numVenta;
    // End of variables declaration//GEN-END:variables
}
