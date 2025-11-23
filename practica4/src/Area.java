public class Area {
    private String Nombre;
    private String Identificador;
    private Integer Planta;
    private Hospital Hospital;
    private Integer numMedicos;



    //Constructor
    public Area(String Nombre, String Identificador, Integer Planta, Hospital Hospital, Integer numMedicos) {
        this.Nombre = Nombre;
        this.Identificador = Identificador;
        this.Planta = Planta;
        this.Hospital = Hospital;
        this.numMedicos = numMedicos;
    }


    //Metodo get / set

    //Nombre
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String NuevoNombre) {
        this.Nombre = NuevoNombre;
    }

    //Identificador
    public String getIdentificador() {
        return Identificador;
    }
    public void setIdentificador(String NuevoIdentificador) {
        this.Identificador = NuevoIdentificador;
    }

    //Planta
    public Integer getPlanta() {
        return Planta;
    }
    public void setPlanta(Integer NuevaPlanta) {
        this.Planta = NuevaPlanta;
    }

    //Hospital
    public Hospital getHospital() {
        return Hospital;
    }
    public void setHospital(Hospital NuevoHospital) {
        this.Hospital = NuevoHospital;
    }

    //Medicos
    public Integer getNumMedicos() {
        return numMedicos;
    }
    public void setNumMedicos(Integer numMedicos) {
        this.numMedicos = numMedicos;
    }
    public void incrementarmedicos() {
        this.numMedicos++;
    }
}