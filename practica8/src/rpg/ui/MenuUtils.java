package rpg.ui;

import rpg.dao.ClaseRPGDAO;
import rpg.dao.PersonajeDAO;
import rpg.dao.RazaDAO;
import rpg.exception.RPGException;
import rpg.model.Clases_RPG;
import rpg.model.Personaje;
import rpg.model.Raza;
import rpg.utils.Log;

import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    private Scanner sc;
    private Log logger;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseRPGDAO claseRPGDAO;

    public MenuUtils() throws RPGException {
        this.sc = new Scanner(System.in);
        this.logger = new Log("practica8/src/rpg/dao/PersonajeDAO.java");
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseRPGDAO = new ClaseRPGDAO();



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
                    // 1. Crear Personaje
                    // nombre,nivel,oro,vida_actual,id_raza,id_clase,id_ciudad_actual
                    try {
                        // PARA COGER LOS FALLOS LO METEMOS EN UN TRY-CATCH
                        System.out.println("Escribe un nombre para el personaje: ");
                        String nombre = sc.nextLine();

                        separador();

                        System.out.println("Eligue la Raza (id): ");
                        List<Raza> razas = razaDAO.listarRazas();

                        //MOSTRAR RAZAS

                        for (Raza r : razas) {
                            System.out.println(r.toString());
                        }
                        // ELEGIR RAZA
                        int raza = Integer.parseInt(sc.nextLine());

                        separador();

                        System.out.println("Elige la Clase (id): ");
                        List<Clases_RPG> clases = claseRPGDAO.listarClases();

                        //MOSTRAR CLASES

                        for (Clases_RPG clasesRpg : clases) {
                            System.out.println(clasesRpg.toString());
                        }

                        int clase = Integer.parseInt(sc.nextLine());

                        separador();

                        System.out.println("Elige la Ciudad (id): ");

                        //TODO: MOSTRAR CIDUADES

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
                case 3:
                    // 3. Comprar items
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
                    // 8. Ver Personajes
                    List<Personaje> prueba = personajeDAO.listarPersonajes();
                    for (Personaje p : prueba) {
                        System.out.println(p.toString());
                    }
                    break;
            }
        } while (opcion != 0);
    }


    public void cabecera() {
        System.out.println(
                "" +
                        "____  _______________________  ________ \n" +
                        "\\   \\/  /\\______   \\______   \\/  _____/ \n" +
                        " \\     /  |     ___/|       _/   \\  ___ \n" +
                        " /     \\  |    |    |    |   \\    \\_\\  \\\n" +
                        "/___/\\  \\ |____|    |____|_  /\\______  /\n" +
                        "      \\_/                  \\/        \\/ "
        );
    }

    public void separador() {
        System.out.println();
        System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
        System.out.println();
    }
}
