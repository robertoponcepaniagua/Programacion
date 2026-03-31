package rpg.dao;

import rpg.model.Ciudades;
import rpg.model.Clases_RPG;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    private Log log;
    private ConexionBD conexionBD;
    public CiudadDAO() {
        this.conexionBD = new ConexionBD();
        this.log = new Log("practica8/src/rpg/dao/CiudadDAO.java");
    }

    //PROBAR
    public List<Ciudades> listarCiudades() {
        String sql = "SELECT * FROM Ciudades";
        // LISTA PARA AÑADIR A LAS CIDUADES
        List<Ciudades> ciudadesList = new ArrayList<>();
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // MIENTRAS QUE HAYA FILA
                //int id, String nombre, int nivel_minimo_acceso
                Ciudades claseRpg = new Ciudades(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel_minimo_acceso")
                );
                // AÑADIMOS LAS CLASES A LA LISTA
                ciudadesList.add(claseRpg);
                log.escribirFichero("INFO","El metodo listarCiudades se ha ejecutado");
            }
            return ciudadesList;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarCiudades ha fallado" + e.getMessage());
            throw new RuntimeException("El metodo listarCiudades ha fallado" + e.getMessage());
        }
    }
}
