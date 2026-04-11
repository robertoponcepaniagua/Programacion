package rpg.ui;

import rpg.dao.*;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.RPGException;
import rpg.model.*;
import rpg.utils.Log;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MenuUtils {
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

    //LIST
    private List<Ciudades> ciudadesList;
    private List<Personaje> personajes;
    private List<Raza> razas;
    private List<Clases_RPG> clases;
    private List<Item> items;
    private List<Habilidades> habilidades;
    private List<Personajes_Habilidades> habilidadesPJ;

    public MenuUtils() throws RPGException {
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


        //LISTAS
        this.ciudadesList = new ArrayList<>();
        this.personajes = new ArrayList<>();
        this.razas = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.items = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.habilidadesPJ = new ArrayList<>();
        //CONECTA LAS LISTAS CON LA DE LAS BASES DE DATOS
        conectarListas();

        //FUNCION MOSTRAR MENÚ
        MostrarMenu();
    }


    public void MostrarMenu() throws RPGException {
        int opcion;
        int opcionhabilidades;
        do {
            cabecera();
            System.out.println(" 1. Crear Personaje");
            System.out.println(" 2. Viajar a Ciudad");
            System.out.println(" 3. Comprar items");
            System.out.println(" 4. Combate PVP");
            System.out.println(" 5. Cobro de impuestos");
            System.out.println(" 6. Habilidades");
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
                    // TODO: ESTÁ MAL NO INSERTA LAS HABILIDADES Y EL INVENTARIO
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
                    // FUNCIONA / TERMINADO

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

                    for (Personaje pj : personajes) {
                        if (pj.getId() == idViaja) {

                            for (Ciudades ciudad : ciudadesList) {
                                if (ciudad.getId() == idDestino) {

                                    if (pj.getNivel() >= ciudad.getNombre_minimo_acceso()) {
                                        System.out.println("---VIAJE COMPLETADO---");
                                        logger.escribirFichero("INFO","Viaje con exito");
                                        personajeDAO.viajar(idViaja, idDestino);
                                        enter();
                                    } else {
                                        System.out.println("Nível insuficiente, viaje no completado");
                                        enter();
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 3:
                    // FUNCIONA / TERMINADO
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

                                        int oroactualizado = compradorpj.getOro();

                                        // ACTUALIZAMOS ORO EN LA BASE DE DATOS
                                        personajeDAO.actualizarOro(compradorpj.getId(),oroactualizado);

                                        // AÑADIMOS ITEM A INVENTARIO
                                        inventarioDAO.añadirItem(compradorpj, itemventa);


                                        System.out.println("---COMPRA REALIZADA CON EXITO!---");
                                        logger.escribirFichero("INFO","Compra realizada con exito Comprador: " +compradorpj.getId() + " Item comprado: " + itemventa.getId());
                                        enter();

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

                    // TODO: REPASAR ITERADORES CON VÍDEOS, ME CUESTA ENTENDERLO

                    Iterator<Personaje> personajeIterator = personajes.iterator();

                    while(personajeIterator.hasNext()) { //mientras que tenga otro objeto
                        Personaje pj = personajeIterator.next();
                        if (pj.getOro() < 20) {
                            //ELIMINA PORQUE NO TIENE 20 MONEDAS DE ORO
                            personajeIterator.remove();
                            // TODO: HACER UN UPDATE DE LA BASE DE DATOS, HAY QUE ELIMINAR AL PERSONAJE QUE NO TENGA 20 MONEDAS DE ORO
                            System.out.println("El personaje " + pj.getId() + " no tiene suficientes monedas, eliminando...");
                            logger.escribirFichero("INFO","El personaje " + pj.getId() + " no tiene suficientes monedas, eliminando...");
                        } else {
                            pj.setOro(pj.getOro() - 20);
                            System.out.println("El personaje " + pj.getId() + " ha pagado sus impuestos");
                            logger.escribirFichero("INFO","El personaje " + pj.getId() + " ha pagado sus impuestos");
                        }
                    }
                    enter();
                    break;
                case 6:
                    // 6. Equipar Habilidad

                    // PRIMER PASO: MIRAR QUE CLASE ES EL PERSONAJE (consulta sql)
                    // SEGUNDO PAS: MIRAR LAS HABILIDADES DE ESA CLASE (consulta sql)
                    // TERCER PASO MIRAR LA RELACIÓN ( PERSONAJES_HABILIDADES ) (consulta sql) *TIENE UN TRUE O FALSE SI TIENE LA HABILIDAD EQUIPADA

                    // DESPUÉS DE ESO HAY QUE HAY QUE HACER U MENÚ PARA QUE PUEDA EQUIPAR , QUITAR Y SALIR ( HAY QUE HACER UN UPDATE A LA BASE DE DATOS DEPENDIENDO DE LO QUE HAGA EL USUARIO )

                    // PRIMER PASO:


                    do {
                        cabecerahabilidades();
                        System.out.println(" 1. Equipar Habilidad");
                        System.out.println(" 2. Desequipar Habilidad");
                        System.out.println(" 3. Ver Habilidades");
                        System.out.println(" 0. Salir");
                        separador();

                        opcionhabilidades = sc.nextInt();

                        switch (opcionhabilidades) {
                            case 1:
                                // EQUIPAR HABILIDAD

                                mostrarPersonajes();
                                int idpersonaje = sc.nextInt();
                                sc.nextLine();

                                habilidadesPJ = personajeHabilidadDAO.listarPersonajesHabilidades(idpersonaje);
                                for (Personajes_Habilidades h : habilidadesPJ) {
                                    System.out.println(h.toString());
                                }

                                System.out.println("Que habilidad quieres equiparte (id): ");
                                int idhabilidad = sc.nextInt();
                                sc.nextLine();

                                personajeHabilidadDAO.actualizarHabilidades(idpersonaje, idhabilidad, true);

                                break;
                            case 2:
                                // DESEQUIPAR HABILIDAD

                                mostrarPersonajes();
                                int idpersonaje2 = sc.nextInt();
                                sc.nextLine();

                                habilidadesPJ = personajeHabilidadDAO.listarPersonajesHabilidades(idpersonaje2);
                                for (Personajes_Habilidades h : habilidadesPJ) {
                                    System.out.println(h.toString());
                                }

                                System.out.println("Que habilidad quieres desequiparte (id): ");
                                int idhabilidad2 = sc.nextInt();
                                sc.nextLine();

                                personajeHabilidadDAO.actualizarHabilidades(idpersonaje2, idhabilidad2, false);

                                break;
                            case 3:
                                // VER HABILIDADES
                                System.out.println("Elige el personaje (id): ");
                                mostrarPersonajes();

                                int idpersonajeelegido = sc.nextInt();
                                sc.nextLine();

                                habilidadesPJ = personajeHabilidadDAO.listarPersonajesHabilidades(idpersonajeelegido);
                                for (Personajes_Habilidades h : habilidadesPJ) {
                                    System.out.println(h.toString());
                                }

                                enter();
                                System.out.println();

                                break;
                            case 0:
                                // SALIR
                                MostrarMenu();
                                break;
                        }

                    } while (opcionhabilidades != 0);

                    break;
                case 7:
                    //TODO: REVISAR

                    // FUNCIONA / SIN TERMINAR

                    // 7. Estadísticas

                    //FUNCIONA
                    // A. TOP 3 MÁS RICOS
                    List<Personaje> personajesRicos = new ArrayList<>();

                    for (Personaje pj : personajes) {
                        personajesRicos.add(pj);
                    }

                    // TODO: LO TENGO HECHO CON EL COLLECTIONS SORT, HAY QUE PREGUNTAR SI ESTÁ BIEN, SI NO HACERLO DE FORMA HABITUAL
                    Collections.sort(personajesRicos, new Comparator<Personaje>() {
                        @Override
                        public int compare(Personaje pj1, Personaje pj2) {
                            return  pj2.getOro() - pj1.getOro();
                        }
                    });

                    System.out.println("--- A. Top 3 más ricos ---");
                    for (int i = 0; i < 3; i++) {
                        Personaje p = personajesRicos.get(i);
                        System.out.println((i+1) + ". " + p.getNombre() + " — " + p.getOro() + " oro");
                    }


                    // FUNCIONA
                    // B. CONTAR CUANTOS HAY DE CADA CLASE
                    System.out.println("--- B. Contar cada clase ---");
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
                        System.out.println("Clase: " + nombre + " | Cantidad: " + clase_y_numero.get(nombre));
                    }

                    separador();

                    enter();

                    break;

                case 8:
                    //FUNCIONA / TERMINADO
                    // 8. Ver Personajes
                    mostrarPersonajes();
                    enter();
                    break;
            }
        } while (opcion != 0);
        System.out.println("---SALIENDO---");
        logger.escribirFichero("INFO","El usuario ha terminado la sesión");
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

    public void cabecerahabilidades() {
        System.out.println("  ___ ___    _____ __________.___.____    .___________      _____  ________  ___________ _________\n" +
                " /   |   \\  /  _  \\\\______   \\   |    |   |   \\______ \\    /  _  \\ \\______ \\ \\_   _____//   _____/\n" +
                "/    ~    \\/  /_\\  \\|    |  _/   |    |   |   ||    |  \\  /  /_\\  \\ |    |  \\ |    __)_ \\_____  \\ \n" +
                "\\    Y    /    |    \\    |   \\   |    |___|   ||    `   \\/    |    \\|    `   \\|        \\/        \\\n" +
                " \\___|_  /\\____|__  /______  /___|_______ \\___/_______  /\\____|__  /_______  /_______  /_______  /\n" +
                "       \\/         \\/       \\/            \\/           \\/         \\/        \\/        \\/        \\/ ");
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

    public void  mostrarHabilidades() {
        habilidades = habilidadDAO.listarHabilidades();
        for (Habilidades habilidad : habilidades) {
            System.out.println(habilidad.toString());
        }
    }

    public void conectarListas() {
        personajes = personajeDAO.listarPersonajes();
        razas = razaDAO.listarRazas();
        clases = claseRPGDAO.listarClases();
        items = itemDAO.listarItems();
        habilidades = habilidadDAO.listarHabilidades();
    }



    // METODO PARA QUE NO PASE EL MENÚ DIRECTAMENTE Y SE PUEDA LEER
    public void enter() {
        System.out.println("----PULSA ENTER PARA CONTINUAR----");
        sc.nextLine();
        sc.nextLine();
    }
}
