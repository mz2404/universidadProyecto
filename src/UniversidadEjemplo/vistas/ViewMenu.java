/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadEjemplo.vistas;

import UniversidadEjemplo.accesoADatos.AlumnoData;
import UniversidadEjemplo.accesoADatos.MateriaData;

/**
 *
 * @author Usuario
 */
public class ViewMenu extends javax.swing.JFrame {

    private AlumnoData ad;//creo
    private MateriaData md;
    public ViewMenu() {
        initComponents();
        ad=new AlumnoData();//instancio
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiFormularioAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiFormularioMateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiManejoInscripcion = new javax.swing.JMenuItem();
        jmiManejoNotas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiAlumnoMateria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jmiFormularioAlumno.setText("Formulario de alumno");
        jmiFormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFormularioAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiFormularioAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jmiFormularioMateria.setText("Formulario de materia");
        jmiFormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFormularioMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmiFormularioMateria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Administracion");

        jmiManejoInscripcion.setText("Manejo de inscripciones");
        jMenu3.add(jmiManejoInscripcion);

        jmiManejoNotas.setText("Manejo de notas");
        jMenu3.add(jmiManejoNotas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        jmiAlumnoMateria.setText("Alumno por materia");
        jMenu4.add(jmiAlumnoMateria);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Salir");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

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

    private void jmiFormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFormularioAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ViewFormularioDeAlumno fdv=new ViewFormularioDeAlumno(ad);
        fdv.setVisible(true);
        escritorio.add(fdv);//agrega
        escritorio.moveToFront(fdv);//mueve al frente
        
    }//GEN-LAST:event_jmiFormularioAlumnoActionPerformed

    private void jmiFormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFormularioMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ViewFormularioDeMaterias fdm=new ViewFormularioDeMaterias();
        fdm.setVisible(true);
        escritorio.add(fdm);//agrega
        escritorio.moveToFront(fdm);//mueve al frente // TODO add your handling code here:
    }//GEN-LAST:event_jmiFormularioMateriaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiAlumnoMateria;
    private javax.swing.JMenuItem jmiFormularioAlumno;
    private javax.swing.JMenuItem jmiFormularioMateria;
    private javax.swing.JMenuItem jmiManejoInscripcion;
    private javax.swing.JMenuItem jmiManejoNotas;
    // End of variables declaration//GEN-END:variables
}
