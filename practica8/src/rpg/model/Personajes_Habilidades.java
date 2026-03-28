package rpg.model;

public class Personajes_Habilidades {
    private int id_personaje;
    private int id_habilidad;

    public Personajes_Habilidades(int id_personaje, int id_habilidad) {
        this.id_personaje = id_personaje;
        this.id_habilidad = id_habilidad;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
    }
}
