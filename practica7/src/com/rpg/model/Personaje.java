package com.rpg.model;

import java.util.Arrays;
import java.util.List;

public class Personaje {
    private String nombre;
    private String raza;
    private int nivel;
    private List<Item> equipo;
    private Ciudad ciudad;

    public Personaje(String nombre, String raza, int nivel, List<Item> equipo, Ciudad ciudad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipo = equipo;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Item> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Item> equipo) {
        this.equipo = equipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return nombre + " | Raza: " + raza + " | Nivel: " + nivel + " | Equipo: " + equipo;
    }
}
