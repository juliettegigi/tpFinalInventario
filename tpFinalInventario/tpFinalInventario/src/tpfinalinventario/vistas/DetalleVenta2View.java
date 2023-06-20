/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxEditor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
 * @author julie
 */
public class DetalleVenta2View extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private DetalleVentaData detalleVentaData = new DetalleVentaData();
    private ProductoData productoData = new ProductoData();
    private VentaData ventaData = new VentaData();
    private ClienteData clienteData = new ClienteData();
    private JPopupMenu menu;
    private ArrayList<Venta> listaVenta = (ArrayList<Venta>) ventaData.listaSinEstadoDelCliente();
    private JTextField textField;
    private ArrayList<Producto> lista;

    public DetalleVenta2View() {
        initComponents();

        //le agrego un evento al jdatechooser
        jDateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    if (selectedDate != null) {

                        Date fechaDate = jDateChooser.getDate();

                        if (cbProductos.getSelectedIndex() == -1) {
                            listaVenta = (ArrayList<Venta>) ventaData.listaSinEstadoDelCliente();
                        } else {
                            Producto productoSeleccionado = (Producto) cbProductos.getSelectedItem();
                            listaVenta = (ArrayList<Venta>) ventaData.buscarPorIdProducto(productoSeleccionado.getIdProducto());
                        }

                        LocalDate fechaLocalDate = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        ArrayList<Venta> l = new ArrayList();
                        for (Venta v : listaVenta) {
                            if (v.getFecha().equals(fechaLocalDate)) {
                                l.add(v);
                            }
                        }
                        listaVenta = l;
                        llenarTabla();
                    }
                }
                borrarFilas(modelo2);
                jLabel2.setText("");
            }

        });

        // Agregar un editor al ComboBox
        cbProductos.setEditable(true);
        ComboBoxEditor editor = cbProductos.getEditor();
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
                listaVenta.clear();
                llenarTabla();
                lista = (ArrayList<Producto>) productoData.nombresEmpiezanConSinEstado(textField.getText());
                cargarCB();
            }

        });

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2);
            }
        };
        armarCabeceraTabla();
        llenarTabla();
        modelo2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2);
            }
        };
        armarCabeceraTabla2();

        //clivk derechi
        menu = new JPopupMenu();
        JMenuItem item = new JMenuItem("verDetalle");
        item.addActionListener(e -> verDetalle());
        menu.add(item);
        jTable1.setComponentPopupMenu(menu);

    }

    private void cargarCB() {
        String text = textField.getText();
        cbProductos.removeAllItems();
        for (Producto item : lista) {
            cbProductos.addItem(item);
        }
        cbProductos.setPopupVisible(true);
        textField.setText(text);
    }

    private void verDetalle() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione la fila.");
            return;
        }
        Object hiddenColumnValue = modelo.getValueAt(row, 0);
        int idCliente = Integer.parseInt(jTable1.getValueAt(row, 1).toString());
        Cliente c = clienteData.buscarPorDNISinEstado(idCliente);
        jLabel2.setText("<html>" + c.getNombre() + ", " + c.getApellido() + " <br> Domicilio: " + c.getDomicilio() + "<br>Telefono:" + c.getTelefono() + "</html>");

        int id = Integer.parseInt(hiddenColumnValue.toString());
        //lista de detalleventa con el id de la venta
        ArrayList<DetalleVenta> listaDetalleVenta = (ArrayList<DetalleVenta>) detalleVentaData.detalleVentaPorIdVenta(id);
        llenarTabla2(listaDetalleVenta);
    }

    private void armarCabeceraTabla() {
        //creo las columnas de la tabla
        ArrayList<Object> columns = new ArrayList();
        columns.add("Id DE VENTA");
        columns.add("FECHA");
        columns.add("CLIENTE(DNI)");

        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo.addColumn(it);
        }
        jTable1.setModel(modelo);
        // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = jTable1.getColumnModel();

        // Obtener la columna que deseas ocultar
        TableColumn columnToHide = columnModel.getColumn(0); // Por ejemplo, ocultar la segunda columna (índice 1)

        // Ocultar la columna
        columnModel.removeColumn(columnToHide);
    }

    private void armarCabeceraTabla2() {
        //creo las columnas de la tabla
        ArrayList<Object> columns = new ArrayList();
        columns.add("PRODUCTO");
        columns.add("CANTIDAD");
        columns.add("PRECIO");

        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo2.addColumn(it);
        }
        jTable2.setModel(modelo2);
    }

    private void borrarFilas(DefaultTableModel model) {

        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void llenarTabla() {
        borrarFilas(modelo);
        for (Venta v : listaVenta) {
            Cliente c = clienteData.buscarPorDNISinEstado(v.getCliente().getDni());
            modelo.addRow(new Object[]{v.getIdVenta(), v.getFecha(), c.getDni()});

        }

    }

    private void llenarTabla2(ArrayList<DetalleVenta> listaDetalleVenta) {
        borrarFilas(modelo2);
        if (listaDetalleVenta.isEmpty()) {
            return;
        }
        double total = 0;
        for (DetalleVenta dv : listaDetalleVenta) {
            Producto p = productoData.buscarPorIdSinEstado(dv.getProducto().getIdProducto());
            modelo2.addRow(new Object[]{p.getNombre(), dv.getCantidad(), p.getPrecioActual()});
            total += dv.getPrecioVenta();
        }

        modelo2.addRow(new Object[]{"", "", total});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Lista de ventas realizadas");

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

        jLabel3.setText("Producto:");

        jLabel4.setText("Fecha: ");

        jButton1.setText("Todos los productos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed

        try {
            Producto productoSeleccionado = (Producto) cbProductos.getSelectedItem();
            borrarFilas(modelo);
            listaVenta = (ArrayList<Venta>) ventaData.buscarPorIdProducto(productoSeleccionado.getIdProducto());
            if (listaVenta.isEmpty()) {
                return;
            }
            llenarTabla();
        } catch (Exception e) {

        }
        borrarFilas(modelo2);
        jLabel2.setText("");
    }//GEN-LAST:event_cbProductosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cbProductos.setSelectedIndex(-1);
        jDateChooser.setDate(null);
        listaVenta = (ArrayList<Venta>) ventaData.listaSinEstadoDelCliente();
        llenarTabla();

        borrarFilas(modelo2);
        jLabel2.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cbProductos;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
