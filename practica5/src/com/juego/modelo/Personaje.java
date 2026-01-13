package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidad;
import com.juego.razas.IRaza;
import com.juego.razas.Raza;

import java.util.ArrayList;
import java.util.Scanner;

public class Personaje {
    private String nombre;
    //Vida
    private int vida;
    private int vidaMax;
    //Fuerza
    private int fuerza;
    //Defensa
    private int defensa;
    //Inteligencia
    private int inteligencia;
    //Destreza
    private int destreza;
    //Velocidad
    private int velocidad;

    private Clase clase;
    private IRaza raza;

    public Personaje (String nombre, IRaza raza, Clase clase) {
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
    }
    //GET Y SET

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public IRaza getRaza() {
        return raza;
    }

    public void setRaza(IRaza raza) {
        this.raza = raza;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void Corazones() {
        int MaxCorazones = vidaMax / 10; // Calculo cuantos corazones max tiene "♥"
        int corazones = vida / (vidaMax / MaxCorazones); // bloques llenos dependiendo de la vida actual
        int Corazonesvacios = MaxCorazones - corazones; // Corazones Vacios

        //LLENO
        for (int i = 0; i < corazones ; i++) {
            System.out.print("♥");
        }

        //VACIO
        for (int i = 0; i < Corazonesvacios ; i++) {
            System.out.print("♡");
        }
    }

    public void atacar (Personaje pj) {

    }
}
