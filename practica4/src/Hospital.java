import java.util.List;

public class Hospital {
    //Atributos
    private String Nombre;
    private String CIF;
    private List<Area> Areas;
    private Direccion Direccion;

    //Constructor
    public Hospital(String Nombre, String CIF) {
        this.Nombre = Nombre;
        this.CIF = CIF;
        this.Areas = Areas;

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
}
