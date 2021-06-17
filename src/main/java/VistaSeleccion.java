import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class VistaSeleccion {

    Scene scene ;
    Button personaje1,personaje2,aceptar;
    ImageView fondo,seleccion;
    TextField nombreP1,nombreP2;
    Group group;

    VistaSeleccion(){
        //Inicializa lo necesario para crear la ventana y poder graficar
        group = new Group();
        scene =  new Scene(group,550,400);
        //Inicializacion de los elementos en la ventana
        personaje1 = new Button();
        personaje2 = new Button();
        aceptar = new Button();
        nombreP1 = new TextField();
        nombreP2 = new TextField();
        seleccion = new ImageView(new Image("SelecP1.png"));
        seleccion.setX(140);
        seleccion.setY(300);
        fondo = new ImageView();
        fondo.setImage(new Image("fondoSeleccion.gif"));
        //Configuración boton personaje2


        //Configuración boton aceptar
        aceptar.setMinSize(115,60);
        aceptar.setMaxSize(10,60);
        aceptar.setLayoutX(210);
        aceptar.setLayoutY(180);

        //Configuración TextField nombreP1
        nombreP1.setPromptText("Ingresar Nombre 1");
        nombreP1.setMinSize(170,60);
        nombreP1.setMaxSize(170,60);
        nombreP1.setLayoutY(180);
        nombreP1.setLayoutX(5);

        //Configuración TextField nombreP2
        nombreP2.setPromptText("Ingresar Nombre 2");
        nombreP2.setMinSize(170,60);
        nombreP2.setMaxSize(170,60);
        nombreP2.setLayoutX(370);
        nombreP2.setLayoutY(175);


        colocarImagenButton();


        group.getChildren().addAll(fondo,personaje1,personaje2,nombreP1,nombreP2,aceptar,seleccion);

    }

    public void cambiarTextoJugador(String linkImagen) {
        seleccion.setImage(new Image(linkImagen));
    }

    public Scene getScene(){
        return scene;
    }
    public Button getPersonaje1(){
        return personaje1;
    }
    public Button getPersonaje2(){
        return personaje2;
    }
    private void colocarImagenButton(){
        Image imagePJ1 = new Image("Aries.png",170,170,false,true);
        Image imagePJ2 = new Image("Kratos.png",170,170,false,true);
        Image imageAceptar = new Image("Jugar.png",115,60,false,true);
        personaje1.setGraphic(new ImageView(imagePJ1));
        personaje2.setGraphic(new ImageView(imagePJ2));
        aceptar.setGraphic(new ImageView(imageAceptar));
        personaje2.setLayoutX(370);

        personaje1.setStyle("-fx-background-color: rgba(250,250,250,0)");
        personaje2.setStyle("-fx-background-color:rgba(250,250,250,0)");
        aceptar.setStyle("-fx-background-color: rgba(250,250,250,0)");

    }


}
