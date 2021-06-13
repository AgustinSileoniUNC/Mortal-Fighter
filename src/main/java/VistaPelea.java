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

import java.util.ArrayList;

public class VistaPelea implements Observador{

    Scene scene ;
    Group group;
    int xp1;
    int xp2=300; //Tengo que hacer que se carg
    int vidap1;
    int vidap2;
    GraphicsContext graphicsContext;
    String animacion;

    VistaPelea(){

    }



    //Inicializa lo necesario para crear la ventana y poder graficar
    public void inicializar(){
        group = new Group();
        scene = new Scene(group,621,240);
        Canvas canvas = new Canvas(621,240);
        group.getChildren().addAll(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
        pintar();
    }

    //Dibuja los personajes y el fondo, es el método que se llama 60 veces por seg
    public void pintar(){
        graphicsContext.drawImage(new Image("fondo.png"),0,0);
        graphicsContext.drawImage(new Image("Cuerpo.png"),xp1,100,100,100);
        graphicsContext.strokeRect(xp1,100,90,100);
        graphicsContext.drawImage(new Image("CuerpoInverso.png"),xp2,100,100,100);
        graphicsContext.strokeRect(xp2,100,90,100);
    }

    public Group getGroup(){return group;}
    public Scene getScene(){
        return scene;
    }

    //Esto deberia reemplazarse por el observer
    public void setCoordenadas(ArrayList<Jugador> jugadores){
        this.xp1 =  jugadores.get(0).x;
        this.xp2 =  jugadores.get(1).x;
    }
    //Este igual
    public void setVidas(ArrayList<Jugador> jugadores){
        this.vidap1 = jugadores.get(0).vida;
        this.vidap2 = jugadores.get(1).vida;
    }

    //Implemento el observer No me acuerdo bien como se implementaba
    @Override
    public void actualizar(int xp1,int vidap) {
            this.vidap1 = vidap1;
            this.vidap2 = vidap2;
    }
}
