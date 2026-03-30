package rpg.dao;

import rpg.exception.RPGException;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonajeDAO {
    private Log log;
    private ConexionBD conexionBD;

    public PersonajeDAO() {
        this.conexionBD = new ConexionBD();
        this.log = new Log("practica8/src/rpg/dao/PersonajeDAO.java");
    }

    // FUNCIONA
    public boolean crearPJ(String nombre, int nivel, int salud, int oro, int idRaza, int idClase, int idCiudadActual) throws RPGException {
        String sql = "INSERT INTO Personajes (nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual) VALUES (?,1,100,100,?,?,?)"; // LOS VALORES ? SE RELLENAN MÁS TARDE, LOS PERSONAJES EMPEIZAN SIEMPRE CON NIVEL 1 SALUD 100 ORO 100 LO DEMÁS SE INTRODUCE DESPUÉS
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            // SUSTITUYE CADA ? POR SU ATRIBUTO REAL
            ps.setString(1, nombre);
            ps.setInt(2, idRaza);
            ps.setInt(3, idClase);
            ps.setInt(4, idCiudadActual);
            log.escribirFichero("INFO","El metodo crearPJ ha sido ejecutado con exito");

            ps.executeUpdate(); // EJECUTA EL INSERT

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo crearPJ ha fallado");
            throw new RPGException("El metodo crearPJ ha fallado");
        }
    }
}
