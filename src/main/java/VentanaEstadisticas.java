import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaEstadisticas extends JFrame implements Observador{

    JPanel panel;
    JLabel a = new JLabel();
    int jugador;
    String name = "1";

    public VentanaEstadisticas(int jugador,String name) {
        this.jugador = jugador;
        this.name = name;
        this.setTitle("Estadisticas " + name);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    @Override
    public void actualizar(ArrayList<Jugador> jugadores) {
        setear(jugadores);
    }

    private void iniciarComponentes(){

        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.add(a);
        setResizable(false);

    }

    public void setear(ArrayList<Jugador> jugadores){
        String str = ("<html><br/>"+jugadores.get(jugador-1).getNombre()+"<br/>Vida: "+(int)jugadores.get(jugador-1).getVida()+"<br/>Golpes Dados: " + jugadores.get(jugador-1).estadistica.getGolpesRealizados() + "<br/> Golpes Acertados: " +
                jugadores.get(jugador-1).estadistica.PorcentajeGolpesAcertados() + "%");
        a.setText(str);
    }

}
