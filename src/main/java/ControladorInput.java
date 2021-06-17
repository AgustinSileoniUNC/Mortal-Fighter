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
                    enviarMovimiento(new DesplazarDerecha(1));
                     bool =false;
                }
                break;
            case LEFT:
                if(bool){
                    enviarMovimiento(new DesplazarIzquierda(1));
                     bool =false;
                }
                break;
            case UP:
                //Crear saltar
                break;
            case NUMPAD0:
                if(bool){
                    enviarMovimiento(new Atacar(1));
                }
                break;
            case D:
                //Para que no se mueva si tiene la tecla apretada
                if(bool){
                    enviarMovimiento(new DesplazarDerecha(0));
                     bool =false;
                }
                break;
            case A:
                if(bool){
                    enviarMovimiento(new DesplazarIzquierda(0));
                     bool =false;
                }
                break;
            case W:
                //Crear saltar
                break;
            case SPACE:
                if(bool){
                    enviarMovimiento(new Atacar(0));
                }
                break;
        }
    }


    public void enviarMovimiento(Accion accion){
        escenario.ejecutarAccion(accion);
    }
}
