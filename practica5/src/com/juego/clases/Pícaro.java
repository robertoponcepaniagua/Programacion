package com.juego.clases;

import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Pícaro extends Clase implements IClase{

    public Pícaro() {
        super(105,0,1,3,0,4);

        Habilidad Cuchillada = new Habilidad("Cuchillada","Acuchilla al enemigo a alta velocidad",17,"Daño Cuerpo a Cuerpo",5,"velocidad");

        Habilidad SangreRobada  = new Habilidad("Sangre Robada","Roba vitalidad del enemigo para curarse", 10,"Cura Cuerpo a Cuerpo",3,"inteligencia");

        Habilidad MarcaSombra = new Habilidad("Marca Sombra","Convierte su sombra en clones que atacan al enemigo marcado, los clones no se pueden diferenciar del real",35,"Daño a Distancia",1,"destreza");

        addHabilidades(Cuchillada);
        addHabilidades(SangreRobada);
        addHabilidades(MarcaSombra);
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
