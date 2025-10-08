import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Crea un array de números donde le indicamos por teclado el tamaño del array
        System.out.print("Escribe el tamaño del array: ");
        int tamaño = sc.nextInt();
        int[] a = new int[tamaño];
        int suma= 0;
        //rellenaremos el array con números aleatorios entre 0 y 9
        for (int i=0; i<a.length;i++) {
            a[i]= (int) (Math.random()*10);
            suma += a[i];
        }
        //al final muestra por pantalla el
        //valor de cada posición y la suma de todos los valores.
        for (int i = 0; i<a.length;i++) {
            System.out.println("Indice: "+i+" : "+a[i]);
        }
        System.out.println(suma);
    }
}