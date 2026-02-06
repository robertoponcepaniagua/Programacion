import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
}
