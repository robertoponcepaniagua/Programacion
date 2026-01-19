package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.IHabilidad;
import com.juego.razas.IRaza;

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

        aplicarBonificaciones();

        this.vida = this.vidaMax; //empieza con la vida llena

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

    public void aplicarBonificaciones() {

        this.vidaMax = clase.getVidaMax() + raza.getVidaBase();
        this.fuerza = clase.getFuerza() + raza.getBaseFuerza();
        this.defensa = clase.getDefensa() + raza.getBaseDefensa();
        this.inteligencia = clase.getInteligencia() + raza.getBaseInteligencia();
        this.destreza = clase.getDestreza() + raza.getBaseDestreza();
        this.velocidad = clase.getVelocidad() + raza.getBaseVelocidad();
    }

    public void recibirAtaque (IHabilidad h, int bonus) {
        setVida((getVida() + defensa) - (h.getPoder() + bonus));
    }
    public void curar (IHabilidad h, int bonus) {
        if (vida >= vidaMax) {
            System.out.println("No puedes curar, estás full vida");
        } else {
            setVida((vida + h.getPoder() + bonus));
            System.out.println("Has sido curado por " + (h.getPoder() + bonus) + " puntos. Vida actual: " + vida);
        }
    }
}
