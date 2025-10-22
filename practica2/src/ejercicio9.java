import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        //Crea un programa en Java que:
        //Pida al usuario por teclado 10 números enteros y los guarde en un array.
        //Recorra el array para encontrar:
        //El valor máximo y la posición en la que aparece.
        //El valor mínimo y la posición en la que aparece.


        //Pida al usuario por teclado 10 números enteros y los guarde en un array.
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Escribe 10 números enteros ");
            array[i] = sc.nextInt();
        }
        int max = array[0];
        int posicion_max= 0;
        int min = array[0];
        int posicion_min= 0;
        //Recorra el array para encontrar:
        for (int i = 0; i < array.length; i++) {
            if (array[i]<min) {
                min = array[i];
                posicion_min = i;
            }
            if (array[i]>max) {
                max = array[i];
                posicion_max = i;
            }
        }
        System.out.println("Valor máximo: "+max+" en la posición "+posicion_max);
        System.out.println("Valor mínimo: "+min+" en la posición "+posicion_min);
    }
}
