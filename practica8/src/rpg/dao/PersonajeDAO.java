package rpg.dao;

import rpg.exception.RPGException;
import rpg.model.Personaje;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO {
    private Log log;
    private ConexionBD conexionBD;
    private PersonajeHabilidadDAO personajeHabilidadDAO;
    private InventarioDAO inventarioDAO;

    public PersonajeDAO() {
        this.conexionBD = new ConexionBD();
        this.log = new Log("practica8/src/rpg/dao/PersonajeDAO.java");
        this.personajeHabilidadDAO = new PersonajeHabilidadDAO();
        this.inventarioDAO = new InventarioDAO();
    }

    // FUNCIONA
    public List<Personaje> listarPersonajes() {
        String sql = "SELECT * FROM Personajes";
        // LISTA PARA AÑADIR A LOS PERSONAJES
        List<Personaje> personajeList = new ArrayList<>();
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            // TODO: PROBAR
            while (rs.next()) { // MIENTRAS QUE HAYA FILA
                //String nombre, int nivel, int salud, int oro, int idRaza, int idClase, int idCiudadActual
                Personaje pj = new Personaje(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel"),
                        rs.getInt("vida_actual"),
                        rs.getInt("oro"),
                        rs.getInt("id_raza"),
                        rs.getInt("id_clase"),
                        rs.getInt("id_ciudad_actual")
                );
                // AÑADIMOS LOS PERSONAJES A LA LISTGA
                personajeList.add(pj);
                log.escribirFichero("INFO","El metodo listarPersonajes se ha ejecutado");
            }
            return personajeList;

        } catch (SQLException | ClassNotFoundException | RPGException e) {
            log.escribirFichero("ERROR","El metodo listarPersonajes ha fallado");
            throw new RuntimeException("El metodo listarPersonajes ha fallado");
        }
    }

    // FUNCIONA
    public boolean crearPJ(String nombre, int idRaza, int idClase, int idCiudadActual) throws RPGException {
        String sql = "INSERT INTO Personajes (nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual) VALUES (?,1,100,100,?,?,?)"; // LOS VALORES ? SE RELLENAN MÁS TARDE, LOS PERSONAJES EMPEIZAN SIEMPRE CON NIVEL 1 SALUD 100 ORO 100 LO DEMÁS SE INTRODUCE DESPUÉS
        String sqlId = "SELECT LASTVAL()";

        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            // SUSTITUYE CADA ? POR SU ATRIBUTO REAL
            ps.setString(1, nombre);
            ps.setInt(2, idRaza);
            ps.setInt(3, idClase);
            ps.setInt(4, idCiudadActual);

            ps.executeUpdate(); // EJECUTA EL INSERT

            // PARA OBTERNER EL ULTIMO ID
            PreparedStatement psId = con.prepareStatement(sqlId);
            ResultSet rs = psId.executeQuery();
            if (rs.next()) {
                int nuevoId = rs.getInt(1);
                personajeHabilidadDAO.insertarPersonajeHabilidad(nuevoId, idClase);
                log.escribirFichero("INFO","El metodo crearPJ ha creado las habilidades");
            }
            log.escribirFichero("INFO","El metodo crearPJ ha sido ejecutado con exito");
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo crearPJ ha fallado" + e.getMessage());
            throw new RPGException("El metodo crearPJ ha fallado" + e.getMessage());
        }
    }

    public boolean viajar(int idPersonaje, int idCiudad) throws RPGException {
        String sql = "UPDATE PERSONAJES SET id_ciudad_actual = ? WHERE id = ?";

        try(Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
            PreparedStatement ps = con.prepareStatement(sql)) {
            // SUSTITUYE CADA ? POR EL NUEVO ID
            ps.setInt(1, idCiudad);  // POSICIÓN / VALOR: es decir el primero signo "?" pone ahí el nuevo idCiudad
            ps.setInt(2, idPersonaje); // y aquí pone el segundo

            log.escribirFichero("INFO","El personaje ha viajado con exito" + idPersonaje);
            return ps.executeUpdate() > 0; // true se ha ejecutado , false no se ha ejecutado
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se ha podido viajar " + e.getMessage());
            throw new RPGException("No se ha podido viajar " + e.getMessage());
        }
    }

    public boolean actualizarOro(int idPersonaje, int oro) throws RPGException {
        String sql  = "UPDATE PERSONAJES SET ORO = ? WHERE id = ?";

        try (Connection con = conexionBD.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, oro);
            ps.setInt(2,idPersonaje);

            log.escribirFichero("INFO","Se ha actualizado el oro del personaje [id]: " + idPersonaje);
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","No se ha podido actualizar el oro del personaje [id] " + idPersonaje + " " + e.getMessage());
            throw new RPGException("No se ha podido actualizar el oro del personaje [id] " + idPersonaje + " " + e.getMessage());
        }
    }

    public boolean actualizarVida(int idPersonaje, int vida) throws RPGException {
        String sql = "UPDATE PERSONAJES SET salud = ? WHERE id = ?";

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, vida);
            ps.setInt(2, idPersonaje);

            log.escribirFichero("INFO", "Vida actualizada a " + vida + " PJ: " + idPersonaje);
            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "Vida no actualizada " + idPersonaje);
            throw new RPGException("Vida no actualizada " + idPersonaje);
        }
    }

    public boolean actualizarNivel(int idPersonaje, int nivel) throws RPGException {
        String sql = "UPDATE PERSONAJES SET nivel = ? WHERE id = ?";

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nivel);
            ps.setInt(2, idPersonaje);

            log.escribirFichero("INFO", "Nivel actualizado a " + nivel + " PJ: " + idPersonaje);
            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "Nivel no actualizado [ID_POERSONAJE] " + idPersonaje + " " + e.getMessage());
            throw new RPGException("Nivel no actualizado [ID_POERSONAJE] " + idPersonaje + " " + e.getMessage());
        }
    }

    public boolean eliminarPJ(int id) throws RPGException {
        String sql = "DELETE FROM Personajes WHERE id = ?";
        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            log.escribirFichero("INFO", "PJ ID " + id + " eliminado ");
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "Error eliminar: " + e.getMessage());
            throw new RPGException("Error eliminar: " + e.getMessage());
        }
    }
    public boolean desterrarPJ(int id) throws RPGException {
        String sql = "UPDATE Personajes SET id_ciudad_actual = NULL WHERE id = ?";
        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            log.escribirFichero("INFO", "PJ ID " + id + " ha sido desterrado (Ciudad -> NULL)");
            return ps.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "Error al desterrar: " + e.getMessage());
            throw new RPGException("Error al desterrar: " + e.getMessage());
        }
    }

    public int contarHabilidadesEquipadas(int idPersonaje) throws RPGException {
        String sql = "SELECT COUNT(*) FROM Personajes_Habilidades WHERE id_personaje = ? AND equipada_combate = 1";
        int total = 0;

        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPersonaje);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }

            log.escribirFichero("INFO", "Consuultadas habilidades equipadas del PJ ID: " + idPersonaje + " (Total: " + total + ")");
            return total;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR", "Error al contar habilidades del PJ " + idPersonaje + ": " + e.getMessage());
            throw new RPGException("Error al contar habilidades: " + e.getMessage());
        }
    }

}
