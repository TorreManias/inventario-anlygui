package controladores;

import inventarioanlygui.Producto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 */

public class TblProducto extends Conexion {

    public Producto m_Producto;
    private ArrayList<Producto> lista_productos;

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

    public void agregarProducto(Producto pro) {
        lista_productos.add(pro);
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

    public DefaultTableModel actualizarTablaInventario(Producto p, DefaultTableModel t) {
        DefaultTableModel tabla_actualizada;

        // Fila nueva en la tabla
        Object[] fila = new Object[8];
        fila[0] = p.getId();
        fila[1] = p.getNombre();
        fila[2] = p.getMarca();
        fila[3] = p.getPrecioCompra();
        fila[4] = p.getPrecioCompra();
        fila[5] = p.m_Categoria.getid();
        fila[6] = p.getCantidad();
        fila[7] = p.getDescripcion();

        // Insertar la fila en la tabla actualizada.
        tabla_actualizada = t;
        tabla_actualizada.addRow(fila);

        return tabla_actualizada;
        
    }

    public int sumarEntradas(int id, int cant) {

        int idlista = 0, cantidadlista = 0;
        System.out.println("Si");

        for (Producto pro : this.getLista_productos()) {

            idlista = pro.getId();
            System.out.println("Id: " + idlista);
            if (id == idlista) {

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
