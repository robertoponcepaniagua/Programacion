package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Druida extends Clase implements IClase {

    public Druida () {
        super(100,2,2,0,1,2);

        Habilidad Zarzal = new Habilidad("Zarzal opresor","Golpea el suelo, infligiendo daño mágico a los enemigos cercanos",20,"Daño Cuerpo a Cuerpo",5,"fuerza");

        Habilidad Drenado = new Habilidad("Drenado","Drena la Fuerza vital del suelo para recuperar Vitalidad",15,"Cura Cuerpo a Cuerpo",3,"inteligencia");

        Habilidad GarrasDeLaNaturaleza = new Habilidad("Garras de la naturaleza","oleada colosal de zarzas y pinchos que avanza lentamente, otrogando grandes heridas",30,"Daño a Distancia",1,"inteligencia");

        addHabilidades(Zarzal);
        addHabilidades(Drenado);
        addHabilidades(GarrasDeLaNaturaleza);
    }
}
