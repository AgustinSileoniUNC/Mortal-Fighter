import java.util.ArrayList;

public class Desplazar implements Accion{

    public Desplazar(){

    }

    //No se como hacerlo para que reconozca cuando mover al player2
    @Override
    public ArrayList<Jugador> ejecutar(Jugador player1, Jugador player2) {
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        arrayList.add(player1);
        arrayList.add(player2);
        if( !arrayList.get(0).verificarColision(arrayList.get(1))){
            System.out.println(arrayList.get(0).verificarColision(arrayList.get(1)));
            arrayList.get(0).x ++;
        }
        return arrayList;
    }

}
