package controladores;

import inventarioanlygui.Producto;
import java.util.ArrayList;

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
        
        System.out.println("Id: " + lista_productos.get(0).getId());
       
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
        
        for(Producto pro : this.getLista_productos()){
            
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
