package com.juego.modelo;
import com.juego.clases.*;
import com.juego.razas.*;
import java.util.Scanner;

public class GestorPersonajes {

    public GestorPersonajes() {
    }

    public Personaje crearpj () {
        System.out.print("¿Qué nombre quieres para tu personaje? ");
        Scanner sc = new Scanner(System.in);
        String nombrepj = sc.nextLine();



        int opcion;

        Clase claseElegida = null;
        IRaza razaElegida = null;
        do {
            System.out.println("Elige la Raza");
            System.out.println("1. Humano");
            System.out.println("2. Elfo");
            System.out.println("3. Enano");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    razaElegida = crearHumano();
                    break;
                case 2:
                    razaElegida = crearElfo();
                    break;
                case 3:
                    razaElegida = crearEnano();
                    break;
                default:
                    System.out.print("Opción no valida");
            }
        } while (razaElegida == null);


        do {
            System.out.println("Elige la Clase: ");
            System.out.println("1. Guerrero");
            System.out.println("2. Paladín");
            System.out.println("3. Monje");
            System.out.println("4. Pícaro");
            System.out.println("5. Druida");
            System.out.println("6. Sacerdote");
            System.out.println("7. Mago");
            System.out.println("8. Bardo");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    claseElegida = serGuerrero();
                    break;
                case 2:
                    claseElegida = serPaladin();
                    break;
                case 3:
                    claseElegida = serMonje();
                    break;
                case 4:
                    claseElegida = serPicaro();
                    break;
                case 5:
                    claseElegida = serDruida();
                    break;
                case 6:
                    claseElegida = serSacerdote();
                    break;
                case 7:
                    claseElegida = serMago();
                    break;
                case 8:
                    claseElegida = serBardo();
                    break;
                default:
                    System.out.print("Opción no valida");
            }

        } while (claseElegida == null);

        Personaje personaje = new Personaje(nombrepj, razaElegida, claseElegida);

        return personaje;
    }

    //-----------------------------------RAZAS------------------------------------------
    public Humano crearHumano() {
        Humano humano = new Humano();
        return humano;
    }
    public Elfo crearElfo() {
        Elfo elfo = new Elfo();
        return elfo;
    }
    public Enano crearEnano() {
        Enano enano = new Enano();
        return enano;
    }
    //------------------------------------CLASES---------------------------------------
    public Clase serGuerrero() {
        Guerrero guerrero = new Guerrero();
        return guerrero;
    }
    public Clase serPaladin() {
        Paladín paladín = new Paladín();
        return paladín;
    }
    public Clase serMonje() {
        Monje monje = new Monje();
        return monje;
    }
    public Clase serPicaro() {
        Pícaro picaro = new Pícaro();
        return picaro;
    }
    public Clase serDruida() {
        Druida druida = new Druida();
        return druida;
    }
    public Clase serSacerdote () {
        Sacerdote sacerdote = new Sacerdote();
        return sacerdote;
    }
    public Clase serMago () {
        Mago mago =  new Mago();
        return mago;
    }
    public Clase serBardo() {
        Bardo bardo = new Bardo();
        return bardo;
    }
}
