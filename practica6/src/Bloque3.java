import java.util.*;

public class Bloque3 {
    public void comericio () {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> preciosbaseItems = new HashMap<>();
        HashMap<String, ArrayList<String>>  ciudadesItems = new HashMap<>();

        //ITEMS
        preciosbaseItems.put("Pantalón",16.4);
        preciosbaseItems.put("Sal",0.60);
        preciosbaseItems.put("Arroz",0.99);
        preciosbaseItems.put("Sudadera",60.4);
        preciosbaseItems.put("Figurita",20.67);
        preciosbaseItems.put("Mesa",40.3);
        preciosbaseItems.put("PS5",499.99);
        preciosbaseItems.put("Monitor",200.99);
        preciosbaseItems.put("RTX 4060TI",400.00);
        preciosbaseItems.put("Chicles",1.50);

        //Madrid 6 items
        ArrayList<String> itemsMadrid = new ArrayList<>();
        itemsMadrid.add("Chicles");
        itemsMadrid.add("PS5");
        itemsMadrid.add("Monitor");
        itemsMadrid.add("RTX 4060TI");
        itemsMadrid.add("Mesa");
        itemsMadrid.add("Sudadera");

        ciudadesItems.put("Madrid",itemsMadrid);

        //Tokio 4 items
        ArrayList<String> itemsTokio = new ArrayList<>();
        itemsTokio.add("Pantalón");
        itemsTokio.add("Sal");
        itemsTokio.add("Arroz");
        itemsTokio.add("Figurita");

        ciudadesItems.put("Tokio", itemsTokio);

        //Escribir ciudad
        System.out.println("Escribe una ciudad");
        System.out.println(ciudadesItems.keySet());
        String eleccion = sc.nextLine();

        if (ciudadesItems.containsKey(eleccion)) {
            ArrayList<String> itemsEleccion = ciudadesItems.get(eleccion);
            if (itemsEleccion.size() > 5) {
                for (String item : itemsEleccion) {
                    Double preciobase = preciosbaseItems.get(item);
                    Double precioaumentado = preciobase * 1.1; //1.1 es el 10% o sea +10%
                    System.out.println("Precio base : " + preciobase + " de " + item );
                    System.out.println("Precio +10% : " + precioaumentado + " de " + item );
                    preciosbaseItems.put(item,precioaumentado);
                }
            } else {
                System.out.println("Precios Normales no es > 5");
            }
        }
    }
    public void arbolesHabilidades () {
        HashMap<String, HashMap<String, Boolean>> arbolHabilidades =  new HashMap<>();

        HashMap<String, Boolean> habilidades = new HashMap<>();
        habilidades.put("Hola",true);
        habilidades.put("Rayo",true);
        habilidades.put("Enfoque",false);
        habilidades.put("Golpe Divino",true);
        habilidades.put("Espada sanguinaria",true);

        arbolHabilidades.put("Paladin", habilidades);
        //Comprobamos que el personaje ha desbloqueado Golpe Divino
        if (arbolHabilidades.get("Paladin").get("Golpe Divino").equals(true)) {
            //Comprobamos si el personaje ha desbloqueado Enfoque, si no lo tiene no puede aprender Golpe Divino y lanzamos un mensaje de error
            if (arbolHabilidades.get("Paladin").get("Enfoque").equals(true)) {
                System.out.println("Habilidad Golpe divino aprendida correctamente ");
            } else {
                System.out.println("No puedes aprender golpe divino");
            }
        }
    }

    public void historialdeIncursiones () {
        HashMap<String, List<HashSet<String>>> incursiones = new HashMap<>();

        //Creamos las raids completadas con los nombres
        HashSet<String> raid1 = new HashSet<>();
        raid1.add("Roberto");
        raid1.add("David");
        raid1.add("Ana");
        raid1.add("Nicolás");
        raid1.add("Ana");

        HashSet<String> raid2 = new HashSet<>();
        raid2.add("Marcos");
        raid2.add("Álvaro");
        raid2.add("Roberto");
        raid2.add("Lucas");
        raid2.add("Nay");

        HashSet<String> raid3 = new HashSet<>();
        raid3.add("Marcos");
        raid3.add("Elena");
        raid3.add("Lucía");
        raid3.add("Paula");
        raid3.add("Iván");

        HashSet<String> raid4 = new HashSet<>();
        raid4.add("Claudia");
        raid4.add("Raúl");
        raid4.add("Roberto");
        raid4.add("Lucía");
        raid4.add("Nay");

        //LISTAS
        List<HashSet<String>> lista1 = new ArrayList<>();
        lista1.add(raid1);
        lista1.add(raid2);
        lista1.add(raid3);

        List<HashSet<String>> lista2 = new ArrayList<>();
        lista2.add(raid2);
        lista2.add(raid3);
        lista2.add(raid4);

        List<HashSet<String>> lista3 = new ArrayList<>();
        lista3.add(raid1);
        lista3.add(raid4);
        lista3.add(raid2);

        incursiones.put("Cueva Muerta",lista1);
        incursiones.put("Torre Maligna",lista2);
        incursiones.put("Laberinto",lista3);

        HashMap<String, Integer> masValioso = new HashMap<>();

        //nota mental: tengo que recorrer dentro de las distintas incursuines las listas de los personajes que las han completado y en masvalioso sumar 1 cada vez que lo encuentre
        //recorremos las incursiones
        for (String incursion : incursiones.keySet()) {
            //creamos un hashset lista para guardar las listas de las distintas incursiones
            for (HashSet<String> lista : incursiones.get(incursion)) {
                //for para coger los jugadores de la lista
                for (String jugador : lista) {
                    //si el jugador está +1
                    if (masValioso.containsKey(jugador)) {
                        //entramos ne mas valioso con la clave del jugador (el nombre) nos metemos dentro de masValioso cogemos el jugador y le sumamos 1
                        masValioso.put(jugador, masValioso.get(jugador) + 1);
                    } else {
                        //si no está simplemente lo metemos con 1
                        masValioso.put(jugador,1);
                    }
                }
            }
        }

        for (String jugador : masValioso.keySet()) {
            System.out.println(jugador);
            System.out.println(masValioso.get(jugador));
        }
        System.out.println("----El más valioso es----");
        String mejorJugador = "";
        Integer maxIncursiones = 0;

        for (String jugador : masValioso.keySet()) {

            if (masValioso.get(jugador) > maxIncursiones) {
                maxIncursiones = masValioso.get(jugador);
                mejorJugador = jugador;
            }
        }
        System.out.println(mejorJugador);
        System.out.println("Con : " + masValioso.get(mejorJugador));
    }

    public void mensageriaGlobal () {
        HashMap <String, List<String>> conversacion = new HashMap<>();

        List<String> j1 = new ArrayList<>();
        List<String> j2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        //lisya de jugadores silenciados
        HashSet<String> jugadoresSilenciados = new HashSet<>();

        System.out.print("Dime tú nombre: ");
        String nombreJugador1 = sc.nextLine();
        System.out.print("Dime tú nombre: ");
        String nombreJugador2 = sc.nextLine();

        conversacion.put(nombreJugador1,j1);
        conversacion.put(nombreJugador2,j2);

        String msj1 = "";
        String msj2 = "";

        System.out.print("Si quieres salir al siguiente ejericicio pon [Salir]");

        do {
            System.out.print("Jugador 1:");
            msj1 = sc.nextLine();
            System.out.print("Jugador 2:");
            msj2 = sc.nextLine();

            // TODO: NECESITO COMPROBAR LOS ULTIMOS 3 MENSAJES SI 2 DE ELLOS SON IGUALES HAY QUE METERLO (NOMBRE JUGADOR) EN JUGADORES SILENCIADOS

            j1.add(msj1);
            j2.add(msj2);

        }while (!msj1.equals("Salir") && !msj2.equals("Salir"));
    }
}
