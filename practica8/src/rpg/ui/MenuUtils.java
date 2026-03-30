package rpg.ui;

import java.util.Scanner;

public class MenuUtils {
    private Scanner sc;

    public MenuUtils() {
        this.sc = new Scanner(System.in);
    }


    public void menu() {
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

            // TODO: switch ()
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

    public void MostrarMenu() {

    }
}
