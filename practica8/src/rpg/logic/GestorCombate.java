package rpg.logic;

import com.sun.source.tree.WhileLoopTree;
import rpg.dao.*;
import rpg.exception.RPGException;
import rpg.model.*;
import rpg.ui.MenuUtils;
import rpg.utils.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorCombate {
    private Scanner sc;
    private Log logger;

    //DAO
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseRPGDAO claseRPGDAO;
    private CiudadDAO ciudadDAO;
    private ItemDAO itemDAO;
    private InventarioDAO inventarioDAO;
    private HabilidadDAO habilidadDAO;
    private PersonajeHabilidadDAO personajeHabilidadDAO;

    public GestorCombate() throws RPGException {
        this.sc = new Scanner(System.in);
        this.logger = new Log("practica8/Ficheros/info.log");

        //DAO
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseRPGDAO = new ClaseRPGDAO();
        this.ciudadDAO = new CiudadDAO();
        this.itemDAO = new ItemDAO();
        this.inventarioDAO = new InventarioDAO();
        this.habilidadDAO = new HabilidadDAO();
        this.personajeHabilidadDAO = new PersonajeHabilidadDAO();

    }


    public void menu() throws RPGException {
        int opcion;

        do {
            cabecera();
            System.out.println(" 1. Combate");
            System.out.println(" 0. Salir");
            separador();

            System.out.println("Elige: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    // IDEA DEL COMBATE
                    // WHILE VIDA <= 0 SEGUIMOS EL COMBATE
                    // ELEGIMOS LA HABILIDADES CON UN MENÚ ( A SER QUE SEA BONITO )
                    // REVISAR SI LA HABILIDAD TIENE SUFICIENTES USOS, SI NO TIENE USOS VOLVEMOS 1 ARRIBA
                    // LE HACEMOS DAÑO AL OTRO
                    // COMPROBAMOS SI MUERE, SI NO VOLVEMOS AL WHILE DE ARRIBA
                    // EL QUE GANA LO MOSTRAMOS , LE SUMAMOS MONEDAS Y +1 NIVEL
                    // EL QUE PIERDA , LE RESTAMOS MONEDAS Y MOSTRAMOS QUE HA PERDIDO TAMBIÉN


                    System.out.println("Elige a 2 Personajes: ");
                    List<Personaje> personajes = personajeDAO.listarPersonajes();
                    //MOSTRAR PERSONAJES DISPONIBLES
                    for (Personaje p : personajes) {
                        System.out.println(p.toString());
                    }

                    System.out.print("ID del Jugador 1: ");
                    int id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("ID del Jugador 2: ");
                    int id2 = sc.nextInt(); sc.nextLine();

                    Personaje jugador1 = buscarPersonajePorId(personajes, id1);
                    Personaje jugador2 = buscarPersonajePorId(personajes, id2);

                    // Aplicar bonificaciones de raza
                    List<Raza> razas = razaDAO.listarRazas();
                    Raza raza1 = buscarRazaPorId(razas, jugador1.getIdRaza());
                    Raza raza2 = buscarRazaPorId(razas, jugador2.getIdRaza());
                    if (raza1 != null) jugador1.aplicarBonificaciones(raza1);
                    if (raza2 != null) jugador2.aplicarBonificaciones(raza2);

                    // Calcular estadísticas de combate usando inventario
                    //  PJ1
                    int ataque1 = calcularAtaqueFisico(jugador1, raza1);
                    int defensa1 = calcularDefensa(jugador1);
                    // PJ2
                    int ataque2 = calcularAtaqueFisico(jugador2, raza2);
                    int defensa2 = calcularDefensa(jugador2);

                    separador();

                    imprimirFicha(jugador1, ataque1, defensa1);
                    imprimirFicha(jugador2, ataque2, defensa2);

                    separador();

                    enter();

                    int turnos = 0;

                    List<Habilidades> habilidadesJugador1 = habilidadDAO.listarHabilidadesPersonaje(jugador1.getId());
                    List<Habilidades> habilidadesJugador2 = habilidadDAO.listarHabilidadesPersonaje(jugador2.getId());

                    while(jugador1.getSalud() > 0 && jugador2.getSalud() > 0) {
                        turnos++;
                        System.out.println("TURNO: " + turnos);
                        separador();

                        // ELEGIR ATAQUE PJ1
                        // MOSTRAR ATAQUES DE PJ1
                        // COMPROBAR SI TIENE USOS DISPONIBLES EL ATAQUE, SI TIENE RESTAR USO, SI NO ELEGIR OTRO ATAQUE
                        imprimirFicha(jugador1,ataque1,defensa1);
                        System.out.println("-------------------------");
                        System.out.println("-   ELIGA HABILIDAD     -");
                        System.out.println("-------------------------");
                        System.out.println(); // MENU PARA ELEGIR HABILIDAD

                        System.out.println(" 0. Ataque Básico (sin coste de usos)");
                        for (Habilidades h : habilidadesJugador1) {
                            if (h.getUsos_maximos() > 0) {
                                System.out.println(h.toString());
                            }
                        }
                        separador();

                        int idElegidaPJ1 = sc.nextInt();
                        Habilidades habilidadPJ1 = null;
                        int dano1;

                        if (idElegidaPJ1 == 0) {
                            dano1 = calcularDanoBasico(ataque1, jugador2);
                        } else {
                            habilidadPJ1 = buscarHabilidadPorId(habilidadesJugador1, idElegidaPJ1);
                            while (habilidadPJ1 == null || verificarUsos(habilidadPJ1)) {
                                if (habilidadPJ1 == null) {
                                    System.out.println("NO VALIDA");
                                } else {
                                    System.out.println("ELIGE OTRA HABILIDAD");
                                }
                                idElegidaPJ1 = sc.nextInt();
                                if (idElegidaPJ1 == 0) break; // Por si cambia de opinión
                                habilidadPJ1 = buscarHabilidadPorId(habilidadesJugador1, idElegidaPJ1);
                            }
                            dano1 = (idElegidaPJ1 == 0)
                                    ? calcularDanoBasico(ataque1, jugador2)
                                    : calcularDanoHabilidad(habilidadPJ1, jugador2);
                            if (idElegidaPJ1 != 0) restarUso(habilidadPJ1);
                        }

                        // ELEGIR ATAQUE PJ2
                        // MOSTRAR ATAQUES PJ2
                        // COMPROBAR SI TIENE USOS DISPONIBLES EL ATAQUE, SI TIENE RESTAR USO, SI NO ELEGIR OTRO ATAQUE
                        imprimirFicha(jugador2,ataque2,defensa2);
                        System.out.println("-------------------------");
                        System.out.println("    ELIGA HABILIDAD     ");
                        System.out.println("-------------------------");

                        System.out.println(" 0. Ataque Básico (sin coste de usos)");
                        for (Habilidades h : habilidadesJugador2) {
                            if (h.getUsos_maximos() > 0) {
                                System.out.println(h.toString());
                            }
                        }
                        separador();

                        int idElegidaPJ2 = sc.nextInt();
                        Habilidades habilidadPJ2 = null;
                        int dano2;

                        if (idElegidaPJ2 == 0) {
                            dano2 = calcularDanoBasico(ataque2, jugador1);
                        } else {
                            habilidadPJ2 = buscarHabilidadPorId(habilidadesJugador2, idElegidaPJ2);
                            while (habilidadPJ2 == null || verificarUsos(habilidadPJ2)) {
                                if (habilidadPJ2 == null) {
                                    System.out.println("NO VALIDA");
                                } else {
                                    System.out.println("ELIGE OTRA HABILIDAD");
                                }
                                idElegidaPJ2 = sc.nextInt();
                                if (idElegidaPJ2 == 0) break;
                                habilidadPJ2 = buscarHabilidadPorId(habilidadesJugador2, idElegidaPJ2);
                            }
                            dano2 = (idElegidaPJ2 == 0)
                                    ? calcularDanoBasico(ataque2, jugador1)
                                    : calcularDanoHabilidad(habilidadPJ2, jugador1);
                            if (idElegidaPJ2 != 0) restarUso(habilidadPJ2);
                        }

                        // RESTAR VIDA Y MOSTRAR DAÑO PJ1 A PJ2
                        if (habilidadPJ1 != null) {
                            vistaDanoHabilidad(habilidadPJ1, dano1);
                        } else {
                            System.out.println(jugador1.getNombre() + " usa ATAQUE BÁSICO y hace " + dano1 + " de daño!");
                        }
                        jugador2.setSalud(jugador2.getSalud() - dano1);
                        enter();

                        // RESTAR VIDA Y MOSTRAR DAÑO PJ2 A PJ1
                        if (habilidadPJ2 != null) {
                            vistaDanoHabilidad(habilidadPJ2, dano2);
                        } else {
                            System.out.println(jugador2.getNombre() + " usa ATAQUE BÁSICO y hace " + dano2 + " de daño!");
                        }
                        jugador1.setSalud(jugador1.getSalud() - dano2);
                        enter();

                        if (jugador1.getSalud() <= 0 && jugador2.getSalud() <= 0) {
                            System.out.println("---EMPATE---");
                            enter();
                            break;
                        }

                        //COMPROBAMOS SI ALGUIEN HA GANADO
                        if (jugador2.getSalud() <= 0) {
                            System.out.println("---EL JUGADOR 1 HA GANADO---");
                            System.out.println("---GANADOR---");
                            imprimirFicha(jugador1, ataque1, defensa1);
                            System.out.println("EL JUGADOR 1 HA SUBIDO DE NÍVEL");
                            int nivel1 = jugador1.getNivel() +1;
                            jugador1.setNivel(nivel1);

                            personajeDAO.actualizarNivel(jugador1.getId(), jugador1.getNivel());

                            int robo = (int) (jugador2.getOro() * 0.2);
                            personajeDAO.actualizarOro(jugador1.getId(), (jugador1.getOro() + robo));
                            personajeDAO.actualizarOro(jugador2.getId(), (jugador2.getOro() - robo));

                            break;
                        }

                        if (jugador1.getSalud() <= 0) {
                            System.out.println("---EL JUGADOR 2 HA GANADO---");
                            System.out.println("---GANADOR---");
                            imprimirFicha(jugador2, ataque2, defensa2);
                            System.out.println("EL JUGADOR 2 HA SUBIDO DE NÍVEL");
                            int nivel2 = jugador2.getNivel() +1;
                            jugador2.setNivel(nivel2);

                            personajeDAO.actualizarNivel(jugador2.getId(), jugador2.getNivel());

                            int robo = (int) (jugador1.getOro() * 0.2);
                            personajeDAO.actualizarOro(jugador2.getId(),(jugador2.getOro() + robo));
                            personajeDAO.actualizarOro(jugador1.getId(), (jugador1.getOro() - robo));

                            break;

                        }

                        //MOSTRAR FICHAS
                        imprimirFicha(jugador1, ataque1, defensa1);
                        imprimirFicha(jugador2, ataque2, defensa2);

                        enter();
                    }
                    break;

                case 0:
                    break;
            }
        } while (opcion != 0);
    }


    public void imprimirFicha(Personaje j, int atq, int def) {
        String nombre = j.getNombre().toUpperCase();
        int id = j.getId();
        int hp = j.getSalud();
        int hpMax = j.getSaludMax();

        String lineaHp = "║ HP:  " + hp + "/" + hpMax;

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║ " + nombre);
        System.out.println("║ ID: #" + id);
        System.out.println("╠═══════════════════════════╣");
        System.out.println("║ ATQ: " + atq);
        System.out.println("║ DEF: " + def);
        System.out.println(lineaHp);
        System.out.println("╚═══════════════════════════╝");
    }


    public void cabecera() {
        System.out.println("_________  ________      _____ __________    ___________________________\n" +
                "\\_   ___ \\ \\_____  \\    /     \\\\______   \\  /  _  \\__    ___/\\_   _____/\n" +
                "/    \\  \\/  /   |   \\  /  \\ /  \\|    |  _/ /  /_\\  \\|    |    |    __)_ \n" +
                "\\     \\____/    |    \\/    Y    \\    |   \\/    |    \\    |    |        \\\n" +
                " \\______  /\\_______  /\\____|__  /______  /\\____|__  /____|   /_______  /\n" +
                "        \\/         \\/         \\/       \\/         \\/                 \\/ ");
    }

    public void separador() {
        System.out.println();
        System.out.println("﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌﹌");
        System.out.println();
    }

    public void enter() {
        System.out.println("----PULSA ENTER PARA CONTINUAR----");
        sc.nextLine();
        sc.nextLine();
    }

    private Personaje buscarPersonajePorId(List<Personaje> lista, int id) {
        for (Personaje p : lista) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private Raza buscarRazaPorId(List<Raza> lista, int id) {
        for (Raza r : lista) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    private Habilidades buscarHabilidadPorId(List<Habilidades> lista, int id) {
        for (Habilidades h : lista) {
            if (h.getId() == id) return h;
        }
        return null;
    }

    private int calcularAtaqueFisico(Personaje pj, Raza raza) {
        int fuerzaBase = 0;
        if (raza != null)  {
            fuerzaBase = raza.getBonificador_fuerza();
        }
        int bonusItems = 0;
        List<Item> items = inventarioDAO.listarItemsPersonaje(pj.getId());
        for (Item item : items) {
            bonusItems += item.getBonificador_ataque();
        }
        return fuerzaBase + bonusItems;
    }

    private int calcularDefensa(Personaje pj) {
        int defensa = 0;
        List<Item> items = inventarioDAO.listarItemsPersonaje(pj.getId());
        for (Item item : items) {
            defensa += item.getBonificador_defensa();
        }
        return defensa;
    }

    private int calcularDanoHabilidad(Habilidades habilidad, Personaje pj) {
        // DAÑO BASE DE LA HABILIDAD - (DEFENSA TOTAL DEL ENEMIGO / 2)
        return habilidad.getDano_base() - (calcularDefensa(pj) / 2);
    }

    private void vistaDanoHabilidad(Habilidades habilidad, int dano) {
        System.out.println("Usa " + habilidad.getNombre() + " y provocas " + dano + " de daño.");
    }

    public boolean verificarUsos(Habilidades habilidad) {
        return habilidad.getUsos_maximos() <= 0;
    }
    private void restarUso(Habilidades habilidad) {
        int usosActuales = habilidad.getUsos_maximos();
        if (usosActuales > 0) {
            habilidad.setUsos_maximos(usosActuales - 1);
        }
    }

    private int calcularDanoBasico(int ataqueAtacante, Personaje defensor) {
        int dano = ataqueAtacante - (calcularDefensa(defensor) / 2);
        return Math.max(1, dano);  // PARA HACER MÍNIMO 1 DE DAÓ
    }
}
