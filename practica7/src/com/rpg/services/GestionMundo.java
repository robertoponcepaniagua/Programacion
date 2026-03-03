package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.io.IOException;
import java.util.*;

public class GestionMundo {
    private Scanner sc;
    private JsonHelper jsonHelper;
    private TxtHelper txtHelper;
    private List<Personaje> personajes;
    private List<Item> items;
    private List<Ciudad> ciudades;
    private Map<String, Item> catalogoItems;

    public GestionMundo() throws IOException {
        //el scanner
        this.sc = new Scanner(System.in);

        //para escribir ficheros etc
        this.jsonHelper = new JsonHelper();
        this.txtHelper = new TxtHelper();

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
        //leer ciudades
        ciudades = txtHelper.leerLineas2();
        //leer items
        items = jsonHelper.readList("practica7/Ficheros/items.json",Item.class);
        //leer personajes
        personajes = jsonHelper.readList("practica7/Ficheros/personajes.json",Personaje.class);

        //catalogo de items (actualizado)
        for (Item i : items) {
            catalogoItems.put(i.getId(), i);
        }
    }

    public Personaje crearPJ() throws DatoInvalidoException {

        //Antes de crear el persoanje cargamos toda la iformación sobre personajes, items, Ciudades...
        cargarTodo();

        //para crear un personaje y añadirlo a personajes.json

        System.out.println("Qué nombre quieres para tú personaje: ");
        String nombre = sc.nextLine();

        System.out.println("Que raza quieres para tu personaje: ");
        String raza = sc.nextLine();

        System.out.println("Que nivel es tú personaje: ");
        int nivel = sc.nextInt();
        sc.nextLine();

        // Validación de que el nivel no sea menor a 0
        if(nivel < 0) {
            throw new DatoInvalidoException(" El nível del personaje no puede ser < 0");
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

        // Leer personajes actuales
        personajes = jsonHelper.readList("practica7/Ficheros/personajes.json", Personaje.class);

        // Añadir el nuevo
        personajes.add(pj);

        // Guardar en JSON
        guardarCambios();
        return pj;
    }

    public void guardarCambios() {
        jsonHelper.writeList("practica7/Ficheros/personajes.json", personajes);
    }
}
