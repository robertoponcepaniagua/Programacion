public class Contrato {

    //Atributos
    private Integer esDeAnio;
    private Integer diasDesdeCreacion;

    //Constructor
    public Contrato(Integer esDeAnio, Integer diasDesdeCreacion) {
        this.esDeAnio = esDeAnio;
        this.diasDesdeCreacion = diasDesdeCreacion;
    }

    //Metodo get / set

    //Dias Desde Creación
    public Integer getDiasDesdeCreacion() {
        return diasDesdeCreacion;
    }
    public void setDiasDesdeCreacion(Integer nuevodiasDesdeCreacion) {
        this.diasDesdeCreacion = nuevodiasDesdeCreacion;
    }

    //Es De Año
    public Integer getEsDeAnio() {
        return esDeAnio;
    }
    public void setEsDeAnio(Integer nuevoesDeAnio) {
        this.esDeAnio = nuevoesDeAnio;
    }
}
