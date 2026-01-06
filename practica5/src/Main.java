import com.juego.modelo.Personaje;
import com.juego.modelo.GestorPersonajes;

public class Main {
    public static void main(String [] args) {
        GestorPersonajes gestor = new GestorPersonajes();


        Personaje pj1 = gestor.crearpj();
        Personaje pj2 = gestor.crearpj();


    }
}
