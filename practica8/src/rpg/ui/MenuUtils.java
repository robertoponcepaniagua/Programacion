package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.model.Personaje;

import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    private Scanner sc;
    private PersonajeDAO personajeDAO;

    public MenuUtils() {
        this.sc = new Scanner(System.in);
        this.personajeDAO = new PersonajeDAO();


        //FUNCION MOSTRAR MENÚ
        MostrarMenu();
    }


    public void MostrarMenu() {
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

            // TODO: TERMINAR EL MENÚ
            switch (opcion)  {
                case 1:
                    // 1. Crear Personaje
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
