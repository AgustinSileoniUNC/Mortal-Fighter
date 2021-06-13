public class Estadistica {
    public int golpesRealizados=0;
    public int golpesAcertados =0;

    public void golpe(boolean acertado){
        golpesRealizados ++;
        if(acertado){
            golpesAcertados++;
        }
    }

    public int getGolpesRealizados(){
        return golpesRealizados;
    }
    public int porcentajeGolpesAcertados(){
        if(golpesRealizados>0){
            return golpesAcertados/golpesRealizados;
        }
        return 0;
    }


}
