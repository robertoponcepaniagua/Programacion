package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.modelo.Personaje;

public class Monje extends Clase {

    public Monje() {
        super(110,2,2,1,0,3);
    }


    public void bonusClase(Personaje pj) {
        pj.setFuerza(pj.getFuerza() + getFuerza());
        pj.setDefensa(pj.getDefensa() + getDefensa());
        pj.setDestreza(pj.getDestreza() + getDestreza());
        pj.setInteligencia(pj.getInteligencia() + getInteligencia());
        pj.setVelocidad(pj.getVelocidad() + getVelocidad());
    }
    public void cargarHabilidades() {

        DanioCC SaltoAgil = new DanioCC("Salto Ágil","Salta hacia un enemigo, golpeándole con su bastón",15,5,"fuerza");
        CuraCC Meditacion = new CuraCC("Meditación","El monje canaliza energía interna para curarse",12,3,"inteligencia");
        DanioLD MilBrazos = new DanioLD("Mil Brazos","El monje se concentra y aparecen brazos gigantes de su espalda que atacan a distancia.",30,1,"fuerza");

        addHabilidades(SaltoAgil);
        addHabilidades(Meditacion);
        addHabilidades(MilBrazos);
    }
}
