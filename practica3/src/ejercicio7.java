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

        Scanner sc =new Scanner(System.in);
        System.out.print("Escribe valor mínimo: ");
        int minr = sc.nextInt();
        System.out.print("Escribe valor maximo: ");
        int maxr = sc.nextInt();
        int rango = maxr - minr + 1;

        int[][] a = new int[6][10];
        int[][] temp = new int[6][10];

        // Suma total
        int sumatotal = 0;

        // Suma columnas y filas
        int[] columnas = new int[10];
        int[] filas = new int[6];

        //Media aritmetica
        int media_aritmetica = (maxr + minr) / 2;

        //Comprobamos que el rango es adecuado para el array
        if (rango > 60) {
            System.out.println("Porfavor elige otros números min y maximos recuerda el rango es de 60");
            System.out.print("Escribe valor mínimo. ");
            minr = sc.nextInt();
            System.out.print("Escribe valor maximo: ");
            maxr = sc.nextInt();
        }

        // Rellenamos temp con números
        int index = minr;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index <= maxr) {
                    temp[i][j] = index++;
                } else {
                    temp[i][j] = 0; // Rellenar con 0 si se excede el rango
                }
            }
        }

        // Mezclamos temp
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                //Da un número random entre 20 y 60
                int pos = (int) (Math.random() * 60);
                //fil calcula la fila del número random y col calcula la columna del número random, se divide por el número
                //de columnas
                int fil = pos / 10;
                int col = pos % 10;

                // Intercambiar
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
        int[] siesprimo = new int[60];
        //Números Primos
        for (int i = 0; i < a.length; i++) {
            int[] primo = new int[2];
            for (int j = 0; j < a[i].length; j++) {
                int num = a[i][j];
                if (num % 1 == 0 && num % num == 0) {
                    primo [0] = 1;
                    primo [1] = num;
                    boolean esprimo = true;
                }
                for (int k = 0; k < num; k++) {
                    if (primo[0] == 1 && primo[1] == a[i][j]) {
                        siesprimo[i] = primo[1];
                    }
                }
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

        // Max y Min
        int max = a[0][0];
        int filamax = 0;
        int columnamax = 0;
        int min = maxr;
        int filamin = 0;
        int columnamin = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                // Max y Min
                if (a[i][j] != 0 && a[i][j] < min) {
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
        System.out.println();
        System.out.println("La media Aritmetica es: "+media_aritmetica);
        // Posición del número máximo y mínimo
        System.out.println("El número máximo es [" + max + "] en la posición [" + filamax + "][" + columnamax + "]");
        System.out.println("El número mínimo es [" + min + "] en la posición [" + filamin + "][" + columnamin + "]");

        // Suma total
        System.out.println("La suma total es " + sumatotal);

        for (int i = 0; i < a.length; i++) {
            System.out.println("Los números primos son: "+siesprimo);
        }
    }
}
