package com.juego.presentacion;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidad;
import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Vista {
    Scanner sc = new Scanner(System.in);
    public Habilidad elegirHabilidad(Personaje pj) {
        //Se crea una clase que coge la clase del personaje seleccionado.
        Clase clasepj = pj.getClase();
        for (int i = 0; i < clasepj.getHabilidades().size(); i++) {
            System.out.print(i+". - ");
            clasepj.getHabilidades().get(i).infoHabilidad();
            System.out.println();
            System.out.println();
        }
        int opcion = sc.nextInt();
        return null;
    }
}
