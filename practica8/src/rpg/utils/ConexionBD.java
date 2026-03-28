package rpg.utils;
import java.sql.*;

public class ConexionBD {
    // CÓDIGO PARA CONECTAR A LA BASE DE DATOS

    // SE CONECTA MEDIANTE URL, USER, PASSWORD (LOS QUE TENGO EN entorno_bd/docker-compose.yml)

    // LA URL ES LA SIGUIENTE
    private String url = "jdbc:postgresql://localhost:5432/XRPG";
    private String user = "xrpg_user";
    private String password = "xrpg_password";


    public void conectar() throws ClassNotFoundException {

        try {
            // CARGAMOS EL DRIVER
            Class.forName("org.postgresql.Driver");

            // TRY-WITH-RESOURCES (ABRE Y CIERRA SOLO)
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Conexión");
                // TODO: HACER UNA CONSULTA PARA PROBAR
            }
            // ERRORES
        } catch (ClassNotFoundException e) {
            System.out.println("Fallo Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de (Docker, usuario o pass): " + e.getMessage());
        }
    }
}
