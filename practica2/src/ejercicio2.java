import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrayInt = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el siguiente valor: ");
            arrayInt[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arrayInt[i]+" ");
        }
    }
}
