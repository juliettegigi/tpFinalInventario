/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tpfinalinventario.accesoADatos.CompraData;
import tpfinalinventario.accesoADatos.DetalleCompraData;
import tpfinalinventario.accesoADatos.ProductoData;
import tpfinalinventario.accesoADatos.ProveedorData;
import tpfinalinventario.accesoADatos.VentaData;
import tpfinalinventario.entidades.Cliente;
import tpfinalinventario.entidades.Compra;
import tpfinalinventario.entidades.DetalleCompra;
import tpfinalinventario.entidades.DetalleVenta;
import tpfinalinventario.entidades.Producto;
import tpfinalinventario.entidades.Proveedor;

/**
 *
 * @author santi
 */
public class DetalleCompraView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ProductoData productoData = new ProductoData();
    private DetalleCompraData detalleCompraData = new DetalleCompraData();
    private ProveedorData proveedorData = new ProveedorData();
    private ArrayList<Producto> lista;
    private CompraData compraData=new CompraData();

    /**
     * Creates new form DetalleCompraView
     */
    public DetalleCompraView() {
        initComponents();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        lista = (ArrayList<Producto>) productoData.lista();
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
        jtf_numCompra = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Detalle de Compra");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("N° Compra");

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
        btSalir.setText("Salir");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Proveedor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        jLabel5.setText("nombre");

        jLabel6.setText("fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_numCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalir)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_numCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSalir)
                .addGap(186, 186, 186))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // ACCION BOTON BUSCAR
        if (jtf_numCompra.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de compra.");
            return;
        }
        
        int numero=0;
        try{
            numero=Integer.parseInt(jtf_numCompra.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ingrese un número.");
            return; 
        }
        
        // lista de compra, con un numero de compra, es uno solo
        Compra compra = compraData.buscarPorNumeroDeCompra(numero);
        if(compra==null){
            JOptionPane.showMessageDialog(this, "No existe ese número de compra.");
            return; 
        }
           
        String fecha=compra.getFecha().toString();
        Proveedor prov=compra.getProveedor();
        jLabel5.setText("Proveedor: "+prov.getRazonSocial());
        jLabel6.setText("Fecha: "+fecha);
        // buscar en detalleVenta por idVenta
        ArrayList<DetalleCompra> listaDetalleCompra= new ArrayList<DetalleCompra>();
        
        llenarTabla(listaDetalleCompra);
        
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
    }//GEN-LAST:event_btBuscarActionPerformed
    private void armarCabeceraTabla() {
        //creo las columnas de la tabla
        ArrayList<Object> columns = new ArrayList();
        columns.add("PRODUCTO");
        columns.add("CANTIDAD");
        columns.add("PRECIO");
        columns.add("FECHA");
        columns.add("PROVEEDOR");

        //recorro el arrayList, a nuestro modelo le agrego columnas
        for (Object it : columns) {
            modelo.addColumn(it);
        }
        jTable1.setModel(modelo);
    }

    private void llenarTabla(ArrayList<DetalleCompra> listaDetalleCompra) {
        borrarFilas();
        if (listaDetalleCompra.isEmpty()) {
            return;
        }
        double total=0;
        for (DetalleCompra dc : listaDetalleCompra) {
            Producto p=productoData.buscarPorId(dc.getProducto().getIdProducto());
            modelo.addRow(new Object[]{p.getNombre(), dc.getCantidad(),p.getPrecioActual()});
           total+=dc.getPrecioCosto();
        }
        
         modelo.addRow(new Object[]{ "","",total});
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtf_numCompra;
    // End of variables declaration//GEN-END:variables
}
