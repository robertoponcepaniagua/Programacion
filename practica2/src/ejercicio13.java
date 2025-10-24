import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {
        //Crea un programa que: - - -
        //Cree una lista de enteros (ArrayList<Integer>).
        //Pida números por teclado hasta que el usuario introduzca un número negativo (ese
        //no se añade).
        //Muestre por pantalla todos los números de la lista y la suma total de los mismos.

        // Crear una lista de enteros (ArrayList)
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        //Le pedimos al usuario que ponga números
        System.out.print("Introduce números y para terminar escribe un número negativo: ");
        //Creamos un scanner para leer la entrada de teclado
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        int sumatotal = 0;
        //Pida números por teclado hasta que el usuario introduzca un número negativo (ese
        //no se añade).
        while (true) {
            //si el número es negativo salimos del bucle
            numero = sc.nextInt();
            if (numero < 0) {
                break;
            }
            // Si el número no es negativo, lo añadimos a la lista
            listaNumeros.add(numero);
        }
        // Mostrar la lista de números
        System.out.println("Los números introducidos son: "+listaNumeros);

        //Calcular el total
        for (int num : listaNumeros) {
            sumatotal += num;
        }
        System.out.print("La suma total de los números es: "+sumatotal);
    }
}