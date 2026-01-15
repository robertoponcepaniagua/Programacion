package com.juego.presentacion;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidad;
import com.juego.habilidades.IHabilidad;
import com.juego.modelo.Personaje;

import java.util.List;
import java.util.Scanner;

public class Vista {
    //meotod para elegir la habilidad que vas a utilizar contra el contrincante
    public IHabilidad elegirHabilidad(Personaje pj) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < pj.getClase().getHabilidades().size(); i++) {
            System.out.println("---------------------------------"+ (i+1) +"----------------------------------");
            pj.getClase().getHabilidades().get(i).infoHabilidad();
            System.out.println();

        }
        System.out.println("Qué habilidad quieres usar?");

        int opcion = sc.nextInt();

        IHabilidad habilidadElegida = null;

        List<IHabilidad> habilidades = pj.getClase().getHabilidades();
        do {
            switch (opcion) {
                case 1:
                    habilidadElegida = habilidades.get(0);
                    break;
                case 2:
                    habilidadElegida = habilidades.get(1);
                    break;
                case 3:
                    habilidadElegida = habilidades.get(2);
                    break;
                default:
                    System.out.print("Opción no valida");
            }
        } while (habilidadElegida == null);

        System.out.print("Has elegido: ");
        System.out.println(habilidadElegida.nombreHabilidad());
        return habilidadElegida;
    }

    public void infoPersonaje (Personaje pj1) {
        System.out.println(pj1.getNombre());
        System.out.println(pj1.getRaza());
        System.out.println(pj1.getClase());
    }

    public void infoPersonajeExtensa (Personaje pj1) {
        System.out.println(pj1.getNombre());
        System.out.println(pj1.getRaza());
        System.out.println(pj1.getClase());

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

    public void victoria(Personaje pj1) {
        //HACER!!
    }
}
