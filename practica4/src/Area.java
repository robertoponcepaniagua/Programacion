public class Area {
    private String Nombre;
    private String Identificador;
    private Integer Planta;
    private Hospital Hospital;
    private Integer numMedicos;



    //Constructor
    public Area(String Nombre, String Identificador, Integer Planta, Hospital Hospital) {
        this.Nombre = Nombre;
        this.Identificador = Identificador;
        this.Planta = Planta;
        this.Hospital = Hospital;
        this.numMedicos = 0;
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
    public void decrementarmedicos() {
        if (this.numMedicos > 0) {
            numMedicos--;
        }
    }

    //Comprobación y Comparación médicos y areas, cómo tiene que devolver un texto he puesto String en vez de poner void
    public String compararMedicos(Area otraArea) {
        if (this.numMedicos > otraArea.getNumMedicos()) { //comparo de las 2 areas, cual tiene más médicos
            return "El Area "+ this.Nombre +" es mayor que el Area "+ otraArea.getNombre();  //devuelvo cual tiene más medicos
        } else {
            return "El Area "+ otraArea.getNombre() +" es mayor que el Area "+ this.Nombre;  //devuelvo cual tiene más medicos
        }
    }

    //Calculo de Capacidad
    public String calcularCapacidadRestante(int capacidadMaxima) {
        if (this.numMedicos <= capacidadMaxima) {
            int i = capacidadMaxima-this.numMedicos; //resto la capmax - el numMedicos
            return "Faltan "+i;
        }
        int j = this.numMedicos-capacidadMaxima; // resto el numMedicos - capmax
        return "Sobran "+ j +" medicos";
    }
}