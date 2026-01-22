package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.modelo.Personaje;

public class Druida extends Clase {

    public Druida () {
        super(100,2,2,0,1,2);
    }

    public void bonusClase(Personaje pj) {
        pj.setFuerza(pj.getFuerza() + getFuerza());
        pj.setDefensa(pj.getDefensa() + getDefensa());
        pj.setDestreza(pj.getDestreza() + getDestreza());
        pj.setInteligencia(pj.getInteligencia() + getInteligencia());
        pj.setVelocidad(pj.getVelocidad() + getVelocidad());
    }
    @Override
    public void cargarHabilidades() {

        DanioCC ZarzalOpresor = new DanioCC("Zarzal opresor","Golpea el suelo, infligiendo daño mágico a los enemigos cercanos",20,5,"fuerza");
        CuraCC Drenado = new CuraCC("Drenado","Drena la Fuerza vital del suelo para recuperar Vitalidad",15,3,"inteligencia");
        DanioLD GarrasDeLaNaturaleza = new DanioLD("Garras de la naturaleza","Oleada colosal de zarzas y pinchos que avanza lentamente, otorgando grandes heridas",30,1,"inteligencia");

        addHabilidades(ZarzalOpresor);
        addHabilidades(Drenado);
        addHabilidades(GarrasDeLaNaturaleza);
    }
}
