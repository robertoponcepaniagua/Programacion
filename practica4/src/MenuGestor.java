import javax.management.MalformedObjectNameException;
import javax.swing.event.MouseInputAdapter;
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
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearHospital();
                    break;
                case 2:
                    crearArea();
                    break;
                case 3:
                    crearMedico();
                    break;
                case 4:
                    modificarMedico();
                    break;
                case 5:
                    modificarHospital();
                    break;
                case 6:
                    calcularAntiguedad();
                    break;
                case 7:
                    calcularSueldoNeto();
                    break;
                case 8:
                    comprobarEdad();
                    break;
                case 9:
                    proporcionMedicos();
                    break;
                case 10:
                    capacidadAreas();
                    break;
                case 11:
                    compararAreas();
                    break;
                case 12:
                    contratosAño();
                    break;
                case 0:
                    System.out.print("Saliendo...");
                    break;
            }
        } while (opcion != 0);
    }

    //---------------------------CREAR HOSPITAL------------------------------------
    private void crearHospital() {
        System.out.println("Dime el Nombre del Hospital");
        String Nombre = sc.nextLine();
        sc.nextLine();

        System.out.println("Dime el CIF del Hospital");
        String CIF = sc.nextLine();
        sc.nextLine();

        System.out.println("--DIRECCIÓN--");
        System.out.println("Calle: ");
        String calle = sc.nextLine();
        System.out.println("Numero: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.println("CP: ");
        Integer cp = sc.nextInt();
        sc.nextLine();
        System.out.println("Localidad: ");
        String localidad = sc.nextLine();
        System.out.println("Provincia: ");
        String provincia = sc.nextLine();
        sc.nextLine();

        Direccion dir = new Direccion(calle, numero, cp, localidad, provincia);
        Hospital h = new Hospital(Nombre, CIF, dir);
        Main.hospitales.add(h);
    }


    //--------------------------------CREAR AREA----------------------------------------------------
    public void crearArea() {
        System.out.println("Seleccione un Hospital");
        for (int i = 0; i < Main.hospitales.size(); i++) {
            System.out.println(i + "." + Main.hospitales.get(i).getNombre());
        }

        int opcion = sc.nextInt();
        sc.nextLine();

        Hospital h = Main.hospitales.get(opcion);


        System.out.println("--CREAR ÁREA--");
        System.out.print("Nombre del área: ");
        String nombre = sc.nextLine();

        System.out.print("Identificador del área: ");
        String id = sc.nextLine();

        System.out.print("Planta: ");
        int planta = sc.nextInt();
        sc.nextLine();

        Area a = new Area(nombre, id, planta, h);

        h.agregarArea(a);
        Main.areas.add(a);
        System.out.println("Área creada correctamente.");
    }

    //-----------------------------------CREAR MÉDICO----------------------------------------------
    private void crearMedico() {

        System.out.println("Seleccione un Area");
        for (int i = 0; i < Main.areas.size(); i++) {
            System.out.println(i + "." + Main.areas.get(i).getNombre());
        }
        int opcion = sc.nextInt();
        sc.nextLine();
        Area a = Main.areas.get(opcion);

        System.out.println("DNI del médico");
        String dni = sc.nextLine();
        System.out.println("Nombre");
        String nombre_medico = sc.nextLine();
        System.out.println("Edad");
        Integer edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Sexo");
        String sexo = sc.nextLine();
        System.out.println("Sueldo Bruto");
        double sueldobruto = sc.nextDouble();
        sc.nextLine();
        System.out.println("Fecha de Inicio");
        Integer fechadeinicio = sc.nextInt();
        sc.nextLine();

        Medico m = new Medico(dni, nombre_medico, edad, sexo, sueldobruto, fechadeinicio, a);

        a.incrementarmedicos();
        Main.medicos.add(m);

        Contrato c = new Contrato(fechadeinicio, m, a.getHospital());
        Main.contratos.add(c);
    }

    //--------------------------------------------MODIFICAR MEDICO-----------------------------------------------
    public void modificarMedico() {

        Medico m = pedirMedico();             //La función pedir medico está al final
        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }

        System.out.println("Elige lo que quieras modificar:");
        System.out.println("1. Sueldo Bruto");
        System.out.println("2. Área de trabajo");

        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 1) {
            System.out.println("Nuevo Sueldo Bruto: ");
            double sueldobrutonuevo = sc.nextDouble();
            m.setSueldo_Bruto(sueldobrutonuevo);
            System.out.println("Sueldo actualizado");
        }

        if (opcion == 2){
            System.out.println("Nuevo Area de Trabajo: ");
            String id = sc.nextLine();
            Area areanueva = Main.buscarArea(id);
            if (areanueva != null) {
                m.cambiarArea(areanueva);
                System.out.println("Area cambiada correctamente");
            } else {
                System.out.println("Area no encontrada");
                return;
            }
        }
    }

    //------------------5. Modificar Hospital------------------
    private void modificarHospital() {
        Hospital h = pedirHospital();                           //la función pedir hospital está abajo
        if (h == null) {
            System.out.println("Hospital no encontrado");
            return;
        }

        System.out.println("Elige lo que quieras modificar");
        System.out.println("1. Nombre");
        System.out.println("2. Dirección");

        int opcion = sc.nextInt();
        sc.nextLine();

    }
    //------------------6. Calcular Antigüedad------------------
    private void calcularAntiguedad() {
        Medico m = pedirMedico();
        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }
        System.out.println("Calculando Antiguedad...");
        System.out.println("Años de antiguedad: " + m.getAniosAntiguedad());
    }

    //------------------7. Calcular Sueldo Neto-----------------
    private void calcularSueldoNeto() {
        Medico m = pedirMedico();
        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }
        double retencion;
        System.out.println("Introduzca la retención: ");
        retencion = sc.nextDouble();
        double calculo = m.getSueldo_Bruto() - (m.getSueldo_Bruto() * (retencion / 100));
        System.out.println("Sueldo Neto: "+ calculo);
    }

    //------------------8. Comprobar Edad-----------------------
    private void comprobarEdad() {
        Medico m = pedirMedico();
        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }
        System.out.println("Escribe la edad mínima: ");
        int MayoriaDeEdad = sc.nextInt();
        System.out.println("El Médico"+m.getNombre()+" es mayor o igual "+ m.esMayorDeEdad(MayoriaDeEdad));
    }

    //------------------9. Proporción de Médicos---------------
    private void proporcionMedicos() {
        Hospital h = pedirHospital();
        if (h == null) {
            System.out.println("Hospital no encontrado");
            return;
        }

        System.out.print("Escribe el Identificador del Area: ");
        String id = sc.nextLine();

        if (!h.existeArea(id)) {
            System.out.println("Area no encontrada en Hospital introducido");
            return;
        }
        double proporcion = h.getProporcionMedicosArea(id);
        System.out.println(proporcion);
    }

    //------------------10. Capacidad de Área------------------
    private void capacidadAreas() {
    }

    //------------------11. Comparar Áreas---------------------
    private void compararAreas() {

    }

    //------------------12. Contratos por Año------------------
    private void contratosAño() {

    }

    //Funciones para código más claro
    public Medico pedirMedico() {
        System.out.print("Introduce el DNI del médico: ");
        String dni = sc.nextLine();
        Medico m = Main.buscarMedico(dni);
        if (m == null) {
            System.out.println("Médico no encontrado.");
        }
        return m;
    }
    public Hospital pedirHospital() {
        System.out.print("Introduce el CIF del Hospital: ");
        String cif = sc.nextLine();
        Hospital h = Main.buscarHospital(cif);
        if (h == null) {
            System.out.println("Hospital no encontrado.");
        }
        return h;
    }
    public Area pedirArea() {
        System.out.print("Introduce el Identificador de Area: ");
        String identificador = sc.nextLine();
        Area a = Main.buscarArea(identificador);
        if (a == null) {
            System.out.println("Area no encontrada.");
        }
        return a;
    }
}