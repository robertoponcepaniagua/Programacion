package rpg.model;

public class Habilidades {
    private int id;
    private String nombre;
    private int dano_base;
    private int usos_maximos;
    private int id_clase;

    public Habilidades(int id, String nombre, int dano_base, int usos_maximos, int id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.dano_base = dano_base;
        this.usos_maximos = usos_maximos;
        this.id_clase = id_clase;
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

    public int getDano_base() {
        return dano_base;
    }

    public void setDano_base(int daño_base) {
        this.dano_base = dano_base;
    }

    public int getUsos_maximos() {
        return usos_maximos;
    }

    public void setUsos_maximos(int usos_maximos) {
        this.usos_maximos = usos_maximos;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    @Override
    public String toString() {
        return "[ID: " + id + "] » " + nombre + " | Daño: " + dano_base + " | Usos: " + usos_maximos;
    }
}
