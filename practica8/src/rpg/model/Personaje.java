package rpg.model;

import rpg.exception.NivelInvalidoException;
import rpg.utils.Log;

public class Personaje {
    private Log logger = new Log("");

    private int id; //PK
    private String nombre;
    private int nivel;
    private int saludMax;
    private int salud;
    private int oro;
    private int idRaza; //FK
    private int idClase; //FK
    private int idCiudadActual; //FK

    public Personaje(String nombre, int nivel, int salud, int oro, int idRaza, int idClase, int idCiudadActual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.saludMax = saludMax;
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

    public int getSaludMax() {
        return saludMax;
    }

    public void setSaludMax(int saludMax) {
        this.saludMax = saludMax;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", saludMax=" + saludMax +
                ", salud=" + salud +
                ", oro=" + oro +
                ", idRaza=" + idRaza +
                ", idClase=" + idClase +
                ", idCiudadActual=" + idCiudadActual +
                '}';
    }

    public void subirNivel() throws NivelInvalidoException {
        this.nivel++;
        this.oro += 100;
        this.saludMax = this.saludMax + 10;
        this.salud = this.saludMax;
    }

    public void aplicarBonificaciones(Raza raza) {
        this.saludMax = this.saludMax + raza.getBonificadorVida();
        this.salud = this.saludMax;
    }

    public void checkParametros() {
        // TODO: CHECKEO DE PARAMETORS EJ: NIVEL < 0
    }

    // TODO: TENGO QUE APLICARLE LAS BONIFICACIONES DE LOS OBJETOS / INVENTARIO
}