package com.rpg.utils;

import com.rpg.handler.DatoInvalidoException;
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
    private LoggerCustom loggerCustom;

    public TxtHelper() throws IOException {
        this.file = new File("practica7/Ficheros/ciudades.txt"); //para representar el fichero que se quiere leer.
        this.fr = new FileReader(file);  //para poder leer un fichero
        this.br = new BufferedReader(fr);  // para leer más de un caracter
        this.loggerCustom = new LoggerCustom("practica7/src/com/rpg/utils/TxtHelper.java"); // PARA ESCRIBIR LOS ERRORES, LE PASAMOS LA RUTA, PARA ESCRIBIRLA EN EL FICHERO DE LOG
    }

    // FUNCIONAMIENTO: SEPARA CIUDADES EN ";", COMPRUEBA QUE NO HAY NINGUNA LÍNEA QUE SEA CORRUPTA, SI HAY LÍNEA CORRUPTA NO ABORTA DEJANDO UN MENSAJE DE ERROR EN LOG
    public List<Ciudad> leerLineas() {
        List<Ciudad> ciudades = new ArrayList<>();
        try (var file = new BufferedReader(new FileReader("practica7/Ficheros/ciudades.txt"))) { //abre y cierra el fichero automáticamente

            String linea;
            while ((linea = file.readLine()) != null) {

                if (linea.startsWith("#") || linea.isBlank()) continue; //si la linea empieza por # o es un espacio en blanco el codigo sigue

                try {
                    String[] partes = linea.split(";"); //separa los campos para poder obtener todos los campos de la Ciudad en este caso.

                    //crear una validación de líneas corruptas aquí
                    if (partes.length != 4) {
                        throw new FormatoInvalidoException("Línea corrupta: " + linea);
                    }

                    String nombre = partes[0];
                    //como necesitamos un tipo int hacemos una conversión de la parte 2 y 4
                    int poblacion = Integer.parseInt(partes[1]);
                    String clima = partes[2];
                    int nivelRiesgo = Integer.parseInt(partes[3]);

                    Ciudad c = new Ciudad(nombre, poblacion, clima, nivelRiesgo);
                    ciudades.add(c);

                } catch (FormatoInvalidoException e) {
                    loggerCustom.escribirFichero("ERROR","Linea corrupta en " + linea);
                    System.out.println("Formato invalido");
                }
            }
        } catch (IOException e) {
            loggerCustom.escribirFichero("ERROR","No se ha podido abrir el fichero");
        }
        return ciudades;
    }

    //FUNCIONAMIENTO: ESCRIBE EL FICHERO DE EL OBJETO QUE LE PASES, LO ESCRIBE CON LOS ATIBUTOS Y PONIENDO UN ";" EN MEDIO
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
