/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tpfinalinventario.vistas;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
 * @author Paula Priotti
 */
public class RealizarVenta extends javax.swing.JInternalFrame {
     private DefaultTableModel modelo;
    ClienteData clienteData = new ClienteData();
    VentaData ventaData = new VentaData();
    DetalleVentaData detalleVentaData = new DetalleVentaData();
    ProductoData productoData = new ProductoData();
    private ArrayList<Producto> lista;
    private Producto producto;
    private JPopupMenu menuEliminar;
    ArrayList<Producto> productosAgregados=new ArrayList();
    public RealizarVenta() {
        initComponents();
        initComboBox();
        modelo=new DefaultTableModel(){
            @Override
             public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2|| column == 3 );
            }
        };
        armarCabeceraTabla();
        modelo.addRow(new Object[]{ "","","",0});
        menuEliminar = new JPopupMenu();
        JMenuItem itemEliminar = new JMenuItem("Eliminar");
        itemEliminar.addActionListener(e -> eliminarFila());
        menuEliminar.add(itemEliminar);
        jtable.setComponentPopupMenu(menuEliminar);
    }

    
    // para cuando hacen click derecho
    private void eliminarFila() {
      int row = jtable.getSelectedRow();
      if (row == -1){
          JOptionPane.showMessageDialog(this, "Seleccione la fila.");
         return;
      }
      int cantidad=Integer.parseInt(jtable.getValueAt(row,1 ).toString());
      Producto productoAEliminar=productosAgregados.get(row);
      productoAEliminar.setStock(productoAEliminar.getStock()+cantidad);
      productoData.update(productoAEliminar);
      productosAgregados.remove(row);
    
           modelo.removeRow(row);
      
      
      // actualizar total
      row=modelo.getRowCount()-1;
      double total=Double.parseDouble(jtable.getValueAt(row,3 ).toString());
      total-=cantidad*productoAEliminar.getPrecioActual();
       modelo.removeRow(row);
      modelo.addRow(new Object[]{ "","","",total});
     
}
    
    private void armarCabeceraTabla(){
         ArrayList<Object> columns=new ArrayList();
        columns.add("Producto");
        columns.add("Cantidad");
        columns.add("Precio");
        columns.add("Total");
        //recorro el arrayList, a nuestro modelo le agrego columnas
        for(Object it:columns)
            modelo.addColumn(it);
        //a la tabla alumno le cambio el modelo, le pongo este que tiene estas columnas(id,nombre, nota)
       jtable.setModel(modelo);
    }
    
      private void cargarDatosTabla(){
               //quito la última fila      
                modelo.removeRow(modelo.getRowCount()-1);
                
                Producto p=(Producto) cbProductos.getSelectedItem();
                double total= Integer.parseInt(jtf_cantidad.getText())*p.getPrecioActual();
                 modelo.addRow(new Object[]{ p.getNombre(),jtf_cantidad.getText(),p.getPrecioActual(),total});
                 
                 total=0;
                 for (int row = 0; row < jtable.getRowCount(); row++) {
                      total+=Double.parseDouble(jtable.getValueAt(row,3 ).toString());
                 } 
                modelo.addRow(new Object[]{ "","","",total});
        } 
  
        
    
    private void initComboBox() {
        ArrayList<Cliente> lista = (ArrayList<Cliente>) clienteData.lista();
        if (!lista.isEmpty()) {
            for (Cliente item : lista) {
                jcb_clientes.addItem(item);
            }
        }
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
        jcb_clientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_cantidad = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbProductos = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("VENDER");

        jcb_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("CLIENTE");

        jLabel3.setText("Cantidad: ");

        jLabel5.setText("Producto:");

        jtf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_nombreKeyReleased(evt);
            }
        });

        jButton1.setText("Realizar venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar a la lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(248, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(jcb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        // cargar la venta
        Cliente c = (Cliente) jcb_clientes.getSelectedItem();
        System.out.println("nu,ero de venta "+ventaData.numeroVenta());
        Venta v = new Venta(ventaData.numeroVenta(),LocalDate.now(), c, true);
        ventaData.guardar(v);
        
        //recorrer la tabla
         for (int row = 0; row < jtable.getRowCount()-1; row++) {
             DetalleVenta dv=new DetalleVenta();
             dv.setCantidad(Integer.parseInt(jtable.getValueAt(row, 1).toString()));
             dv.setPrecioVenta(Double.parseDouble(jtable.getValueAt(row, 3).toString()));
             dv.setVenta(v);
             dv.setProducto(productosAgregados.get(row));
             detalleVentaData.guardar(dv);
         }
       
      
            JOptionPane.showMessageDialog(this, "Venta realizada.");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nombreKeyReleased
         lista=(ArrayList<Producto>) productoData.nombresEmpiezanCon(jtf_nombre.getText());
         System.out.println(lista);
         cargarCB();
         
    }//GEN-LAST:event_jtf_nombreKeyReleased

    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
         producto=(Producto) cbProductos.getSelectedItem();
        if(producto==null)return;
    }//GEN-LAST:event_cbProductosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
          if(!jtf_cantidad.getText().toLowerCase().matches("[0-9]{1,10}")){
              JOptionPane.showMessageDialog(null,"Campo cantidad: ingrese un número."); 
              return;
          }      
          int cantidad=Integer.parseInt(jtf_cantidad.getText());
          if(producto.getStock()<cantidad){
            JOptionPane.showMessageDialog(this, "Stock disponible: "+producto.getStock()+" .Venta rechazada.");
            return;
        }
        
          producto.setStock(producto.getStock()-cantidad);
          productoData.update(producto);
          cargarDatosTabla();
        productosAgregados.add(producto);
    }//GEN-LAST:event_jButton2ActionPerformed

    
       private void cargarCB(){
        cbProductos.removeAllItems();       
        for(Producto item:lista){
                cbProductos.addItem(item);               
        }
        cbProductos.setPopupVisible(true);
    }
    
       
       
       
       
       
       private boolean validar( DetalleVenta v){
         ArrayList<String> errores=new ArrayList();
         
         
        if(!jtf_cantidad.getText().toLowerCase().matches("[0-9]{1,10}"))
              errores.add("Campo cantidad: ingrese un número.");
        else v.setCantidad(Integer.parseInt(jtf_cantidad.getText()));
        
         
     
         if(!errores.isEmpty()){
                 String mensaje="";
            for(int i=0; i<errores.size();i++){
                if(i==errores.size()-1)
                    mensaje+=errores.get(i)+", ";
                else  mensaje+=errores.get(i)+".";
            }
          JOptionPane.showMessageDialog(this,mensaje);
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
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarVenta().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Producto> cbProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<Cliente> jcb_clientes;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField jtf_cantidad;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables
}
