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

    //metodo Get / set

    //Calle
    public String getCalle() {
        return Calle;
    }
    public void setCalle(String calle) {
        Calle = calle;
    }

    //Codigo Postal
    public Integer getCodigo_Postal() {
        return Codigo_Postal;
    }
    public void setCodigo_Postal(Integer codigo_Postal) {
        Codigo_Postal = codigo_Postal;
    }

    //Numero
    public Integer getNumero() {
        return Numero;
    }
    public void setNumero(Integer numero) {
        Numero = numero;
    }

    //Localidad
    public String getLocalidad() {
        return Localidad;
    }
    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    //Provincia
    public String getProvincia() {
        return Provincia;
    }
    public void setProvincia(String provincia) {
        Provincia = provincia;
    }
}
