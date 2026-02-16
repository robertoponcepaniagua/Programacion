import java.util.ArrayList;

public class Tesoreria {
    //atr
    private ArrayList<Catalogo> paqueteMezclado;

    public Tesoreria(ArrayList<Catalogo> paqueteMezclado) {
        this.paqueteMezclado = new ArrayList<>();
    }

    public ArrayList<Catalogo> getPaqueteMezclado() {
        return paqueteMezclado;
    }

    public void setPaqueteMezclado(ArrayList<Catalogo> paqueteMezclado) {
        this.paqueteMezclado = paqueteMezclado;
    }

    public double calcularTotalPagar() {
        return 0.0;
    }
}
