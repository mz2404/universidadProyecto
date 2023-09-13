/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo;

import UniversidadEjemplo.accesoADatos.AlumnoData;
import UniversidadEjemplo.accesoADatos.Conexion;
import UniversidadEjemplo.accesoADatos.MateriaData;
import UniversidadEjemplo.entidades.Alumno;
import UniversidadEjemplo.entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Usuario
 */
public class universidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        AlumnoData alu=new AlumnoData();
        
        System.out.println(alu.buscarAlumnoPorDni(123));
    }
}
    
              
       
               
            
              
              
 