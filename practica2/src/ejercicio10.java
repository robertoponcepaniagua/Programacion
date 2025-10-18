import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        //Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas.
        // El nombre del estudiante lo introduce el usuario por teclado (usa la clase Scanner).
        // Utiliza un array para los nombres de los alumnos y otro para las notas. ¿Serías capaz de hacerlo con un array BIdimensional?
        Scanner sc = new Scanner(System.in);
        String[][] arraym = new String[20][2];
        for (int i = 0; i < arraym.length; i++) {
            System.out.print("Rellena el nombre de los alumnos: ");
            arraym[i][0] = sc.nextLine();
        }
        for (int i = 0; i < arraym.length; i++) {
            System.out.print("Rellena la nota de los alumnos: ");
            int nota = sc.nextInt();
            arraym[i][1] = String.valueOf(nota);
        }
        for (int i = 0; i < arraym.length; i++) {
            System.out.println("Nombre del alumno: "+arraym[i][0]+" su nota es= "+arraym[i][1]);

        }
    }
}