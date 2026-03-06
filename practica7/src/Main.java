import com.rpg.handler.DatoInvalidoException;
import com.rpg.model.Ciudad;
import com.rpg.services.GestionMundo;
import com.rpg.utils.TxtHelper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DatoInvalidoException {
        GestionMundo g = new GestionMundo();
        g.crearPJ();
        g.informeFinal();
    }
}