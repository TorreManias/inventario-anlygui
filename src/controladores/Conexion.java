package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos Lanuza
 */
public class Conexion {

    private static final String SERVIDOR = "165.98.12.158\\lp2";
    private static final String USUARIO = "poo12";
    private static final String PASSWORD = "grupo12";
    private static final String NOMBREBD = "BDAnlygui";
    private static final String PUERTO = "1432";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection conectar() {

        try {

            String URL = "jdbc:sqlserver://" + SERVIDOR + ": " + PUERTO + "; Databasename= " + NOMBREBD + "; user= " + USUARIO + "; password = " + PASSWORD + ";";

            Class.forName(DRIVER);
            return (DriverManager.getConnection(URL));

        } catch (SQLException | ClassNotFoundException error) {
            System.out.println(error.toString());
        }

        return null;

    }

    public void cerrarConexion(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
        }
    }

}
