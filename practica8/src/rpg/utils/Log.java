package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private String path;

    // EL FORMATO TIENE QUE SER [FECHA] [TIPO (INFO O ERROR) ] [PAQUETE] MENSAJE
    public Log(String path) {
        this.path = path; //cada path es diferente así que le paso por el constructor el path
    }


    public void escribirFichero(String tipo, String mensaje) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter("practica8/Ficheros/info.log", true))) {

            String paquete = Thread.currentThread()
                    .getStackTrace()[2]
                    .getClassName();

            //FUNCION: FORMATEA LA HORA PARA SER PRECIOS YA QUE AL TENER MUCHOS LOGS NO SE VE CUANDO ES DE CADA MOMENTO
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String fecha = LocalDateTime.now().format(formatter);

            //la ciudad que la pasemos la juntamos y hacemos un ; entre cada atrinuto
            file.write("[" + fecha + "] [" + tipo + "] [" + paquete + "] ["+ path +"] "  + mensaje);
            //añadimos u salto de linea
            file.newLine();

        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero.");
        }
    }
}
