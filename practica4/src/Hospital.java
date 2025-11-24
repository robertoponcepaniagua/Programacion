import java.util.ArrayList;

public class Hospital {
    //Atributos
    private String Nombre;
    private String CIF;
    private ArrayList<Area> Areas;
    private Direccion Direccion;

    //Constructor
    public Hospital(String Nombre, String CIF, ArrayList<Area> Areas, Direccion Direccion) {
        this.Nombre = Nombre;
        this.CIF = CIF;
        this.Areas = new ArrayList<>(); //Creamos el ArrayList Areas en el constructor
        this.Direccion = Direccion;
    }


    //Metodo get / set

    //Nombre
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String NuevoNombre) {
        this.Nombre = NuevoNombre;
    }

    //CIF
    public String getCIF() {
        return CIF;
    }
    public void setCIF(String NuevoCIF) {
        this.CIF = NuevoCIF;
    }

    //Areas
    public ArrayList<Area> getAreas() {
        return Areas;
    }
    public void setAreas(ArrayList<Area> areas) {
        Areas = areas;
    }

    //Dirección
    public Direccion getDireccion() {
        return Direccion;
    }
    public void setDireccion(Direccion direccion) {
        Direccion = direccion;
    }
}
