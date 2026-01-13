package com.juego.clases;

import com.juego.habilidades.Habilidad;
import com.juego.habilidades.IHabilidad;
import com.juego.razas.Raza;

import java.util.ArrayList;

public class Clase {
    //Vida
    private int Vida;
    private int VidaMax;
    //Fuerza
    private int Fuerza;
    //Defensa
    private int Defensa;
    //Inteligencia
    private int Inteligencia;
    //Destreza
    private int Destreza;
    //Velocidad
    private int Velocidad;
    //Habilidades
    private ArrayList<IHabilidad> habilidades;

    public Clase(int vidaMax, int fuerza, int defensa, int destreza, int inteligencia, int velocidad) {
        this.VidaMax = vidaMax;
        this.Vida = vidaMax; // quiero empezar con la vida al completo
        this.Fuerza = fuerza;
        this.Defensa = defensa;
        this.Destreza = destreza;
        this.Inteligencia = inteligencia;
        this.Velocidad = velocidad;
        this.habilidades = new ArrayList<>();
    }

    //-------------------------------------------------GET Y SET----------------------------------------------------


    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getVidaMax() {
        return VidaMax;
    }

    public void setVidaMax(int vidaMax) {
        VidaMax = vidaMax;
    }

    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int fuerza) {
        Fuerza = fuerza;
    }

    public int getDefensa() {
        return Defensa;
    }

    public void setDefensa(int defensa) {
        Defensa = defensa;
    }

    public int getInteligencia() {
        return Inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        Inteligencia = inteligencia;
    }

    public int getDestreza() {
        return Destreza;
    }

    public void setDestreza(int destreza) {
        Destreza = destreza;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(int velocidad) {
        Velocidad = velocidad;
    }

    public ArrayList<IHabilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<IHabilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public void addHabilidades(IHabilidad h) {
        habilidades.add(h);
    }
}
