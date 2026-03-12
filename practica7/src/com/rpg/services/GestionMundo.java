package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.io.IOException;
import java.util.*;

public class GestionMundo {
    private Scanner sc;
    private JsonHelper jsonHelper;
    private TxtHelper txtHelper;
    private LoggerCustom loggerCustom;
    private List<Personaje> personajes;
    private List<Item> items;
    private List<Ciudad> ciudades;
    private Map<String, Item> catalogoItems;

    public GestionMundo() throws IOException, RecursoNoEncontradoException {
        //el scanner
        this.sc = new Scanner(System.in);

        //para escribir ficheros etc
        this.jsonHelper = new JsonHelper();
        this.txtHelper = new TxtHelper();
        this.loggerCustom = new LoggerCustom("practica7/src/com/rpg/services/GestionMundo.java");

        //array de los personjaes items...
        this.personajes = new ArrayList<>();
        this.items = new ArrayList<>();
        this.ciudades = new ArrayList<>();

        //como pide en la practica un hashmap
        this.catalogoItems = new HashMap<>();
        cargarTodo(); //para cargar cuando se crea
    }

    //esta función lo que hace es cargar todos los datos ciudades, items etc
    public void cargarTodo() {

        // FUNCION: SEPARAR LOS TRY CATCH PARA QUE EL MENSAJE DEL ERROR SEA MÁS ESPECIFICO

        try {
            ciudades = txtHelper.leerLineas();
        } catch (Exception e) {
            loggerCustom.escribirFichero("ERROR", "Error al cargar ciudades.txt: " + e.getMessage());
        }
        try {
            items = jsonHelper.readList("practica7/Ficheros/items.json", Item.class);
        } catch (Exception e) {
            loggerCustom.escribirFichero("ERROR", "Error al cargar items.json: " + e.getMessage());
        }
        try {
            personajes = jsonHelper.readList("practica7/Ficheros/personajes.json", Personaje.class);
        } catch (Exception e) {
            loggerCustom.escribirFichero("ERROR", "Error al cargar personajes.json: " + e.getMessage());
        }
        //catalogo de items (actualizado)
        for (Item i : items) {
            catalogoItems.put(i.getId(), i);
        }
        loggerCustom.escribirFichero("INFO","La función cargarTodo se ha completado con exito");
    }

    public Personaje crearPJ() throws DatoInvalidoException {

        //para crear un personaje y añadirlo a personajes.json

        System.out.println("Qué nombre quieres para tú personaje: ");
        String nombre = sc.nextLine();
        System.out.println("Que raza quieres para tu personaje: ");
        String raza = sc.nextLine();

        System.out.println("Que nivel es tú personaje: ");

        int nivel = 0;

        // FUNCIÓN: PARA TENER CONTROLADO EL FALLO DE PONER UN STRING EN NIVEL
        try {
            nivel = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            loggerCustom.escribirFichero("ERROR","El parametro nivel debe de ser un int");
            throw new DatoInvalidoException("El parametro nivel debe de ser un int");
        }

        // Validación de que el nivel no sea menor a 0
        if(nivel < 0) {
            loggerCustom.escribirFichero("ERROR","El nível del personaje no puede ser < 0");
            throw new DatoInvalidoException("El nível del personaje no puede ser < 0");
        }

        System.out.println("Que equipo quieres para tú personaje: ");

        //creamos arraylist para añadirle el equipo que queramos añadirle al persoanje
        List<Item> equipo = new ArrayList<>();

        String id;
        do {
            System.out.println("Items disponibles:");
            for (Item i : catalogoItems.values()) {
                System.out.println(i.toString());
            }

            System.out.print("Elige los objetos por su id (o escribe Salir): ");
            id = sc.nextLine();

            //si en algún momento escribimos Salir ya saldremos de crear el personaje
            if (id.equals("Salir")) {
                break;
            }

            Item item = catalogoItems.get(id);
            //si el item es no null se añade al equipo si no
            if (item != null) {
                equipo.add(item);
                System.out.println("Se ha añadido el item correctamente");
                //si no lanza un error de que el item no existe
            } else {
                System.out.println("El item no existe");
            }

        } while (true);

        // Crear personaje
        Personaje pj = new Personaje(nombre, raza, nivel, equipo);

        // Añadir el nuevo
        personajes.add(pj);

        // Guardar en JSON
        guardarCambios();

        //log
        loggerCustom.escribirFichero("INFO","Personaje creado correctamente " + pj.toString());
        return pj;
    }

    public void informeFinal() {
        //en el informe Final tenemos que enseñar todas las ciudades, objetos, Personajes, etc

        System.out.println();
        //CIUDADES
        System.out.println("-------------------------------------------");
        System.out.println("-------------------CIUDADES----------------");
        System.out.println("-------------------------------------------");
        for (Ciudad c : ciudades) {
            System.out.println(c.toString());
        }

        //Items
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("-------------------ITEMS-------------------");
        System.out.println("-------------------------------------------");
        for (Item i : items) {
            System.out.println(i.toString());
        }

        // Personajes
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("-------------------PERSONAJES--------------");
        System.out.println("-------------------------------------------");
        for (Personaje p : personajes) {
            System.out.println(p.toString());
        }
        System.out.println();
        loggerCustom.escribirFichero("INFO","Informe final ha sido ejecutado con exito");
    }

    public void guardarCambios() {
        jsonHelper.writeList("practica7/Ficheros/personajes.json", personajes);
        loggerCustom.escribirFichero("INFO","GuardarCambios se ha ejecutado con exito");
    }
}
