import java.util.ArrayList;

public class DesplazarDerecha implements Accion{

    int jugador;
    public DesplazarDerecha(int numero){
        this.jugador = numero;
    }

    /*
    public ArrayList<Jugador> reiniciar(Jugador jugador1, Jugado

     */


    @Override
    public ArrayList<Jugador> ejecutar(Jugador jugador1, Jugador jugador2) {
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        if (jugador==0 && jugador1.accionDisponible){
            jugador1.ejecutoAccion = true;
            jugador1.accionDisponible = false;
            if( !jugador1.verificarColision(jugador2)){
                jugador1.setNombreImagen("Forward");
                jugador1.setX2(jugador1.getX());
                jugador1.addX(10);
                System.out.println(jugador1.getX());
            }
        }
        else if(jugador==1){
            if( !jugador2.verificarColisionVentana(jugador)){
                jugador2.accionDisponible = true;
                jugador2.ejecutoAccion = true;
                jugador2.setNombreImagen("BackwardR");
                jugador2.setX2(jugador2.getX());
                jugador2.addX(10);
                System.out.println(jugador2.getX());
            }
        }
        arrayList.add(jugador1);
        arrayList.add(jugador2);
        return arrayList;
    }

}
