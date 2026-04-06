package rpg.ui;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.RPGException;
import rpg.model.*;
import rpg.utils.Log;

import java.util.*;

public class MenuUtils {
    private Scanner sc;
    private Log logger;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseRPGDAO claseRPGDAO;
    private CiudadDAO ciudadDAO;
    private ItemDAO itemDAO;
    private InventarioDAO inventarioDAO;
    List<Ciudades> ciudadesList;
    List<Personaje> personajes;
    List<Raza> razas;
    List<Clases_RPG> clases;
    List<Item> items;

    public MenuUtils() throws RPGException {
        this.sc = new Scanner(System.in);
        this.logger = new Log("practica8/src/rpg/dao/PersonajeDAO.java");
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseRPGDAO = new ClaseRPGDAO();
        this.ciudadDAO = new CiudadDAO();
        this.itemDAO = new ItemDAO();
        this.inventarioDAO = new InventarioDAO();


        //LISTAS
        this.ciudadesList = new ArrayList<>();
        this.personajes = new ArrayList<>();
        this.razas = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.items = new ArrayList<>();
        conectarListas();

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
                    int idcomprador = sc.nextInt();

                    separador();

                    System.out.println("Que quieres comprar");
                    mostrarItems();
                    int iditemcompra = sc.nextInt();

                    // TODO: FUNCIÓN Y DESPUÉS ACTUALIZAMOS CON CONSULTA SQL

                    //GUARDAMOS LOS PERSONAJES
                    List<Personaje> compradores = personajeDAO.listarPersonajes();
                    List<Item> itemsventa = itemDAO.listarItems();

                    for (Personaje compradorpj : compradores) {
                        for (Item itemventa : itemsventa) {

                            //FOR PARA CONSEGUIR LOS 2 EL ITEM Y EL COMPRADOR

                            if (itemventa.getId() == iditemcompra) { // CONSEGIR EL ITEM


                                if (compradorpj.getId() == idcomprador) {  // CONSEGUIR EL COPMPRADOR
                                    //MIRAMOS SI TIENE ORO
                                    if (compradorpj.getOro() >= itemventa.getPrecio_oro()) {

                                        // RESTAMOS ORO
                                        compradorpj.setOro(compradorpj.getOro() - itemventa.getPrecio_oro());

                                        // ACTUALIZAMOS ORO EN LA BASE DE DATOS

                                        // AÑADIMOS ITEM A INVENTARIO
                                        inventarioDAO.añadirItem(compradorpj, itemventa);


                                        System.out.println("---COMPRA REALIZADA CON EXITO!---");
                                        logger.escribirFichero("INFO","Compra realizada con exito Comprador: " +compradorpj.getId() + " Item comprado: " + itemventa.getId());

                                    } else {
                                        logger.escribirFichero("ERROR","El personaje no tiene suficiente oro");
                                        throw new FondosInsuficientesException("El personaje " + compradorpj.toString() + " no tiene suficiente oro" + itemventa.toString() );
                                    }
                                }

                            }
                        }

                    }

                    break;

                case 4:
                    // 4. Combate PVP
                    break;
                case 5:
                    // 5. Cobro de impuestos
                    break;
                case 6:
                    // 6. Equipar Habilidad
                    break;
                case 7:
                    // 7. Estadísticas

                    // A. TOP 3 MÁS RICOS

                    List<Personaje> personajesRicos = new ArrayList<>();

                    for (Personaje pj : personajes) {
                        personajesRicos.add(pj);
                    }

                    // TODO: HAY QUE ORDENAR A LOS PERSONAJES RICOS
                    for (Personaje pj : personajesRicos) {
                        Personaje pj_mas_oro = pj;
                        if (pj.getOro() > pj_mas_oro.getOro()) {
                        }
                    }

                    //SEPARADOR
                    separador();
                    //SEPARADOR

                    // FUNCIONA
                    // B. CONTAR CUANTOS HAY DE CADA CLASE

                    HashMap<String, Integer> clase_y_numero = new HashMap<>();

                    // EJ : MAGO:4 , ELFO: 5


                    for (Personaje pj : personajes) {
                        for (Clases_RPG clasesRpg : clases) {
                            if (pj.getIdClase() == clasesRpg.getId()) {
                                clase_y_numero.put(clasesRpg.getNombre(),+1);
                            }
                        }
                    }

                    for (String nombre : clase_y_numero.keySet()) {
                        System.out.println("Clase: " + nombre + " Número: " + clase_y_numero.get(nombre));
                    }

                    break;

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
        ciudadesList = ciudadDAO.listarCiudades();
        for (Ciudades ciudades : ciudadesList) {
            System.out.println(ciudades.toString());
        }
    }

    public void mostrarPersonajes() {
        personajes = personajeDAO.listarPersonajes();
        for (Personaje p : personajes) {
            System.out.println(p.toString());
        }
    }

    public void mostrarRazas() {
        razas = razaDAO.listarRazas();
        for (Raza r : razas) {
            System.out.println(r.toString());
        }
    }

    public void mostrarClases() {
        clases = claseRPGDAO.listarClases();
        for (Clases_RPG clasesRpg : clases) {
            System.out.println(clasesRpg.toString());
        }
    }

    public void mostrarItems() {
        items = itemDAO.listarItems();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public void conectarListas() {
        personajes = personajeDAO.listarPersonajes();
        razas = razaDAO.listarRazas();
        clases = claseRPGDAO.listarClases();
        items = itemDAO.listarItems();
    }
}
