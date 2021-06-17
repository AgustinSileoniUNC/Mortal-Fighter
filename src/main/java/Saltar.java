import java.util.ArrayList;

public class Saltar implements Accion{


    @Override
    public ArrayList<Jugador> ejecutar(Jugador player1,Jugador player2) {
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        arrayList.add(player1);
        arrayList.add(player2);
        return arrayList;
    }
}
