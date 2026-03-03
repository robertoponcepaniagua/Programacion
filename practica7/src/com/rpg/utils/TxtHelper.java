package com.rpg.utils;

import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.Ciudad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    private File file;
    private FileReader fr;
    private BufferedReader br;

    public TxtHelper() throws IOException {
        this.file = new File("practica7/Ficheros/ciudades.txt"); //para representar el fichero que se quiere leer.
        this.fr = new FileReader(file);  //para poder leer un fichero
        this.br = new BufferedReader(fr);  // para leer más de un caracter
    }

    //public void leerLineas() throws IOException {
    //    String linea = br.readLine();
    //    while (linea != null) {
    //        System.out.print(linea);
    //        linea = br.readLine();
    //    }
    //    fr.close();
    //}

    public void leerLineas() {
        try {
            var file = new BufferedReader(new FileReader("practica7/Ficheros/ciudades.txt"));

            String linea;
            while ((linea = file.readLine()) != null)
                System.out.println(linea);

            file.close();
        } catch (IOException e) {
            System.out.println("No se ha podido abrir el fichero.");
        }
    }

    //TODO: hay que hacer este metodo para poder leer bien el fichero.txt ya que necesito convertir la información del fichero txt en ciudades.
    //Necesito separar las ciudades en ";", comprobar que no hay ninguna línea que sea corrucpa y en el caso que lo sea no puede abortar y debe seguir con su funcionamiento, pero dejando un mensaje de error en el log
    public List<Ciudad> leerLineas2() {
        List<Ciudad> ciudades = new ArrayList<>();
        try {
            var file = new BufferedReader(new FileReader("practica7/Ficheros/ciudades.txt"));

            String linea;
            while ((linea = file.readLine()) != null) {
                try {
                    String[] partes = linea.split(";"); //separa los campos para poder obtener todos los campos de la Ciudad en este caso.

                    //crear una validación de líneas corruptas aquí
                    if (partes.length != 5) {
                        throw new FormatoInvalidoException("Línea corrupta: " + linea);
                    }

                    String nombre = partes[1];
                    //como necesitamos un tipo int hacemos una conversión de la parte 2 y 4
                    int poblacion = Integer.parseInt(partes[2]);
                    String clima = partes[3];
                    int nivelRiesgo = Integer.parseInt(partes[4]);

                    Ciudad c = new Ciudad(nombre, poblacion, clima, nivelRiesgo);
                    ciudades.add(c);
                }catch (FormatoInvalidoException f) {
                    //supongo que aquí hay que escribir en el log
                }
            }
            file.close();
        } catch (IOException e) {
            System.out.println("No se ha podido abrir el fichero.");
        }
        return ciudades;
    }

    //le pasamos una ciudad
    public void escribirFichero(Ciudad c) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter("practica7/Ficheros/ciudades.txt", true))) {

            //la ciudad que la pasemos la juntamos y hacemos un ; entre cada atrinuto
            file.write(c.getNombre() + ";" + c.getPoblacion() + ";" + c.getClima() + ";" + c.getNivelRiesgo());
            //añadimos u salto de linea
            file.newLine();

            System.out.println("Escritura realizada.");

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero.");
        }
    }
}
