package controladores;

import inventarioanlygui.Entrada;
import inventarioanlygui.Producto;



public class TblEntrada extends Conexion {

	public TblProducto m_TblProducto;
	public Entrada m_Entrada;

	public TblEntrada(){

	}

	/**
	 * 
     * @param cant
     * @param fecha
     * @return 
	 */
	public int agregarEntrada(int cant, String fecha){
            int cantidad;
            cantidad = cant;
            String fe;
            fe = fecha;
            
            return cantidad;
	}

}