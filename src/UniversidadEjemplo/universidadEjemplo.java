/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo;

import UniversidadEjemplo.accesoADatos.Conexion;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class universidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con=Conexion.getConexion();
    }
    
}
