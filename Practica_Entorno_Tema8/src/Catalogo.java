import java.util.ArrayList;

public class Catalogo {
    //atr
    private String nombre;
    public Catalogo(String nombre) {
        this.nombre = nombre;
    }

    public void ObservarContenido(Tesoreria tesoreria) {
        for (int i = 0; i < tesoreria.getPaqueteMezclado().size(); i++) {
            System.out.println(tesoreria.getPaqueteMezclado().get(i));
        }
    }
}
