import Modelo.Coordenadas;
import Modelo.Movimiento;

import java.awt.*;

public class Personaje {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static int y= 330;
    private Coordenadas coordenadas;
    int xa = 0;
    int life;
    protected int dañoAtaque;
    Color color;

    public Personaje(Coordenadas coordenadas, Color color){
        life = 100;
        this.coordenadas = coordenadas;
    }

    void move() {
        if(coordenadas.getX() + xa > 0 & coordenadas.getX() + xa < 1000 - WIDTH){
            coordenadas.setX(coordenadas.getX() + xa);
        }
    }


    void moverDerecha(){
        getCoordenadas().setX(getCoordenadas().getX()+1);
    }
    void moverIzquierda(){
        getCoordenadas().setX(getCoordenadas().getX()-1);
    }
    void noMover(){
        xa=0;
    }

    public Rectangle getBounds(){

        return new Rectangle(coordenadas.getX(),y,WIDTH, HEIGHT);
    }

    public int getTopY(){
        return y;
    }

    public void paint(Graphics2D g){
        y = 360 - 30;
        g.fillRect( coordenadas.getX() , y ,WIDTH ,HEIGHT );
        g.setColor(color);
    }

    public Coordenadas getCoordenadas(){
        return coordenadas;
    }



}
