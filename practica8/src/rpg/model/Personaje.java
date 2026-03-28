package rpg.model;

public class Personaje {
    private int id; //PK
    private String nombre;
    private int nivel;
    private int salud;
    private int oro;
    private int idRaza; //FK
    private int idClase; //FK
    private int idCiudadActual;

    public Personaje(String nombre, int nivel, int salud, int oro, int idRaza, int idClase, int idCiudadActual) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.oro = oro;
        this.idRaza = idRaza;
        this.idClase = idClase;
        this.idCiudadActual = idCiudadActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public int getIdCiudadActual() {
        return idCiudadActual;
    }

    public void setIdCiudadActual(int idCiudadActual) {
        this.idCiudadActual = idCiudadActual;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                ", oro=" + oro +
                ", idRaza=" + idRaza +
                ", idClase=" + idClase +
                ", idCiudadActual=" + idCiudadActual +
                '}';
    }
}