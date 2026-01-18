package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class DanioLD implements IHabilidad {
    private String nombre;
    private String descripcion;
    private int poder;
    private int usosActuales;
    private int usosMax;
    private String escalado;

    public DanioLD (String nombre, String descripcion, int poder, int usosMax, String escalado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poder = poder;
        this.usosActuales = usosMax;
        this.usosMax = usosMax;
        this.escalado = escalado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getUsosActuales() {
        return usosActuales;
    }

    public void setUsosActuales(int usosActuales) {
        this.usosActuales = usosActuales;
    }

    public int getUsosMax() {
        return usosMax;
    }

    public void setUsosMax(int usosMax) {
        this.usosMax = usosMax;
    }

    public String getEscalado() {
        return escalado;
    }

    public void setEscalado(String escalado) {
        this.escalado = escalado;
    }

    //-----------------------------------------------------------------------
    @Override
    public void infoHabilidad() {
        System.out.println("Nombre:       "+ nombre);
        System.out.println("Descripción:  "+ descripcion);
        System.out.println("Poder:        "+ poder);
        System.out.println("Usos:         "+ usosActuales+ " / " + usosMax);
    }

    @Override
    public String nombreHabilidad() {
        return nombre;
    }

    @Override
    public boolean usar() {
        if (usosActuales > 0) {
            usosActuales--;
            return true;
        }
        return false;
    }
    @Override
    public int escaladoPoder(Personaje pj) {
        double bonus = 0;

        switch (escalado) {
            case "fuerza":
                bonus = pj.getFuerza() * 4.2;
                break;

            case "defensa":
                bonus = pj.getDefensa() * 3.5;
                break;

            case "inteligencia":
                bonus = pj.getInteligencia() * 4.5;
                break;

            case "destreza":
                bonus = pj.getDestreza() * 4.5;
                break;

            case "velocidad":
                bonus = pj.getVelocidad() * 3.8;
                break;
        }

        return (int) Math.round(bonus);
    }
    @Override
    public String getTipo() {
        return "DanioLD";
    }
}