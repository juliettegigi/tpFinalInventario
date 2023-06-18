/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ComboBoxEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.entidades.Producto;
/**
 *
 * @author julie
 */
public class ProductoView extends javax.swing.JInternalFrame {

    private ArrayList<Producto> lista;
    private int idBuscado;
    private  ProductoData pd=new ProductoData();
    private JTextField textField;
    public ProductoView() {
        initComponents();
        setSize(624, 564);
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);       
       jLabel9.setText("AGREGAR PRODUCTO");
       // Agregar un editor al ComboBox
        cbResultado.setEditable(true);
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
                
        lista=(ArrayList<Producto>) pd.nombresEmpiezanCon(textField.getText());
         cargarCB();
            }

       
        });
         
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_precioActual = new javax.swing.JTextField();
        jtf_stock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_categoria = new javax.swing.JTextField();
        cbResultado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("NOMBRE: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("DESCRIPCIÓN: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("PRECIO ACTUAL: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("STOCK: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        jtf_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nombreFocusGained(evt);
            }
        });
        getContentPane().add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 200, 33));
        getContentPane().add(jtf_precioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 186, 84, 30));
        getContentPane().add(jtf_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 60, 33));

        jta_descripcion.setColumns(20);
        jta_descripcion.setRows(5);
        jScrollPane1.setViewportView(jta_descripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 563, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("BUSCAR PRODUCTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 200, 43));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("NOMBRE:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 659, 29));

        btnAgregar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        btnActualizar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, -1, -1));

        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setText("CATEGORÍA:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        getContentPane().add(jtf_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 179, 33));

        cbResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResultadoActionPerformed(evt);
            }
        });
        getContentPane().add(cbResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 52, 287, 31));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setText("AGREGAR PRODUCTO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     private void cargarCB(){
        String text = textField.getText();
        cbResultado.removeAllItems();       
        for(Producto item:lista){
                cbResultado.addItem(item);               
        }
        cbResultado.setPopupVisible(true);
        textField.setText(text);
    }
    
    private void cargarTF(Producto producto){
        jtf_nombre.setText(producto.getNombre());
        jtf_categoria.setText(producto.getCategoria());
        jta_descripcion.setText(producto.getDescripcion());
        jtf_precioActual.setText(String.valueOf(producto.getPrecioActual()));
        jtf_stock.setText(String.valueOf(producto.getStock()));
    }
    
    
    private Producto cargarProducto(){       
        Producto p=new Producto();
        
      
            p.setNombre(jtf_nombre.getText());
            p.setDescripcion(jta_descripcion.getText());
            p.setPrecioActual(Double.parseDouble(jtf_precioActual.getText()));
            p.setEstado(true);            
            p.setStock(Integer.parseInt(jtf_stock.getText()));
            p.setCategoria(jtf_categoria.getText());
        
        return p;
    }
    
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         
         
                
         if (!validar())
            return;
         
         
         if(!pd.buscarCampoValor("nombre",jtf_nombre.getText()).isEmpty()){
              int respuesta = JOptionPane.showConfirmDialog(this, "Ya existe un producto con nombre:"+jtf_nombre.getText()+"\n"+"Desea agregar?", "Si", JOptionPane.YES_NO_OPTION);
              if (respuesta == JOptionPane.NO_OPTION){
                  JOptionPane.showMessageDialog(this,  "Operación cancelada.\n ");
                  return;
              }
         }
         
         // si se encuentra inactivo
          
         if(pd.buscarPorNombreInactivo(jtf_nombre.getText())!=null){
             
                  JOptionPane.showMessageDialog(this, "Ya existe un producto con nombre:"+jtf_nombre.getText()+"\n"+" en la lista de productos inactivos"+"\n"+"Activelo y actualícelo.");
                  return;
              }
         
             
         Producto p=cargarDatos();
         
         if(pd.guardar(p))
              JOptionPane.showMessageDialog(this,  "Producto guardado.\n ");
         else  JOptionPane.showMessageDialog(this,  "Producto no guardado, el producto ya existe o error.\n ");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
      if(cbResultado.getSelectedItem()==null){
             JOptionPane.showMessageDialog(this,"Debe seleccionar un producto");
             return;
        }
        
        if(pd.eliminadoLogico(idBuscado))
          JOptionPane.showMessageDialog(this, "Producto eliminado. " );
        else 
          JOptionPane.showMessageDialog(this,"El producto seleccionado no existe. ");
         cbResultado.setSelectedItem(null);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        if(cbResultado.getSelectedItem()==null){
             JOptionPane.showMessageDialog(this,"Debe seleccionar un producto");
             return;
        }
            
     
        if (!validar())
            return;
     
        Producto producto=cargarProducto();
        producto.setIdProducto(idBuscado);
        if(pd.update(producto))
            JOptionPane.showMessageDialog(this,"Producto actualizado");
        else  JOptionPane.showMessageDialog(this,"Producto no actualizado");
         cbResultado.setSelectedItem(null);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  limpiar();
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nombreFocusGained
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_jtf_nombreFocusGained

    private void cbResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResultadoActionPerformed
        // CUANDO SELECCIONAN UN PRODUCTO DEL CB
        Producto p=(Producto) cbResultado.getSelectedItem();
        if(p==null)return;
        idBuscado=p.getIdProducto();
        cargarTF(p);
        jLabel9.setText("Producto seleccionado.");
         btnEliminar.setEnabled(true);
        btnActualizar.setEnabled(true);
         btnAgregar.setEnabled(false);
    }//GEN-LAST:event_cbResultadoActionPerformed

    
    
    private boolean validar( ){
         ArrayList<String> errores=new ArrayList();
         
         if(jtf_nombre.getText().trim().length()==0)
            errores.add("Campo nombre es obligatorio.");
       
         
           if(jtf_categoria.getText().trim().length()==0)
            errores.add("Campo categoría es obligatorio.");
         
        try{
          Integer.parseInt(jtf_stock.getText());    
        }
        
        
        
        catch(Exception e){
            errores.add("Campo stock: numérico.");
        }
         try{
            Double.parseDouble(jtf_precioActual.getText());    
        }
        catch(Exception e){
            errores.add("Campo precio actual: numérico.");
        }
         
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
    
    
    private Producto cargarDatos(){
        Producto p=new Producto();
        
        p.setNombre(jtf_nombre.getText());
        p.setCategoria(jtf_categoria.getText());
        p.setDescripcion(jta_descripcion.getText());
        p.setPrecioActual(Double.parseDouble(jtf_precioActual.getText()));
        p.setStock(Integer.parseInt(jtf_stock.getText()));
        p.setEstado(true);
        return p;
    }
    
    
    
    private void limpiar(){
       btnAgregar.setEnabled(false);
       btnEliminar.setEnabled(false);
       btnActualizar.setEnabled(false);
       jtf_nombre.setText("");
       textField.setText("");
       jtf_precioActual.setText("");
       jtf_stock.setText("");
       jta_descripcion.setText("");
       jtf_categoria.setText("");
       jLabel9.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<Producto> cbResultado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jta_descripcion;
    private javax.swing.JTextField jtf_categoria;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_precioActual;
    private javax.swing.JTextField jtf_stock;
    // End of variables declaration//GEN-END:variables
}
