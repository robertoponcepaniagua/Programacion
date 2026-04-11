package rpg.logic;

import rpg.model.Personaje;
import rpg.ui.MenuUtils;

import java.util.Scanner;

public class GestorCombate {
    Scanner sc;
    public GestorCombate() {
        this.sc = new Scanner(System.in);

    }


    public void menu() {
        int opcion;

        do {
            System.out.println(" 1. Combate");
            System.out.println(" 0. Salir");

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
