import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        //Programa Java para leer la altura de N personas y calcular la altura media.
        // Calcular cuántas personas tienen una altura superior a la media y
        // cuántas tienen una altura inferior a la media.
        // El valor de N se pide por teclado y debe ser entero positivo.
        Scanner sc = new Scanner(System.in);
        int a= 0;   //Altura media
        int at= 0;   //Suma de todas las alturas de todas las personas
        int inf =0;  //inferior a la media
        int may =0;  //mayor a la media
        System.out.print("Elige cuantas personas quieres para calcular la media de su altura: ");
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Escribe todas las alturas de las personas: ");
            array[i] = sc.nextInt();
            at = array[i] + at;
        }
        a = at / array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < a) {   //calcular la altura inferior a la media con if
                inf++;
            } else if (array[i] > a)
                may++;
        }
        System.out.println("La media de las "+array.length+" personas es: "+a+" y "+inf+" personas tienen una altura inferior a la media y "+may+" tienen una altura superior a la media");
    }
}