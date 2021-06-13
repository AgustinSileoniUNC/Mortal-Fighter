import java.util.ArrayList;

public class Atacar implements Accion{
    
    //Esta implementado para el jugador 1, deberia ver como hacerlo para los dos. Mi idea es poner golpeador y golpeado y dependiendo del boron el orden en el que los coloco
    public ArrayList<Jugador> ejecutar(Jugador golpeador, Jugador golpeado){
        ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
        golpeador.x+=1;
        if(golpeador.verificarColision(golpeado)){
            golpeado.recibirGolpe(10);
        }
        golpeador.x -=1;

        arrayList.add(golpeador);
        arrayList.add(golpeado);
            return arrayList;
    }

}
