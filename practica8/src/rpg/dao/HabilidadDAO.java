package rpg.dao;

import rpg.exception.RPGException;
import rpg.model.Habilidades;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO {
    private Log log;
    private ConexionBD conexionBD;

    public HabilidadDAO() {
        this.log = new Log("practica8/src/rpg/dao/HabilidadDAO.java");
        this.conexionBD = new ConexionBD();
    }

    public List<Habilidades> listarHabilidades() {
        String sql = "SELECT * FROM HABILIDADES";

        List<Habilidades> habilidadesList = new ArrayList<>();

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // int id, String nombre, int dano_base, int usos_maximos, int id_clase
                Habilidades habilidad = new Habilidades(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("dano_base"),
                        rs.getInt("usos_maximos"),
                        rs.getInt("id_clase")
                );
                habilidadesList.add(habilidad);
                log.escribirFichero("INFO","El metodo listarHabilidades se ha ejecutado");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("INFO","El metodo listarHabilidades ha fallado" + e.getMessage());
            throw new RuntimeException("El metodo listarHabilidades ha fallado" + e.getMessage());
        }
        return habilidadesList;
    }


    public List<Habilidades> listarHabilidadesPersonaje(int idPersonaje) throws RPGException {
        String sql = "SELECT * " +
                "FROM Habilidades h " +
                "JOIN Clases_RPG c ON h.id_clase = c.id " +
                "JOIN Personajes p ON p.id_clase = c.id " +
                "WHERE p.id = ?";
        List<Habilidades> habilidadesList = new ArrayList<>();

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // EL ID DEL PERSONAJE QUE QUERAMOS VER LAS HABILIDADES EQUIPADAS Y NO EQUIPADAS
            ps.setInt(1,idPersonaje);

            // DESPUÉS DE PONER EL ID DEL PERSONAJE EJECUTAMOS LA QUERY
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    //int id, String nombre, int dano_base, int usos_maximos, int id_clase
                    Habilidades habilidades = new Habilidades(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("dano_base"),
                            rs.getInt("usos_maximos"),
                            rs.getInt("id_clase")
                    );
                    habilidadesList.add(habilidades);
                }
            }
            log.escribirFichero("INFO","Habilidades obtenidas del personaje" + idPersonaje);

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se han podido obtener las habilidades de " + idPersonaje + " " + e.getMessage());
            throw new RPGException("No se han podido obtener las habilidades de " + idPersonaje + " " + e.getMessage());
        }
        return habilidadesList;
    }
}
