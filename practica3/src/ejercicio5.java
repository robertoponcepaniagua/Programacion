public class ejercicio5 {
    public static void main(String[] args) {
        //Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas
        //por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos
        //incluidos). A continuación, el programa deberá:
        //- dar la posición del número máximo y mínimo
        //- la suma total de todas las filas y columnas
        //- la suma de todas las columnas
        //- la suma de todas las filas.

        int[][] a = new int[6][10];

        //suma total
        int sumatotal= 0;

        //suma columnas y filas
        int[] columnas = new int[10];
        int[] filas = new int[6];

        //Rellenamos eñ array con números enteros positivos comprendidos entre 0 y 1000
        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 1001);

                //sumas
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
