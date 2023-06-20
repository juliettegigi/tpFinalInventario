/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tpfinalinventario.vistas;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
 * @author Paula Priotti
 */
public class RealizarCompraView extends javax.swing.JInternalFrame {

    private DefaultTableModel mod;
    private DefaultTableModel mod2;
    private Proveedor proveedorSeleccionado;
    ProveedorData prov = new ProveedorData();
    ProductoData prod = new ProductoData();
    CompraData compraD = new CompraData();
    DetalleCompraData dcD = new DetalleCompraData();

    /**
     * Creates new form DetalleCompraView
     */
    public RealizarCompraView() {
        initComponents();
       
        setSize(517, 560);
        //hago la tabla
        String[] columns = {"id", "nombre", "telefono"};
        mod = new DefaultTableModel(columns, 0);
        for (Proveedor p : prov.lista()) {
            Object[] d = {p.getIdProveedor(), p.getRazonSocial(), p.getTelefono()};
            mod.addRow(d);
        }
       
        jTableProv.setModel(mod);
        // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = jTableProv.getColumnModel();

        // Obtener la columna que deseas ocultar
        TableColumn columnToHide = columnModel.getColumn(0); // Por ejemplo, ocultar la segunda columna (índice 1)

        // Ocultar la columna
        columnModel.removeColumn(columnToHide);
        
        // Obtener el modelo de selección de la tabla
        ListSelectionModel selectionModel = jTableProv.getSelectionModel();

        // Agregar un ListSelectionListener al modelo de selección
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Verificar si la selección es válida y no está ajustándose
                if (!event.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
                    
                    int selectedRow = selectionModel.getMinSelectionIndex();
                     Object hiddenColumnValue = mod.getValueAt(selectedRow, 0);
                     int idProveedor = Integer.parseInt( hiddenColumnValue.toString());
                    int id=  (int) mod.getValueAt(selectedRow, 0);
                     proveedorSeleccionado=prov.buscar(id);
                    // Realizar acciones con los datos seleccionados
                   // System.out.println("//Fila seleccionada: " + id + ", " );
                }
            }
    });
        
        
        
        //HAGO LA TABLA 2
        
         String[] columns2 = {"id", "nombre", "categoria", "precio actual", "cantidad"};
         mod2 = new DefaultTableModel(columns2, 0) {
            @Override
            public boolean isCellEditable(int i, int il) {
                return il == 4;
            }
            @Override
            public void setValueAt(Object value, int row, int column) {
                Object oldValue = getValueAt(row, column); // Obtener el valor original
                super.setValueAt(value, row, column);
                Object newValue = getValueAt(row, column); // Obtener el nuevo valor

                if (oldValue != null && !oldValue.equals(newValue)) {
                    // La celda ha sido editada, realizar acciones aquí
                    
                   // System.out.println("Celda editada en la fila " + row + ", columna " + column);
                }
            }
            
        };
        
        
        cargarProductos();
        
        
        
                }

 

    private void cargarProductos() {
        
         
        for (Producto p : prod.lista()) {
            
            Object[] d = {p.getIdProducto(), p.getNombre(), p.getCategoria(), p.getPrecioActual(), "0"};
            mod2.addRow(d);
        }
        jTableProd.setModel(mod2);
              // Obtener el modelo de columnas de la tabla
        TableColumnModel columnModel = jTableProd.getColumnModel();

        // Obtener la columna que deseas ocultar
        TableColumn columnToHide = columnModel.getColumn(0); // Por ejemplo, ocultar la segunda columna (índice 1)

        // Ocultar la columna
        columnModel.removeColumn(columnToHide);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProv = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(508, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Comprar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(215, 11, 73, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Proveedores");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(23, 54, 86, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Productos");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(23, 204, 68, 20);

        jTableProv.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableProvMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProv);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(23, 92, 453, 84);

        jTableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Ca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableProdMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProd);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(23, 242, 452, 84);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Realizar compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(171, 344, 144, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(23, 188, 453, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProvMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProvMousePressed

    }//GEN-LAST:event_jTableProvMousePressed

    private void jTableProdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdMousePressed

    }//GEN-LAST:event_jTableProdMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //boton de realizar compra
        //metodo que obtiene cantidad de filas seleccionadas
        if(jTableProv.getSelectedRow()==-1){
             JOptionPane.showMessageDialog(this, "No ha seleccionado a un proveedor.");
             return;
        }
            
        int cantProd = jTableProd.getRowCount();
        int c=0;
        Compra comp = new Compra(compraD.numeroCompra(),LocalDate.now(),proveedorSeleccionado,true);
        compraD.guardar(comp);
        for (int i = 0; i < cantProd; i++) {
            if (!jTableProd.getValueAt(i, 3).equals("0")) {
                    DetalleCompra dc = new DetalleCompra();
                    Object hiddenColumnValue = mod2.getValueAt(i, 0);
                    int idCliente = Integer.parseInt(hiddenColumnValue.toString());
                    Producto p = prod.buscarPorId(idCliente);
                    dc.setCantidad(Integer.parseInt((String) jTableProd.getValueAt(i, 3)));
                    dc.setPrecioCosto(p.getPrecioActual());
                    dc.setCompra(comp);
                    dc.setProducto(p);
                    dc.setEstado(true);
                    p.setStock(p.getStock()+dc.getCantidad());
                    prod.update(p);
                    dcD.guardar(dc);
                    c++;    
            }
        }
      if(c==0)
           JOptionPane.showMessageDialog(this, "Debe colocar la cantidad de los productos.");
      else
      JOptionPane.showMessageDialog(this, "Compra realizada correctamente");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarCompraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarCompraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarCompraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarCompraView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarCompraView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableProd;
    private javax.swing.JTable jTableProv;
    // End of variables declaration//GEN-END:variables
}
