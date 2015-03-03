/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes; 

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 */
public class VentanaJuego extends JFrame {
    
    public static VentanaJuego instancia = null;
    private static long tiempoInicial = System.currentTimeMillis();
    private static long tiempoActual = tiempoInicial;
    private static long periodoRepintado = 32;
    
    public static VentanaJuego Singleton() {
        if (instancia == null) {
            instancia = new VentanaJuego();
            instancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            instancia.setBounds(100, 100, 800, 600);
            instancia.setVisible(true);
            instancia.createBufferStrategy(2);
        }
        return instancia;
    }
    
    @Override
    public void paint(Graphics g) {
        tiempoActual = System.currentTimeMillis();
        if (tiempoActual - tiempoInicial >= periodoRepintado) {
            tiempoInicial = tiempoActual;
            BufferStrategy buffer = Singleton().getBufferStrategy();
            if(buffer != null)
            {
                Graphics segundo = buffer.getDrawGraphics();
                //Mostrar imagenes
                segundo.drawImage(Imagenes.Singleton().imagen("background_1.jpg"), 0, 0, null);
                segundo.drawImage(Imagenes.Singleton().imagen("Mario.gif"), 300, 500, null);
                //segundo.drawImage(Imagenes.Singleton().imagen("break.jpg"), 0, 0, null);
                buffer.show();
            }
        }
    }
}
