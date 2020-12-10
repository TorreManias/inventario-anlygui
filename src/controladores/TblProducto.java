package controladores;

import inventarioanlygui.Producto;
import jForm.Acceder_a_otraApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class TblProducto extends Conexion {

    private DefaultTableModel Def;
    public Producto m_Producto;
    private ArrayList<Producto> lista_productos;
    public static ArrayList<Producto> productosEliminados;
    
    Connection coneccionDB;
    private PreparedStatement insertarProducto;

    ServicioDeArranque ser;
    
    private PreparedStatement solicitarProductos;
    private final String seleccionar_productos = "SELECT * from dbo Producto";

    public TblProducto() {

        lista_productos = new ArrayList<>();
        productosEliminados = new ArrayList<>();

    }

    // Getters y Setters

    public static ArrayList<Producto> getProductosEliminados() {
        return productosEliminados;
    }

    public static void setProductosEliminados(ArrayList<Producto> productosEliminados) {
        TblProducto.productosEliminados = productosEliminados;
    }
    

    public DefaultTableModel getDef() {
        return Def;
    }

    public void setDef(DefaultTableModel Def) {
        this.Def = Def;
    }
    
    
    
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
    public void agregarProducto(Producto pro) {
        lista_productos.add(pro);
    }

    public DefaultTableModel eliminarProducto(int id) {
        
        DefaultTableModel Tabla;
        
        Tabla = new DefaultTableModel();
        

        int idlista , cant = 0;

        for (int i = 0; i < Acceder_a_otraApp.lista_con_productos.size(); i++) {
            
            
            idlista = Acceder_a_otraApp.lista_con_productos.get(i).getId();
            if (id == idlista) {

                cant += i;
                Acceder_a_otraApp.lista_con_productos.get(cant).setEstado(3);
                productosEliminados.add(Acceder_a_otraApp.lista_con_productos.get(cant));
                Acceder_a_otraApp.lista_con_productos.remove(cant);
            }
           
        }
        
        
        Tabla = new DefaultTableModel();
        
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
        Tabla.setColumnIdentifiers(titulos_tabla);

        for (Producto p : Acceder_a_otraApp.lista_con_productos) {

            Object[] fila = new Object[8];

            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getMarca();
            fila[3] = p.getPrecioVenta();
            fila[4] = p.getPrecioCompra();
            fila[5] = p.m_Categoria.getnombre();
            fila[6] = p.getCantidad();
            fila[7] = p.getDescripcion();

            Tabla.addRow(fila);
            setDef(Tabla);

        }

        return Tabla;
    }

    public DefaultTableModel actualizarTablaInventario(Producto p, DefaultTableModel t) {

        // Fila nueva en la tabla
        Object[] fila = new Object[8];
        fila[0] = p.getId();
        fila[1] = p.getNombre();
        fila[2] = p.getMarca();
        fila[3] = p.getPrecioVenta();
        fila[4] = p.getPrecioCompra();
        fila[5] = p.m_Categoria.getnombre();
        fila[6] = p.getCantidad();
        fila[7] = p.getDescripcion();

        // Insertar la fila en la tabla actualizada.
        t.addRow(fila);
        return t;

    }

    public static DefaultTableModel actualizarTablaInventario(ArrayList<Producto> inv) {
        DefaultTableModel tabla_actualizada = new DefaultTableModel();

         String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
         tabla_actualizada.setColumnIdentifiers(titulos_tabla);
        Object[] fila = new Object[8];

        for (Producto p : inv) {
            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getMarca();
            fila[3] = p.getPrecioVenta();
            fila[4] = p.getPrecioCompra();
            fila[5] = p.m_Categoria.getnombre();
            fila[6] = p.getCantidad();
            fila[7] = p.getDescripcion();
            
            tabla_actualizada.addRow(fila);
        }
        
        return tabla_actualizada;
    }

    public DefaultTableModel sumarEntradas(int id, int cant) {

        DefaultTableModel Tabla;
        
        Tabla = new DefaultTableModel();
        

        int idlista , cantidad = 0, cantidadSuma = 0;

        for (int i = 0; i < Acceder_a_otraApp.lista_con_productos.size(); i++) {
            
            
            idlista = Acceder_a_otraApp.lista_con_productos.get(i).getId();
            if (id == idlista) {

                cantidad += i;
//                productosEliminados.add(Acceder_a_otraApp.lista_con_productos.get(cantidad));
                cantidadSuma = Acceder_a_otraApp.lista_con_productos.get(cantidad).getCantidad();
                cantidadSuma += cant;
                Acceder_a_otraApp.lista_con_productos.get(cantidad).setCantidad(cantidadSuma);
                Acceder_a_otraApp.lista_con_productos.get(cantidad).setEstado(2);
            }
           
        }
        
        
        Tabla = new DefaultTableModel();
        
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
        Tabla.setColumnIdentifiers(titulos_tabla);

        for (Producto p : Acceder_a_otraApp.lista_con_productos) {

            Object[] fila = new Object[8];

            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getMarca();
            fila[3] = p.getPrecioVenta();
            fila[4] = p.getPrecioCompra();
            fila[5] = p.m_Categoria.getnombre();
            fila[6] = p.getCantidad();
            fila[7] = p.getDescripcion();

            Tabla.addRow(fila);
            setDef(Tabla);

        }

        
        return Tabla;
    }

    public DefaultTableModel sumarSalidad(int id, int cant) {

        DefaultTableModel Tabla;
        
        Tabla = new DefaultTableModel();
        

        int idlista , cantidad = 0, cantidadSuma = 0;

        for (int i = 0; i < Acceder_a_otraApp.lista_con_productos.size(); i++) {
            
            
            idlista = Acceder_a_otraApp.lista_con_productos.get(i).getId();
            if (id == idlista) {

                cantidad += i;
//                productosEliminados.add(Acceder_a_otraApp.lista_con_productos.get(cantidad));
                cantidadSuma = Acceder_a_otraApp.lista_con_productos.get(cantidad).getCantidad();
                cantidadSuma = cantidadSuma - cant;
                Acceder_a_otraApp.lista_con_productos.get(cantidad).setCantidad(cantidadSuma);
                Acceder_a_otraApp.lista_con_productos.get(cantidad).setEstado(2);
            }
           
        }
        
        
        Tabla = new DefaultTableModel();
        
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
        Tabla.setColumnIdentifiers(titulos_tabla);

        for (Producto p : Acceder_a_otraApp.lista_con_productos) {

            Object[] fila = new Object[8];

            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getMarca();
            fila[3] = p.getPrecioVenta();
            fila[4] = p.getPrecioCompra();
            fila[5] = p.m_Categoria.getnombre();
            fila[6] = p.getCantidad();
            fila[7] = p.getDescripcion();

            Tabla.addRow(fila);
            setDef(Tabla);

        }
        return Tabla;
    }
}  
