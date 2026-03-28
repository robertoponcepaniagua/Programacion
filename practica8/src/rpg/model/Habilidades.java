package rpg.model;

public class Habilidades {
    private int id;
    private String nombre;
    private int daño_base;
    private int usos_maximos;
    private int id_clase;

    public Habilidades(int id, String nombre, int daño_base, int usos_maximos, int id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.daño_base = daño_base;
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

    public int getDaño_base() {
        return daño_base;
    }

    public void setDaño_base(int daño_base) {
        this.daño_base = daño_base;
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
}
