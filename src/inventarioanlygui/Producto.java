package inventarioanlygui;

public class Producto {

	private String descripcion;
	private int id;
	private String marca;
	private String nombre;
	private float precioCompra;
	private float precioVenta;
	public Categoria m_Categoria;

	public Producto(){

	}

	public void finalize() throws Throwable {

	}

	public String getdescripcion(){
		return descripcion;
	}

	public int getid(){
		return id;
	}

	public String getmarca(){
		return marca;
	}

	public String getnombre(){
		return nombre;
	}

	public float getprecioCompra(){
		return precioCompra;
	}

	public float getprecioVenta(){
		return precioVenta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setid(int newVal){
		id = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmarca(String newVal){
		marca = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombre(String newVal){
		nombre = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setprecioCompra(float newVal){
		precioCompra = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setprecioVenta(float newVal){
		precioVenta = newVal;
	}

}