package rpg.logic;

import com.sun.source.tree.WhileLoopTree;
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


                    System.out.println("Elige a 2 Personajes: ");
                    List<Personaje> personajes = personajeDAO.listarPersonajes();
                    //MOSTRAR PERSONAJES DISPONIBLES
                    for (Personaje p : personajes) {
                        System.out.println(p.toString());
                    }

                    System.out.print("ID del Jugador 1: ");
                    int id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("ID del Jugador 2: ");
                    int id2 = sc.nextInt(); sc.nextLine();

                    Personaje jugador1 = buscarPersonajePorId(personajes, id1);
                    Personaje jugador2 = buscarPersonajePorId(personajes, id2);

                    // Aplicar bonificaciones de raza
                    List<Raza> razas = razaDAO.listarRazas();
                    Raza raza1 = buscarRazaPorId(razas, jugador1.getIdRaza());
                    Raza raza2 = buscarRazaPorId(razas, jugador2.getIdRaza());
                    if (raza1 != null) jugador1.aplicarBonificaciones(raza1);
                    if (raza2 != null) jugador2.aplicarBonificaciones(raza2);

                    // Calcular estadísticas de combate usando inventario
                    //  PJ1
                    int ataque1 = calcularAtaqueFisico(jugador1, raza1);
                    int defensa1 = calcularDefensa(jugador1);
                    // PJ2
                    int ataque2 = calcularAtaqueFisico(jugador2, raza2);
                    int defensa2 = calcularDefensa(jugador2);

                    separador();

                    imprimirFicha(jugador1, ataque1, defensa1);
                    imprimirFicha(jugador2, ataque2, defensa2);

                    separador();

                    enter();

                    int turnos = 0;

                    while(jugador1.getSalud() > 0 || jugador2.getSalud() > 0) {
                        turnos++;
                        System.out.println("TURNO: " + turnos);

                        // ELEGIR ATAQUE PJ1
                        // MOSTRAR ATAQUES DE PJ1
                        // COMPROBAR SI TIENE USOS DISPONIBLES EL ATAQUE, SI TIENE RESTAR USO, SI NO ELEGIR OTRO ATAQUE

                        // ELEGIR ATAQUE PJ2
                        // MOSTRAR ATAQUES PJ2
                        // COMPROBAR SI TIENE USOS DISPONIBLES EL ATAQUE, SI TIENE RESTAR USO, SI NO ELEGIR OTRO ATAQUE

                        // RESTAR VIDA AL OPONENTE PJ2
                        // RESTAR VIDA AL OPONENTE PJ1

                        //MOSTRAR FICHAS
                        imprimirFicha(jugador1, ataque1, defensa1);
                        imprimirFicha(jugador2, ataque2, defensa2);

                    }

                case 0:
                    break;
            }
        } while (opcion != 0);
    }


    public void imprimirFicha(Personaje j, int atq, int def) {
        String nombre = j.getNombre().toUpperCase();
        int id = j.getId();
        int hp = j.getSalud();
        int hpMax = j.getSaludMax();

        String lineaHp = "║ HP:  " + hp + "/" + hpMax;

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║ " + nombre);
        System.out.println("║ ID: #" + id);
        System.out.println("╠═══════════════════════════╣");
        System.out.println("║ ATQ: " + atq);
        System.out.println("║ DEF: " + def);
        System.out.println(lineaHp);
        System.out.println("╚═══════════════════════════╝");
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

    private Personaje buscarPersonajePorId(List<Personaje> lista, int id) {
        for (Personaje p : lista) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private Raza buscarRazaPorId(List<Raza> lista, int id) {
        for (Raza r : lista) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    private Habilidades buscarHabilidadPorId(List<Habilidades> lista, int id) {
        for (Habilidades h : lista) {
            if (h.getId() == id) return h;
        }
        return null;
    }

    private int calcularAtaqueFisico(Personaje pj, Raza raza) {
        int fuerzaBase = 0;
        if (raza != null)  {
            fuerzaBase = raza.getBonificador_fuerza();
        }
        int bonusItems = 0;
        List<Item> items = inventarioDAO.listarItemsPersonaje(pj.getId());
        for (Item item : items) {
            bonusItems += item.getBonificador_ataque();
        }
        return fuerzaBase + bonusItems;
    }

    private int calcularDefensa(Personaje pj) {
        int defensa = 0;
        List<Item> items = inventarioDAO.listarItemsPersonaje(pj.getId());
        for (Item item : items) {
            defensa += item.getBonificador_defensa();
        }
        return defensa;
    }
}
