
package academia;

import ControladorAcademia.conexion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esney
 */
public class tab_curso extends javax.swing.JFrame {
conexion con=new conexion();
    Connection cnn=con.Conexiondb();
     PreparedStatement ps=null;
    ResultSet rs=null;
    public tab_curso() {
        initComponents();
        cargatabla();
        setSize(770,400);
    //   this.setMinimumSize(new Dimension(863,425));
    }
public void cargatabla(){
    DefaultTableModel tabla=new DefaultTableModel ();
    tabla.addColumn("Codigo Curso");
      tabla.addColumn("Nombre Curso");
      tabla.addColumn("Horas");
      tabla.addColumn("Valor del Curso");
      tab_curso.setModel(tabla);
      String datos[]=new String[5];
      tabla.addRow(datos);
      
       try {
        ps=cnn.prepareStatement("SELECT * FROM tbl_curso");
        rs=ps.executeQuery();
        while (rs.next()){
         datos[0]=rs.getString(1);
         datos[1]=rs.getString(2);
         datos[2]=rs.getString(3);
         datos[3]=rs.getString(4);  
         tabla.addRow(datos);
        }
       } catch (Exception e) {
        System.out.print(e);
   }
  }



public void registrar (){

    try {
        ps=cnn.prepareStatement("INSERT INTO tbl_curso ( cur_cod_cur, cur_nom_curs, cur_horas_cur,cur_valor_cur)values (?,?,?,?) ");
        ps.setInt(1,Integer.parseInt(jTextFieldcodigo.getText()));
        ps.setString(2,jTextFieldnombre.getText());
        ps.setInt(3,Integer.parseInt(jTextFieldhoras.getText()));
        ps.setInt(4,Integer.parseInt(jTextFieldvalor.getText()));
        ps.executeUpdate();
         
       JOptionPane.showMessageDialog(null,"Datos guardados");

    } catch (Exception e) {
        
    }


}


     public void eliminar (String dat){
         try {
             ps=cnn.prepareStatement(" DELETE from tbl_curso where cur_cod_cur='"+dat+"' ");
             ps=executeUpdate();
             
             JOptionPane.showMessageDialog(null,"datos eliminados "); 
             
         } catch (Exception e) {
             System.out.println("eee"+ e);
         }
     }
     
     public void modificar(String codigo,String nombre,String cur,String va ){
         try {
             ps=cnn.prepareStatement(" UPDATE  tbl_curso set cur_nom_curs='"+nombre+"',cur_horas_cur='"+cur+"',cur_valor_cur='"+va+"' where cur_cod_cur ='"+codigo+"' ");
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null,"datos modificados "); 
         } catch (Exception e) {
             System.out.print("eee"+e);
             
         }
     
     }
     
     
     /*public void cargarcombo(){
         try {
             jComboBox1.removeAll();
             jComboBox1.addItem(" selecione codigo");
     ps=cnn.prepareStatement(" select   cur_cod_cur from tbl_curso");
     rs=ps.executeQuery();
     while (rs.next()){
     String aux=rs.getString("cur_cod_cur");
     this.jComboBox1.addItem(aux);
     
     
     
     
     }
         } catch (Exception e) {
             
             
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

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_curso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldnombre = new javax.swing.JTextField();
        jTextFieldhoras = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldvalor = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextFieldcodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("                                                                                                                                              TBL_CURSO");
        getContentPane().setLayout(null);

        tab_curso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tab_curso);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 35, 375, 275);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("codigo curso");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 40, 71, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("nombre");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 80, 51, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("horas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 110, 27, 14);

        jTextFieldnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldnombreKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldnombre);
        jTextFieldnombre.setBounds(530, 80, 130, 20);

        jTextFieldhoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldhorasKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldhoras);
        jTextFieldhoras.setBounds(530, 110, 130, 30);

        jButton2.setText("registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(403, 231, 90, 23);

        jButton3.setText("eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(509, 231, 90, 23);

        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(520, 280, 75, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("valor");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 150, 80, 14);

        jTextFieldvalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldvalorActionPerformed(evt);
            }
        });
        jTextFieldvalor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldvalorKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldvalor);
        jTextFieldvalor.setBounds(530, 150, 130, 30);

        jButton5.setText("MODIFICAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(640, 230, 90, 23);

        jTextFieldcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldcodigoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldcodigo);
        jTextFieldcodigo.setBounds(530, 40, 130, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/Academia_de_San_Carlos_esquina_de_Calle_de_Moneda_y_Academia.JPG"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 760, 350);

        jMenu3.setText("programas");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("profesor");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("estudiante");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("estudiante x curso");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldvalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldvalorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldvalorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String  dat=jTextFieldcodigo.getText();
        eliminar(dat);
        cargatabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String c,n,h,v;
        c=jTextFieldcodigo.getText();
        n=jTextFieldnombre.getText();
        h=jTextFieldhoras.getText();
        v=jTextFieldvalor.getText();
        modificar(c, n, h, v);
        cargatabla();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
       
        jTextFieldcodigo.setText(null);
        jTextFieldhoras.setText(null);
        jTextFieldvalor.setText(null);
        jTextFieldnombre.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
      tab_profesor p=new tab_profesor();
      p.setVisible(true);
      dispose();
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        tab_estudiante ec=new tab_estudiante();
        ec.setVisible(true);
        dispose();
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        tab_estxcurso et=new tab_estxcurso();
        et.setVisible(true);
        dispose();
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void jTextFieldnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnombreKeyTyped
        String txt=jTextFieldnombre.getText();
        if(txt.length()>0){
            char pletra=txt.charAt(0);
            txt=Character.toUpperCase(pletra)+txt.substring(1, txt.length());
            jTextFieldnombre.setText(txt);
        }
        char c=evt.getKeyChar();
        if (Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldnombreKeyTyped

    private void jTextFieldcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcodigoKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
        
    }//GEN-LAST:event_jTextFieldcodigoKeyTyped

    private void jTextFieldhorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldhorasKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldhorasKeyTyped

    private void jTextFieldvalorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldvalorKeyTyped
        char c=evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldvalorKeyTyped

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
            java.util.logging.Logger.getLogger(tab_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tab_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tab_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tab_curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tab_curso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldcodigo;
    private javax.swing.JTextField jTextFieldhoras;
    private javax.swing.JTextField jTextFieldnombre;
    private javax.swing.JTextField jTextFieldvalor;
    private javax.swing.JTable tab_curso;
    // End of variables declaration//GEN-END:variables

    private PreparedStatement executeUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
