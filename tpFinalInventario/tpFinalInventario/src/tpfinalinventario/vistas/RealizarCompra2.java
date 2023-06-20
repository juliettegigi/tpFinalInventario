/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ComboBoxEditor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tpfinalinventario.accesoADatos.CompraData;
import tpfinalinventario.accesoADatos.DetalleCompraData;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.accesoADatos.ProveedorData;
import tpfinalinventario.entidades.Compra;
import tpfinalinventario.entidades.DetalleCompra;
import tpfinalinventario.entidades.Producto;
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author santi
 */
public class RealizarCompra2 extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    ProveedorData proveedorData = new ProveedorData();
    CompraData compraData = new CompraData();
    DetalleCompraData detalleCompraData = new DetalleCompraData();
    ProductoData productoData = new ProductoData();
    private ArrayList<Producto> lista;
    private Producto producto;
    private JPopupMenu menuEliminar;
    private ArrayList<Producto> productosAgregados = new ArrayList();
    private ComboBoxEditor editor2;
    private JTextField textField2;
    private JTextField textField;

    /**
     * Creates new form RealizarCompra2
     */
    public RealizarCompra2() {
        initComponents();
        setSize(497, 529);
        //  initComboBox();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2 || column == 3);
            }
        };
        armarCabeceraTabla();
        modelo.addRow(new Object[]{"", "", "", 0});
        menuEliminar = new JPopupMenu();
        JMenuItem itemEliminar = new JMenuItem("Eliminar");
        itemEliminar.addActionListener(e -> eliminarFila());
        menuEliminar.add(itemEliminar);
        jtable.setComponentPopupMenu(menuEliminar);
        setTitle("COMPRAR");
        jBtnRealizarCompra.setText("<html>Realizar<br> compra</html>");

        //
        cbProveedor.setEditable(true); // Habilitar la edición del ComboBox
        cbProductos.setEditable(true);
        
        // Agregar un editor al ComboBox
        editor2 = cbProductos.getEditor();
        textField2 = (JTextField) editor2.getEditorComponent();

        // Agregar un editor al ComboBox
        ComboBoxEditor editor = cbProveedor.getEditor();
        textField = (JTextField) editor.getEditorComponent();
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                ArrayList<Proveedor> l = (ArrayList<Proveedor>) proveedorData.razonSocialEmpiezanCon(textField.getText());
                cargarCB2(l);
            }
        });

        textField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                lista = (ArrayList<Producto>) productoData.nombresEmpiezanCon(textField2.getText());
                cargarCB();

            }

        });
    }

    // para cuando hacen click derecho
    private void eliminarFila() {
        int row = jtable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila.");
            return;
        }
        int cantidad = Integer.parseInt(jtable.getValueAt(row, 1).toString());
        Producto productoAEliminar = productosAgregados.get(row);
        productoAEliminar.setStock(productoAEliminar.getStock() + cantidad);
        productoData.update(productoAEliminar);
        productosAgregados.remove(row);

        modelo.removeRow(row);

        // actualizar total
        row = modelo.getRowCount() - 1;
        double total = Double.parseDouble(jtable.getValueAt(row, 3).toString());
        total -= cantidad * productoAEliminar.getPrecioActual();
        modelo.removeRow(row);
        modelo.addRow(new Object[]{"", "", "", total});

    }

    private void armarCabeceraTabla() {
        ArrayList<Object> columns = new ArrayList();
        columns.add("Producto");
        columns.add("Cantidad");
        columns.add("Precio");
        columns.add("Total");
        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo.addColumn(it);
        }

        jtable.setModel(modelo);
    }

    private void cargarDatosTabla() {
        //quito la última fila      
        modelo.removeRow(modelo.getRowCount() - 1);

        Producto p = (Producto) cbProductos.getSelectedItem();
        double total = Integer.parseInt(jtf_cantidad.getText()) * p.getPrecioActual();
        modelo.addRow(new Object[]{p.getNombre(), jtf_cantidad.getText(), p.getPrecioActual(), total});

        total = 0;
        for (int row = 0; row < jtable.getRowCount(); row++) {
            total += Double.parseDouble(jtable.getValueAt(row, 3).toString());
        }
        modelo.addRow(new Object[]{"", "", "", total});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProveedor = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtf_cantidad = new javax.swing.JTextField();
        jBtnAgregarLista = new javax.swing.JButton();
        jBtnRealizarCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();

        jLabelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabelProveedor.setText("PROVEEDOR");

        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        cbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbProveedorKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Producto:");

        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad: ");

        jBtnAgregarLista.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jBtnAgregarLista.setText("Agregar a la lista");
        jBtnAgregarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarListaActionPerformed(evt);
            }
        });

        jBtnRealizarCompra.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jBtnRealizarCompra.setText("<html>Realizar<br>  compra</html>");
        jBtnRealizarCompra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRealizarCompraActionPerformed(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnAgregarLista)))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProveedor)
                    .addComponent(cbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jBtnAgregarLista)))
                    .addComponent(jBtnRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed

    }//GEN-LAST:event_cbProveedorActionPerformed

    private void cbProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbProveedorKeyReleased

    }//GEN-LAST:event_cbProveedorKeyReleased

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
        try {
            producto = (Producto) cbProductos.getSelectedItem();
        } catch (Exception e) {

        }

    }//GEN-LAST:event_cbProductosActionPerformed

    private void jBtnAgregarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarListaActionPerformed

        if (cbProductos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
            return;
        }

        if (!jtf_cantidad.getText().toLowerCase().matches("[0-9]{1,10}")) {
            JOptionPane.showMessageDialog(null, "Campo cantidad: ingrese un número.");
            return;
        }
        int cantidad = Integer.parseInt(jtf_cantidad.getText());

        producto.setStock(producto.getStock() + cantidad);//Sumo cantidad productos comprados
        productoData.update(producto);
        cargarDatosTabla();
        productosAgregados.add(producto);

    }//GEN-LAST:event_jBtnAgregarListaActionPerformed

    private void jBtnRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRealizarCompraActionPerformed

        if (productosAgregados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos en la lista.");
            return;
        }

        if (cbProveedor.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado un proveedor.");
            return;
        }
        // cargar la compra
        Proveedor c = (Proveedor) cbProveedor.getSelectedItem();
        Compra v = new Compra(compraData.numeroCompra(), LocalDate.now(), c, true);
        compraData.guardar(v);

        //recorrer la tabla
        for (int row = 0; row < jtable.getRowCount() - 1; row++) {
            DetalleCompra dc = new DetalleCompra();
            dc.setCantidad(Integer.parseInt(jtable.getValueAt(row, 1).toString()));
            dc.setPrecioCosto(Double.parseDouble(jtable.getValueAt(row, 3).toString()));
            dc.setCompra(v);
            dc.setProducto(productosAgregados.get(row));
            detalleCompraData.guardar(dc);
        }

        JOptionPane.showMessageDialog(this, "Compra realizada.");
        borrarFilasTabla();

        productosAgregados.clear();
    }//GEN-LAST:event_jBtnRealizarCompraActionPerformed

    private void borrarFilasTabla() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cargarCB() {
        String text = textField2.getText();
        cbProductos.removeAllItems();

        for (Producto item : lista) {
            cbProductos.addItem(item);
        }
        cbProductos.setPopupVisible(true);
        textField2.setText(text);
    }

    private void cargarCB2(ArrayList<Proveedor> lista) {
        String text = textField.getText();
        cbProveedor.removeAllItems();
        for (Proveedor item : lista) {
            cbProveedor.addItem(item);
        }
        cbProveedor.setPopupVisible(true);
        textField.setText(text);
    }

    private boolean validar(DetalleCompra v) {
        ArrayList<String> errores = new ArrayList();

        if (!jtf_cantidad.getText().toLowerCase().matches("[0-9]{1,10}")) {
            errores.add("Campo cantidad: ingrese un número.");
        } else {
            v.setCantidad(Integer.parseInt(jtf_cantidad.getText()));
        }

        if (!errores.isEmpty()) {
            String mensaje = "";
            for (int i = 0; i < errores.size(); i++) {
                if (i == errores.size() - 1) {
                    mensaje += errores.get(i) + ", ";
                } else {
                    mensaje += errores.get(i) + ".";
                }
            }
            JOptionPane.showMessageDialog(this, mensaje);
            return false;
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarCompra2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarCompra2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cbProductos;
    private javax.swing.JComboBox<Proveedor> cbProveedor;
    private javax.swing.JButton jBtnAgregarLista;
    private javax.swing.JButton jBtnRealizarCompra;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField jtf_cantidad;
    // End of variables declaration//GEN-END:variables
}
