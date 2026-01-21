package com.juego.presentacion;
import com.juego.modelo.Combate;
import com.juego.modelo.GestorPersonajes;
import com.juego.modelo.Personaje;
import com.juego.modelo.PrecargaDatos;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Presentador {

    //CONSTRUCTOR PARA QUE INICIE SOLO EL MENÚ
    public Presentador() {
        menu();
    }

    private PrecargaDatos precargaDatos = new PrecargaDatos();
    private GestorPersonajes gestorPersonajes = new GestorPersonajes();
    private Vista vista = new Vista();
    private Combate combate = new Combate();

    public void juego() {

        //elige personaje
        System.out.println("Jugador 1 elige su personaje:");
        Personaje pj1 = vista.elegirPJ(precargaDatos);

        // Jugador 2 elige personaje (NO puede ser el mismo)
        Personaje pj2;
        do {
            System.out.println("Jugador 2 elige su personaje:");
            pj2 = vista.elegirPJ(precargaDatos);

            if (pj2 == pj1) {
                System.out.println("Ese personaje ya ha sido elegido por el Jugador 1.");
                System.out.println("Elige un personaje diferente.");
            }

        } while (pj2 == pj1);

        // COMBATE
        combate.combate(pj1, pj2);
    }



    public void menu() {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println();
            System.out.println("╔══════════ MENÚ RPG ═══════════╗");
            System.out.println("  1. Jugar");
            System.out.println("  2. Crear Personaje");
            System.out.println("  3. Créditos");
            System.out.println("  4. Salir");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Introduce un número para continuar: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido JUGAR");
                    juego();
                    break;

                case 2:
                    System.out.println("Has elegido CREAR PERSONAJE");
                    precargaDatos.precargaPJ().add(gestorPersonajes.crearpj());
                    break;

                case 3:
                    System.out.println("Créditos del juego");
                    creditos();
                    break;

                case 4:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo");
            }
        } while (opcion != 4);
    }

    public void creditos() {
        System.out.println("                              (0 0)            ");
        System.out.println("                      ---oOO-- (_) ----oOO---  ");
        System.out.println("                    ╔═════════════════════════╗");
        System.out.println("                    ║     Hecho por           ║");
        System.out.println("                    ║  Roberto Ponce Paniagua ║");
        System.out.println("                    ╚═════════════════════════╝");
        System.out.println("                       -------------------     ");
        System.out.println("                             |__|__|           ");
        System.out.println("                              || ||            ");
        System.out.println("                             ooO Ooo           ");
    }
}
