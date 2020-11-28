package controladores;

import inventarioanlygui.Producto;
import java.util.ArrayList;


/**

 */
public class TblProducto extends Conexion {

	public Producto m_Producto;

	public TblProducto(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public int actualizarBD(){
		return 0;
	}

	public int agregarProducto(){
		return 0;
	}

	public Producto buscarProducto(){
		return null;
	}

	public float calcularExistencia(){
		return 0;
	}

	public int eliminarProducto(){
		return 0;
	}

	public int modificarProducto(){
		return 0;
	}

	public ArrayList mostarProductos(){
		return null;
	}

	public float sumarEntradas(){
		return 0;
	}

	public float sumarSalidad(){
		return 0;
	}

}