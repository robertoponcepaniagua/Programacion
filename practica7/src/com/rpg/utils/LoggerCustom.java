package com.rpg.utils;

import com.rpg.model.Ciudad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class LoggerCustom {
    private String path; //lo creo en diferentes clases y le pongo por el constructor el path


    // EL FORMATO TIENE QUE SER [FECHA] [TIPO (INFO O ERROR) ] [PAQUETE] MENSAJE
    public LoggerCustom(String path) {
        this.path = path; //cada path es diferente así que le paso por el constructor el path
    }


    public void escribirFichero(String tipo, String mensaje) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter("practica7/Ficheros/errores.log", true))) {

            String paquete = Thread.currentThread()
                    .getStackTrace()[2]
                    .getClassName();

            //la ciudad que la pasemos la juntamos y hacemos un ; entre cada atrinuto
            file.write("[" + LocalDate.now() + "] [" + tipo + "] [" + paquete + "] ["+ path +"] "  + mensaje);
            //añadimos u salto de linea
            file.newLine();

            System.out.println("Escritura realizada.");

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero.");
        }
    }
}
