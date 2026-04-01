package rpg.dao;

import rpg.model.Clases_RPG;
import rpg.model.Item;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Log log;
    private ConexionBD conexionBD;

    public ItemDAO() {
        this.log = new Log("practica8/src/rpg/dao/ItemDAO.java");
        this.conexionBD = new ConexionBD();
    }


    //FUNCIONA
    public List<Item> listarItems() {
        String sql = "SELECT * FROM Items";
        // LISTA PARA AÑADIR A LAS Clases
        List<Item> itemList = new ArrayList<>();
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // MIENTRAS QUE HAYA FILA
                //String nombre, String tipo, int precio_oro, int bonificador_ataque, int bonificador_defensa
                Item item = new Item(
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("precio_oro"),
                        rs.getInt("bonificador_ataque"),
                        rs.getInt("bonificador_defensa")
                        );
                // AÑADIMOS LOS ITEMS A LA LISTA
                itemList.add(item);
                log.escribirFichero("INFO","El metodo listarItems se ha ejecutado");
            }
            return itemList;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarItems ha fallado" + e.getMessage());
            throw new RuntimeException("El metodo listarItems ha fallado" + e.getMessage());
        }
    }
}
