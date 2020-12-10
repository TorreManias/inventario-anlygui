package controladores;

import inventarioanlygui.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Lanuza :D
 */
public class GestionProductos extends Conexion {

    Connection coneccionDB;

    // Statement de SQL
    private PreparedStatement insertarProducto;
    private PreparedStatement actualizarProductos;
    private PreparedStatement buscarProductoPorID;
    private PreparedStatement buscarProductoPorNombre;
    private PreparedStatement eliminarProducto;

    public GestionProductos() {

        try {

            coneccionDB = this.conectar();

            // Sentencias de SQL preparadas
            insertarProducto = coneccionDB.prepareStatement("INSERT into dbo.Producto(id, nombre, precioCompra, precioVenta, marca, categoria, cantidad, descripcion) VALUES (?,?,?,?,?,?,?,?)");
            actualizarProductos = coneccionDB.prepareStatement("UPDATE dbo.Producto "
                    + "SET id = ?, nombre = ?, precioCompra = ?, precioVenta = ?, marca = ?, categoria = ?, cantidad = ?, descripcion = ? "
                    + "WHERE id = ?");
            buscarProductoPorID = coneccionDB.prepareStatement("SELECT * from dbo.Producto WHERE id = ?");
            buscarProductoPorNombre = coneccionDB.prepareStatement("SELECT * from dbo.Producto WHERE nombre = ?");
            eliminarProducto = coneccionDB.prepareStatement("DELETE from dbo.Producto WHERE id = ?");

        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultTableModel buscarPorID(int ID) {
        DefaultTableModel resultado = new DefaultTableModel();

        Object[] filas = new Object[8]; // Contendrá las filas de la tabla
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
        resultado.setColumnIdentifiers(titulos_tabla);

        try {
            buscarProductoPorID.setInt(1, ID);
            ResultSet resultado_busqueda = buscarProductoPorID.executeQuery();

            // Crear un modelo de tabla nuevo.
            while (resultado_busqueda.next()) {

                filas[0] = resultado_busqueda.getInt("id");
                filas[1] = resultado_busqueda.getString("nombre");
                filas[2] = resultado_busqueda.getString("marca");
                filas[3] = resultado_busqueda.getFloat("precioCompra");
                filas[4] = resultado_busqueda.getFloat("precioVenta");
                filas[5] = resultado_busqueda.getString("categoria");
                filas[6] = resultado_busqueda.getInt("cantidad");
                filas[7] = resultado_busqueda.getString("descripcion");

                resultado.addRow(filas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error evaluando la consulta", "Error", 0);
            System.out.println(e.toString());
        }

        return resultado;
    }

    public DefaultTableModel buscarPorNombre(String nombre_producto) {
        DefaultTableModel resultado = new DefaultTableModel();

        Object[] filas = new Object[8]; // Contendrá las filas de la tabla
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
        resultado.setColumnIdentifiers(titulos_tabla);

        try {
            buscarProductoPorNombre.setString(1, nombre_producto);
            ResultSet resultado_busqueda = buscarProductoPorNombre.executeQuery();

            // Crear un modelo de tabla nuevo.
            while (resultado_busqueda.next()) {

                filas[0] = resultado_busqueda.getInt("id");
                filas[1] = resultado_busqueda.getString("nombre");
                filas[2] = resultado_busqueda.getString("marca");
                filas[3] = resultado_busqueda.getFloat("precioCompra");
                filas[4] = resultado_busqueda.getFloat("precioVenta");
                filas[5] = resultado_busqueda.getString("categoria");
                filas[6] = resultado_busqueda.getInt("cantidad");
                filas[7] = resultado_busqueda.getString("descripcion");

                resultado.addRow(filas);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error evaluando la consulta", "Error", 0);
            System.out.println(e.toString());
        }

        return resultado;
    }

    public String actualizarBDConProductos(ArrayList<Producto> lista) {
        String resultado;

        int productos_actualizados = 0;
        int productos_nuevos = 0;
        int productos_eliminados = 0;

        for (Producto p : lista) {
            int estado = p.getEstado();
            switch (estado) {
                case 1:
                    break;

                case 2: // Estado 2 - Actualizar los datos modificados
                    try {

                    actualizarProductos.setInt(1, p.getId());
                    actualizarProductos.setString(2, p.getNombre());
                    actualizarProductos.setDouble(3, p.getPrecioCompra());
                    actualizarProductos.setDouble(4, p.getPrecioVenta());
                    actualizarProductos.setString(5, p.getMarca());
                    actualizarProductos.setString(6, p.m_Categoria.getnombre());
                    actualizarProductos.setInt(7, p.getCantidad());
                    actualizarProductos.setString(8, p.getDescripcion());
                    actualizarProductos.setInt(9, p.getId());

                    actualizarProductos.executeUpdate();
                    productos_actualizados++;

                } catch (SQLException ex) {

                    Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);

                }
                break;

                case 3: // Eliminar el producto
                    try {

                        eliminarProducto.setInt(1, p.getId());
                        eliminarProducto.executeUpdate();
                        
                    } catch (SQLException e) {
                        
                        System.out.println(e.toString());

                    }
                    
                    productos_eliminados++;
                    break;

                case 4: // Insertar el producto
                    insertarProducto(p.getId(), p.getNombre(), p.getPrecioCompra(), p.getPrecioVenta(), p.getMarca(), p.m_Categoria.getnombre(), p.getCantidad(), p.getDescripcion());
                    productos_nuevos++;
                    break;

            }
        }

        resultado = "" + productos_actualizados + "," + productos_eliminados + "," + productos_nuevos;
        return resultado;
    }

    public int insertarProducto(int id, String nombre, float pCompra, float pVenta, String marca, String cat, int cantidad, String desc) {
        int result = 0;

        try {
            insertarProducto.setInt(1, id);
            insertarProducto.setString(2, nombre);
            insertarProducto.setFloat(3, pCompra);
            insertarProducto.setFloat(4, pVenta);
            insertarProducto.setString(5, marca);
            insertarProducto.setString(6, cat);
            insertarProducto.setInt(7, cantidad);
            insertarProducto.setString(8, desc);

            result = insertarProducto.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);

        }

        return result;
    }
}
