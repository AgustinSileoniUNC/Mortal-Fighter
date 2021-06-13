import java.util.ArrayList;

public class Escenario implements Sujeto {
    public ArrayList<Observador> observers;
    public ArrayList<Jugador> jugadores;


    public Escenario(){
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador(000,200,"Cuerpo.png"));
        jugadores.add(new Jugador(300,200,"CuerpoInverso.png"));
    }


    public void ejecutarAccion(Accion accion){
        jugadores = accion.ejecutar(jugadores.get(0),jugadores.get(1));

    }


    //Implemento observer
    @Override
    public void agregarObservador(Observador observador) {
        observers.add(observador);
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
            observador.actualizar();
        }
    }
}
