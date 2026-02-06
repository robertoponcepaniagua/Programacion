import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque1 {
    public ArrayList<String> registroDeMuertes() {
        //Creamos un Array<List> para gaurdar lolamado Registro de Muertes
        ArrayList<String> registroCombate = new ArrayList<>();
        //Añadimso 5 eventos
        registroCombate.add("Poción consumida");
        registroCombate.add("Enemigo Derrotado");
        registroCombate.add("Has ganado!");
        registroCombate.add("Has huido con exito");
        registroCombate.add("Habilidad ejecutada");
        registroCombate.add("Ataque ejecutado");

        //Mostrar el tercer evento
        System.out.println(registroCombate.get(2));
        return registroCombate;
    }

    public HashSet<String> censoUnico () {
        //Creamos un HashSet para nombres de villanos (String)
        HashSet<String> nombresVillanos = new HashSet<>();
        //Añadminos nombre de villanos
        nombresVillanos.add("Romeo Celestial");
        nombresVillanos.add("Sauron");
        nombresVillanos.add("Dario");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Mago Oscuro");
        //Imprimir el tamaño del set para ver que no se ha duplicado
        System.out.println(nombresVillanos.size());

        return nombresVillanos;
    }

    public void oroHeroes() {
        //Creamos un HashMap con la clave que sea el nombre del Heroe y la Cantidad de oro
        HashMap<String, Integer> bolsaDeOro = new HashMap<String, Integer>();
        //Añadimso
        bolsaDeOro.put("Roberto",2000);
        bolsaDeOro.put("Felipe",1784);
        bolsaDeOro.put("Isabel",1332);
        //Mostrar oro
        System.out.println(bolsaDeOro.get("Roberto"));
    }

    public void limpiezaCalabozo () {
        ArrayList<String> calabozo = registroDeMuertes();
        //Quitamos el más antigup
        calabozo.remove(0);

        calabozo.add("Dragón avistado");
        System.out.println(calabozo.get(0));
        System.out.println(calabozo.get(5));
    }

    public void mercadoHechizos() {
        HashMap<String, Double> hechizos = new HashMap<String, Double>();
        //AÑADIR HECHIZOS
        hechizos.put("Explosion",70.4);
        hechizos.put("Llamarada",28.4);
        hechizos.put("Hojas Afiladas",60.7);
        hechizos.put("Rayo divino",46.4);
        hechizos.put("Hidrobomba",50.3);

        //Guardamos en el String Llaves la key del HashMap, ahora cuando tenemos la Llave hacemos un if dentro de for que reccorre el HashMap y que obtiene el valor del mana con la llave.
        for (String Llaves : hechizos.keySet()) {
            if (hechizos.get(Llaves) > 50) {
                System.out.println(Llaves);
            }
        }
    }

    public void expulsionReino () {
        HashSet<String> expulsion = censoUnico();
        System.out.println("Size del HashSet antes de la expulsión: "+expulsion.size());
        for (int i = 0; i < expulsion.size(); i++) {
            if (expulsion.contains("Sauron")) {
                System.out.println("Encontrado Sauron, eliminando...");
                expulsion.remove("Sauron");
                System.out.println("Size del HashSet después de la expulsión: "+expulsion.size());
            }
        }
    }
    public void bloque1 () {
        System.out.println("-----------------Ejercicio 1 : Registro de Muertes");
        registroDeMuertes();
        System.out.println();
        System.out.println("-----------------Ejercicio 2 : El Censo Único");
        censoUnico();
        System.out.println();
        System.out.println("-----------------Ejercicio 3 : Bolsa de Oro");
        oroHeroes();
        System.out.println();
        System.out.println("-----------------Ejercicio 4 : Limpieza del Calabozo");
        limpiezaCalabozo();
        System.out.println();
        System.out.println("-----------------Ejercicio 5 : Mercado de Hechizos");
        mercadoHechizos();
        System.out.println();
        System.out.println("-----------------Ejercicio 6 : Expulsión del Reino");
        expulsionReino();
        System.out.println();
    }
}
