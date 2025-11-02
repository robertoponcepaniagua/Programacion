public class ejercicio1 {
    public static void main(String[] args) {
        //Define un array de números tipo double de 3 filas por 7 columnas con nombre doub y
        //asigna los valores según la siguiente tabla. Muestra el contenido de todos los elementos del
        //array dispuestos en forma de tabla como se muestra en la figura.

        //Creamos un array de 3 filas y 7 columnas
        //Asignamos los valores
        double[][] doub = {
                {0.0, 30.0, 2.0, 0.0, 0.0, 5.0},  //Fila 1
                {75.0, 0.0, 0.0, 0.0, 0.0, 0.0},  //Fila 2
                {0.0, 0.0, -2.0, 9.0, 0.0, 11.0} //Fila 3
        };
        //Encabezado
        System.out.printf("%11s", "Array num");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%14s", "Columna " + i);
        }
        //Introducimos un salto de página si no la fila 0 queda pegado con las columnas
        System.out.println();
        //Cuerpo
        for (int i = 0; i < doub.length; i++) {     //Creamos 2 for para recorrer el array [i][j]  (filas y columnas)
            System.out.printf("   %-10s", "Fila " + i);
            for (int j = 0; j < doub[i].length; j++) {
                if (doub[i][j] == 0.0 && !(i==0 && j==0) && !(i==1 && j==4)) {     // No muestra ceros excepto el primero [0][0]
                    System.out.printf(" | %11s", "");
                } else {
                    System.out.printf(" | %6.1f%5s", doub[i][j],"");
                }
            }
            System.out.println();
        }
    }
}