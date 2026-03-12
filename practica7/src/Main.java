import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.services.GestionMundo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DatoInvalidoException, RecursoNoEncontradoException {
        GestionMundo g = new GestionMundo();
        g.crearPJ();
        g.informeFinal();
    }
}