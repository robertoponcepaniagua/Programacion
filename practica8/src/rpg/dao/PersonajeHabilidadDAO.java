package rpg.dao;

import rpg.exception.RPGException;
import rpg.model.Habilidades;
import rpg.model.Personajes_Habilidades;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonajeHabilidadDAO {
    private Log log;
    private ConexionBD conexionBD;

    public PersonajeHabilidadDAO() {
        this.log = new Log("practica8/src/rpg/dao/PersonajeHabilidadDAO.java");
        this.conexionBD = new ConexionBD();
    }


    public List<Personajes_Habilidades> listarPersonajesHabilidades(int idPersonaje) {
        List<Personajes_Habilidades> personajesHabilidadesList = new ArrayList<>();

        String sql = "SELECT ph.id_personaje, ph.id_habilidad, ph.equipada_combate, " +
                "h.nombre, h.dano_base, h.usos_maximos " +
                "FROM Personajes_Habilidades ph " +
                "JOIN Habilidades h ON ph.id_habilidad = h.id " +
                "WHERE ph.id_personaje = ?";

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersonaje);

            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    //int id_personaje, int id_habilidad, boolean equipada_combate
                    Personajes_Habilidades personajes_habilidades = new Personajes_Habilidades(
                            rs.getInt("id_personaje"),
                            rs.getInt("id_habilidad"),
                            rs.getBoolean("equipada_combate")
                    );
                    personajesHabilidadesList.add(personajes_habilidades);
                    log.escribirFichero("INFO","El metodo listarPersonajesHabilidades se ha ejecutado");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarPersonajesHabilidades ha fallado");
            throw new RuntimeException("El metodo listarPersonajesHabilidades ha fallado");
        }
        return personajesHabilidadesList;
    }

    public boolean actualizarHabilidades(int idPersonaje,int idHabilidad, boolean equipada) {
        // UN UPDATE PARA PODER QUITAR Y EQUIPAR HABILIDADES
        String sql = "UPDATE Personajes_Habilidades SET equipada_combate = ? WHERE id_personaje = ? AND id_habilidad = ?";

        try (Connection con = conexionBD.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1,equipada);
            ps.setInt(2,idPersonaje);
            ps.setInt(3,idHabilidad);

            log.escribirFichero("INFO","Se han actualizado las habilidades");

            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se han actualizado las habilidades" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean insertarPersonajeHabilidad(int idPJ, int idClase) {
        String sql = "INSERT INTO Personajes_Habilidades (id_personaje, id_habilidad, equipada_combate) SELECT ?, id, false FROM Habilidades WHERE id_clase = ?";


        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPJ);
            ps.setInt(2,idClase);

            log.escribirFichero("INFO","Se le han otorgado las habilidades de su clase al nuevo personaje" + idPJ);

            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se le han podido otorgar las habilidades de su clase " + idPJ + " " +e.getMessage());
            throw new RuntimeException("No se le han podido otorgar las habilidades de su clase " + idPJ + " " +e.getMessage());
        }
    }
}
