package com.juego.clases;

import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

public class Mago extends Clase implements IClase{

    public Mago(){
        super(90,0,1,0,3,1);
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

        DanioCC Descarga = new DanioCC("Descarga","Estallido mágico a corta distancia",15,5,"inteligencia");
        CuraCC Sanar = new CuraCC("Sanar","Sanación mágica",12,3,"inteligencia");
        DanioLD LlamaradaFinal = new DanioLD("Llamarada Final","Llamarada potente como la llama de un dragón",35,1,"inteligencia");

        addHabilidades(Descarga);
        addHabilidades(Sanar);
        addHabilidades(LlamaradaFinal);
    }
}
