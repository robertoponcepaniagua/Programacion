import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] arraym = new String[5][2];

        // Introducir nombres por teclado
        for (int i = 0; i < arraym.length; i++) {
            System.out.print("Rellena el nombre de los alumnos: ");
            arraym[i][0] = sc.nextLine();
        }

        // Introducir notas por teclado
        for (int i = 0; i < arraym.length; i++) {
            System.out.print("Rellena la nota de los alumnos: ");
            int nota = sc.nextInt();
            sc.nextLine();
            arraym[i][1] = String.valueOf(nota);
        }
        //buscar el alumno
        System.out.print("Escribe el nombre de un alumno para ver su nota: ");
        String NombreBuscado = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < arraym.length; i++) {
            if (arraym[i][0].equalsIgnoreCase(NombreBuscado)) {
                System.out.println(arraym[i][0] + " tiene de nota un: " + arraym[i][1]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Alumno no encontrado");
        }
    }
}
