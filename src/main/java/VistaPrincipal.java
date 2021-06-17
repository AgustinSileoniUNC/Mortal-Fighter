import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPrincipal {

    Scene scene ;
    Button  buttonPelea,buttonSalir;
    ImageView fondo;
    Group group;

    VistaPrincipal(){
        group = new Group();
        scene = new Scene(group,500,300);
        buttonPelea = new Button();
        buttonSalir = new Button();
        buttonSalir.setGraphic(new ImageView("Salir.png"));
        buttonPelea.setGraphic(new ImageView("NuevaPartida.png"));
        fondo = new ImageView();
        fondo.setImage(new Image("Pantalla1.png"));

        buttonPelea.setLayoutX(70);
        buttonPelea.setLayoutY(160);
        buttonPelea.setStyle("-fx-background-color: rgba(143,179,222,0)");
        buttonSalir.setLayoutX(165);
        buttonSalir.setLayoutY(240);
        buttonSalir.setStyle("-fx-background-color: rgba(143,179,222,0)");


        group.getChildren().addAll(fondo,buttonPelea,buttonSalir);
    }


    public Scene getScene(){
        return scene;
    }
    public Button getButtonPelea(){
        return buttonPelea;
    }
    public Button getButtonSalir(){
        return buttonSalir;
    }


}
