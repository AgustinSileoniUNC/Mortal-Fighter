import java.util.ArrayList;

public class Reniciar implements Accion {

    @Override
    public ArrayList<Jugador> ejecutar(Jugador jugador1, Jugador jugador2) {
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        jugador1.setX2(jugador1.getX());
        jugador1.addX(200 - jugador1.getX());
        jugador2.setX2(jugador2.getX());
        jugador2.addX(500 - jugador2.getX());
        jugador1.setVida(100);
        jugador2.setVida(100);
        arrayList.add(jugador1);
        arrayList.add(jugador2);
        return arrayList;
    }

}