
import javafx.scene.image.Image;

public class Aries extends Personaje{

    private Image AnimEstable;
    private Image AnimDespR;
    private Image AnimDespL;
    private Image AnimTrompada;
    private Image AnimSalto;


    boolean Orientacion;
    boolean L=false, R=true;

    public Aries(Coordenadas coordenadas, Color color, Orientacion) {
        super(coordenadas, color);
        this.setAnimaciones(Orientacion);
        this.setdañoAtaque=20;
    }

    private setAnimaciones(boolean Orientacion){
        if (Orientacion==L){
            AnimEstable = new Image ("Stance.gif");
            AnimDespR = new Image ("Foward.gif");
            AnimDespL = new Image ("Backwards.gif");
            AnimSalto = new Image ("Jump.gif");
            AnimTrompada = new Image ("Punch.gif");
        }
        else{
            AnimEstable = new Image ("StanceR.gif");
            AnimDespR = new Image ("FowardR.gif");
            AnimDespL = new Image ("BackwardsR.gif");
            AnimSalto = new Image ("JumpR.gif");
            AnimTrompada = new Image ("PunchR.gif")
        }
    }

}