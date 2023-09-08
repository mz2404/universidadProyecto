/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
     private static final String URL="jdbc:mariadb://localhost/"; //cambiar por nombre de la base de datos
     private static final String DB="universidad";
    private static final String USUARIO="root";         
    private static final String PASSWORD="";
    //singleton crea una unica conexion con la base de datos
    private static Connection conexion;  //clase Conexion,variable conexion
    
    private Conexion(){}{}
    

    public static Connection getConexion(){
        if(conexion==null){

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                JOptionPane.showMessageDialog(null, "CONECTADO");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Clase Conexion= error a cargar el Driver");
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error de conexion");
            }

        }
        return conexion;
    }

}



