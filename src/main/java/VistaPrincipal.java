import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.net.URL;

public class VistaPrincipal {

    Scene scene ;
    Button  buttonPelea;
    Button  buttonSalir;
    GridPane gridPane;

    VistaPrincipal(){
        buttonPelea = new Button("Pelea");
        buttonSalir = new Button(" Salir ");
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0,120,0,120));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        GridPane.setConstraints(buttonPelea,0,8);
        GridPane.setConstraints(buttonSalir,0,15);
        gridPane.getChildren().addAll(buttonPelea, buttonSalir);
        scene = new Scene(gridPane,300,300);
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
