
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

        int menor = 0;
        int mayor = 1000;


        //Rellenamos eñ array con números enteros positivos comprendidos entre 0 y 1000

        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 1001);

                //sumas
                sumatotal += a[i][j];
                filas[i] = a[i][j];
                columnas[j] += a[i][j];

            }
        }

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
        //- dar la posición del número máximo y mínimo
        System.out.println("El número maximo es ["+max+"] en la posición ["+filamax+"]["+columnamax+"]");
        System.out.println("El número mínimo es ["+min+"] en la posición ["+filamin+"]["+columnamin+"]");

    }
}