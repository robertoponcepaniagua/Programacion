package com.juego.clases;

import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Bardo extends Clase implements IClase {

    public Bardo () {
        super(90,0,2,0,3,3);

        Habilidad NotaDePoder = new Habilidad("Nota de Poder", "Dispara una onda de sonido en línea que inflige daño a los enemigos",15,"Daño Cuerpo a Cuerpo",5,"inteligencia");

        Habilidad NotaVital = new Habilidad("Nota Vital","Armonía que restaura gran cantidad de Vitalidad",18,"Cura Cuerpo a Cuerpo",3,"inteligencia");

        Habilidad Crescendo =  new Habilidad("Crescendo","Ataque de área que aturde a todos los enemigos",30,"Daño a Distancia",5,"inteligencia");

        addHabilidades(NotaDePoder);
        addHabilidades(NotaVital);
        addHabilidades(Crescendo);
    }

    @Override
    public void bonusClase(Personaje pj) {
        pj.setFuerza(pj.getFuerza() + getFuerza());
        pj.setDefensa(pj.getDefensa() + getDefensa());
        pj.setDestreza(pj.getDestreza() + getDestreza());
        pj.setInteligencia(pj.getInteligencia() + getInteligencia());
        pj.setVelocidad(pj.getVelocidad() + getVelocidad());
    }
}
