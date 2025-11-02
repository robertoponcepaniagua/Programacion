import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        //Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas
        //por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos
        //incluidos). A continuación, el programa deberá:
        //- dar la posición del número máximo y mínimo
        //- la suma total de todas las filas y columnas
        //- la suma de todas las columnas
        //- la suma de todas las filas.
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[6][10];
        int menor = 0;
        int mayor = 1000;
        int sumatotal= 0;
        int[] columnas = new int[10];
        int[] filas = new int[6];

        //Rellenamos eñ array con números enteros positivos comprendidos entre 0 y 1000

        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("Escribe un número positivo entre 0 y 1000: ");
                a[i][j] = sc.nextInt();
                while ((a[i][j] <= menor) || (a[i][j] >= mayor)) {
                    System.out.print("Escribe otro número, recuerda que debe ser números enteros positivos entre 0 y 1000: ");
                    a[i][j] = sc.nextInt();
                }
                sumatotal += a[i][j];
                filas[i] = a[i][j];
                columnas[j] += a[i][j];
            }
        }

        //Número min y max

        int max = a[0][0];
        int min = a[0][0];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                } else if (a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }
        System.out.println("El número maximo es ["+max+"]");
        System.out.println("El número mínimo es ["+min+"]");

    }
}
