package com.juego.razas;

import com.juego.modelo.Personaje;

public class Humano implements IRaza {
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

    public Humano() {
        this.vidaBase = 100;
        this.baseFuerza = 5;
        this.baseDefensa = 5;
        this.baseInteligencia = 5;
        this.baseDestreza = 5;
        this.baseVelocidad = 5;
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
