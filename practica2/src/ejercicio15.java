import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio15 {
    public static void main(String[] args) {
        //Crea un programa que:
        //-Cree una lista de enteros (ArrayList<Integer>).
        //-Pida al usuario 10 números enteros y los añada a la lista.
        //-Elimine los valores duplicados manteniendo solo el primero que apareció.
        //-Ordene la lista de menor a mayor y la muestre por pantalla.

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>(10);

        //Pedimos los 10 números
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            int x = scanner.nextInt();
            numeros.add(x);
        }

        //Eliminar duplicados manteniendo el primero
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) { //solo compara con los siguientes
                if (numeros.get(i).equals(numeros.get(j))) {
                    numeros.remove(j);
                    j--; //retrocede porque la lista se acorta
                }
            }
        }

        //Ordenar de menor a mayor
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = 0; j < numeros.size() - 1 - i; j++) {
                if (numeros.get(j) > numeros.get(j + 1)) {
                    // Intercambiamos los valores
                    int temp = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, temp);
                }
            }
        }

        //Lista por pantalla
        System.out.println("Lista sin duplicados y ordenada: " + numeros);
    }
}
