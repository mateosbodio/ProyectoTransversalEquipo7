
package transversal2.persistencia;

import java.sql.*;
import javax.swing.JOptionPane;

/* by Julian Rios - Grupo 7 */

public class Conexion {
    
    private static String url = "jdbc:mariadb://localhost/tp13_ulp";
    private static String usuario = "root";
    private static String password = "";
    private static Conexion conexion;// = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("carga driver ok");
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Error al cargar el Driver");
        }
    }

    public static Connection getConexion() {
        Connection con = null;

        if (conexion == null) {
            conexion = new Conexion();
        }

        try {
            con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
            System.out.println("conexion ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error conexion");
        }
        return con;
    }

}
