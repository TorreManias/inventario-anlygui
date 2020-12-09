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
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class TblProducto extends Conexion {

    private DefaultTableModel Def;
    public Producto m_Producto;
    private ArrayList<Producto> lista_productos;

    Connection coneccionDB;
    private PreparedStatement insertarProducto;

    ServicioDeArranque ser;
    
    private PreparedStatement solicitarProductos;
    private final String seleccionar_productos = "SELECT * from dbo Producto";

    public TblProducto() {

        lista_productos = new ArrayList<>();

    }

    // Getters y Setters

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
    public int actualizarBD() {
        return 0;
    }

    public void agregarProducto(Producto pro) {

        lista_productos.add(pro);
    }

    public Producto buscarProducto() {
        return null;
    }

    public float calcularExistencia() {
        return 0;
    }

    public DefaultTableModel eliminarProducto(int id) {
       DefaultTableModel Tabla = new DefaultTableModel();
        Connection conexionProductos = this.conectar();
        
        ser = new ServicioDeArranque();
        ser.obtenerListaDeProductos();

        try {

            Statement listar = conexionProductos.createStatement();
            ResultSet consulta_productos = listar.executeQuery(seleccionar_productos);

            while (consulta_productos.next()) {

                m_Producto = new Producto();

                m_Producto.setId((int) consulta_productos.getObject(1));
                m_Producto.setNombre((String) consulta_productos.getObject(2));

                double pc = (double) consulta_productos.getObject(3);
                m_Producto.setPrecioCompra((float) pc);

                double pv = (double) consulta_productos.getObject(4);
                m_Producto.setPrecioVenta((float) pv);

                m_Producto.setMarca((String) consulta_productos.getObject(5));
                m_Producto.m_Categoria.setnombre((String) consulta_productos.getObject(6));
                m_Producto.setCantidad((int) consulta_productos.getObject(7));
                m_Producto.setDescripcion((String) consulta_productos.getObject(8));

                m_Producto.setEstado(1);

                ser.cuaderno_productos.getLista_productos().add(m_Producto);

            }

            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        int idlista;
        
        Tabla = ser.getTabla();
        Tabla.getColumnCount();
        
        int cont = 0; //contador
        
        for (Producto pro : this.ser.cuaderno_productos.getLista_productos()) {

            idlista = pro.getId();
            System.out.println("Id: " + idlista);
            if (id == idlista) {
                
                System.out.println("ID " + idlista);
              ser.cuaderno_productos.getLista_productos().remove(cont);

            }
            cont = cont + 1;
                   
    }
        
        //if(ser.cuaderno_productos.getLista_productos().isEmpty()){
            
        //}else{
        String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
            Tabla.setColumnIdentifiers(titulos_tabla);
            
            for (Producto p : this.ser.cuaderno_productos.getLista_productos()) {

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
        //}
            
        return Tabla;
    }
        
    public int modificarProducto() {
        return 0;
    }

    public DefaultTableModel actualizarTablaInventario(Producto p, DefaultTableModel t) {

        // Fila nueva en la tabla
        Object[] fila = new Object[8];
        fila[0] = p.getId();
        fila[1] = p.getNombre();
        fila[2] = p.getMarca();
        fila[3] = p.getPrecioCompra();
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
            fila[3] = p.getPrecioCompra();
            fila[4] = p.getPrecioCompra();
            fila[5] = p.m_Categoria.getnombre();
            fila[6] = p.getCantidad();
            fila[7] = p.getDescripcion();
            
            tabla_actualizada.addRow(fila);
        }
        
        return tabla_actualizada;
    }

    public int sumarEntradas(int id, int cant) {

        ser = new ServicioDeArranque();
        ser.obtenerListaDeProductos();

        int idlista, cantidadlista = 0;
        System.out.println("Si");

        for (Producto pro : this.ser.cuaderno_productos.getLista_productos()) {

            idlista = pro.getId();
            System.out.println("Id: " + idlista);
            if (id == idlista) {

                cantidadlista = pro.getCantidad();
                cantidadlista = cantidadlista + cant;

            }

        }

        return cantidadlista;
    }

    public int sumarSalidad(int id, int cant) {

        ser = new ServicioDeArranque();
        ser.obtenerListaDeProductos();

        int idlista, cantidadlista = 0;
        System.out.println("Si");

        for (Producto pro : this.ser.cuaderno_productos.getLista_productos()) {

            idlista = pro.getId();
            System.out.println("Id: " + idlista);
            if (id == idlista) {

                cantidadlista = pro.getCantidad();
                cantidadlista = cantidadlista - cant;

            }

        }

        return cantidadlista;
    }

}
