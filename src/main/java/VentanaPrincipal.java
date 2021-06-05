import Modelo.VistaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.ShapeGraphicAttribute;


@SuppressWarnings("serial")

public class VentanaPrincipal extends JPanel {

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    boolean valor= false;
    Graphics2D g2d;
    Graphics g;
    public void paint(Graphics g) {
        super.paint(g);
        this.g = g;
        g2d = (Graphics2D) g;

        if(valor){
            vistaPrincipal();
        }
        else {
            canvas();
        }


    }


    public void vistaPrincipal(){
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.paint(g);
    }


    public void canvas(){
        Canvas can = new Canvas();
        can.paint(g);
    }




}
