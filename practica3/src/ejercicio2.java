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
        int suma_total = 0;
        int[] max = new int[5];
        // Estos números debemos de introducirlo en un array de 4 filas por 5 columnas.
        System.out.println("Escribe números para el array 4x5: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Introduce el número para array[" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < 5; j++) {
            max[j] = array[0][j];
        }
        // El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.
        for (int i = 0; i < 4; i++) {
            int sumafila = 0;
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-5d", array[i][j]);
                sumafila += array[i][j];
                suma_total += array[i][j];
                if (array[i][j] > max[j]) {
                    max[j] = array[i][j];
                }
            }
            System.out.printf(" | %-5d\n", sumafila);
        }
        System.out.println("--------------------------------");
        for (int j = 0; j < 5; j++) {
            System.out.printf("%-5d", max[j]);
        }
        System.out.printf("| %5d",suma_total);
        System.out.println();
    }
}