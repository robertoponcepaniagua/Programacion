package com.juego.clases;

import com.juego.habilidades.*;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Bardo extends Clase implements IClase {

    public Bardo () {
        super(90,0,2,0,3,3);
    }

    @Override
    public void bonusClase(Personaje pj) {
        pj.setFuerza(pj.getFuerza() + getFuerza());
        pj.setDefensa(pj.getDefensa() + getDefensa());
        pj.setDestreza(pj.getDestreza() + getDestreza());
        pj.setInteligencia(pj.getInteligencia() + getInteligencia());
        pj.setVelocidad(pj.getVelocidad() + getVelocidad());
    }
    @Override
    public void cargarHabilidades() {

        DanioCC NotaDePoder = new DanioCC("Nota de Poder", "Dispara una onda de sonido en línea que inflige daño a los enemigos",15,5,"inteligencia");
        CuraCC NotaVital = new CuraCC("Nota Vital","Armonía que restaura gran cantidad de Vitalidad",18,3,"inteligencia");
        DanioLD Crescendo =  new DanioLD("Crescendo","Ataque de área que aturde a todos los enemigos",30,1,"inteligencia");

        this.addHabilidades(NotaDePoder);
        this.addHabilidades(NotaVital);
        this.addHabilidades(Crescendo);
    }
}
