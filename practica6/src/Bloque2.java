import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Bloque2 {
    //Atributos
    private HashMap<String, ArrayList<String>> gremio;
    public Bloque2 () {
        this.gremio = new HashMap<>();
        bloque2();
    }
    public HashMap<String, ArrayList<String>> repositorioDeGremios () {
        Scanner sc = new Scanner(System.in);
        //La clave es el nombre del gremio
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Cama");
        a1.add("Dario");
        a1.add("Iker");
        a1.add("Judas");
        gremio.put("Guerreros", a1);

        ArrayList<String> a2 = new ArrayList<>();
        a2.add("Ismael");
        a2.add("Adrián");
        a2.add("Roberto");
        gremio.put("Magos", a2);

        System.out.println("Que gremio quieres que imprima?: ");
        //Imprimimos las opciones
        System.out.println(gremio.keySet());
        String eleccion = sc.nextLine();

        //Si el HashMap gremio contiene la llave eleccion muestra
        //Si no lo ignoramos con un No existe
        if (gremio.containsKey(eleccion)) {
            System.out.println(gremio.get(eleccion));
        } else {
            System.out.print("No existe");
        }
        return gremio;
    }

    public void loot () {
        Scanner sc = new Scanner(System.in);
        HashMap<String, HashSet<String>> botin = new HashMap<String, HashSet<String>>();
        ArrayList<String> a1 = new ArrayList<>();

        HashSet<String> posibilidadesLoot = new HashSet<String>();
        posibilidadesLoot.add("Espada Oxidada");
        posibilidadesLoot.add("Alma de Tresgo");
        posibilidadesLoot.add("Anillo");

        botin.put("Tresgo", posibilidadesLoot);

        System.out.println("Botín de Tresgo: ");
        //Mostramos el botín para que podamos añadirle botín
        for (String loot : botin.get("Tresgo")) {
            System.out.println(loot);
        }

        System.out.println("Qué loot quieres agregar al Tresgo");
        String eleccion = sc.nextLine();

        //Buscamos dentro de botín a Tresgo, dentro de tresgo busca nuestra elección !!!NO HACE FALTA HACER UN FOR PARA NUSCARLO COMO UN ARRAYLIS!!!!
        if (botin.get("Tresgo").contains(eleccion)) {
            System.out.println("No puedes añadir este botín, ya existe");
        } else {
            System.out.println("Botín añadido con exito");
        }
    }
    public void estadisticasComplejas () {
        //Clave es Nombre jugador/personaje   valor son sus atributos
        HashMap<String,HashMap<String, Integer>> personaje = new HashMap<String,HashMap<String, Integer>>();

        HashMap<String, Integer> atributos = new HashMap<String, Integer>();
        atributos.put("Inteligencia",10);
        atributos.put("Fuerza",8);
        atributos.put("Vida",90);

        personaje.put("Conan",atributos);

        System.out.println("Fuerza de Conan antes: "+ personaje.get("Conan").get("Fuerza"));

        //Guardamos la fuerza de Conan para después sumarla esa fuerza +2
        Integer cambio = personaje.get("Conan").get("Fuerza");
        //ahora como cambio tiene la fuerza de conan solo tenemos que añadirle esa fuerza a coanan y +2
        personaje.get("Conan").put("Fuerza",cambio+2);

        System.out.println("Fuerza de Conan después: "+ personaje.get("Conan").get("Fuerza"));
    }
    public void buscadorTraidores() {

        HashMap<String, ArrayList<String>> traidores = gremio;

        //for anidado para recorrer traidores
        for (String s : traidores.keySet()) {
            //si alguno del for anidado contiene Judas
            if (traidores.get(s).contains("Judas")) {
                System.out.println("Judas está en el gremio: "+ s);
                //lo quitamos
                traidores.get(s).remove("Judas");
            }
        }
    }
    public void bloque2() {
        System.out.println("-----------------Ejercicio 7 : Repositorio de Gremios");
        repositorioDeGremios();
        System.out.println();

        System.out.println("-----------------Ejercicio 8 : Sistema de Loot ");
        loot();
        System.out.println();

        System.out.println("-----------------Ejercicio 9 : Rastreador de Estadísticas Complejas");
        estadisticasComplejas();
        System.out.println();

        System.out.println("-----------------Ejercicio 10 : Buscador de Traidores");
        buscadorTraidores();
        System.out.println();
    }

}
