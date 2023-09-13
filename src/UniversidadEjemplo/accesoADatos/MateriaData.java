/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo.accesoADatos;

import UniversidadEjemplo.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MateriaData {
    private Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    Materia materia = null;
    ArrayList<Materia> materias = new ArrayList<>();

    public MateriaData() {
        con = Conexion.getConexion();//Se va a conectar a la base de datos
    }

    public void guardarMateria(Materia materia) {

        String sql = "insert into materia(nombre,anio,estado)"
                + "values (?,?,?)";

        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();//genera una sola fila
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));//
                JOptionPane.showMessageDialog(null, "Materia Guardada");
            }
            ps.close();//cierro

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }

    public Materia buscarMateria(int id) {

        String sql = "select nombre,anio,estado from materia where idMateria=? "
                + "and estado=1";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "id de la materia no existe");
            }

            ps.close();//cierro

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }
        return materia;

    }

    public void modificarMateria(Materia materia) {

        String sql = "update materia set nombre=?, anio=?"
                + "where idMateria=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "materia modificada exitosamente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }

    }

    public void eliminarMateria(int id) {

        String sql = "update materia set estado=0 where idMateria=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "materia eliminada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla materia");
        }

    }

    public List<Materia> listarMaterias() {

        String sql = "select idMateria, anio, nombre from materia where estado=1";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            Materia materia= new Materia();
                    
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materia.setEstado(true);
            materias.add(materia);
            
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error ");
        }
        return materias;
        
    } 
}
