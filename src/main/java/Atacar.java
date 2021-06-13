import java.util.ArrayList;

public class Atacar implements Accion{

    public ArrayList<Jugador> ejecutar(Jugador player1, Jugador player2){
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        player1.x+=10;
        if(player1.verificarColision(player2)){
            player2.recibirGolpe(10);
        }
        player1.x -=10;

        arrayList.add(player1);
        arrayList.add(player2);
            return arrayList;
    }

}
