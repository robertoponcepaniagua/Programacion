package com.juego.modelo;

public class Combate {

    public void atacaPrimero(Personaje p1, Personaje p2) {
        if (p1.getVelocidad() > p2.getVelocidad()) {
            p1.atacar(p2);
        } else {
            p2.atacar(p1);
        }
    }

}
