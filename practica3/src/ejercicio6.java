public class ejercicio6 {
    public static void main(String[] args) {
        // Modifica el programa anterior para que el array sea de [6][10]
        // y las posiciones restantes se rellenen con 0 si no hay suficientes números entre 20-40.

        int[][] a = new int[6][10];
        int[][] temp = new int[6][10];

        // Suma total
        int sumatotal = 0;

        // Suma columnas y filas
        int[] columnas = new int[10];
        int[] filas = new int[6];

        // Rellenamos temp con números del 20 al 40
        int index = 20;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index <= 40) {
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
        int min = 41;
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

        // Posición del número máximo y mínimo
        System.out.println("El número máximo es [" + max + "] en la posición [" + filamax + "][" + columnamax + "]");
        System.out.println("El número mínimo es [" + min + "] en la posición [" + filamin + "][" + columnamin + "]");

        // Suma total
        System.out.println("La suma total es " + sumatotal);
    }
}
