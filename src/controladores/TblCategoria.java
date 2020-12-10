package controladores;

import inventarioanlygui.Categoria;
import jForm.Acceder_a_otraApp;
import jForm.CrearCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 */
public class TblCategoria extends Conexion {

    public Categoria m_Categoria;
    private ArrayList<Categoria> lista_categoria;
    private PreparedStatement insertarCategoria;
    private PreparedStatement borrarCategoria;
    final String sentenciaInsertar = "INSERT into dbo.Categoria(nombre) VALUES (?)";
    final String BORRAR_CATEGORIA = "DELETE from dbo.Categoria WHERE nombre  = ?";
    ServicioDeArranque arranque;

    public TblCategoria() {

        lista_categoria = new ArrayList<>();

        try {
            Connection conexion = this.conectar();

            insertarCategoria = conexion.prepareStatement(sentenciaInsertar);
            borrarCategoria = conexion.prepareStatement(BORRAR_CATEGORIA);

        } catch (SQLException ex) {
            System.out.println("x");

        }
    }

    public Categoria getM_Categoria() {

        return m_Categoria;
    }

    public void insertarCategoriaEnDB(String nombre) {

        try {

            insertarCategoria.setString(1, nombre);
            insertarCategoria.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    
    public void eliminarCategoria(String nombre){
        try{
            borrarCategoria.setString(1, nombre);
            borrarCategoria.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }

    public DefaultComboBoxModel actualizarCBM(String nombre) {

        DefaultComboBoxModel nuevoModelo;
        nuevoModelo = new DefaultComboBoxModel();
        arranque = new ServicioDeArranque();

        for (int i = 0; i < arranque.obtenerListaDeCategorias().getSize(); i++) {

            nuevoModelo.addElement(arranque.obtenerListaDeCategorias().getElementAt(i));

        }
        nuevoModelo.addElement(nombre);

        return nuevoModelo;
    }

    public void setM_Categoria(Categoria m_Categoria) {
        this.m_Categoria = m_Categoria;
    }

    public ArrayList<Categoria> getLista_categoria() {
        return lista_categoria;
    }

    public void setLista_categoria(ArrayList<Categoria> lista_categoria) {
        this.lista_categoria = lista_categoria;
    }

    public void agregarCategoria(Categoria c) {
        lista_categoria.add(c);
    }

}
