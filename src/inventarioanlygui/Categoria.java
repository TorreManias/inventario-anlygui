package inventarioanlygui;

public class Categoria {

    private String nombre;

    public Categoria() {}

    public Categoria(String nombre) {
  
        this.nombre = nombre;
    }



    public String getnombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    /**
     *
     * @param newVal
     */
    public void setnombre(String newVal) {
        nombre = newVal;
    }

    @Override
    public String toString() {
        return "Categoria{" + ", nombre=" + nombre + '}';
    }
    
    

}
