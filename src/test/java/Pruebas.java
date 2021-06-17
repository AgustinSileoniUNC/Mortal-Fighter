import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Pruebas {


    // TU-001
    @Test
    @DisplayName("Prueba desplazar derecha jugador 1")
    void pruebaDesplazarDerecha1() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(500,0);
        DesplazarDerecha d = new DesplazarDerecha(0);
        Assertions.assertEquals(10, d.ejecutar(j1,j2).get(0).getX());
    }

    @Test
    @DisplayName("Prueba desplazar derecha jugador 2")
    void pruebaDesplazarDerecha2() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(500,0);
        DesplazarDerecha d = new DesplazarDerecha(1);
        Assertions.assertEquals(510, d.ejecutar(j1,j2).get(1).getX());
    }

    @Test
    @DisplayName("Prueba desplazar derecha ilegal jugador 1")
    void pruebaDesplazarDerechaIlegal1() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(99,0);
        DesplazarDerecha d = new DesplazarDerecha(0);
        Assertions.assertEquals(0,d.ejecutar(j1,j2).get(0).getX());
    }

    @Test
    @DisplayName("Prueba desplazar derecha ilegal jugador 2")
    void pruebaDesplazarDerechaIlegal2() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(521,0);
        DesplazarDerecha d = new DesplazarDerecha(1);
        Assertions.assertEquals(531,d.ejecutar(j1,j2).get(1).getX());
    }

    // TU-002
    @Test
    @DisplayName("Prueba desplazar izquierda jugador 1")
    void pruebaDesplazarIzquierda1() {
        Jugador j1 = new Jugador(100,0);
        Jugador j2 = new Jugador(500,0);
        DesplazarIzquierda a = new DesplazarIzquierda(0);
        Assertions.assertEquals(90, a.ejecutar(j1,j2).get(0).getX());
    }

    @Test
    @DisplayName("Prueba desplazar izquierda jugador 2")
    void pruebaDesplazarIzquierda2() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(500,0);
        DesplazarIzquierda a = new DesplazarIzquierda(1);
        Assertions.assertEquals(490, a.ejecutar(j1,j2).get(1).getX());
    }

    @Test
    @DisplayName("Prueba desplazar izquierda ilegal jugador 1")
    void pruebaDesplazarIzquierdaIlegal1() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(100,0);
        DesplazarIzquierda a = new DesplazarIzquierda(0);
        Assertions.assertEquals(0,a.ejecutar(j1,j2).get(0).getX());
    }

    @Test
    @DisplayName("Prueba desplazar izquierda ilegal jugador 2")
    void pruebaDesplazarIzquierdaIlegal2() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(99,0);
        DesplazarIzquierda a = new DesplazarIzquierda(1);
        Assertions.assertEquals(99,a.ejecutar(j1,j2).get(1).getX());
    }

    /*    @Test
          @Saltar
    void pruebaDesplazarSaltar() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(100,0);
        Saltar saltar = new Saltar(0);

        e.ejecutarAccion(d);

        Assertions.assertEquals(200, e.jugadores.get(0).getY());
    }
*/
    // Falta Saltar (TU-003)


    // TU-004
    @Test
    @DisplayName("Prueba ataque efectivo")

    void pruebaAtacar() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(100,0);
        Atacar a = new Atacar(0);

        a.ejecutar(j1, j2);
        Assertions.assertEquals(90, j2.vida);
    }
    @Test
    @DisplayName("Prueba ataque no efectivo")
    void pruebaAtacar2() {
        Jugador j1 = new Jugador(0,0);
        Jugador j2 = new Jugador(200,0);
        Atacar a = new Atacar(0);

        a.ejecutar(j1, j2);
        Assertions.assertEquals(100.0, j2.vida);
    }

    // TU-005

    @Test
    @DisplayName("Prueba ingreso ilegal de nombre")
    void name() {
        Ventana vent = new Ventana();

        String str = "Juan1!";
        Assertions.assertEquals(false, vent.corroborarNombre(str));
        str = "Federico";
        Assertions.assertEquals(false, vent.corroborarNombre(str));
    }

    @Test
    @DisplayName("Prueba ingreso de nombre")
    void nametest() {
        Ventana vent = new Ventana();
        String str = "Juan";
        Assertions.assertEquals(true, vent.corroborarNombre(str));
        str = "1234";
        Assertions.assertEquals(true, vent.corroborarNombre(str));
        str = "Juan12";
        Assertions.assertEquals(true, vent.corroborarNombre(str));
    }
}

