import javax.swing.*;
import java.awt.*;

public class Controlador {

    private VentanaPrincipal ventPral ;
    public Controlador(){
        JFrame frame = new JFrame("Titulo");
        ventPral = new VentanaPrincipal();
        frame.add(ventPral);
        frame.setSize(300,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public VentanaPrincipal ventana(){
        return ventPral;
    }



}
