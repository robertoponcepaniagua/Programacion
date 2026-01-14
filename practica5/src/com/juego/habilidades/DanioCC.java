package com.juego.habilidades;

import com.juego.modelo.Personaje;

public class DanioCC implements IHabilidad {
    private String nombre;
    private String descripcion;
    private int poder;
    private int usosActuales;
    private int usosMax;
    private String escalado;

    public DanioCC(String nombre, String descripcion, int poder, int usosMax, String escalado) {
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
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Poder de la Habilidad: " + poder);
        System.out.println("Usos Actuales: " + usosActuales);
        System.out.println("Usos Max " + usosMax);
    }
    //Para restar el uso de las habilidades
    public void restarUso() {
        if (usosActuales > usosMax) {
            usosActuales--;
        }
    }

    @Override
    public String nombreHabilidad() {
        return nombre;
    }

    @Override
    public boolean usar() {
        if (usosActuales > usosMax) {
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
                bonus = pj.getFuerza() * 1.4;
                break;

            case "defensa":
                bonus = pj.getDefensa() * 1.3;
                break;

            case "inteligencia":
                bonus = pj.getInteligencia() * 1.4;
                break;

            case "destreza":
                bonus = pj.getDestreza() * 1.3;
                break;

            case "velocidad":
                bonus = pj.getVelocidad() * 1.3;
                break;
        }

        return (int) Math.round(bonus);
    }
    @Override
    public String getTipo() {
        return "DanioCC";
    }
}