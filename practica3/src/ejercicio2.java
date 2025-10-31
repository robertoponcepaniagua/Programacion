import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        //Escribe un programa que solicite 20 números enteros. Estos números debemos de
        //introducirlo en un array de 4 filas por 5 columnas. El programa mostrará las sumas parciales
        //de filas y en las columnas el mayor número de la columna. La suma total debe aparecer en
        //la esquina inferior derecha.

        //Escribe un programa que solicite 20 números enteros
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[4][5];
        // Estos números debemos de introducirlo en un array de 4 filas por 5 columnas.
        System.out.println("Escribe números para el array 4x5: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Introduce el número para array[" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
            }
        }
        // El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.

    }
}