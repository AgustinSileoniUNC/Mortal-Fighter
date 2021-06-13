import javafx.animation.Animation;
import javafx.scene.canvas.GraphicsContext;
import java.awt.*;
import java.util.HashMap;

public class Jugador {
    public int x;
    protected int y=100;
    public String nombreImagen;
    public int ancho=100;
    public int alto=100;
    protected int vida=100;

    public Jugador(int x, int y, String nombreImagen){
        this.x = x;
        this.y = y;
        this.nombreImagen = nombreImagen;


    }

    public Rectangle getRectangle(){
        return new Rectangle(x,y,ancho,alto);
    }

    public boolean verificarColision(Jugador player){
        return player.getRectangle().getBounds().intersects(new Rectangle(x,y,ancho,alto));
    }

    public void recibirGolpe(int danio){
        vida -= danio;
    }

}
