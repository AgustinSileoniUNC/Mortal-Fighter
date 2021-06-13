import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaSeleccion {

    Scene scene ;
    Button personaje1;
    Button personaje2;
    Button personaje3;
    Button personaje4;
    Button personaje5;
    Button personaje6;
    GridPane gridPane;
    ImageView fondo;

    VistaSeleccion(){
        fondo = new ImageView("fondoSeleccion.jpg");
        personaje1 = new Button();
        personaje2 = new Button();
        personaje3 = new Button();
        personaje4 = new Button();
        personaje5 = new Button();
        personaje6 = new Button();
        colocarImagenButton();
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0,75,0,75));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        GridPane.setConstraints(personaje1,0,5);
        GridPane.setConstraints(personaje2,5,5);
        GridPane.setConstraints(personaje3,10,5);
        GridPane.setConstraints(personaje4,0,10);
        GridPane.setConstraints(personaje5,5,10);
        GridPane.setConstraints(personaje6,10,10);

        gridPane.getChildren().addAll(personaje1,personaje2,personaje3,personaje4,personaje5,personaje6);
        scene =  new Scene(gridPane,600,600);
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
         Image imagePJ1 = new Image("personaje1.jpg",100,100,false,true);
         Image imagePJ2 = new Image("personaje2.jpg",100,100,false,true);
         Image imagePJ3 = new Image("personaje3.jpg",100,100,false,true);
         Image imagePJ4 = new Image("personaje4.jpg",100,100,false,true);
         Image imagePJ5 = new Image("personaje5.jpg",100,100,false,true);
         Image imagePJ6 = new Image("personaje6.jpg",100,100,false,true);
         personaje1.setGraphic(new ImageView(imagePJ1));
         personaje2.setGraphic(new ImageView(imagePJ2));
         personaje3.setGraphic(new ImageView(imagePJ3));
         personaje4.setGraphic(new ImageView(imagePJ4));
         personaje5.setGraphic(new ImageView(imagePJ5));
         personaje6.setGraphic(new ImageView(imagePJ6));

    }

}
