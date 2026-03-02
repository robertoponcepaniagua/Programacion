import com.rpg.handler.DatoInvalidoException;
import com.rpg.model.Ciudad;
import com.rpg.services.GestionMundo;
import com.rpg.utils.TxtHelper;

import java.io.IOException;

public class Main {
    public void main(String[] args) throws IOException, DatoInvalidoException {
        TxtHelper txtHelper = new TxtHelper();
        GestionMundo g = new GestionMundo();

        g.crearPJ();
    }
}