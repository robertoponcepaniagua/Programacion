import com.juego.modelo.Combate;
import com.juego.modelo.Personaje;
import com.juego.modelo.GestorPersonajes;
import com.juego.presentacion.Vista;

public class Main {
    public static void main(String [] args) {
        GestorPersonajes gestor = new GestorPersonajes();


        Personaje pj1 = gestor.crearpj();
        System.out.println();
    }
}
