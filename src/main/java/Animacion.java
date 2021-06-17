import java.awt.*;
import java.util.ArrayList;

public class Animacion {
    private int duracion;
    private Rectangle coordenadas[];
    public Animacion(int duracion, Rectangle coordenadas[]){
        super();
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCoordenadas(Rectangle[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getDuracion() {
        return duracion;
    }

    public Rectangle[] getCoordenadas() {
        return coordenadas;
    }
}
