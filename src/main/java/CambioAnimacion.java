public class CambioAnimacion extends Thread{

    Jugador jugador;
    Escenario escenario;
    public CambioAnimacion (Jugador jugador,Escenario escenario){
        this.jugador = jugador;
        this.escenario = escenario;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(400);
            if(jugador.orientacion){
                jugador.setNombreImagen("StanceR");
            }
            else if(!jugador.orientacion){
                jugador.setNombreImagen("Stance");
            }

            jugador.accionDisponible = true;
            jugador.ejecutoAccion = false;
            escenario.notificar();
        } catch (InterruptedException e) {
        }

    }
}
