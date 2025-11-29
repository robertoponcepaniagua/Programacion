import java.util.ArrayList;

public class Hospital {
    //Atributos
    private String Nombre;
    private String CIF;
    private Direccion Direccion;
    private ArrayList<Area> Areas;

    //Constructor
    public Hospital(String Nombre, String CIF, Direccion Direccion) {
        this.Nombre = Nombre;
        this.CIF = CIF;
        this.Direccion = Direccion;
        this.Areas = new ArrayList<>(); //Creamos el ArrayList Areas en el constructor
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

    //Conseguir el número total de médicos
    public int  getNumeroTotalMedicos() {
        int total = 0;
        for (int i = 0; i < Areas.size(); i++) { //Areas.size() numero de elementos que hay en el ArrayList
            Area AreaActual = Areas.get(i);
            total += AreaActual.getNumMedicos();
        }
        return total;
    }

    //Cálculo de Proporción
    public double getProporcionMedicosArea(String idArea) {
        double proporcion = 0;
        for (int i = 0; i < Areas.size(); i++) {
            Area AreaActual = Areas.get(i);
            if (AreaActual.getIdentificador().equals(idArea)) {
                proporcion = (double) AreaActual.getNumMedicos() / getNumeroTotalMedicos();
            }
        }
        return proporcion;
    }


    //Comprobación de Existencia
    public boolean existeArea(String idArea) {
        boolean existe = false;
        for (int i = 0; i < Areas.size() ; i++) {
            Area AreaActual = Areas.get(i);
            if (AreaActual.getIdentificador().equals(idArea)) {
                existe = true;
                return existe;
            }
        }
        return existe;
    }

    public void agregarArea(Area a) {
        this.Areas.add(a);
    }

}
