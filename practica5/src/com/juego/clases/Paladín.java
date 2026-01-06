package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Paladín extends Clase implements IClase {

    public Paladín() {
        super(115,2,3,0,1,2);
    }

    Habilidad Golpe = new Habilidad("Golpe","Golpe básico pero temible",16,"Daño Cuerpo a Cuerpo",5,"fuerza");

    Habilidad VoluntadInquebrantable = new Habilidad("Voluntad Inquebrantable","La voluntad del Paladin hace que recupere vitalidad y luche con más ganas",12,"Cura Cuerpo a Cuerpo",3,"inteligencia");

    Habilidad JuicioDivino  = new Habilidad("Juicio Divino","El paladín invoca una espada de luz sagrada que cae del cielo sobre el enemigo",30,"Daño a Distancia",1,"fuerza");
}
