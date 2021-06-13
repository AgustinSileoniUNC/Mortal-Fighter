import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ControladorInput implements EventHandler<KeyEvent> {

    Escenario escenario;
    boolean bool = true;
    public ControladorInput(Escenario escenario){
        this.escenario = escenario;
    }


    @Override
    public void handle(KeyEvent evento) {
        //System.out.println(evento.getCode());
        switch (evento.getCode()){
            case RIGHT:
                //Para que no se mueva si tiene la tecla apretada
                if(bool){
                    enviarMoviminto(new Desplazar());
                    //bool =false;
                }
                break;
            case LEFT:
                if(bool){
                    escenario.jugadores.get(0).x -= 1;
                    bool =false;
                }
                break;
            case UP:
                //Crear saltar
                break;
            case NUMPAD0:
                if(bool){
                    enviarMoviminto(new Atacar());
                }
                break;
        }
    }


    public void enviarMoviminto(Accion accion){
        escenario.ejecutarAccion(accion);
    }
}
