/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
    private ArrayList<Producto> productosAgregados=new ArrayList();
    private ComboBoxEditor editor2; 
    private JTextField textField2;
    private JTextField textField;
    public RealizarVenta() {
        initComponents();
        setSize(497, 529);
      //  initComboBox();
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
        setTitle("VENDER");
         jButton1.setText("<html>Realizar<br> venta</html>");
         
         //
            cbResultado.setEditable(true); // Habilitar la edición del ComboBox
            cbProductos.setEditable(true);
          // Agregar un editor al ComboBox
            
        editor2 = cbProductos.getEditor();
       textField2 = (JTextField) editor2.getEditorComponent();
        
        // Agregar un editor al ComboBox
        ComboBoxEditor editor = cbResultado.getEditor();
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
                
        ArrayList<Cliente> l=(ArrayList<Cliente>) clienteData.dnisEmpiezanCon(textField.getText());
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
            
                   lista=(ArrayList<Producto>) productoData.nombresEmpiezanCon(textField2.getText());
                   cargarCB();
                   
            }

       
        });
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
  
        


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_cantidad = new javax.swing.JTextField();
        cbProductos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        cbResultado = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("CLIENTE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 23, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 750, 22));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Producto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, -1, -1));
        getContentPane().add(jtf_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 70, 30));

        cbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductosActionPerformed(evt);
            }
        });
        getContentPane().add(cbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 250, 32));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("<html>Realizar<br>   venta</html>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 110, 90));

        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setText("Agregar a la lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 281));

        cbResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResultadoActionPerformed(evt);
            }
        });
        cbResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbResultadoKeyReleased(evt);
            }
        });
        getContentPane().add(cbResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 250, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(productosAgregados.isEmpty()){
             JOptionPane.showMessageDialog(this, "No hay productos en la lista.");
             return;
        }
            
        
        if( cbResultado.getSelectedIndex()==-1){
             JOptionPane.showMessageDialog(this, "No ha seleccionado un cliente.");
            return;
        }
        // cargar la venta
        Cliente c = (Cliente) cbResultado.getSelectedItem();
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
            borrarFilasTabla();
            
        productosAgregados.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    
       private void borrarFilasTabla(){
      int a=modelo.getRowCount()-1;
      for(int i=a;i>=0;i--)
          modelo.removeRow(i);
    }
    
    private void cbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductosActionPerformed
       try{
               producto=(Producto) cbProductos.getSelectedItem();    
       }   catch(Exception e ){
           
       }
       
        
    }//GEN-LAST:event_cbProductosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
           if(cbProductos.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un producto."); 
              return;
        }
        
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

    private void cbResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResultadoActionPerformed
        
       
    }//GEN-LAST:event_cbResultadoActionPerformed

    private void cbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbResultadoKeyReleased
         
      
    }//GEN-LAST:event_cbResultadoKeyReleased

    
 
    
       private void cargarCB(){
         String text = textField2.getText();
        cbProductos.removeAllItems();    
      
        for(Producto item:lista){
                cbProductos.addItem(item);               
        }
        cbProductos.setPopupVisible(true);
        textField2.setText(text);
    }
    
       
        private void cargarCB2(ArrayList<Cliente> lista){
        String text = textField.getText();    
        cbResultado.removeAllItems(); 
        for(Cliente item:lista){
                cbResultado.addItem(item);
        }
        cbResultado.setPopupVisible(true); 
        textField.setText(text);
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
    private javax.swing.JComboBox<Cliente> cbResultado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtable;
    private javax.swing.JTextField jtf_cantidad;
    // End of variables declaration//GEN-END:variables
}
