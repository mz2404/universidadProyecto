/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo.accesoADatos;

import UniversidadEjemplo.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author Usuario
 */
public class AlumnoData {
    private Connection con=null;
    PreparedStatement ps;
    ResultSet rs;
    Alumno alumno=null;
    ArrayList<Alumno> alumnos=new ArrayList<>();//lista vacia de alumnos 
    
    public AlumnoData(){
    con=Conexion.getConexion();//Se va a conectar a la base de datos
    }
    //guardar alumno
    public void guardarAlumno(Alumno alumno){
    String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
            + "VALUES(?,?,?,?,?)";//caracteres comodines
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDni());//seteo en orden de lo q pase y el tipo de dato
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));//por que es del tipo de fecha
            ps.setBoolean(5,alumno.isActivo());//por q es boolean se genera como is
            ps.executeUpdate();
            
            rs=ps.getGeneratedKeys();//genera una sola fila
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));//
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            }
            ps.close();//cierro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
    
    }
    
    public void ModificarAlumno(Alumno alumno){
    String sql="UPDATE alumno SET dni=?,apellido=?, nombre=?,fechaNacimiento=?,"
            + "WHERE idAlumno=?";
    
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,alumno.getDni());//seteo en orden de lo q pase y el tipo de dato
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));//por que es del tipo de fecha
            ps.setInt(5,alumno.getIdAlumno());//por q es boolean se genera como is
            int exito=ps.executeUpdate();
            if(exito==1){
            JOptionPane.showMessageDialog(null,"Alumno modificado exitosamente");
            
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
   
    }

    public void eliminarAlumno(int id){
    String sql="UPDATE alumno SET estado=0 WHERE idAlumno=?";
    
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);//por parametro el id
            int exito=ps.executeUpdate();
            if(exito==1){
            JOptionPane.showMessageDialog(null,"Alumno eliminado");
            }
    
        }catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
    }

    
    public Alumno buscarAlumno(int id){//solo va a traer los alumnos activos
        String sql="SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno=?,"
                + "estado=1";
              
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();//ResultSET por q es una consulta
            if(rs.next()){
            alumno=new Alumno();//El q tiene el constructor vacio
            alumno.setIdAlumno(id);//por que ya lo tengo por parametro
            alumno.setDni(rs.getInt("dni"));//paso las columnas de mi tabla. MISMO NOMBRE
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());// lo combierto a local date
            alumno.setActivo(true);
           
            }else{
            JOptionPane.showMessageDialog(null, "El id del Alumno no existe ");
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
        return alumno;
    }
    
    public  Alumno buscarAlumnoPorDni(int dni){
            String sql="SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni=?,"
                + "estado=1";
              
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs=ps.executeQuery();//ResultSET por q es una consulta
            if(rs.next()){
            alumno=new Alumno();//El q tiene el constructor vacio
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));//paso las columnas de mi tabla. MISMO NOMBRE
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());// lo combierto a local date
            alumno.setActivo(true);
           
            }else{
            JOptionPane.showMessageDialog(null, "El id del Alumno no existe ");
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
        return alumno;
    
    }

public List<Alumno> listarAlumnos(){
       String sql="SELECT idAlumno,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE estado=1"; 
                
              
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();//ResultSET por q es una consulta
            while(rs.next()){//por que tiene mas de una fila
            Alumno alumno=new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));//paso las columnas de mi tabla. MISMO NOMBRE
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());// lo combierto a local date
            alumno.setActivo(true);
           
            alumnos.add(alumno);//guarda los alumnos en la lista
            
            }
        ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
        }
        return alumnos;
    
}
    
    
    //METODO PARA IMPRIMIR LA LISTA
    
    //public mostrarLista
    
    
    
    
    


}
