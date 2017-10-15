package ControladorAcademia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexion {
    Connection acade=null;
    
    public Connection Conexiondb(){
        try {
        Class.forName("com.mysql.jdbc.Driver");
        acade=DriverManager.getConnection("jdbc:mysql://localhost/dbacademia","root","");
            JOptionPane.showMessageDialog(null,"Conexion Exitosa" );
        } catch (Exception e) {
            System.out.println(e);
        }
        return acade;
        }
    
       public static void main(String[] args) {
      conexion con=new conexion();
      con.Conexiondb();
       }
       }
