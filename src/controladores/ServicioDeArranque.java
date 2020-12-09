package controladores;

import inventarioanlygui.Categoria;
import inventarioanlygui.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Lanuza - Luis Orozco - Steven Melara
 */
public class ServicioDeArranque extends Conexion {

    // Atributos
    public TblProducto cuaderno_productos;
    public TblCategoria cuaderno_categorias;
    public Categoria c;
    public Producto p;

    // Tabla de productos
    public static DefaultTableModel tabla;

    // Conexion
    Connection conexion;

    // Sentencias de SQL
    private PreparedStatement solicitarProductos;
    private final String seleccionar_productos = "SELECT * from dbo.Producto";

    private PreparedStatement solicitarCategorias;
    private final String seleccionar_categorias = "SELECT * from dbo.Categoria";

    // Constructores
    public ServicioDeArranque() {

        cuaderno_productos = new TblProducto();
        cuaderno_categorias = new TblCategoria();

    }

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }

    public TblProducto getCuaderno_productos() {
        return cuaderno_productos;
    }

    public void setCuaderno_productos(TblProducto cuaderno_productos) {
        this.cuaderno_productos = cuaderno_productos;
    }

    // Métodos propios
    public DefaultComboBoxModel obtenerListaDeCategorias() {

        Connection conexionCategorias = this.conectar();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        try {

            c = new Categoria();
            Statement listar = conexionCategorias.createStatement();
            ResultSet consulta_cateogrias = listar.executeQuery(seleccionar_categorias);
            while (consulta_cateogrias.next()) {

                c.setnombre((String) consulta_cateogrias.getObject(1));
                cuaderno_categorias.agregarCategoria(c);
                modelo.addElement(c.getnombre());
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return modelo;

    }

    public DefaultTableModel obtenerListaDeProductos() {

        Connection conexionProductos = this.conectar();
        DefaultTableModel unnombre = new DefaultTableModel();

        try {

            Statement listar = conexionProductos.createStatement();
            ResultSet consulta_productos = listar.executeQuery(seleccionar_productos);

            while (consulta_productos.next()) {

                p = new Producto();

                p.setId((int) consulta_productos.getObject(1));
                p.setNombre((String) consulta_productos.getObject(2));

                double pc = (double) consulta_productos.getObject(3);
                p.setPrecioCompra((float) pc);

                double pv = (double) consulta_productos.getObject(4);
                p.setPrecioVenta((float) pv);

                p.setMarca((String) consulta_productos.getObject(5));
                p.m_Categoria.setnombre((String) consulta_productos.getObject(6));
                p.setCantidad((int) consulta_productos.getObject(7));
                p.setDescripcion((String) consulta_productos.getObject(8));

                p.setEstado(1);

                cuaderno_productos.getLista_productos().add(p);

            }
            System.out.println("Cuaderno de producto " + cuaderno_productos.getLista_productos().toString());

            String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
            unnombre.setColumnIdentifiers(titulos_tabla);

            for (Producto p : this.cuaderno_productos.getLista_productos()) {

                Object[] fila = new Object[8];

                fila[0] = p.getId();
                fila[1] = p.getNombre();
                fila[2] = p.getMarca();
                fila[3] = p.getPrecioVenta();
                fila[4] = p.getPrecioCompra();
                fila[5] = p.m_Categoria.getnombre();
                fila[6] = p.getCantidad();
                fila[7] = p.getDescripcion();

                unnombre.addRow(fila);

            }
            setTabla(unnombre);
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return unnombre;

    }

}
