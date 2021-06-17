import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.WindowEvent;


import javax.management.Notification;
import java.awt.*;
import java.beans.Expression;

import static javafx.application.Application.launch;

public class Ventana extends Application {

    VistaPrincipal vistaPrincipal;
    VistaPelea vistaPelea;
    VistaSeleccion vistaSeleccion;
    Stage window;
    Escenario escenario;
    ControladorInput controladorInput;
    VentanaEstadisticas Estadisticas1;
    VentanaEstadisticas Estadisticas2;
    Dimension screenSize;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        //Calcular como hacer para poder centrar siempre el juego
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        window.setResizable(false);
        this.window= window;
        inicializarComponentes();
        window.setX(((screenSize.width-600-800)/2)+300);
        window.setY((screenSize.height/2)-250);
        window.show();
        cicloJuego();

        //Configuro el boton aceptar para que inicie la pelea
        vistaSeleccion.aceptar.setOnAction(event -> {

            if(corroborarNombre(vistaSeleccion.nombreP1.getText())) {
                escenario.setNombre(0,vistaSeleccion.nombreP1.getText());
            } else {
                escenario.setNombre(0,"Player1");            }
            if(corroborarNombre(vistaSeleccion.nombreP2.getText())) {
                escenario.setNombre(1,vistaSeleccion.nombreP2.getText());
            }
            else {
                escenario.setNombre(1,"Player2");
            }
            inicializarEstadisticas();
            escenario.jugadores.get(0).startFight();
            escenario.jugadores.get(1).startFight();
            escenario.notificar();
            vistaPelea.getCronometro().start();

            window.setScene(vistaPelea.getScene());
        });
        //Configuro el boton de pelear en el menu principal para que cargue la vista de seleccion
        vistaPrincipal.getButtonPelea().setOnAction(event -> window.setScene(vistaSeleccion.getScene()));

        //Configuro el boton de salir en el menu principal para que cierrela ventana
        vistaPrincipal.getButtonSalir().setOnAction(event -> System.exit(0));

        //Configuro el personaje 1 para que cargue la vista de pelea
        vistaSeleccion.getPersonaje1().setOnAction(event -> {
            if(!vistaPelea.valor){
                vistaSeleccion.getPersonaje1().setStyle("-fx-border-color: red");
                vistaSeleccion.cambiarTextoJugador("SelecP2.png");
                escenario.jugadores.get(0).setPersonaje("Aries");
                vistaPelea.valor = true;
            }
            else {
                vistaSeleccion.getPersonaje1().setStyle("-fx-border-color: red");
                escenario.jugadores.get(1).setPersonaje("Aries");
                vistaSeleccion.cambiarTextoJugador("LISTO.png");
            }
        });
        //Configuro el personaje 2 para que cargue la vista de pelea
        vistaSeleccion.getPersonaje2().setOnAction(event -> {
            if(!vistaPelea.valor){
                vistaSeleccion.getPersonaje2().setStyle("-fx-border-color: red");
                vistaSeleccion.cambiarTextoJugador("SelecP2.png");
                escenario.jugadores.get(0).setPersonaje("Kratos");
                vistaPelea.valor = true;
            }
            else {
                vistaSeleccion.getPersonaje2().setStyle("-fx-border-color: red");
                escenario.jugadores.get(1).setPersonaje("Kratos");
                vistaSeleccion.cambiarTextoJugador("LISTO.png");
            }
        });

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });


    }

    public void cicloJuego() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(!(escenario.jugadores.get(0).isVivo() && escenario.jugadores.get(1).isVivo()) || vistaPelea.getCronometro().tiempo==0) {
                    controladorInput.bool = false;
                    vistaPelea.getCronometro().frenar();
                    escenario.ejecutarAccion(new Reniciar());
                    window.setScene(vistaPelea.getScene());
                }
            }
        };
        animationTimer.start();

    }




    //Inicializar las ventanas y las clases necesarias
    private void inicializarComponentes(){
        //Creo las vistas
        escenario = new Escenario();
        vistaPrincipal = new VistaPrincipal();
        vistaPelea = new VistaPelea();
        vistaSeleccion = new VistaSeleccion();
        vistaPelea.inicializar();
        escenario.agregarObservador(vistaPelea);
        vistaPelea.setCoordenadasX(escenario.jugadores);
        gestionEventos();

        //Configuro el Stage
        window.setResizable(true);
        window.setTitle( "Mortal-Fighter" );
        window.setScene(vistaPrincipal.getScene());
    }

    //
    private void gestionEventos(){
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

    public boolean corroborarNombre(String nombre){
        String regex = "^[a-zA-Z0-9]{0,7}+$";
        if (nombre.matches(regex) && !nombre.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


    private void inicializarEstadisticas(){
        Estadisticas1 = new VentanaEstadisticas(1,escenario.jugadores.get(0).nombre);
        escenario.agregarObservador((Observador) Estadisticas1);
        Estadisticas1.setLocation(((screenSize.width-600-800)/2)+15,((screenSize.height)/2)-250);
        Estadisticas1.setVisible(true);
        Estadisticas2 = new VentanaEstadisticas( 2,escenario.jugadores.get(1).nombre);
        escenario.agregarObservador((Observador) Estadisticas2);
        Estadisticas2.setLocation(((screenSize.width-600-800)/2)+1100,((screenSize.height)/2)-250);
        Estadisticas2.setVisible(true);
    }

}
