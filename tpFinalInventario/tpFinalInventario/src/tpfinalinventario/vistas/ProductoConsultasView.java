/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tpfinalinventario.accesoADatos.DetalleVentaData;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.entidades.Producto;

/**
 *
 * @author julie
 */
public class ProductoConsultasView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ProductoData productoData = new ProductoData();
    private DetalleVentaData detalleVentaData = new DetalleVentaData();
    private ArrayList<Producto> lista;

    public ProductoConsultasView() {

        initComponents();
        jtf_buscar.setVisible(false);
        btnBuscar.setVisible(false);
        rbtnTodos.setSelected(true);
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        lista = (ArrayList<Producto>) productoData.lista();
        llenarTabla(lista);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableT = new javax.swing.JTable();
        rbtnTodos = new javax.swing.JRadioButton();
        rbtnCategoria = new javax.swing.JRadioButton();
        rbtnNombre = new javax.swing.JRadioButton();
        jtf_buscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("PRODUCTOS");

        jTableT.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableT);

        buttonGroup1.add(rbtnTodos);
        rbtnTodos.setText("Todos");
        rbtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnCategoria);
        rbtnCategoria.setText("Categoria");
        rbtnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCategoriaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnNombre);
        rbtnNombre.setText("Nombre");
        rbtnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNombreActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Productos vendidos");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(rbtnTodos)
                                .addGap(28, 28, 28)
                                .addComponent(rbtnCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnNombre)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTodos)
                    .addComponent(rbtnCategoria)
                    .addComponent(rbtnNombre)
                    .addComponent(jRadioButton1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodosActionPerformed
        jtf_buscar.setVisible(false);
        btnBuscar.setVisible(false);
        lista = (ArrayList<Producto>) productoData.lista();
        if (lista.isEmpty()) {
            return;
        }
        llenarTabla(lista);

    }//GEN-LAST:event_rbtnTodosActionPerformed

    private void rbtnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCategoriaActionPerformed
        borrarFilas();
        jtf_buscar.setText("");
        jtf_buscar.setVisible(true);
        btnBuscar.setVisible(true);


    }//GEN-LAST:event_rbtnCategoriaActionPerformed

    private void rbtnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNombreActionPerformed
        borrarFilas();
        jtf_buscar.setText("");
        jtf_buscar.setVisible(true);
        btnBuscar.setVisible(true);
    }//GEN-LAST:event_rbtnNombreActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

//        System.out.println(buttonGroup1.getSelection().getSelectedObjects().toString());
        if (rbtnCategoria.isSelected()) {
            if (jtf_buscar.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese una categoría.");
            }
            lista = (ArrayList<Producto>) productoData.buscarCampoValor("categoria", jtf_buscar.getText());
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La categoria \"" + jtf_buscar.getText() + "\" no contiene productos.");
            } else {
                llenarTabla(lista);
            }
            return;
        }

        if (jtf_buscar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre.");
        }
        lista = (ArrayList<Producto>) productoData.buscarCampoValor("nombre", jtf_buscar.getText());
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre \"" + jtf_buscar.getText() + "\" no contiene productos.");
        } else {
            llenarTabla(lista);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        jtf_buscar.setVisible(false);
        btnBuscar.setVisible(false);
        lista = (ArrayList<Producto>) detalleVentaData.productosEnDetalleVenta();
        if (lista.isEmpty()) {
            return;
        }
        llenarTabla(lista);


    }//GEN-LAST:event_jRadioButton1ActionPerformed

    public void borrarFilas() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    private void armarCabeceraTabla() {
        //creo las columnas de la tabla
        ArrayList<Object> columns = new ArrayList();
        columns.add("NOMBRE");
        columns.add("CATEGORIA");
        columns.add("DESCRIPCIÓN");
        columns.add("PRECIO ACTUAL");
        columns.add("STOCK");
        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo.addColumn(it);
        }
        //a la tabla alumno le cambio el modelo, le pongo este que tiene estas columnas(id,nombre, nota)
        jTableT.setModel(modelo);
    }

    private void llenarTabla(ArrayList<Producto> lista) {
        borrarFilas();
        if (lista.isEmpty()) {
            return;
        }
        for (Producto p : lista) {
            modelo.addRow(new Object[]{p.getNombre(), p.getCategoria(), p.getDescripcion(), p.getPrecioActual(), p.getStock()});

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableT;
    private javax.swing.JTextField jtf_buscar;
    private javax.swing.JRadioButton rbtnCategoria;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JRadioButton rbtnTodos;
    // End of variables declaration//GEN-END:variables
}
