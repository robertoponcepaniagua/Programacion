package com.juego.habilidades;

public class CuraCP implements IHabilidad {
    private String nombre;
    private String descripcion;
    private int poder;
    private int usosActuales;
    private int usosMax;
    private String escalado;

    public CuraCP (String nombre, String descripcion, int poder, String tipoHabilidad, int usosMax, String escalado) {
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
    public int usos() {
        return 0;
    }
}