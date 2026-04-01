package rpg.ui;

import rpg.dao.*;
import rpg.exception.RPGException;
import rpg.model.*;
import rpg.utils.Log;

import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    private Scanner sc;
    private Log logger;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseRPGDAO claseRPGDAO;
    private CiudadDAO ciudadDAO;
    private ItemDAO itemDAO;

    public MenuUtils() throws RPGException {
        this.sc = new Scanner(System.in);
        this.logger = new Log("practica8/src/rpg/dao/PersonajeDAO.java");
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseRPGDAO = new ClaseRPGDAO();
        this.ciudadDAO = new CiudadDAO();
        this.itemDAO = new ItemDAO();



        //FUNCION MOSTRAR MENÚ
        MostrarMenu();
    }


    public void MostrarMenu() throws RPGException {
        int opcion;
        do {
            cabecera();
            System.out.println(" 1. Crear Personaje");
            System.out.println(" 2. Viajar a Ciudad");
            System.out.println(" 3. Comprar items");
            System.out.println(" 4. Combate PVP");
            System.out.println(" 5. Cobro de impuestos");
            System.out.println(" 6. Equipar Habilidad");
            System.out.println(" 7. Estadísticas");
            System.out.println(" 8. Ver Personajes");
            System.out.println(" 0. Salir");
            separador();
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            // TODO: TERMINAR EL MENÚ
            switch (opcion)  {
                case 1:
                    // FUNCIONA / TERMINADO
                    // 1. Crear Personaje
                    // nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual
                    try {
                        // PARA COGER LOS FALLOS LO METEMOS EN UN TRY-CATCH
                        System.out.println("Escribe un nombre para el personaje: ");
                        String nombre = sc.nextLine();

                        separador();

                        System.out.println("Eligue la Raza (id): ");

                        mostrarRazas();

                        // ELEGIR RAZA
                        int raza = Integer.parseInt(sc.nextLine());

                        separador();

                        System.out.println("Elige la Clase (id): ");

                        mostrarClases();

                        int clase = Integer.parseInt(sc.nextLine());

                        separador();

                        System.out.println("Elige la Ciudad (id): ");

                        //MOSTRAR CIDUADES
                        mostrarCiudades();

                        int ciudad = Integer.parseInt(sc.nextLine());

                        separador();

                        // CREAMOS EL PERSONAJE
                        personajeDAO.crearPJ(nombre, raza, clase, ciudad);
                        System.out.println("--PERSONAJE CREADO CON EXITO--");
                        logger.escribirFichero("INFO","Personaje creado con exito");

                    } catch (Exception e) {
                        logger.escribirFichero("ERROR","El metodo crearPJ ha fallado" + e.getMessage());
                        throw new RPGException("El metodo crearPJ ha fallado" + e.getMessage());
                    }
                    break;
                case 2:
                    // 2. Viajar a Ciudad
                    System.out.println("Que personaje quieres que viaje? ");

                    mostrarPersonajes();

                    separador();

                    int idViaja = sc.nextInt();

                    separador();

                    System.out.println("Donde? ");

                    mostrarCiudades();

                    separador();

                    int idDestino = sc.nextInt();

                    personajeDAO.viajar(idViaja, idDestino);
                case 3:
                    // 3. Comprar items
                    tienda();

                    System.out.println("Qué personaje quieres que compre? ");
                    mostrarPersonajes();
                    System.out.println("Escribe el personaje (id): ");
                    int comprador = sc.nextInt();

                    separador();

                    mostrarItems();

                    // TODO: DUDA: FUNCIONES Y DESPUÉS ACTUALIZAR CON CONSULTA O DIRECTAMENTE CONSULTA?
                    break;

                case 4:
                    // 4. Combate PVP
                case 5:
                    // 5. Cobro de impuestos
                case 6:
                    // 6. Equipar Habilidad
                case 7:
                    // 7. Estadísticas

                    // A. TOP 3 MÁS RICOS

                    // B. CONTAR CUANTOS HAY DE CADA CLASE

                case 8:
                    //FUNCIONA / TERMINADO
                    // 8. Ver Personajes
                    mostrarPersonajes();
                    break;
            }
        } while (opcion != 0);
    }


    public void cabecera() {
        System.out.println("" +
                "____  _______________________  ________ \n" +
                "\\   \\/  /\\______   \\______   \\/  _____/ \n" +
                " \\     /  |       _/|     ___/   \\  ___ \n" +
                " /     \\  |    |   \\|    |   \\    \\_\\  \\\n" +
                "/___/\\  \\ |____|_  /|____|    \\______  /\n" +
                "      \\_/        \\/                  \\/ ");
    }

    public void tienda() {
        System.out.println("___________.______________ _______  ________      _____   \n" +
                "\\__    ___/|   \\_   _____/ \\      \\ \\______ \\    /  _  \\  \n" +
                "  |    |   |   ||    __)_  /   |   \\ |    |  \\  /  /_\\  \\ \n" +
                "  |    |   |   ||        \\/    |    \\|    `   \\/    |    \\\n" +
                "  |____|   |___/_______  /\\____|__  /_______  /\\____|__  /\n" +
                "                       \\/         \\/        \\/         \\/ \n" +
                "                                                          \n");
    }

    public void separador() {
        System.out.println();
        System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
        System.out.println();
    }


    public void mostrarCiudades() {
        List<Ciudades> ciudadesList = ciudadDAO.listarCiudades();
        for (Ciudades ciudades : ciudadesList) {
            System.out.println(ciudades.toString());
        }
    }

    public void mostrarPersonajes() {
        List<Personaje> prueba = personajeDAO.listarPersonajes();
        for (Personaje p : prueba) {
            System.out.println(p.toString());
        }
    }

    public void mostrarRazas() {
        List<Raza> razas = razaDAO.listarRazas();
        for (Raza r : razas) {
            System.out.println(r.toString());
        }
    }

    public void mostrarClases() {
        List<Clases_RPG> clases = claseRPGDAO.listarClases();
        for (Clases_RPG clasesRpg : clases) {
            System.out.println(clasesRpg.toString());
        }
    }

    public void mostrarItems() {
        List<Item> items = itemDAO.listarItems();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
}
