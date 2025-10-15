import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for(int i = 0; i < 10; i++) {
            System.out.println("Escribe 10 números: ");
            a[i]= sc.nextInt();
        }
    }
}