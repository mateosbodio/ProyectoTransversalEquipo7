package transversal2.GUI;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import transversal2.entidades.Alumno;
import transversal2.entidades.Inscripcion;
import transversal2.persistencia.AlumnoGestion;
import transversal2.persistencia.InscripcionGestion;

/**
 *
 * @author Julian Rios
 */
public class ViewNotas extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public ViewNotas() {
        initComponents();
        armarCabecera();
        carCombo();
        btnGuardar.setEnabled(false);
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Materia");
        modelo.addColumn("Nota");
        tabNotas.setModel(modelo);
    }

    private void carCombo() {
        AlumnoGestion ad = new AlumnoGestion();
        List<Alumno> list = ad.obtenerAlumnos();

        cmbAlumnos.removeAllItems(); 
        if (!list.isEmpty()) {
            for (Alumno alum : list) {
                cmbAlumnos.addItem(alum);
            }
        }

        cmbAlumnos.setSelectedIndex(-1); 
    }

    public void actCombo() {
        borrarFilas();
        InscripcionGestion Idata = new InscripcionGestion();
        Alumno alum = new Alumno();
        if (cmbAlumnos.getSelectedItem() != null) {
            alum = (Alumno) cmbAlumnos.getSelectedItem();
            List<Inscripcion> lista = Idata.obtenerInscripcionesPorAlumno(alum.getIdAlumno());
            for (Inscripcion inscrip : lista) {
                modelo.addRow(new Object[]{
                    inscrip.getMateria().getIdMateria(),
                    inscrip.getMateria().getNombre(),
                    inscrip.getNota()
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabNotas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbAlumnos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(270, 120));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal2/sources/volver-24.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel1.setText("GESTION NOTAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        tabNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabNotas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 144, 710, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SELECCIONE ALUMNO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        cmbAlumnos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlumnosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 240, -1));

        btnGuardar.setBackground(new java.awt.Color(102, 51, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transversal2/sources/fondoabst5.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (tabNotas.getSelectedRow() >= 0) {
            InscripcionGestion Idata = new InscripcionGestion();
            Alumno alum = new Alumno();
            alum = (Alumno) cmbAlumnos.getSelectedItem();
            try {
                double nota = pedirNumero();
                Idata.actualizarNota(alum.getIdAlumno(), (int) tabNotas.getValueAt(tabNotas.getSelectedRow(), 0), nota);
            } catch (NullPointerException ex) {
            }
            carCombo();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar nota");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlumnosActionPerformed
        btnGuardar.setEnabled(true);
        actCombo();
    }//GEN-LAST:event_cmbAlumnosActionPerformed

    private void borrarFilas() {
        int f = tabNotas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private double pedirNumero() {
        double nota = 0;
        boolean notaValida = false;

        while (!notaValida) {
            try {
                String input = JOptionPane.showInputDialog(this, "¿Cuál es la nota a ingresar?", "Atencion !!", JOptionPane.QUESTION_MESSAGE);
                if (input == null) {
                    return 0;
                }

                nota = Double.parseDouble(input);

                if (nota >= 1 && nota <= 10) {
                    notaValida = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Ingreso no válido. Debe ingresar un valor entre 1 y 10.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar solo números.");
            }
        }

        return nota;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Alumno> cmbAlumnos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabNotas;
    // End of variables declaration//GEN-END:variables
}
