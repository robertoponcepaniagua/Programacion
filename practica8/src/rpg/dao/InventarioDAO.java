package rpg.dao;

import rpg.exception.RPGException;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {
    private Log log;
    private ConexionBD conexionBD;


    public InventarioDAO() {
        this.log = new Log("practica8/src/rpg/dao/InventarioDAO.java");
        this.conexionBD = new ConexionBD();
    }


    /*
    public boolean crearInventarioVacio(int idPersonaje) {
        String sql = "INSERT INTO Inventarios (id_personaje, id_item, cantidad) VALUES (?, NULL, 0)";
        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPersonaje);
            log.escribirFichero("INFO", "Se ha creado un inventario vacío para el PJ: " + idPersonaje);
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "No se ha podido crear el inventario vacío: " + e.getMessage());
            throw new RuntimeException("No se ha podido crear el inventario vacío: " + e.getMessage());
        }
    } */

    public boolean añadirItem(Personaje pj, Item item) {
        String sql = "INSERT INTO Inventarios (id_personaje, id_item, cantidad) VALUES (?, ?, 1)"; //INSERTA UN NUEVO SITIO AL INVENTARIO

        try (Connection con = conexionBD.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, pj.getId());
            ps.setInt(2, item.getId());


            log.escribirFichero("INFO","Se ha añadido el item correctamentre PJ: " + pj.getId() + " Item: " +item.getId());
            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se ha podido añadir el item " + e.getMessage());
            throw new RuntimeException("No se ha podido añadir el item " + e.getMessage());
        }
    }

    public List<Item> listarItemsPersonaje(int idPJ) {
        String sql = "SELECT i.id, i.nombre, i.tipo, i.precio_oro, i.bonificador_ataque, i.bonificador_defensa " +
                "FROM Items i JOIN Inventarios inv ON i.id = inv.id_item " +
                "WHERE inv.id_personaje = ?";

        List<Item> itemsPersonaje = new ArrayList<>();

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,idPJ);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("precio_oro"),
                        rs.getInt("bonificador_ataque"),
                        rs.getInt("bonificador_defensa")
                );
                itemsPersonaje.add(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return itemsPersonaje;
    }
}
