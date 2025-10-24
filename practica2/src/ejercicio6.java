import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        //Programa Java que guarda en un array 10 números enteros que se leen por teclado. A
        //continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos
        //y cuántos ceros.
        Scanner sc = new Scanner(System.in);
        //Creamos array de 10 posiciones
        int[] a = new int[10];
        //Creamos variables
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        //un for para pedir y guardar los números en el array
        for(int i = 0; i < 10; i++) {
            System.out.println("Escribe el número " + (i + 1) + ": ");
            a[i]= sc.nextInt();
        }
        //un for para contar los números > 0 o sea positivos y < 0 negativos y lo demás son 0
        for(int i = 0; i < 10; i++) {
            if (a[i] > 0) {
                positivos++;
            }else if (a[i] < 0) {
                negativos++;
            }else {
                ceros++;
            }
        }
        //Mostramos por pantalla
        System.out.println("Números positivos: " + positivos);
        System.out.println("Números negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }
}