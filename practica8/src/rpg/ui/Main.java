package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.exception.RPGException;
import rpg.utils.ConexionBD;

import java.sql.SQLException;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException, RPGException, SQLException {
        ConexionBD bd = new ConexionBD();
        bd.conectar();
        MenuUtils menuUtils = new MenuUtils();
        menuUtils.menu();
    }
}
