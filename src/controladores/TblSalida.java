package controladores;

import inventarioanlygui.Producto;
import inventarioanlygui.Salida;


public class TblSalida extends Conexion {

    private int cantidad;
    private String fecha;
    
    public TblProducto m_TblProducto;
    public Salida m_Salida;

    public TblSalida() {

    }

    public TblProducto getM_TblProducto() {
        return m_TblProducto;
    }

    public void setM_TblProducto(TblProducto m_TblProducto) {
        this.m_TblProducto = m_TblProducto;
    }

    public Salida getM_Salida() {
        return m_Salida;
    }

    public void setM_Salida(Salida m_Salida) {
        this.m_Salida = m_Salida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    /**
     *
     * @param p
     */
    public int agregarSalida(Producto p) {
        return 0;
    }

}
