import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio15 {
    public static void main(String[] args) {
        //Crea un programa que:
        //Cree una lista de enteros (ArrayList<Integer>).
        //Pida al usuario 10 números enteros y los añada a la lista.
        //Elimine los valores duplicados manteniendo solo el primero que apareció.
        //Ordene la lista de menor a mayor y la muestre por pantalla.

        // Crear una lista de enteros (ArrayList<Integer>).
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Pida al usuario 10 números enteros y los añada a la lista.
        System.out.println("Escribe 10 números enteros:");

        // Pedir 10 números
        for (int i = 0; i < 10; i++) {
            int numero = sc.nextInt();

            // Añadir el número solo si no está ya en la lista (eliminando duplicados)
            if (!listaNumeros.contains(numero)) {
                listaNumeros.add(numero);
            }
        }
        // Ordenar la lista de menor a mayor
        Collections.sort(listaNumeros);

        // Mostrar la lista ordenada por pantalla
        System.out.println("Lista ordenada sin duplicados: " + listaNumeros);
    }
}
