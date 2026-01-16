package com.juego.habilidades;

public class Habilidad {
    private String nombre;
    private String descripcion;
    private int poder;
    private String tipoHabilidad;
    private int usosActuales;
    private int usosMax;
    private String escalado;

    public Habilidad (String nombre, String descripcion, int poder, String tipoHabilidad, int usosMax, String escalado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoHabilidad = tipoHabilidad;
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

    public String getTipoHabilidad() {
        return tipoHabilidad;
    }

    public void setTipoHabilidad(String tipoHabilidad) {
        this.tipoHabilidad = tipoHabilidad;
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
        System.out.println("Nombre        : " + nombre);
        System.out.println("Descripción   : " + descripcion);
        System.out.println("Poder         : " + poder);
        System.out.println("Tipo          : " + tipoHabilidad);
        System.out.println("Usos          : " + usosActuales + " / " + usosMax);
    }
    //Para restar el uso de las habilidades
    public void restarUso() {
        if (usosActuales > usosMax) {
            usosActuales--;
        }
    }
}
