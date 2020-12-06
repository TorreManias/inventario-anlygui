/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioanlygui;

import controladores.GestionProductos;

/**
 *
 * @author Andrea Wood
 */
public class InventarioAnlygui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        GestionProductos pro = new GestionProductos();
        int n = pro.insertarProducto("Clorox", 7, 14, "Clorox", 1, "Pos es cloro");
        
        System.out.println(n);
        
        AplicacionInventario app = new AplicacionInventario();
        app.setVisible(true);
        
    }
    
}
