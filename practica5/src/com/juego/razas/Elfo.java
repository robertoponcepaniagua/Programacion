package com.juego.razas;

import com.juego.modelo.Personaje;

public class Elfo implements IRaza {
    //Vida
    private int vidaBase;
    //Fuerza
    private int baseFuerza;
    //Defensa
    private int baseDefensa;
    //Inteligencia
    private int baseInteligencia;
    //Destreza
    private int baseDestreza;
    //Velocidad
    private int baseVelocidad;

    public Elfo() {
        this.vidaBase = 90;
        this.baseFuerza = 4;
        this.baseDefensa = 3;
        this.baseInteligencia = 6;
        this.baseDestreza = 7;
        this.baseVelocidad = 7;
    }
    //---------------------------------------GET Y SET---------------------------------------------

    public int getVidaBase() {
        return vidaBase;
    }
    public void setVidaBase(int vidaMax) {
        this.vidaBase = vidaMax;
    }

    public int getBaseFuerza() {
        return baseFuerza;
    }
    public void setBaseFuerza(int baseFuerza) {
        this.baseFuerza = baseFuerza;
    }

    public int getBaseDefensa() {
        return baseDefensa;
    }
    public void setBaseDefensa(int baseDefensa) {
        this.baseDefensa = baseDefensa;
    }

    public int getBaseInteligencia() {
        return baseInteligencia;
    }

    public void setBaseInteligencia(int baseInteligencia) {
        this.baseInteligencia = baseInteligencia;
    }

    public int getBaseDestreza() {
        return baseDestreza;
    }

    public void setBaseDestreza(int baseDestreza) {
        this.baseDestreza = baseDestreza;
    }

    public int getBaseVelocidad() {
        return baseVelocidad;
    }

    public void setBaseVelocidad(int baseVelocidad) {
        this.baseVelocidad = baseVelocidad;
    }

    @Override
    public void infoRaza() {
        System.out.print("Vida: "+getVidaBase());
        System.out.print("Fuerza: "+getBaseFuerza());
        System.out.print("Defensa: "+getBaseDefensa());
        System.out.print("Inteligencia: "+getBaseInteligencia());
        System.out.print("Destreza: "+getBaseDestreza());
        System.out.print("Velocidad: "+getBaseVelocidad());
    }
}
