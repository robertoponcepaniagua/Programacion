package com.juego.clases;

import com.juego.habilidades.Habilidad;

public class Monje extends Clase implements IClase {

    public Monje() {
        super(110,2,2,1,0,3);
    }

    Habilidad SaltoAgil = new Habilidad("Salto Ágil","Salta hacia un enemigo, golpeandole con sus bastón",15,"Daño Cuerpo a Cuerpo",5,"fuerza");

    Habilidad Meditacion = new Habilidad("Meditación","El monje canaliza energía interna para curarse",12,"Cura Cuerpo a Cuerpo",3,"inteligencia");

    Habilidad MilBrazos = new Habilidad("Mil Brazos","El Monje se concentra y aparecen brazos gigantes de su espalda que atacan a distancia.",30,"Daño a Distancia",1,"fuerza");
}
