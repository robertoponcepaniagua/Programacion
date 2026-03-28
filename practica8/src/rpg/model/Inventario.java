package rpg.model;

public class Inventario {
    private int id_personaje;
    private int id_item;
    private int cantidad;

    public Inventario(int id_personaje, int id_item, int cantidad) {
        this.id_personaje = id_personaje;
        this.id_item = id_item;
        this.cantidad = cantidad;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
