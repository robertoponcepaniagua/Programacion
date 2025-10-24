import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        //Muestra por pantalla todos los elementos de un array de números enteros separados por
        //un espacio.
        Scanner sc = new Scanner(System.in);
        //creamos el array
        int[] arrayInt = new int[10];
        //recorremos el array para añadir en cada posición un valor
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Introduce el valor para la posición " + i + ":");
            arrayInt[i] = sc.nextInt();
        }
        //recorremos el array y mostrams por pantalla
        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(arrayInt[i]+" ");
        }
    }
}
