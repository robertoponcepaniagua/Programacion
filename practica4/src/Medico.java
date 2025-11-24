import java.time.LocalDate;
import java.util.Scanner;

public class Medico {

    //Atributos
    private String DNI;
    private String Nombre;
    private Integer Edad;
    private String Sexo;
    private double Sueldo_Bruto;
    private Integer Fecha_de_inicio;
    private Area area;

    //Constructor
    public Medico(String DNI, String Nombre, Integer Edad, String Sexo, Double Sueldo_Bruto, Integer Fecha_de_inicio, Area area) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Sueldo_Bruto = Sueldo_Bruto;
        this.Fecha_de_inicio = Fecha_de_inicio;
        this.area = area;
    }

    //Motodos Get/Set

    //DNI
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //Nombre
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Edad
    public Integer getEdad() {
        return Edad;
    }
    public void setEdad(Integer edad) {
        Edad = edad;
    }

    //Sexo
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    //Sueldo Bruto
    public double getSueldo_Bruto() {
        return Sueldo_Bruto;
    }
    public void setSueldo_Bruto(double sueldo_Bruto) {
        Sueldo_Bruto = sueldo_Bruto;
    }

    //Fecha de Inicio
    public Integer getFecha_de_inicio() {
        return Fecha_de_inicio;
    }
    public void setFecha_de_inicio(Integer fecha_de_inicio) {
        Fecha_de_inicio = fecha_de_inicio;
    }

    //Area
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }


    //Metodos Sueldo neto
    public double calcularSueldoNeto(double retencion) {
        double SueldoNeto = this.Sueldo_Bruto * (retencion/100);
        return SueldoNeto;
    }

    //Fechas de Antiguedad
    public int getAniosAntiguedad() {
        int antiguedad = 2025 - getFecha_de_inicio();
        return antiguedad;
    }

    //Calcular Impuestos Anuales
    public int calcularImpuestosAnuales(double tasaImpositiva) {
        return Sueldo_Bruto * tasaImpositiva;
    }

    //Mayor de Edad ? Si es mayor de edad o sea (Edad >= MayoriaDeEdad)
    public boolean esMayorDeEdad (int MayoriaDeEdad) {
        return MayoriaDeEdad >= 18;
    }

    public double proximoAumento (double porcentajeAumento, int aniosRequeridos) {

    }
}
