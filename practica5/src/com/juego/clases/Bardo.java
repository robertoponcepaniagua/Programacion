package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Bardo extends Clase implements IClase {

    public Bardo () {
        super(90,0,2,0,3,3);

        DanioCC NotaDePoder = new DanioCC("Nota de Poder", "Dispara una onda de sonido en línea que inflige daño a los enemigos",15,5,"inteligencia");
        CuraCC NotaVital = new CuraCC("Nota Vital","Armonía que restaura gran cantidad de Vitalidad",18,3,"inteligencia");
        DanioLD Crescendo =  new DanioLD("Crescendo","Ataque de área que aturde a todos los enemigos",30,5,"inteligencia");

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
