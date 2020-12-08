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

    // Métodos propios
    public DefaultComboBoxModel obtenerListaDeCategorias() {

        Connection conexionCategorias = this.conectar();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        try {

            Statement listar = conexionCategorias.createStatement();
            ResultSet consulta_cateogrias = listar.executeQuery(seleccionar_categorias);

            while (consulta_cateogrias.next()) {

                c = new Categoria();

                for (int i = 1; i < 3; i++) {

                    switch (i) {
                        case 1:
                            c.setid((int) consulta_cateogrias.getObject(i));
                            break;

                        case 2:
                            c.setnombre((String) consulta_cateogrias.getObject(i));
                            break;
                    }

                }

                this.cuaderno_categorias.agregarCategoria(c);
                modelo.addElement(c.getnombre());
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return modelo;

    }

    public DefaultTableModel obtenerListaDeProductos() {

        Connection conexionProductos = this.conectar();
        DefaultTableModel tabla = new DefaultTableModel();

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
                p.m_Categoria.setid((int) consulta_productos.getObject(6));
                p.setCantidad((int) consulta_productos.getObject(7));
                p.setDescripcion((String) consulta_productos.getObject(8));

                this.cuaderno_productos.agregarProducto(p);

            }

            String[] titulos_tabla = {"iD", "Nombre", "Marca", "Precio Venta", "Precio compra", "Categoría", "Cantidad", "Descripción"};
            tabla.setColumnIdentifiers(titulos_tabla);

            for (Producto p : this.cuaderno_productos.getLista_productos()) {

                Object[] fila = new Object[8];

                fila[0] = p.getId();
                fila[1] = p.getNombre();
                fila[2] = p.getMarca();
                fila[3] = p.getPrecioVenta();
                fila[4] = p.getPrecioCompra();
                fila[5] = p.m_Categoria.getid();
                fila[6] = p.getCantidad();
                fila[7] = p.getDescripcion();

                tabla.addRow(fila);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return tabla;

    }

}
