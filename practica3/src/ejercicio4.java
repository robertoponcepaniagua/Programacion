import java.util.Random;

public class ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        //Modifica el programa anterior de tal forma que las sumas parciales y la suma total
        //aparezcan en la pantalla con un pequeño retraso, dando la impresión de que el ordenador
        //se queda “pensando” antes de mostrar los números.

        //Escribe un programa que solicite 20 números enteros
        int[][] array = new int[4][5];
        Random random = new Random();
        int suma_total = 0;
        int[] max = new int[5];
        // El array se rellena atumáticamente con números random
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = random.nextInt(2000);
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
                sumacolumna[j] += array[i][j];
                suma_total += array[i][j];
                //recorremos las columnas "j" para buscar el número más grande de estás
                if (array[i][j] > max[j]) {
                    max[j] = array[i][j];
                }
            }
            Thread.sleep(1000);
            System.out.printf(" | %-5d\n", sumafila);
        }
        //Crea una barra separadora
        System.out.println("----------------------------------");
        //Sumar columnas
        for (int j = 0; j < 5; j++) {
            Thread.sleep(1000);
            System.out.printf("%-5d",sumacolumna[j]);
        }
        //Escribe la suma total del array
        Thread.sleep(1000);
        System.out.printf(" | %6d",suma_total);
        System.out.println();
        //Aquí muestra el número más grande del array
        for (int j = 0; j < 5; j++) {
            Thread.sleep(500);
            System.out.println("El número más grande de la columna " + j + " es: " + max[j]);
        }
    }
}

