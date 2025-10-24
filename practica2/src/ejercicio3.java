import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        //Crea un array que contenga 5 números. Realiza un programa que te muestre por pantalla
        //SOLO el más pequeño de ellos.
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];               //Cremos el array
        for (int i = 0; i < a.length; i++) {
            System.out.println("Introduce el siguiente número: ");
            a[i] = sc.nextInt();
            }
        // Inicializamos min con el primer valor del array
        int min = a[0];
        //hacemos un bucle para encoontrar el número más pequeño
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        //Mostramos por pantalla el número más pequeño
        System.out.println("El número más pequeño es: "+min);
    }
}