package com.juego.presentacion;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidad;
import com.juego.habilidades.IHabilidad;
import com.juego.modelo.Personaje;
import com.juego.modelo.PrecargaDatos;

import java.util.List;
import java.util.Scanner;

public class Vista {
    //meotod para elegir la habilidad que vas a utilizar contra el contrincante
    public IHabilidad elegirHabilidad(Personaje pj) {
        List<IHabilidad> habilidades = pj.getClase().getHabilidades();
        Scanner sc = new Scanner(System.in);
        IHabilidad habilidadElegida = null;

        do {
            // Mostrar habilidades
            for (int i = 0; i < habilidades.size(); i++) {
                System.out.println("┌───────────────────────────── HABILIDAD " + (i+1) + " ─────────────────────────────┐");
                habilidades.get(i).infoHabilidad();
                System.out.println("└───────────────────────────────────────────────────────────────────────┘");
            }

            System.out.println("Qué habilidad quieres usar?");
            int opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= habilidades.size()) {
                habilidadElegida = habilidades.get(opcion - 1);
                if (habilidadElegida.getUsosActuales() <= 0) {
                    System.out.println("Esa habilidad no tiene usos, elige otra.");
                    habilidadElegida = null; // fuerza a repetir
                }
            } else {
                System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (habilidadElegida == null);

        System.out.println("Has elegido: " + habilidadElegida.nombreHabilidad());
        return habilidadElegida;
    }



    public void corazones(Personaje pj) {
        int maxCorazones = pj.getVidaMax() / 10;
        int corazones = pj.getVida() / (pj.getVidaMax() / maxCorazones);
        int corazonesVacios = maxCorazones - corazones;

        for (int i = 0; i < corazones; i++) {
            System.out.print("♥");
        }
        for (int i = 0; i < corazonesVacios; i++) {
            System.out.print("♡");
        }
        System.out.print("   HP: " + pj.getVida() + "/" + pj.getVidaMax());
    }

    //para mostrar el estado de como va el combate
    public void mostrarEstado(Personaje p1, Personaje p2) {
        System.out.println();
        System.out.println("╔══❖════ESTADO DEL COMBATE═══❖══╗ ");

        System.out.println("❤️  VIDA " + p1.getNombre());
        corazones(p1);

        System.out.println();
        System.out.println();
        System.out.println("჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻ VS ჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻჻");
        System.out.println();

        System.out.println("❤️  VIDA " + p2.getNombre() );
        corazones(p2);

        System.out.println();
        System.out.println("╚══❖═════════════════════════❖══╝");
        System.out.println();
    }
    //metodo para elegir personajes
    public Personaje elegirPJ(PrecargaDatos precargaDatos) {

        Personaje personaje = null;

        do {
            for (int i = 0; i < precargaDatos.precargaPJ().size(); i++) {
                System.out.println("───────────────────────────────────────────────────────────────────────────[ " + i + " ]───────────────────────────────────────────────────────────────────────────");
                infoPJ(precargaDatos.getPersonajes().get(i));
                System.out.println();
            }

            System.out.println("Qué personaje quieres elegir?");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            personaje = precargaDatos.getPersonajes().get(opcion);

        }while (personaje == null);
        return personaje;
    }

    public void infoPJ(Personaje pj) {

        System.out.println();
        System.out.printf("%-20s", "Nombre");
        System.out.printf("%-15s", "Raza");
        System.out.printf("%-15s", "Clase");
        System.out.printf("%-10s", "Fuerza");
        System.out.printf("%-15s", "Inteligencia");
        System.out.printf("%-12s", "Velocidad");
        System.out.printf("%-12s", "Destreza");
        System.out.printf("%-12s", "Defensa");
        System.out.printf("%-15s%n", "Vida");

        System.out.println();
        System.out.printf("%-20s", pj.getNombre());
        System.out.printf("%-15s", pj.getRaza().getClass().getSimpleName());
        System.out.printf("%-15s", pj.getClase().getClass().getSimpleName());
        System.out.printf("%-10d", pj.getFuerza());
        System.out.printf("%-15d", pj.getInteligencia());
        System.out.printf("%-12d", pj.getVelocidad());
        System.out.printf("%-12d", pj.getDestreza());
        System.out.printf("%-12d", pj.getDefensa());

        corazones(pj);
        System.out.println();
    }
}
