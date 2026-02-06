import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Bloque2 {
    public void repositorioDeGremios () {
        HashMap<String, ArrayList<String>> gremio = new HashMap<String, ArrayList<String>>();
        Scanner sc = new Scanner(System.in);
        //La clave es el nombre del gremio
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Cama");
        a1.add("Dario");
        a1.add("Iker");
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

        if (gremio.containsKey(eleccion)) {
            System.out.println(gremio.get(eleccion));
        } else {
            System.out.print("No existe");
        }
    }

    public void loot () {
        Scanner sc = new Scanner(System.in);
        HashMap<String, HashSet<String>> botin = new HashMap<String, HashSet<String>>();
        ArrayList<String> a1 = new ArrayList<>();


    }
}
