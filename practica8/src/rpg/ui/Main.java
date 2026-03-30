package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.exception.RPGException;
import rpg.model.Personaje;
import rpg.utils.ConexionBD;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException, RPGException, SQLException {
        ConexionBD bd = new ConexionBD();
        bd.conectar();
        MenuUtils menuUtils = new MenuUtils();
        //menuUtils.MostrarMenu();
        PersonajeDAO personajeDAO = new PersonajeDAO();
    }
}
