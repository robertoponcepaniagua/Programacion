import com.juego.modelo.Combate;
import com.juego.modelo.Personaje;
import com.juego.modelo.GestorPersonajes;
import com.juego.modelo.PrecargaDatos;
import com.juego.presentacion.Vista;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        GestorPersonajes gestor = new GestorPersonajes();


        Personaje pj1 = gestor.crearpj();
        System.out.println();

        // PRUEBA DE VIDA, HAY QUE PROBAR LAS CURAS
        pj1.corazones();
        System.out.println();
        pj1.setVida(45);
        pj1.corazones();
    }
}
