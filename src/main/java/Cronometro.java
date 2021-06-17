import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Cronometro extends Thread{

    int tiempo =60;
    Text text;
    boolean condicion = true;

    public Cronometro(Text text){
        this.text = text;
    }
    @Override
    public void run( ) {
        while (condicion){
            tiempo--;
            try {
                Thread.sleep(1000);
                text.setText(""+tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void frenar(){
        condicion = false;
        reiniciar();
    }

    public void reiniciar(){
        tiempo = 65;
        condicion = true;}
}
