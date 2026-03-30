package rpg.utils;
import java.sql.*;

public class ConexionBD {
    // CÓDIGO PARA CONECTAR A LA BASE DE DATOS

    // SE CONECTA MEDIANTE URL, USER, PASSWORD (LOS QUE TENGO EN entorno_bd/docker-compose.yml)

    // LA URL ES LA SIGUIENTE
    private String url = "jdbc:postgresql://localhost:5432/XRPG";
    private String user = "xrpg_user";
    private String password = "xrpg_password";


    public Connection conectar() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
