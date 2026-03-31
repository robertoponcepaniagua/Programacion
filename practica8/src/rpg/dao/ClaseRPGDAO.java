package rpg.dao;

import rpg.model.Clases_RPG;
import rpg.model.Raza;
import rpg.utils.ConexionBD;
import rpg.utils.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseRPGDAO {
    private Log log;
    private ConexionBD conexionBD;

    public ClaseRPGDAO () {
        this.conexionBD = new ConexionBD();
        this.log = new Log("practica8/src/rpg/dao/ClaseRPGDAO.java");
    }


    //PROBAR
    public List<Clases_RPG> listarClases() {
        String sql = "SELECT * FROM Clases_RPG";
        // LISTA PARA AÑADIR A LAS Clases
        List<Clases_RPG> clasesRpgsList = new ArrayList<>();
        try (Connection con = conexionBD.conectar(); // INTENTAMOS ESTABLECER CONEXIÓN
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // MIENTRAS QUE HAYA FILA
                //String nombre, int bonificador_vida, int bonificador_fuerza
                Clases_RPG claseRpg = new Clases_RPG(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                // AÑADIMOS LAS CLASES A LA LISTA
                clasesRpgsList.add(claseRpg);
                log.escribirFichero("INFO","El metodo listarClases se ha ejecutado");
            }
            return clasesRpgsList;

        } catch (SQLException | ClassNotFoundException e) {
            log.escribirFichero("ERROR","El metodo listarClases ha fallado" + e.getMessage());
            throw new RuntimeException("El metodo listarClases ha fallado" + e.getMessage());
        }
    }
}
