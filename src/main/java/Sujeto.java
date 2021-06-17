import java.util.ArrayList;

public interface Sujeto {

    public void agregarObservador(Observador observador);
    public void quitarObservador(Observador observador);
    public void notificar();

}
