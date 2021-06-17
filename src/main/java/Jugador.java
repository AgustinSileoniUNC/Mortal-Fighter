import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.awt.*;

public class Jugador {
    private int x;
    protected int y;
    private int x2;
    private String personaje= "Aries";
    public String nombreImagen = "Aries/Stance.gif";
    public int ancho = 100;
    public int alto = 100;
    protected float vida = 100;
    public String nombre ;
    public Estadistica estadistica = new Estadistica();
    boolean accionDisponible = true;
    boolean ejecutoAccion = false;
    boolean orientacion=false;

    public Jugador(int x, int y) {
        this.x = x;
        this.x2 = x;
        this.y = y;
        if(x < 400){
            setNombreImagen("Stance");
        }
        else {
            orientacion=true;
            setNombreImagen("StanceR");
        }
    }

    public boolean verificarColision(Jugador player) {
        return player.getRectangle().getBounds().intersects(new Rectangle(x, y, ancho, alto));
    }

    public boolean verificarColisionVentana(int jugador) {
        if ((x <= 2 && jugador == 0) || (x >= 695 && jugador == 1)) {
            return true;
        }
        return false;
    }

    public void recibirGolpe(int danio) {
        vida -= danio;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void startFight() {
        System.out.println(personaje);
        if(x <= 300){
            setNombreImagen("Stance");
        }
        else {
            setNombreImagen("StanceR");
        }
        System.out.println(nombreImagen);
    }

    public void addX(int x) {
        this.x += x;
    }

    public boolean isVivo() {
        if(vida == 0) return false;

        return true;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, ancho, alto);
    }

    //Geters
    public String getNombreImagen() {
        return nombreImagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX2() {
        return x2;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVida() {
        return vida;
    }

    //Seters
    public void setVida(int vida) {this.vida = vida;}

    public void setX(int x) {
        this.x = x;
    }

    public void setX2(int x) {
        this.x2 = x;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = (personaje + "/" + nombreImagen + ".gif");
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPos(int X){
        this.x = X;
        this.x2 = X;}

    public void reiniciar(int X){
        setPos(X);
        vida=100;
        estadistica.reiniciar();
        if(!orientacion){setNombreImagen("Stance");}
        else{setNombreImagen("StanceR");};
    }


}


