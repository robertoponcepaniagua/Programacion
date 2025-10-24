import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio14 {
    public static void main(String[] args) {
        //Crea un programa que:
        //Cree una lista de Strings (ArrayList<String>).
        //Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
        //Luego pida un nombre a buscar y diga si está en la lista o no, mostrando también en qué posición se encuentra si existe.

        // Crear una lista de Strings (ArrayList<String>)
        ArrayList<String> listanombres = new ArrayList<>();

        // Pida al usuario nombres por teclado hasta que introduzca "fin"
        System.out.print("Escribe nombres, cuando quieras parar pon fin: ");
        Scanner sc = new Scanner(System.in);
        String nombre;

        // Bucle para recibir nombres hasta que el usuario ingrese "fin"
        while (true) {
            nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break; // Salir del bucle si el usuario escribe "fin"
            }
            listanombres.add(nombre); // Agregar el nombre a la lista
        }

        // Pedir el nombre a buscar
        System.out.print("Escribe un nombre para buscar: ");
        String buscar = sc.nextLine();

        // Boolean para saber si encontramos el nombre
        boolean encontrado = false;

        // Recorrer la lista para buscar el nombre
        for (int i = 0; i < listanombres.size(); i++) {
            if (buscar.equalsIgnoreCase(listanombres.get(i))) {
                System.out.println("El nombre " + buscar + " está en la lista, en la posición: " + i);
                encontrado = true; // Si encontramos el nombre, cambiamos la variable a true
                break; // Salir del bucle porque ya encontramos el nombre
            }
        }

        // Si no lo encuentra se imprime el siguiente mensaje
        if (!encontrado) {
            System.out.println("El nombre " + buscar + " no está en la lista.");
        }
    }
}