package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Mago extends Clase implements IClase{

    public Mago(){
        super(90,0,1,0,3,1);

        Habilidad Descarga = new Habilidad("Descarga","estallido mágico a corta distancia",15,"Daño Cuerpo a Cuerpo",5,"inteligencia");

        Habilidad Sanar = new Habilidad("Sanar","Sanación Magica",12,"Cura Cuerpo a Cuerpo",3,"inteligencia");

        Habilidad LlamaradaFinal = new Habilidad("Llamarada Final","Llamarada potente como la llama de un dragón",35,"Daño a Distancia",1,"inteligencia");

        addHabilidades(Descarga);
        addHabilidades(Sanar);
        addHabilidades(LlamaradaFinal);
    }
}
