package Modelo;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.drawRect(100,100,60,30);
        g2d.drawRect(50,50,30,30);
    }

    public VistaPrincipal(){

    }

}
