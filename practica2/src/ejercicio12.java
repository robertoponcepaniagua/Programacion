import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
    //En España cada persona está identificada con un Documento Nacional de Identidad (DNI) en
        //el que figura un número y una letra, por ejemplo 56999545W. Realiza un programa donde le
        //pidas al usuario SOLO el número del dni y el programa te devuelva la letra. Para calcular la
        //letra solo tienes que dividir el número del DNI entre 23, el resto de esta división se
        //corresponde con la posición de la letra en el abecedario. Utiliza un array para guardar CADA
        //letra del abecedario.
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe los números del DNI: "); //Pedimos el número del DNI
        int Dni = sc.nextInt();
        int resto =0;
        char[] letrasDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        resto = Dni % 23;
        System.out.println("Tú DNI es: "+Dni+letrasDni[resto]);
    }
}
