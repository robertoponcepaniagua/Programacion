package com.juego.habilidades;

import com.juego.modelo.Personaje;

public interface IHabilidad {
    //Para restar el uso de las habilidades
    boolean usar();
    int escaladoPoder(Personaje pj);
    void infoHabilidad();
    void nombreHabilidad();
}
