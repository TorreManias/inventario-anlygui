package inventarioanlygui;

public class Entrada {

    private float cantidad;
    private String fecha;
    private String observacion;
    private float precio;
    public Producto m_Producto;

    public Entrada() {

    }

    public int calcularMonto() {
        return 0;
    }

    public float getcantidad() {
        return cantidad;
    }

    public String getfecha() {
        return fecha;
    }

    public String getobservacion() {
        return observacion;
    }

    public float getprecio() {
        return precio;
    }

    /**
     *
     * @param newVal
     */
    public void setcantidad(float newVal) {
        cantidad = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setfecha(String newVal) {
        fecha = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setobservacion(String newVal) {
        observacion = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setprecio(float newVal) {
        precio = newVal;
    }

}
