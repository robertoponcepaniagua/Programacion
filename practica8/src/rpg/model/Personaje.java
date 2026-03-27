package rpg.model;

public class Personaje {
    private int id;
    private String nombre;
    private int nivel;
    private int salud;
    private int oro;

    public Personaje() {}

    public Personaje(String nombre, int nivel, int salud, int oro) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
        this.oro = oro;
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

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                ", oro=" + oro +
                '}';
    }
}