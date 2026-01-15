package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.Habilidad;
import com.juego.habilidades.IHabilidad;
import com.juego.presentacion.Vista;

import java.util.List;
import java.util.Scanner;

public class Combate {

    //metodo para saber quien tiene más velocidad, quien tenga más velocidad ataca antes
    public Personaje masRapido(Personaje p1, Personaje p2) {
        if (p1.getVelocidad() > p2.getVelocidad()) {
            return p1;
        } else if (p2.getVelocidad() > p1.getVelocidad()) {
            return p2;
        } else {
            // Si tienen misma velocidad se decide random
            if (Math.random() < 0.5) {
                return p1;
            } else {
                return p2;
            }
        }
    }



    //-------------------------------------COMBATE-------------------------------
    public Personaje combate(Personaje pj1 ,Personaje pj2) {

        Personaje primero = masRapido(pj1, pj2);
        Personaje segundo = null; //Inicializamos con null

        if (primero == pj1) { //si primero es pj1
        segundo = pj2;  //segundo es pj2
        } else {  //si no
            segundo = pj1; // segundo es pj1
        }

        //Mientras los 2 estén -----VIVOS---- sigue el combate, si uno de ellos muere termina.
        while (primero.getVida() > 0 && segundo.getVida() > 0) {
            atacar(primero , segundo);

            //El personaje ganador es el que sale de la pelea
            if (segundo.getVida() <= 0) {
                return primero;
            }

            atacar(segundo , primero);

            if (primero.getVida() <= 0) {
                return segundo;
            }
        }
        return null;
    }
    public void atacar(Personaje atacante, Personaje defensor) {
        Vista vista = new Vista();

        IHabilidad habilidadElegida = vista.elegirHabilidad(atacante);
        habilidadElegida.usar();

        int bonus = habilidadElegida.escaladoPoder(atacante);

        switch (habilidadElegida.getTipo()) {
            case "DanioCC":
            case "DanioLD":
                defensor.recibirAtaque(habilidadElegida, bonus);

                //IMPLEMENTAR INFORMACIÓN DE LOS ATAQUES, PODER CUANTO QUITA ETC....
                System.out.println(atacante.getNombre() + "usa " + habilidadElegida.nombreHabilidad() + " el ataque quita de daño: " + (habilidadElegida.getPoder() + bonus));
                break;

            case "CuraCC":
                atacante.curar(habilidadElegida, bonus);
                System.out.println(atacante.getNombre() + " usa " + habilidadElegida.nombreHabilidad() +
                        " y cura: " + (habilidadElegida.getPoder() + bonus));
                break;
            default:
                System.out.println("Tipo de habilidad desconocido");
        }
    }
}
