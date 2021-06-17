import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
//import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class VistaPelea implements Observador{

    Scene scene ;
    Group group;
    public ImageView P1, P2;
    public ProgressBar vidaP1,vidaP2;
    float vidap1=100, vidap2=100;
    String imagenp1 = "fondo.png",imagenp2 = "fondo.png";
    boolean valor= false;
    Label nombre1,nombre2;
    public Cronometro cronometro;
    Text text;
    VistaPelea(){

    }

    //Inicializa lo necesario para crear la ventana y poder graficar
    public void inicializar(){
        //Inicializacion de la vista
        group = new Group();
        scene = new Scene(group,800,340);

        //Inicializacion de los elementos en la ventana
        ImageView fondo= new ImageView("fondo3-800.gif");
        nombre1 = new Label("Player1");
        nombre2 = new Label("Player2");
        vidaP1 = new ProgressBar();
        vidaP2 = new ProgressBar();
        text = new Text();
        cronometro =  new Cronometro(text);
        //Configuración fondo
        fondo.setX(0);
        fondo.setY(0);

        //Configuración nombre1
        nombre1.setFont(new Font("cooper black",20));
        nombre1.setLayoutX(10);
        nombre1.setTextFill(Color.YELLOW);

        //Configuración nombre2
        nombre2.setFont(new Font("cooper black",20));
        nombre2.setLayoutX(720);
        nombre2.setTextFill(Color.YELLOW);

        //Configuracion vidaP1
        vidaP1.setLayoutX(10);
        vidaP1.setLayoutY(30);
        vidaP1.setMinSize(300,30);
        vidaP1.setProgress((double) vidap1/100);

        //Configuración vida2
        vidaP2.setLayoutX(490);
        vidaP2.setLayoutY(30);
        vidaP2.setMinSize(300,30);
        vidaP2.setProgress(vidap2/100);

        //Configuración personaje1
        P1 = new ImageView(imagenp1);
        P1.setX(200);
        P1.setY(170);
        P1.disabledProperty();
        //Configuración personaje2
        P2 = new ImageView(imagenp2);
        P2.setX(500);
        P2.setY(170);

        //Configuración reloj
        text.setX(390);
        text.setY(50);
        text.setText("60");
        text.setScaleX(8);
        text.setScaleY(8);
        text.setFill(Color.RED);
        text.setStyle("-fx-font-weight: bold");
        text.setStyle("-fx-font-family: Serif");

        //Integración de los elementos en la ventana
        group.getChildren().addAll(fondo,P1, P2,nombre1,nombre2,vidaP1,vidaP2,text);
    }

    public Scene getScene(){
        return scene;
    }

    public Cronometro getCronometro() { return cronometro; }

    public void setCoordenadasX(ArrayList<Jugador> jugadores){
        TranslateTransition mover = new TranslateTransition(Duration.millis(5));
        mover.setNode(P1);
        mover.setByX(jugadores.get(0).getX() - jugadores.get(0).getX2());
        jugadores.get(0).setX2(jugadores.get(0).getX());
        mover.play();
        TranslateTransition mover2 = new TranslateTransition(Duration.millis(5));
        mover2.setNode(P2);
        mover2.setByX(jugadores.get(1).getX() - jugadores.get(1).getX2());
        jugadores.get(1).setX2(jugadores.get(1).getX());
        mover2.play();
    }

    private void setImagenes(ArrayList<Jugador> jugadores){
        P1.setImage(new Image(jugadores.get(0).nombreImagen));
        P2.setImage(new Image(jugadores.get(1).nombreImagen));
    }

    //Este igual
    private void setVidas(ArrayList<Jugador> jugadores){
        vidaP1.setProgress(jugadores.get(0).vida/100);
        vidaP2.setProgress(jugadores.get(1).vida/100);
    }

    private void setNombres(ArrayList<Jugador> jugadores){
        nombre1.setText(jugadores.get(0).getNombre());
        nombre2.setText(jugadores.get(1).getNombre());
    }


    @Override
    public void actualizar(ArrayList<Jugador> jugadores) {
        setImagenes(jugadores);
        setCoordenadasX(jugadores);
        setVidas(jugadores);
        setNombres(jugadores);
    }

}
