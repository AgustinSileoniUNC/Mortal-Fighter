import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Timer;

public class Escenario implements Sujeto {
    public ArrayList<Observador> observers = new ArrayList<>();
    public ArrayList<Jugador> jugadores;


    public Escenario(){
        jugadores = new ArrayList<Jugador>();
        jugadores.add(new Jugador(200,500));
        jugadores.add(new Jugador(500,500));
        jugadores.get(1).orientacion = true;
    }

    //Ejecuta la accion que le haya pasado el Controlador
    public void ejecutarAccion(Accion accion){
        jugadores = accion.ejecutar(jugadores.get(0),jugadores.get(1));
        notificar();
        if(jugadores.get(0).ejecutoAccion){
            new CambioAnimacion(jugadores.get(0),this).start();
        }
        else if(jugadores.get(1).ejecutoAccion){
            new CambioAnimacion(jugadores.get(1),this).start();
        }
        else{
            new CambioAnimacion(jugadores.get(0),this).start();
            new CambioAnimacion(jugadores.get(1),this).start();
        }
        if(jugadores.get(0).vida == 0 ){
            Alert alert = new Alert(Alert.AlertType.NONE, "Ganador : "+ jugadores.get(1).getNombre()+"\nReiniciar partida ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                this.reiniciar();
            }
            else if ((alert.getResult() == ButtonType.NO)){
                System.exit(0);
            }
        }
        else if(jugadores.get(1).vida == 0){
            Alert alert = new Alert(Alert.AlertType.NONE, "Ganador : "+jugadores.get(0).getNombre()+"\nReiniciar partida ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                this.reiniciar();
            }
            else if ((alert.getResult() == ButtonType.NO)){
                System.exit(0);
            }
        }
    }

    public void setNombre(int jugador, String nombreJugador){
        jugadores.get(jugador).setNombre(nombreJugador);
        notificar();
    }


    //Implemento observer
    @Override
    public void agregarObservador(Observador observador) {
        observers.add(observador);
        notificar();
    }

    @Override
    public void quitarObservador(Observador observador) {
        if(observers.contains(observador)){
            observers.remove(observers.indexOf(observador));
        }
    }

    @Override
    public void notificar() {
        for(Observador observador:observers){
            observador.actualizar(jugadores);
        }
    }

    public void reiniciar(){
        jugadores.get(0).reiniciar(200);
        jugadores.get(1).reiniciar(500);
        notificar();
    }
}
