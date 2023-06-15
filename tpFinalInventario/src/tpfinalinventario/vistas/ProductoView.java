/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.entidades.Producto;
/**
 *
 * @author julie
 */
public class ProductoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Producto
     */
    public ProductoView() {
        initComponents();
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnActualizar.setEnabled(false);
        
       
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
        jtf_id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtf_categoria = new javax.swing.JTextField();

        jLabel1.setText("NOMBRE: ");

        jLabel2.setText("DESCRIPCIÓN: ");

        jLabel3.setText("PRECIO ACTUAL: ");

        jLabel4.setText("STOCK: ");

        jtf_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nombreFocusGained(evt);
            }
        });

        jta_descripcion.setColumns(20);
        jta_descripcion.setRows(5);
        jScrollPane1.setViewportView(jta_descripcion);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("PRODUCTO");

        jLabel6.setText("ID: ");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("CATEGORÍA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jButton1))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)
                                .addGap(31, 31, 31)
                                .addComponent(jButton3))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_categoria)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_precioActual))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_precioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jtf_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(jButton3))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int id=0;
        try{
            id=Integer.parseInt(jtf_id.getText());
        
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(this, "Error con el id ingresado, "+e.getMessage());
            return;
        }
        
        ProductoData pd=new ProductoData();
        Producto producto=pd.buscarPorId(id);
        if(producto==null){
            JOptionPane.showMessageDialog(this, "El producto con ID: " + id + " no existe en nuestro registro");
            btnEliminar.setEnabled(false);
            btnActualizar.setEnabled(false);
            return;
        }
           
        jtf_nombre.setText(producto.getNombre());
        jta_descripcion.setText(producto.getDescripcion());
        jtf_precioActual.setText(String.valueOf(producto.getPrecioActual()));
        jtf_stock.setText(String.valueOf(producto.getStock()));
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnActualizar.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
         ProductoData productoData=new ProductoData();
         Producto p=cargarDatos();
         
         if(productoData.guardar(p))
              JOptionPane.showMessageDialog(this,  "Producto guardado.\n ");
         else  JOptionPane.showMessageDialog(this,  "Producto no guardado, el producto ya existe o error.\n ");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        int id=0;
        try{
        id=Integer.parseInt(jtf_id.getText());
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error con el id ingresado, "+e.getMessage());
            return;   
        }
         ProductoData pd=new ProductoData();
        pd.eliminadoLogico(id);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
        int id=0;
        try{
            id=Integer.parseInt(jtf_id.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Debe ingresar un número en el campo id.\n"+e.getMessage());
            return;
        }
        if (!validar())
            return;
        
        ProductoData productoData=new ProductoData();
     
        Producto producto=cargarProducto();
        producto.setIdProducto(id);
        productoData.update(producto);
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  limpiar();
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nombreFocusGained
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_jtf_nombreFocusGained

    
    
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
       jtf_id.setText("");
       jtf_precioActual.setText("");
       jtf_stock.setText("");
       jta_descripcion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jta_descripcion;
    private javax.swing.JTextField jtf_categoria;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_precioActual;
    private javax.swing.JTextField jtf_stock;
    // End of variables declaration//GEN-END:variables
}
