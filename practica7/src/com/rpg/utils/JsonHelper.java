package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonHelper {
    private LoggerCustom loggerCustom;
    public JsonHelper() {
        this.loggerCustom = new LoggerCustom("practica7/src/com/rpg/utils/JsonHelper.java");
    }

    public <T> List<T> readList(String path, Class<T> tClass){
        try (Reader reader = new FileReader(path)){
            Type typetoken = TypeToken.getParameterized(List.class, tClass).getType();
            Gson gson = new Gson();
            return  gson.fromJson(reader, typetoken);
        } catch (IOException e){
            loggerCustom.escribirFichero("Error","No se ha encontrado el archivo " + path);
            System.out.println("No se ha encontrado el archivo");
            return List.of();
        }
    }

    public <T> void writeList(String path, List<T> lista) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (Writer writer = Files.newBufferedWriter(Paths.get(path))) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
