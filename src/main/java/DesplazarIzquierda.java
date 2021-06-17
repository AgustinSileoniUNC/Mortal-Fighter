import java.util.ArrayList;

public class DesplazarIzquierda implements Accion{

    int jugador;
    public DesplazarIzquierda(int numero){
        this.jugador = numero;
    }

    //Implementar lo de accion Disponible para el jugador 2 y lo del cambioAccion

    //No se como hacerlo para que reconozca cuando mover al player2
    @Override
    public ArrayList<Jugador> ejecutar(Jugador jugador1, Jugador jugador2) {
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        if (jugador==0 && jugador1.accionDisponible){
            jugador1.ejecutoAccion = true;
            jugador1.accionDisponible = false;
            if( !jugador1.verificarColisionVentana(jugador)){
                jugador1.setNombreImagen("Backward");
                jugador1.setX2(jugador1.getX());
                jugador1.addX(-10);;
                System.out.println(jugador1.getX());
            }
        }
        if(jugador==1){
            jugador2.accionDisponible = true;
            jugador2.ejecutoAccion = true;
            if( !jugador2.verificarColision(jugador1)){
                jugador2.setNombreImagen("ForwardR");
                jugador2.setX2(jugador2.getX());
                jugador2.addX(-10);
                System.out.println(jugador2.getX());
            }
        }
        arrayList.add(jugador1);
        arrayList.add(jugador2);
        return arrayList;
    }

}
