package imagenes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yair
 */
public class prueba {
    
    public static void main(String[] args) {
        
        Imagenes.Singleton().cargaCarpeta("imagenes");
        while (true) {
            VentanaJuego.Singleton().repaint();
        }
    }
}
