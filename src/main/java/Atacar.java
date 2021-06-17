import java.util.ArrayList;

public class Atacar implements Accion{

    int numero;

    public Atacar(int numero){
        seleccionarJugador(numero);
    }

    public void seleccionarJugador(int numero){
        this.numero = numero;
    }

    //Esta implementado para el jugador 1, deberia ver como hacerlo para los dos. Mi idea es poner jugador1 y jugador2 y dependiendo del boron el orden en el que los coloco
    public ArrayList<Jugador> ejecutar(Jugador jugador1, Jugador jugador2){
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        if (numero == 0 && jugador1.accionDisponible){
            jugador1.accionDisponible = false;
            jugador1.ejecutoAccion = true;
            jugador1.setNombreImagen("Punch");
            jugador1.addX(21);

            if(jugador1.verificarColision(jugador2)){
                jugador2.recibirGolpe(10);
                jugador1.estadistica.golpe(true);
            } else {
                jugador1.estadistica.golpe(false);
            }
            jugador1.addX(-21);
        }
        else if (numero==1 && jugador2.accionDisponible){
            jugador2.accionDisponible = false;
            jugador2.ejecutoAccion = true;
            jugador2.setNombreImagen("PunchR");
            jugador2.addX(-21);
            if(jugador2.verificarColision(jugador1)){
                jugador1.recibirGolpe(10);
                jugador2.estadistica.golpe(true);
            }
            else{
                jugador2.estadistica.golpe(false);
            }
            jugador2.addX(21);
        }
        arrayList.add(jugador1);
        arrayList.add(jugador2);
        return arrayList;
    }


}