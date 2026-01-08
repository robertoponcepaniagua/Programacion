import com.juego.modelo.Personaje;
import com.juego.modelo.GestorPersonajes;
import com.juego.presentacion.Vista;

public class Main {
    public static void main(String [] args) {
        GestorPersonajes gestor = new GestorPersonajes();


        Personaje pj1 = gestor.crearpj();
        Personaje pj2 = gestor.crearpj();

        Vista vistapj = new Vista();
        vistapj.elegirHabilidad(pj1);
    }
}
