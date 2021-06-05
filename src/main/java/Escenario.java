import Modelo.Movimiento;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Escenario {

    ArrayList<Personaje> personajes = new ArrayList<>();

    public Escenario(Personaje personaje1,Personaje personaje2){
        personajes.add(personaje1);
        personajes.add(personaje2);
    }

    public void ejecutarAccion(Movimiento movimiento) {
        movimiento.move();//Pasar los personajes almacenados en un array y debe devolver el array y sobreescribirlo
    }

    public void noMoverPaleta(){
        for(Personaje personaje: personajes){
            personaje.noMover();
        }
    }


}

