import java.util.ArrayList;

public class Podcast extends Tesoreria{
    private String nombre;
    private boolean gratuito;
    public Podcast(ArrayList<Catalogo> paqueteMezclado, String nombre, boolean gratuito) {
        super(paqueteMezclado);
        this.nombre = nombre;
        this.gratuito = gratuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public boolean EsMoneizable() {
        if (!gratuito) {
            return true;
        } else {
            return false;
        }
    }
}
