import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        //Modifica el programa del Ejercicio 6 para que:
        //1. Los números NO se repitan (como en el ejercicio anterior).
        //2. Los números estén comprendidos en un rango dinámico (el usuario introduce el
        //valor mínimo y máximo).
        //3. Al final, el programa muestre:
        //○ La media aritmética de todos los números del array.
        //○ La posición de todos los números primos que haya en el array.
        //○ Una representación gráfica en consola de cada fila, donde cada número se
        //represente con un número de * proporcional a su valor dentro del rango
        //dado (por ejemplo, si el rango es 10-20 y aparece el 15, se mostrarán 5 *).
        Scanner sc = new Scanner(System.in);
        int rango = sc.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();

        int[][] a = new int[3][7];
        int[][] temp = new int[3][7];
        //suma total
        int sumatotal= 0;

        //suma columnas y filas
        int[] columnas = new int[7];
        int[] filas = new int[3];

        // Rellenamos temp con números del 20 al 40
        int index = 20;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = index++;
            }
        }

        // Mezclamos temp
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                int pos = (int) (Math.random() * 21);
                int fil = pos / 7;
                int col = pos % 7;

                // intercambiar
                int aux = temp[i][j];
                temp[i][j] = temp[fil][col];
                temp[fil][col] = aux;
            }
        }

        // Copiamos temp a a y calculamos sumas
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = temp[i][j];
                sumatotal += a[i][j];
                filas[i] += a[i][j];
                columnas[j] += a[i][j];
            }
        }

        // Imprimir la tabla
        System.out.println("Tabla generada:");

        // Encabezado de columnas
        System.out.printf("%-10s", ""); // espacio para la etiqueta de fila
        for (int j = 0; j < a[0].length; j++) {
            System.out.printf("%8s", "Col" + j);
        }
        System.out.printf("%12s%n", "Suma fila");

        // Filas con sus valores y suma
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%-10s", "Fila " + i);
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%8d", a[i][j]);
            }
            System.out.printf("%12d%n", filas[i]);
        }

        // Línea separadora
        System.out.print("----------");
        for (int j = 0; j < a[0].length; j++) {
            System.out.print("--------");
        }
        System.out.println("------------");

        // Totales de columnas
        System.out.printf("%-10s", "Total");
        for (int j = 0; j < columnas.length; j++) {
            System.out.printf("%8d", columnas[j]);
        }
        System.out.printf("%12d%n", sumatotal);

        //max y min
        int max = a[0][0];
        int filamax = 0;
        int columnamax= 0;
        int min = a[0][0];
        int filamin = 0;
        int columnamin= 0;

        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                //max y min
                if (a[i][j] < min) {
                    min = a[i][j];
                    filamin = i;
                    columnamin = j;
                }
                if (a[i][j] > max) {
                    max = a[i][j];
                    filamax = i;
                    columnamax = j;
                }
            }
        }

        //posición del número máximo y mínimo
        System.out.println("El número maximo es ["+max+"] en la posición ["+filamax+"]["+columnamax+"]");
        System.out.println("El número mínimo es ["+min+"] en la posición ["+filamin+"]["+columnamin+"]");

        //Suma total
        System.out.println("La suma total "+sumatotal);
    }
}
