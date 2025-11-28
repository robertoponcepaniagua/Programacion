import java.util.Scanner;

public class MenuGestor {
    private Scanner sc;

    public MenuGestor() {
        sc = new Scanner(System.in);
    }

    public void ejecutarMenuPrincipal() {
        int opcion;

        do {
            System.out.println("---MENÚ GESTOR---");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Crear Área");
            System.out.println("3. Crear Médico");
            System.out.println("4. Modificar Médico");
            System.out.println("5. Modificar Hospital");
            System.out.println("6. Calcular Antigüedad");
            System.out.println("7. Calcular Sueldo Neto");
            System.out.println("8. Comprobar Edad");
            System.out.println("9. Proporción de Médicos");
            System.out.println("10. Capacidad de Área");
            System.out.println("11. Comparar Áreas");
            System.out.println("12. Contratos por Año");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: crearHospital(); break;
                case 2: crearArea(); break;
                case 3: crearMedico(); break;
                case 4: modificarMedico(); break;
                case 5: modificarHospital(); break;
                case 6: calcularAntiguedad(); break;
                case 7: calcularSueldoNeto(); break;
                case 8: comprobarEdad(); break;
                case 9: proporcionMedicos(); break;
                case 10: capacidadAreas(); break;
                case 11: compararAreas(); break;
                case 12: contratosAño(); break;
                case 0:
                    System.out.print("Saliendo...");
                    break;
            }
        } while (opcion != 0);
    }

    private void crearHospital() {
        System.out.print("Dime el Nombre del Hospital");
        String Nombre = sc.nextLine();
        sc.nextLine();

        System.out.println("Dime el CIF del Hospital");
        String CIF = sc.nextLine();
        sc.nextLine();

        System.out.println("--Dirección--");
        System.out.println("Calle");
        String calle = sc.nextLine();
        System.out.println("Numero");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.println("CP:");
        Integer cp = sc.nextInt();
        sc.nextLine();
        System.out.println("Ciudad:");
        String ciudad = sc.nextLine();
        System.out.println("Provincia:");
        String provincia = sc.nextLine();

    }
}
