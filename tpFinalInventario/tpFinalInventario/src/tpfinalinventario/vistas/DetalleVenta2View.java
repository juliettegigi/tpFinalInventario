/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

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
 * @author julie
 */
public class DetalleVenta2View extends javax.swing.JInternalFrame {

      private DefaultTableModel modelo;
      private DefaultTableModel modelo2;
      private DetalleVentaData detalleVentaData = new DetalleVentaData();
      private ProductoData productoData = new ProductoData();
       private VentaData ventaData = new VentaData();
       private ClienteData clienteData=new ClienteData();
        private JPopupMenu menu;
     private ArrayList<Venta> listaVenta=(ArrayList<Venta>) ventaData.listaSinEstadoDelCliente();   
    public DetalleVenta2View() {
        initComponents();
         modelo = new DefaultTableModel(){
            @Override
             public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2 );
            }
        };
         armarCabeceraTabla();
        llenarTabla();
         modelo2=new DefaultTableModel(){
            @Override
             public boolean isCellEditable(int row, int column) {
                return !(column == 0 || column == 1 || column == 2 );
            }
        };
         armarCabeceraTabla2();
        
        
        //clivk derechi
        menu= new JPopupMenu();
        JMenuItem item = new JMenuItem("verDetalle");
        item.addActionListener(e -> verDetalle());
        menu.add(item);
        jTable1.setComponentPopupMenu(menu);
    }

    
    private void verDetalle(){
         int row = jTable1.getSelectedRow();
      if (row == -1){
          JOptionPane.showMessageDialog(this, "Seleccione la fila.");
         return;
      }
      
      int idCliente=Integer.parseInt(jTable1.getValueAt(row,2 ).toString());
      Cliente c=clienteData.buscarPorDNISinEstado(idCliente);
      jLabel2.setText("<html>"+c.getNombre()+", "+c.getApellido()+" <br> Domicilio: "+c.getDomicilio()+"<br>Telefono:"+c.getTelefono()+"</html>");
      
      int id=Integer.parseInt(jTable1.getValueAt(row,0 ).toString());
      //lista de detalleventa con el id de la venta
      ArrayList<DetalleVenta> listaDetalleVenta=(ArrayList<DetalleVenta>) detalleVentaData.detalleVentaPorIdVenta(id);
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
    }
     
     private void armarCabeceraTabla2(){
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
     
      private void llenarTabla(){
           borrarFilas(modelo);
           
           //tengo toda la lista de venta
          if (listaVenta.isEmpty()) {
              System.out.println("entro?");
              return;
           }
        for (Venta v : listaVenta) {
            Cliente c=clienteData.buscarPorDNISinEstado(v.getCliente().getDni());
            modelo.addRow(new Object[]{v.getIdVenta(),v.getFecha(),c.getDni()});
          
        }
        
        
    }
    
 private void llenarTabla2(ArrayList<DetalleVenta> listaDetalleVenta) {
        borrarFilas(modelo2);
        if (listaDetalleVenta.isEmpty()) {
            return;
        }
        double total=0;
        for (DetalleVenta dv : listaDetalleVenta) {
            Producto p=productoData.buscarPorIdSinEstado(dv.getProducto().getIdProducto());
            modelo2.addRow(new Object[]{p.getNombre(), dv.getCantidad(),p.getPrecioActual()});
           total+=dv.getPrecioVenta();
        }
        
         modelo2.addRow(new Object[]{ "","",total});
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
