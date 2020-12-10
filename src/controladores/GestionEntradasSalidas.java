package controladores;

import inventarioanlygui.Entrada;
import inventarioanlygui.Salida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionEntradasSalidas extends Conexion {

    // Conexion
    private Connection conexionDB;

    // Sentencias
    private final String INSERTAR_NUEVA_ENTRADA = "INSERT into dbo.Entrada(cantidad, fecha) VALUES(?,?)";
    private final String INSERTAR_NUEVA_SALIDA = "INSERT into dbo.Salida(cantidad, fecha) VALUES(?,?)";
    private final String SELECCIONAR_ENTRADAS = "SELECT * from dbo.Entrada";
    private final String SELECCIONAR_SALIDAS = "SELECT * from dbo.Salida";

    // Statements
    private PreparedStatement insertarEntrada;
    private PreparedStatement insertarSalida;
    private PreparedStatement seleccionarEntradas;
    private PreparedStatement seleccionarSalidas;

    // Módelos de tablas para las entradas y las salidas
    private DefaultTableModel modelo_tab_entradas;
    private DefaultTableModel modelo_tab_salidas;

    // Titulos para la tabla
    private final String[] TITULOS = {"ID", "Cantidad", "Fecha"};

    public GestionEntradasSalidas() {

        try {

            // Obtener conexión
            conexionDB = this.conectar();

            // Preparar sentencias
            insertarEntrada = conexionDB.prepareStatement(INSERTAR_NUEVA_ENTRADA);
            insertarSalida = conexionDB.prepareStatement(INSERTAR_NUEVA_SALIDA);

            // Instancias las tablas
            modelo_tab_entradas = new DefaultTableModel();
            modelo_tab_salidas = new DefaultTableModel();

        } catch (SQLException ex) {
            Logger.getLogger(GestionEntradasSalidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertarNuevaEntradaProducto(int cantidad_entrada, String fecha) {

        try {

            insertarEntrada.setInt(1, cantidad_entrada);
            insertarEntrada.setString(2, fecha);

            insertarEntrada.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(GestionEntradasSalidas.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void insertarNuevaSalidaProducto(int cantidad_entrada, String fecha) {

        try {

            insertarSalida.setInt(1, cantidad_entrada);
            insertarSalida.setString(2, fecha);

            insertarSalida.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(GestionEntradasSalidas.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public DefaultTableModel mostrarEntradas() {

        this.modelo_tab_entradas.setColumnIdentifiers(TITULOS);

        try {

            Statement listar = conexionDB.createStatement();
            ResultSet consulta_entradas = listar.executeQuery(SELECCIONAR_ENTRADAS);

            while (consulta_entradas.next()) {

                Object[] fila = new Object[3];

                fila[0] = consulta_entradas.getInt("id");
                fila[1] = consulta_entradas.getInt("cantidad");
                fila[2] = consulta_entradas.getString("fecha");

                this.modelo_tab_entradas.addRow(fila);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return this.modelo_tab_entradas;

    }

    public DefaultTableModel actualizarTablaDeEntradas(Entrada ent, DefaultTableModel tab) {

        Object[] fila = new Object[3];
        fila[1] = ent.getcantidad();
        fila[2] = ent.getfecha();

        tab.addRow(fila);

        return tab;

    }

    public DefaultTableModel mostrarSalidas() {

        this.modelo_tab_salidas.setColumnIdentifiers(TITULOS);

        try {

            Statement listar = conexionDB.createStatement();
            ResultSet consulta_salidas = listar.executeQuery(SELECCIONAR_SALIDAS);

            while (consulta_salidas.next()) {

                Object[] fila = new Object[3];

                fila[0] = consulta_salidas.getInt("id");
                fila[1] = consulta_salidas.getInt("cantidad");
                fila[2] = consulta_salidas.getString("fecha");

                this.modelo_tab_salidas.addRow(fila);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return this.modelo_tab_salidas;
    }

    public DefaultTableModel actulizarTablaSalidas(Salida sal, DefaultTableModel tab) {
        
        Object[] fila = new Object[3];
        
        fila[1] = sal.getCantidad();
        fila[2] = sal.getFecha();

        tab.addRow(fila);

        return tab;
    }

}
