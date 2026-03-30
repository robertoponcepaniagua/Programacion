package rpg.ui;

import rpg.utils.ConexionBD;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException {
        ConexionBD bd = new ConexionBD();
        bd.conectar();
        MenuUtils menuUtils = new MenuUtils();
        menuUtils.menu();
    }
}
