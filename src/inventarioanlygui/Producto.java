package inventarioanlygui;

public class Producto {

    private String descripcion;
    private int id;
    private String marca;
    private String nombre;
    private double precioCompra;
    private double precioVenta;
    private int cantidad;

    public Categoria m_Categoria;

    // Constructores
    
    public Producto() {
        m_Categoria = new Categoria();
    }

    public Producto(String descripcion, int id, String marca, String nombre, double precioCompra, double precioVenta, int cantidad, Categoria m_Categoria) {
        this.descripcion = descripcion;
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.m_Categoria = m_Categoria;
    }
    
    // Getters y Setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getM_Categoria() {
        return m_Categoria;
    }

    public void setM_Categoria(Categoria m_Categoria) {
        this.m_Categoria = m_Categoria;
    }
    
    // Métodos propios

}
