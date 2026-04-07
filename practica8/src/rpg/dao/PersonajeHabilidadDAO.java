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


    public List<Personajes_Habilidades> listarPersonajesHabilidades() {
        List<Personajes_Habilidades> personajesHabilidadesList = new ArrayList<>();

        String sql = "SELECT * FROM Personajes_Habilidades";

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

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

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarPersonajesHabilidades ha fallado");
            throw new RuntimeException("El metodo listarPersonajesHabilidades ha fallado");
        }
        return personajesHabilidadesList;
    }

    public List<Habilidades> actualizarHabilidades(int idPersonaje,int idHabilidad, boolean equipada) {
        // UN UPDATE PARA PODER QUITAR Y EQUIPAR HABILIDADES
        // TODO: HACER EL UPDATE Y HACER EL CASE 6 ENTERO
        String sql = "";
    }
}
