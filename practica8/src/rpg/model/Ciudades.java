package rpg.model;

public class Ciudades {
    private int id;
    private String nombre;
    private int nombre_minimo_acceso;

    public Ciudades(int id, String nombre, int nombre_minimo_acceso) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_minimo_acceso = nombre_minimo_acceso;
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

    public int getNombre_minimo_acceso() {
        return nombre_minimo_acceso;
    }

    public void setNombre_minimo_acceso(int nombre_minimo_acceso) {
        this.nombre_minimo_acceso = nombre_minimo_acceso;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " | Nivel minimo: " + nombre_minimo_acceso;
    }
}
