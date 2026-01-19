package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Paladín extends Clase implements IClase {

    public Paladín() {
        super(115,2,3,0,1,2);


        // Habilidades Paladin
        DanioCC Golpe = new DanioCC("Golpe","Golpe básico pero temible",16,5,"fuerza");
        CuraCC VoluntadInquebrantable = new CuraCC("Voluntad Inquebrantable","La voluntad del paladín hace que recupere vitalidad y luche con más ganas",12,3,"inteligencia");
        DanioLD JuicioDivino = new DanioLD("Juicio Divino","El paladín invoca una espada de luz sagrada que cae del cielo sobre el enemigo",30,1,"fuerza");

        addHabilidades(Golpe);
        addHabilidades(VoluntadInquebrantable);
        addHabilidades(JuicioDivino);
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
