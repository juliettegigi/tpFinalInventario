/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpfinalinventario.vistas;

import javax.swing.JInternalFrame;

/**
 *
 * @author julie
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BarraMenu = new javax.swing.JMenuBar();
        MenuCliente = new javax.swing.JMenu();
        IMFormularioCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuCompra = new javax.swing.JMenu();
        IMRealizarCompra = new javax.swing.JMenu();
        IMDetalleCompra = new javax.swing.JMenuItem();
        MenuVenta = new javax.swing.JMenu();
        IMRealizarVenta = new javax.swing.JMenuItem();
        IMDetalleVenta = new javax.swing.JMenuItem();
        MenuProducto = new javax.swing.JMenu();
        IMFormularioProducto = new javax.swing.JMenuItem();
        IMConsulta = new javax.swing.JMenuItem();
        MenuProveedor = new javax.swing.JMenu();
        IMFormularioProveedor = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 80)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FraveMAX SRL ");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuCliente.setText("Cliente");

        IMFormularioCliente.setText("Formulario de cliente");
        IMFormularioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMFormularioClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(IMFormularioCliente);

        jMenuItem1.setText("Activar cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuCliente.add(jMenuItem1);

        BarraMenu.add(MenuCliente);

        MenuCompra.setText("Compra");

        IMRealizarCompra.setText("Realizar Compra");
        IMRealizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IMRealizarCompraMousePressed(evt);
            }
        });
        IMRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMRealizarCompraActionPerformed(evt);
            }
        });
        MenuCompra.add(IMRealizarCompra);

        IMDetalleCompra.setText("Ver Detalle Compra");
        IMDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMDetalleCompraActionPerformed(evt);
            }
        });
        MenuCompra.add(IMDetalleCompra);

        BarraMenu.add(MenuCompra);

        MenuVenta.setText("Venta");

        IMRealizarVenta.setText("Realizar Venta");
        IMRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMRealizarVentaActionPerformed(evt);
            }
        });
        MenuVenta.add(IMRealizarVenta);

        IMDetalleVenta.setText("Ver Detalle Venta");
        IMDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMDetalleVentaActionPerformed(evt);
            }
        });
        MenuVenta.add(IMDetalleVenta);

        BarraMenu.add(MenuVenta);

        MenuProducto.setText("Producto");

        IMFormularioProducto.setText("Formulario de producto");
        IMFormularioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMFormularioProductoActionPerformed(evt);
            }
        });
        MenuProducto.add(IMFormularioProducto);

        IMConsulta.setText("Consultas");
        IMConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMConsultaActionPerformed(evt);
            }
        });
        MenuProducto.add(IMConsulta);

        BarraMenu.add(MenuProducto);

        MenuProveedor.setText("Proveedor");

        IMFormularioProveedor.setText("Formulario de proveedor");
        IMFormularioProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMFormularioProveedorActionPerformed(evt);
            }
        });
        MenuProveedor.add(IMFormularioProveedor);

        BarraMenu.add(MenuProveedor);

        MenuSalir.setText("Salir");
        MenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSalirMouseClicked(evt);
            }
        });
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        BarraMenu.add(MenuSalir);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IMFormularioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMFormularioProductoActionPerformed
        cargarInternal(new ProductoView());
    }//GEN-LAST:event_IMFormularioProductoActionPerformed

    private void IMFormularioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMFormularioClienteActionPerformed
        cargarInternal(new ClienteView());
    }//GEN-LAST:event_IMFormularioClienteActionPerformed

    private void IMFormularioProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMFormularioProveedorActionPerformed
        cargarInternal(new ProveedorView());
    }//GEN-LAST:event_IMFormularioProveedorActionPerformed

    private void IMRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMRealizarVentaActionPerformed
        cargarInternal(new RealizarVenta());
    }//GEN-LAST:event_IMRealizarVentaActionPerformed

    private void IMConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMConsultaActionPerformed
        cargarInternal(new ProductoConsultasView());
    }//GEN-LAST:event_IMConsultaActionPerformed

    private void IMRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMRealizarCompraActionPerformed
        cargarInternal(new RealizarCompra());
    }//GEN-LAST:event_IMRealizarCompraActionPerformed

    private void IMRealizarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IMRealizarCompraMousePressed
        cargarInternal(new RealizarCompra());
    }//GEN-LAST:event_IMRealizarCompraMousePressed

    private void IMDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMDetalleCompraActionPerformed
        cargarInternal(new DetalleCompraView());
    }//GEN-LAST:event_IMDetalleCompraActionPerformed

    private void IMDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMDetalleVentaActionPerformed
        cargarInternal(new DetalleVentaView());
    }//GEN-LAST:event_IMDetalleVentaActionPerformed

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_MenuSalirActionPerformed

    private void MenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSalirMouseClicked
        dispose();
    }//GEN-LAST:event_MenuSalirMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       cargarInternal(new ActivarClienteView());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cargarInternal(JInternalFrame i) {
        escritorio.removeAll(); //si hay una ventana abierta, la limpia,la remueve 
        escritorio.repaint();//dibuja todo de nuevo

        i.setVisible(true);
        escritorio.add(i);
        escritorio.moveToFront(i);
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenuItem IMConsulta;
    private javax.swing.JMenuItem IMDetalleCompra;
    private javax.swing.JMenuItem IMDetalleVenta;
    private javax.swing.JMenuItem IMFormularioCliente;
    private javax.swing.JMenuItem IMFormularioProducto;
    private javax.swing.JMenuItem IMFormularioProveedor;
    private javax.swing.JMenu IMRealizarCompra;
    private javax.swing.JMenuItem IMRealizarVenta;
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenu MenuCompra;
    private javax.swing.JMenu MenuProducto;
    private javax.swing.JMenu MenuProveedor;
    private javax.swing.JMenu MenuSalir;
    private javax.swing.JMenu MenuVenta;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
