package controladores;

import inventarioanlygui.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Lanuza :D
 */
public class GestionProductos extends Conexion {

    Connection coneccionDB;
    private PreparedStatement insertarProducto;
    private PreparedStatement actualizarProductos;

    public GestionProductos() {

        try {

            coneccionDB = this.conectar(); // Guardamos la conexion
            System.out.println(coneccionDB.toString());
            insertarProducto = coneccionDB.prepareStatement("INSERT into dbo.Producto(id, nombre, precioCompra, precioVenta, marca, categoria, cantidad, descripcion) VALUES (?,?,?,?,?,?,?,?)");
            actualizarProductos = coneccionDB.prepareStatement("UPDATE dbo.Producto "
                    + "SET id = ?, nombre = ?, precioCompra = ?, precioVenta = ?, marca = ?, categoria = ?, cantidad = ?, descripcion = ? "
                    + "WHERE id = ?");

        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarBDConProductos(ArrayList<Producto> lista) {
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

                } catch (SQLException ex) {

                    Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);

                }
                    break;
                    
                case 3: // Eliminar el producto
                    break;
                    
                case 4: // Insertar el producto
                    insertarProducto(p.getId(), p.getNombre(), p.getPrecioCompra(), p.getPrecioVenta(), p.getMarca(), p.m_Categoria.getnombre(), p.getCantidad(), p.getDescripcion());
                    break;

            }
        }
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
