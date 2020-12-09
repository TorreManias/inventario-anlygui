package controladores;

import inventarioanlygui.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class TblProducto extends Conexion {

    public Producto m_Producto;
    private ArrayList<Producto> lista_productos;
    
    Connection coneccionDB;
    private PreparedStatement insertarProducto;
    
    ServicioDeArranque ser;
    
    public TblProducto() {

        lista_productos = new ArrayList<>();

        
    }
    

    // Getters y Setters
    public Producto getM_Producto() {
        return m_Producto;
    }

    public void setM_Producto(Producto m_Producto) {
        this.m_Producto = m_Producto;
    }

    public ArrayList<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(ArrayList<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }

    // Métodos propios
    public int actualizarBD() {
        return 0;
    }

    public int agregarProducto(Producto pro) {
        ser = new ServicioDeArranque();
        
        try{
        coneccionDB = this.conectar();
        insertarProducto = coneccionDB.prepareStatement("INSERT into dbo.Producto(id, nombre, precioCompra, precioVenta, marca, categoria, cantidad, descripcion) VALUES (?,?,?,?,?,?,?,?)");
        }catch(SQLException ex){
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int result = 0;

        try {

            insertarProducto.setInt(1, pro.getId());
            insertarProducto.setString(2, pro.getNombre());
            insertarProducto.setFloat(3, pro.getPrecioVenta());
            insertarProducto.setFloat(4, pro.getPrecioCompra());
            insertarProducto.setString(5, pro.getMarca());
            insertarProducto.setInt(6, pro.getM_Categoria().getid());
            insertarProducto.setInt(7, pro.getCantidad());
            insertarProducto.setString(8, pro.getDescripcion());

            result = insertarProducto.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        ser.obtenerListaDeProductos();
       return result;
    }

    public Producto buscarProducto() {
        return null;
    }

    public float calcularExistencia() {
        return 0;
    }

    public int eliminarProducto() {
        return 0;
    }

    public int modificarProducto() {
        return 0;
    }

    public ArrayList mostarProductos() {
        return null;
    }

    public int sumarEntradas(int id, int cant) {
        
        
        
        int idlista = 0, cantidadlista = 0;
        System.out.println("Si");
        
        for(Producto pro : lista_productos){
            
            idlista = pro.getId();
            System.out.println("Id: " + idlista);
            if(id == idlista){
                
                cantidadlista = pro.getId();
                cantidadlista = cantidadlista + cant;
                
            }
            
        }
        
        return cantidadlista;
    }

    public float sumarSalidad() {
        return 0;
    }


}
