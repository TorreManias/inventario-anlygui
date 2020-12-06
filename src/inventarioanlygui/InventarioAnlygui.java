/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioanlygui;

import controladores.GestionProductos;
import jForm.Acceder_a_otraApp;
import jForm.AgregarProducto;
import jForm.AnlyguiLogIn;

/**
 *
 * @author Andrea Wood
 */
public class InventarioAnlygui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        boolean bo = true;
//        GestionProductos pro = new GestionProductos();
//        //int n = pro.insertarProducto("Mr.Musculo", 7, 14, "Clorox", 1, "Pos es cloro");
//
//        //System.out.println(n);
//        AnlyguiLogIn login = new AnlyguiLogIn();
//
//        if (bo = true) {
//
        Acceder_a_otraApp app = new Acceder_a_otraApp();
        app.setVisible(true);
//
//        }
    }

}
