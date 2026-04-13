package rpg.logic;

import rpg.dao.*;
import rpg.exception.RPGException;
import rpg.model.*;
import rpg.ui.MenuUtils;
import rpg.utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorCombate {
    private Scanner sc;
    private Log logger;

    //DAO
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseRPGDAO claseRPGDAO;
    private CiudadDAO ciudadDAO;
    private ItemDAO itemDAO;
    private InventarioDAO inventarioDAO;
    private HabilidadDAO habilidadDAO;
    private PersonajeHabilidadDAO personajeHabilidadDAO;

    public GestorCombate() throws RPGException {
        this.sc = new Scanner(System.in);
        this.logger = new Log("practica8/src/rpg/dao/PersonajeDAO.java");

        //DAO
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseRPGDAO = new ClaseRPGDAO();
        this.ciudadDAO = new CiudadDAO();
        this.itemDAO = new ItemDAO();
        this.inventarioDAO = new InventarioDAO();
        this.habilidadDAO = new HabilidadDAO();
        this.personajeHabilidadDAO = new PersonajeHabilidadDAO();

    }


    public void menu() {
        int opcion;

        do {
            cabecera();
            System.out.println(" 1. Combate");
            System.out.println(" 0. Salir");
            separador();

            System.out.println("Elige: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    // IDEA DEL COMBATE
                    // WHILE VIDA <= 0 SEGUIMOS EL COMBATE
                    // ELEGIMOS LA HABILIDADES CON UN MENÚ ( A SER QUE SEA BONITO )
                    // REVISAR SI LA HABILIDAD TIENE SUFICIENTES USOS, SI NO TIENE USOS VOLVEMOS 1 ARRIBA
                    // LE HACEMOS DAÑO AL OTRO
                    // COMPROBAMOS SI MUERE, SI NO VOLVEMOS AL WHILE DE ARRIBA
                    // EL QUE GANA LO MOSTRAMOS , LE SUMAMOS MONEDAS Y +1 NIVEL
                    // EL QUE PIERDA , LE RESTAMOS MONEDAS Y MOSTRAMOS QUE HA PERDIDO TAMBIÉN





                case 0:
                    break;
            }
        } while (opcion != 0);
    }





    public void cabecera() {
        System.out.println("_________  ________      _____ __________    ___________________________\n" +
                "\\_   ___ \\ \\_____  \\    /     \\\\______   \\  /  _  \\__    ___/\\_   _____/\n" +
                "/    \\  \\/  /   |   \\  /  \\ /  \\|    |  _/ /  /_\\  \\|    |    |    __)_ \n" +
                "\\     \\____/    |    \\/    Y    \\    |   \\/    |    \\    |    |        \\\n" +
                " \\______  /\\_______  /\\____|__  /______  /\\____|__  /____|   /_______  /\n" +
                "        \\/         \\/         \\/       \\/         \\/                 \\/ ");
    }

    public void separador() {
        System.out.println();
        System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
        System.out.println();
    }

    public void enter() {
        System.out.println("----PULSA ENTER PARA CONTINUAR----");
        sc.nextLine();
        sc.nextLine();
    }
}
