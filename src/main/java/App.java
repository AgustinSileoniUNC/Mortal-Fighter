import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class App extends JPanel{

    public static void main(String[] args)throws InterruptedException{
        Controlador controlador = new Controlador();
        InputsController inputsController = new InputsController(controlador.ventana());
           // inputsController.personaje1.moverIzquierda();
           // inputsController.personaje2.moverDerecha();



            for(int i=0;i<10;i++){
                controlador.ventana().repaint();
                Thread.sleep(100);
            }

            controlador.ventana().valor = true;

            while (true){
                controlador.ventana().repaint();
                Thread.sleep(100);
            }
        }

}
