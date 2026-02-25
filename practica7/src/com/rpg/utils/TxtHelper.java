package com.rpg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtHelper {
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public TxtHelper() throws IOException {
        this.file = new File("practica7/Ficheros/ciudades.txt"); //para representar el fichero que se quiere leer.
        this.fr = new FileReader(file);  //para poder leer un fichero
        this.br = new BufferedReader(fr);  // para leer más de un caracter
    }

    public void leerLineas() throws IOException {
        String linea = br.readLine();
        while (linea != null) {
            System.out.print(linea);
            linea = br.readLine();
        }
        fr.close();
    }

    // TODO: ELEGIR UNA DE LOS 2

    //public void leerLineas2() {
    //    try {
    //        var file = new BufferedReader(new FileReader("practica7/Ficheros/ciudades.txt"));

    //        String linea;
    //        while ((linea = file.readLine()) != null)
    //            System.out.println(linea);

    //        file.close();
    //    } catch (IOException e) {
    //        System.out.println("No se ha podido abrir el fichero.");
    //    }
    //}
}
