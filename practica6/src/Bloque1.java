import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bloque1 {
    public void registroDeMuertes() {
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
    }

    public void censoUnico () {
        //Creamos un HashSet para nombres de villanos (String)
        HashSet<String> nombresVillanos = new HashSet<>();
        //Añadminos nombre de villanos
        nombresVillanos.add("Romeo Celestial");
        nombresVillanos.add("Habibi");
        nombresVillanos.add("Dario");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Morgoth");
        nombresVillanos.add("Mago Oscuro");
        //Imprimir el tamaño del set para ver que no se ha duplicado
        System.out.println(nombresVillanos.size());
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

}
