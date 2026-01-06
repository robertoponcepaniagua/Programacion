package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Sacerdote extends Clase implements IClase{

    public Sacerdote () {
        super(95,0,1,0,3,1);
    }

    Habilidad RafagaRadiante = new Habilidad("Ráfaga Radiante","Espada celestial que atraviesa a los enemigos",15,"Daño Cuerpo a Cuerpo",5,"inteligencia");

    Habilidad GraciaCelestial = new Habilidad("Gracia celestial","Al Rezar es bendecida por los Dioses y le otorgan Vitalidad",15,"Cura Cuerpo a Cuerpo",3,"inteligencia");

    Habilidad VeredictoDivino = new Habilidad("Veredicto divino","Al rezar invoca una lluvia de espadas sagradas que purifica la zona",30,"Daño a Distancia",1,"inteligencia");
}
