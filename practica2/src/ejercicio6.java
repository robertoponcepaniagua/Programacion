import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;
        for(int i = 0; i < 10; i++) {
            System.out.println("Escribe el número " + (i + 1) + ": ");
            a[i]= sc.nextInt();
        }
        for(int i = 0; i < 10; i++) {
            if (a[i] > 0) {
                positivos++;
            }else if (a[i] < 0) {
                negativos++;
            }else {
                ceros++;
            }
        }
        System.out.println("Números positivos: " + positivos);
        System.out.println("Números negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }
}