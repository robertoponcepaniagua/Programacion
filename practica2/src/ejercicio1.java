import java.util.Scanner;

public class ejercicio1 {
    //Crea un array de 10 posiciones de números con valores pedidos
    // por teclado. Muestra por consola el índice y el valor al que
    // corresponde.
    public static void main(String[] args) {
        //Crea un array de 10 posiciones de números con valores pedidos por teclado
        Scanner sc = new Scanner(System.in);
        int[] arrayInt = new int[10];
        for(int i = 0; i < arrayInt.length; i++) {
            System.out.println("Introduce el valor para la posición " + i + ":");
            arrayInt[i] = sc.nextInt();
        }
        //Muestra por consola el índice y el valor
        //indice -> valor
        for (int i = 0 ; i < arrayInt.length ; i++){
            System.out.println("Indice "+i+": "+arrayInt[i]);
        }
    }
}
