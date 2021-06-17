import java.util.Timer;
import java.util.TimerTask;


public class Temporizador {

    private TimerTask timerTask;
    private Timer timer;
    public Boolean expiro;

    public Temporizador() {

        timerTask = new TimerTask() {

            @Override
            public void run() {
                expiro = true;
                System.out.println("Termino");
            }
        };

        timer = new Timer("Temporizador");
    }

    public void iniciarTemporizacion() {

        timer.schedule(timerTask, 60000);
        expiro = false;
    }

    public TimerTask getTimerTask() {
        return timerTask;
    }
}

