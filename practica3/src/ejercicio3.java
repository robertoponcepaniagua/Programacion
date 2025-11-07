import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        //Escribe un programa que solicite 20 números enteros. Estos números debemos de
        //introducirlo en un array de 4 filas por 5 columnas. El programa mostrará las sumas parciales
        //de filas y en las columnas el mayor número de la columna. La suma total debe aparecer en
        //la esquina inferior derecha.

        //Escribe un programa que solicite 20 números enteros
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[4][5];
        Random random = new Random();
        int suma_total = 0;
        int[] max = new int[5];
        // El array se rellena atumáticamente con números random
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = random.nextInt(1999)+1;
            }
        }
        //esto inicia el array max con los primeros números del array
        for (int j = 0; j < 5; j++) {
            max[j] = array[0][j];
        }
        int[] sumacolumna = new int[5];
        // El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.
        for (int i = 0; i < 4; i++) {
            int sumafila = 0;
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-5d", array[i][j]);
                sumafila += array[i][j];
                suma_total += array[i][j];
                //recorremos las columnas "j" para buscar el número más grande de estás
                if (array[i][j] > max[j]) {
                    max[j] = array[i][j];
                }
            }
            System.out.printf(" | %-5d\n", sumafila);
        }
        //Crea una barra separadora
        System.out.println("----------------------------------");
        //Sumar columnas
        for (int j = 0; j < 5; j++) {
            System.out.printf("%-5d",max[j] );
        }
        //Escribe la suma total del array
        System.out.printf(" | %6d",suma_total);
        System.out.println();
    }
}