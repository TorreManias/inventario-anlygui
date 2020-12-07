package inventarioanlygui;

public class Categoria {

    private int id;
    private String nombre;

    public Categoria() {}

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getid() {
        return id;
    }

    public String getnombre() {
        return nombre;
    }

    /**
     *
     * @param newVal
     */
    public void setid(int newVal) {
        id = newVal;
    }

    /**
     *
     * @param newVal
     */
    public void setnombre(String newVal) {
        nombre = newVal;
    }

}
