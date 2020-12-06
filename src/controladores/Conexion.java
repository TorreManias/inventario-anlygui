package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Lanuza
 */
public class Conexion {

    private static final String SERVIDOR = "165.98.12.158\\lp2";
    private static final String USUARIO = "poo12";
    private static final String PASSWORD = "grupo12";
    private static final String NOMBREBD = "BDAnlygui";
    private static final String PUERTO = "1433";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection conectar() {

        try {

            String URL = "jdbc:sqlserver://" + SERVIDOR + ": " + PUERTO + "; Databasename= " + NOMBREBD + "; user= " + USUARIO + "; password = " + PASSWORD + ";";
            System.out.println(DriverManager.getConnection(URL).toString());

            Class.forName(DRIVER);
            return (DriverManager.getConnection(URL));

        } catch (SQLException error) {
            System.out.println(error.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void cerrarConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
        }
    }

}
