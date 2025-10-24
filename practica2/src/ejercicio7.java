import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        //Programa Java que llene un array con 10 números enteros que se leen por teclado.
        // A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.
        Scanner sc = new Scanner(System.in);
        //Creamos el array
        int[] a = new int[10];
        //Creamos variables
        int sumapositivos = 0;
        int positivos = 0;
        int sumanegativos = 0;
        int negativos = 0;
        double mediapositivos= 0;
        double medianegativos= 0;

        // Lectura de los números

        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("Escribe un número "+ (i + 1)+" : ");
            a[i] = sc.nextInt();
        }

        // Cálculo de sumas y medias

        for (int i = 0 ; i < 10; i++) {
            if (a[i] > 0) {
                sumapositivos += a[i];
                positivos++;
                mediapositivos = (double) sumapositivos / positivos;
            } else if (a[i] < 0) {
                sumanegativos += a[i];
                negativos++;
                medianegativos = (double) sumanegativos / negativos;
            } else {
                System.out.println(a[i]+" no es ni positivo o negativo");
            }
        }
        System.out.println("De "+positivos+" números positivos introducidos, la media es: "+mediapositivos);
        System.out.println("De "+negativos+" números negativos introducidos, la media es: "+medianegativos);
    }
}