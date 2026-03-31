package rpg.dao;

import rpg.model.Personaje;
import rpg.model.Raza;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RazaDAO {
    private Log log;
    private ConexionBD conexionBD;

    public RazaDAO() {
        this.conexionBD = new ConexionBD();
        this.log = new Log("practica8/src/rpg/dao/RazaDAO.java");
    }

    //FUNCIONA
    public List<Raza> listarRazas() {
        String sql = "SELECT * FROM Razas";
        // LISTA PARA AÑADIR A LAS RAZAS
        List<Raza> razasList = new ArrayList<>();
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // MIENTRAS QUE HAYA FILA
                //String nombre, int bonificador_vida, int bonificador_fuerza
                Raza raza = new Raza(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("bonificador_vida"),
                        rs.getInt("bonificador_fuerza")
                );
                // AÑADIMOS LAS RAZAS A LA LISTA
                razasList.add(raza);
                log.escribirFichero("INFO","El metodo listarPersonajes se ha ejecutado");
            }
            return razasList;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarRazas ha fallado");
            throw new RuntimeException("El metodo listarRazas ha fallado");
        }
    }
}