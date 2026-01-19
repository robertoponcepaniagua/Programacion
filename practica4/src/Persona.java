public class Persona {
    private String DNI;
    private String Nombre;
    private Integer Edad;
    private String Sexo;

    public Persona(String DNI, String nombre, Integer edad, String sexo) {
        this.DNI = DNI;
        Nombre = Nombre;
        Edad = Edad;
        Sexo = Sexo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }
}
