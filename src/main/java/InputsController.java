import Modelo.Coordenadas;
import Modelo.Movimiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputsController extends JPanel {
    Personaje personaje1 ;
    Personaje personaje2 ;
    Escenario escenario;

    public InputsController(VentanaPrincipal window) {

        escenario = new Escenario(personaje1,personaje2);
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                escenario.ejecutarAccion(seleccionMovimiento(keyEvent));


            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                escenario.noMoverPaleta();
            }
        };

        window.addKeyListener(listener);
        window.setFocusable(true);         //Permite recibir las notificaciones del teclado
    }


    private Movimiento seleccionMovimiento(KeyEvent e){

        switch (e.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                return new MoverseDerecha();
            case KeyEvent.VK_LEFT:
                return new MoverseIzquierda();
            case KeyEvent.VK_UP:
                return new Saltar();
            case KeyEvent.VK_NUMPAD0:
                return new Trompada();
            case KeyEvent.VK_D:
                return new MoverseDerecha();
            case KeyEvent.VK_A:
                return new MoverseIzquierda();
            case KeyEvent.VK_W:
                return new Saltar();
            case KeyEvent.VK_SPACE:
                return new Trompada();
        }
        return null;

    }


}
