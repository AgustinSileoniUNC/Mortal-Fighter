public class Estadistica {
    public float golpesRealizados = 0;
    public float golpesAcertados = 0;

    public Estadistica(){}

    public void golpe(boolean acertado){
        golpesRealizados ++;
        if(acertado){
            golpesAcertados++;
        }
    }

    public int getGolpesRealizados(){
        return (int) golpesRealizados;
    }

    public int PorcentajeGolpesAcertados(){
        if(golpesRealizados>0){
            return (int) ((golpesAcertados/golpesRealizados)*100);
        }
        return 0;
    }

    public void reiniciar(){golpesRealizados=0;golpesAcertados=0;}

}
