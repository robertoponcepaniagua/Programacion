package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Guerrero extends Clase implements IClase {


    public Guerrero() {
        super(120, 3, 4, 0, 0, 1);
    }


    Habilidad golpeEspada = new Habilidad("Golpe de espada","Ataque cuerpo a cuerpo con la espada que inflige daño físico constante al enemigo.",15,"Daño Cuerpo a Cuerpo",5,"fuerza");

    Habilidad Persistencia = new Habilidad("Persistencia Guerrera","El guerrero canaliza su fuerza interior para recuperar Vitalidad",10,"Cura Cuerpo a Cuerpo",3,"inteligencia");

    Habilidad GuillotinaSangrienta = new Habilidad("Guillotina Sangrienta", "El guerrero ejecuta un golpe brutal descendente que inflige un daño devastador",35,"Daño a Distancia",1,"fuerza");
}
