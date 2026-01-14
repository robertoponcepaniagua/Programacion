package com.juego.razas;

import com.juego.modelo.Personaje;

public interface IRaza {
    void infoRaza();

    int getVidaBase();
    int getBaseFuerza();
    int getBaseDefensa();
    int getBaseInteligencia();
    int getBaseDestreza();
    int getBaseVelocidad();
}
