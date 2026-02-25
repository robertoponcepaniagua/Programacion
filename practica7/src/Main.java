import com.rpg.model.Ciudad;
import com.rpg.utils.TxtHelper;

import java.io.IOException;

public class Main {
    public void main(String[] args) throws IOException {
        TxtHelper txtHelper = new TxtHelper();

        txtHelper.leerLineas();

        Ciudad c = new Ciudad("Barcelona", 2344534, "Soleado", 10);

        txtHelper.escribirFichero(c);
    }
}