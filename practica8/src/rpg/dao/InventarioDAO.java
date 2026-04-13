package rpg.dao;

import rpg.exception.RPGException;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventarioDAO {
    private Log log;
    private ConexionBD conexionBD;


    public InventarioDAO() {
        this.log = new Log("practica8/src/rpg/dao/InventarioDAO.java");
        this.conexionBD = new ConexionBD();
    }


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
    }

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
}
