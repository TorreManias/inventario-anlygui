package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos Lanuza  :D
 */
public class GestionProductos extends Conexion {

    Connection coneccionDB;
    private PreparedStatement insertarProducto;

    public GestionProductos() {

        try {

            coneccionDB = this.conectar(); // Guardamos la conexion
            System.out.println(coneccionDB.toString());
            insertarProducto = coneccionDB.prepareStatement("INSERT into dbo.Producto(nombre, precioCompra, precioVenta, marca, categoria, cantidad, descripcion) VALUES (?,?,?,?,?,?,?)");

        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int insertarProducto(String nombre, float pCompra, float pVenta, String marca, int cat, int cantidad, String desc) {
        int result = 0;

        try {

            insertarProducto.setString(1, nombre);
            insertarProducto.setFloat(2, pCompra);
            insertarProducto.setFloat(3, pVenta);
            insertarProducto.setString(4, marca);
            insertarProducto.setInt(5, cat);
            insertarProducto.setInt(6, cantidad);
            insertarProducto.setString(7, desc);

            result = insertarProducto.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);

        }

        return result;
    }
}

