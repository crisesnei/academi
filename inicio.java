/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import ControladorAcademia.conexion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author esney
 */
public class inicio extends javax.swing.JFrame {
    conexion con=new conexion();
    Connection cnn=con.Conexiondb();
  
    public inicio() {
        initComponents();
        this.setMinimumSize(new Dimension(400,300));
    }
public void validarusuario(String pro,String clav ){
    PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            
       ps=cnn.prepareStatement("SELECT * FROM  tbl_profesor WHERE Pro_Nom_prof ='"+pro+"'AND clave ='"+clav+"'");
        rs=ps.executeQuery();
        if(rs.next()){
          tab_profesor cap=new tab_profesor();
          
          cap.setSize(530,360);
            cap.setVisible(true);
            
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null,"Datos no Validos");
        }
        }
        catch (Exception e){
            System.out.print("Error"+e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        usu = new javax.swing.JTextField();
        clave = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 204, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("inicio de academia ");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(66, 11, 197, 22);

        jLabel2.setText("usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(68, 97, 35, 14);

        jLabel3.setText("clave");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(78, 143, 25, 14);

        jButton1.setText("ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(113, 210, 73, 57);

        usu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuKeyPressed(evt);
            }
        });
        getContentPane().add(usu);
        usu.setBounds(121, 94, 126, 20);
        getContentPane().add(clave);
        clave.setBounds(121, 140, 126, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/log.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String u,c;
    u=usu.getText();
    c=clave.getText();
        validarusuario(u, c);
                          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuKeyPressed

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
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField usu;
    // End of variables declaration//GEN-END:variables
}
