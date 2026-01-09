package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.presentacion.Vista;

public class Combate {

    //metodo para saber quien tiene más velocidad, quien tenga más velocidad ataca antes
    public void atacaPrimero(Personaje p1, Personaje p2) {
        if (p1.getVelocidad() > p2.getVelocidad()) {
            p1.atacar(p2);
        } else {
            p2.atacar(p1);
        }
    }
}
