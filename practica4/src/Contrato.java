public class Contrato {

    //Atributos
    private int FechaDeCreacion;
    private Medico medico;
    private Hospital hospital;

    //Constructor
    public Contrato(int FechaDeCreacion, Medico medico, Hospital hospital) {
        this.FechaDeCreacion = FechaDeCreacion;
        this.medico = medico;
        this.hospital = hospital;
    }

    //Metodo get / set

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public void setFechaDeCreacion(int fechaDeCreacion) {
        FechaDeCreacion = fechaDeCreacion;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    //Comprobación de Año
    public boolean esDeAnio(int anio) {
        boolean coincide = false;
        if (this.FechaDeCreacion == anio) {
            coincide = true;
            return coincide;
        }
        return coincide;
    }

    //Cálculo de Vigencia
    public int diasDesdeCreacion (int fechahoy) {
        int dias = 365 * (fechahoy - this.FechaDeCreacion);
        return dias;
    }
}
