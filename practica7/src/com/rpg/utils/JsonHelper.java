package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonHelper {
    //ATRIBUTOS
    private Reader reader;
    private List<Item> lista;

    public JsonHelper() throws IOException {
        //CREAMOS EL LECTOR DEL ARCHIVO
        reader = Files.newBufferedReader(Paths.get("practica7/Ficheros/ciudades.json"));

        //USAMOS TYPETOKEN PARA DECIRLE A GSON QUE QUEREMOS UNA LISTA DE CIUDADES   (CUIDADO ES UNA LISTA)
        lista = new Gson().fromJson(reader, new TypeToken<List<Ciudad>>(){}.getType());

        //IMPRIMIMOS PARA COMPROBAR
        for (Ciudad c : lista) {
            //Seguir
            System.out.print("Nombre Ciudad: ");
        }
    }
}
