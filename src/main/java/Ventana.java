import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


import java.awt.*;
import java.net.URL;

import static javafx.application.Application.launch;

public class Ventana extends Application {
    private GraphicsContext graficos;
    VistaPrincipal vistaPrincipal;
    VistaPelea vistaPelea;
    VistaSeleccion vistaSeleccion;
    Stage window;
    Escenario escenario;
    ControladorInput controladorInput;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        this.window= window;
        inicializarComponentes();

        window.show();
        cicloJuego();

        //Configuro el boton de pelear en el menu principal para que cargue la vista de seleccion
        vistaPrincipal.getButtonPelea().setOnAction(event -> window.setScene(vistaSeleccion.getScene()));
        //Configuro el boton de salir en el menu principal para que cierrela ventana
        vistaPrincipal.getButtonSalir().setOnAction(event -> window.close());
        //Configuro el personaje 1 para que cargue la vista de pelea
        vistaSeleccion.getPersonaje1().setOnAction(event -> window.setScene(vistaPelea.getScene()));
        //Configuro el personaje 1 para que cargue la vista de pelea
        vistaSeleccion.getPersonaje2().setOnAction(event -> window.setScene(vistaPelea.getScene()));

    }

    public void cicloJuego(){
        long ts = System.currentTimeMillis();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                System.out.println(escenario.jugadores.get(1).vida);
                vistaPelea.setCoordenadas(escenario.jugadores.get(0));
                vistaPelea.pintar();
            }
        };
        animationTimer.start();
    }

    private void inicializarComponentes(){
        //Creo las vistas
        vistaPrincipal = new VistaPrincipal();
        vistaPelea = new VistaPelea();
        vistaSeleccion = new VistaSeleccion();
        escenario = new Escenario();
        vistaPelea.setCoordenadas(escenario.jugadores.get(0));
        vistaPelea.inicializar();
        gestioEventos();

        //Configuro el Stage
        window.setResizable(true);
        window.setTitle( "Mortal-Fighter" );
        window.setScene(vistaPrincipal.getScene());
    }

    private void gestioEventos(){
        controladorInput = new ControladorInput(escenario);
        vistaPelea.getScene().setOnKeyPressed(controladorInput);
        vistaPelea.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //Para que se pueda volver a mover despues de soltar la tecla
                        controladorInput.bool= true;
            }
        });
    }


}
