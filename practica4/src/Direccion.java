public class Direccion {
    //Atributos
    private String Calle;
    private Integer Numero;
    private Integer Codigo_Postal;
    private String Localidad;
    private String Provincia;


    //Contructor:
    public Direccion(String Calle, Integer Numero, Integer Codigo_Postal, String Localidad, String Provincia) {
        this.Calle = Calle;
        this.Numero = Numero;
        this.Codigo_Postal = Codigo_Postal;
        this.Localidad = Localidad;
        this.Provincia = Provincia;
    }

}
