package controladores;

import inventarioanlygui.Categoria;
import java.util.ArrayList;

/**
 */
public class TblCategoria extends Conexion {

    public Categoria m_Categoria;
    private ArrayList<Categoria> lista_categoria;

    public TblCategoria() {

        lista_categoria = new ArrayList<>();

    }

    public Categoria getM_Categoria() {
        return m_Categoria;
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

    public Categoria buscarCategoria() {
        return null;
    }

    public int eliminarCategoria() {
        return 0;
    }

    public int modificarCategoria() {
        return 0;
    }

    public ArrayList mostrarCategorias() {
        return null;
    }

}
