package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.modelo.Personaje;

public class Guerrero extends Clase {


    public Guerrero() {
        super(120, 3, 4, 0, 0, 1);
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

        DanioCC GolpeEspada = new DanioCC("Golpe de espada","Ataque cuerpo a cuerpo con la espada que inflige daño físico constante al enemigo.",15,5,"fuerza");
        CuraCC PersistenciaGuerrera = new CuraCC("Persistencia Guerrera","El guerrero canaliza su fuerza interior para recuperar Vitalidad",10,3,"inteligencia");
        DanioLD GuillotinaSangrienta = new DanioLD("Guillotina Sangrienta","El guerrero ejecuta un golpe brutal descendente que inflige un daño devastador",35,1,"fuerza");

        addHabilidades(GolpeEspada);
        addHabilidades(PersistenciaGuerrera);
        addHabilidades(GuillotinaSangrienta);
    }
}
