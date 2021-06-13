import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.image.ImageView;

public class VistaPelea implements Observador{

    Scene scene ;
    Group group;
    int x;
    GraphicsContext graphicsContext;
    String animacion;
    VistaPelea(){

    }


    public Group getGroup(){return group;}
    public Scene getScene(){
        return scene;
    }
    public void setCoordenadas(Jugador jugador){
       this.x =  jugador.x;
    }
    public void inicializar(){
        group = new Group();
        scene = new Scene(group,621,240);
        Canvas canvas = new Canvas(621,240);
        group.getChildren().addAll(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
        pintar();
    }

    public void pintar(){
        graphicsContext.drawImage(new Image("fondo.png"),0,0);
        graphicsContext.drawImage(new Image("Cuerpo.png"),x,100,100,100);
        graphicsContext.strokeRect(x,100,90,100);
        graphicsContext.drawImage(new Image("CuerpoInverso.png"),300,100,100,100);
        graphicsContext.strokeRect(300,100,90,100);
    }

    public void update(int posX,String animacion){
        x = posX;
        this.animacion = animacion;
    }

    @Override
    public void actualizar() {

    }
}
