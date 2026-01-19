package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Sacerdote extends Clase implements IClase{

    public Sacerdote () {
        super(95,0,1,0,3,1);

        // Habilidades Sacerdote
        DanioCC RafagaRadiante = new DanioCC("Ráfaga Radiante","Espada celestial que atraviesa a los enemigos",13,5,"inteligencia");
        CuraCC GraciaCelestial = new CuraCC("Gracia celestial","Al rezar es bendecida por los dioses y le otorgan vitalidad",19,3,"inteligencia");
        DanioLD VeredictoDivino = new DanioLD("Veredicto divino","Al rezar invoca una lluvia de espadas sagradas que purifica la zona",30,1,"inteligencia");

        addHabilidades(RafagaRadiante);
        addHabilidades(GraciaCelestial);
        addHabilidades(VeredictoDivino);
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
