package accesoDatos;

import java.sql.*;

import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String url = "jdbc:mariadb://localhost/proyectotransversalg7";    
    private static final String usuario = "root";
    private static final String password = "";
    private static Conexion conexion;
    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("carga driver ok");
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Error carga driver");
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
