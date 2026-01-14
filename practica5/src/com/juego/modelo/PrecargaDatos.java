package com.juego.modelo;


import com.juego.clases.*;
import com.juego.habilidades.CuraCC;
import com.juego.habilidades.DanioCC;
import com.juego.habilidades.DanioLD;
import com.juego.habilidades.Habilidad;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.IRaza;

import java.util.ArrayList;
import java.util.List;

public class PrecargaDatos {

    //RAZAS

    Humano humano = new Humano(100, 5, 5, 5, 5, 5);
    Elfo elfo = new Elfo(110, 7, 6, 4, 4, 3);
    Enano enano = new Enano(90, 4 , 3, 6, 7, 7);

    //CLASES

    Bardo bardo = new Bardo();
    Druida druida = new Druida();
    Guerrero guerrero = new Guerrero();
    Mago mago = new Mago();
    Monje monje = new Monje();
    Paladín paladin = new Paladín();
    Pícaro picaro = new Pícaro();
    Sacerdote sacerdote = new Sacerdote();

    //ARRAYLIST PARA GUARDAR PJ
    List<Personaje> personajes = new ArrayList<>();

    public List<Personaje> precargaPJ() {

        personajes.add(crearPersonaje("Guerrero Elmet", humano, guerrero));
        personajes.add(crearPersonaje("Bardo Lyria", elfo, bardo));
        personajes.add(crearPersonaje("Druida Thorne", enano, druida));
        personajes.add(crearPersonaje("Mago Eldrin", humano, mago));
        personajes.add(crearPersonaje("Monje Kiro", elfo, monje));
        personajes.add(crearPersonaje("Paladin Arthus", humano, paladin));
        personajes.add(crearPersonaje("Picaro Vex", enano, picaro));
        personajes.add(crearPersonaje("Sacerdote Alaric", elfo, sacerdote));
        personajes.add(crearPersonaje("Guerrero Brak", enano, guerrero));
        personajes.add(crearPersonaje("Mago Selene", elfo, mago));

        return personajes;
    }
    public void precargaHabilidades() {
        //Habilidades Bardo
        DanioCC NotaDePoder = new DanioCC("Nota de Poder", "Dispara una onda de sonido en línea que inflige daño a los enemigos",15,5,"inteligencia");
        CuraCC NotaVital = new CuraCC("Nota Vital","Armonía que restaura gran cantidad de Vitalidad",18,3,"inteligencia");
        DanioLD Crescendo =  new DanioLD("Crescendo","Ataque de área que aturde a todos los enemigos",30,5,"inteligencia");

        // Habilidades Druida
        DanioCC ZarzalOpresor = new DanioCC("Zarzal opresor","Golpea el suelo, infligiendo daño mágico a los enemigos cercanos",20,5,"fuerza");
        CuraCC Drenado = new CuraCC("Drenado","Drena la Fuerza vital del suelo para recuperar Vitalidad",15,3,"inteligencia");
        DanioLD GarrasDeLaNaturaleza = new DanioLD("Garras de la naturaleza","Oleada colosal de zarzas y pinchos que avanza lentamente, otorgando grandes heridas",30,1,"inteligencia");

        // Habilidades Guerrero
        DanioCC GolpeEspada = new DanioCC("Golpe de espada","Ataque cuerpo a cuerpo con la espada que inflige daño físico constante al enemigo.",15,5,"fuerza");
        CuraCC PersistenciaGuerrera = new CuraCC("Persistencia Guerrera","El guerrero canaliza su fuerza interior para recuperar Vitalidad",10,3,"inteligencia");
        DanioLD GuillotinaSangrienta = new DanioLD("Guillotina Sangrienta","El guerrero ejecuta un golpe brutal descendente que inflige un daño devastador",35,1,"fuerza");

        // Habilidades Mago
        DanioCC Descarga = new DanioCC("Descarga","Estallido mágico a corta distancia",15,5,"inteligencia");
        CuraCC Sanar = new CuraCC("Sanar","Sanación mágica",12,3,"inteligencia");
        DanioLD LlamaradaFinal = new DanioLD("Llamarada Final","Llamarada potente como la llama de un dragón",35,1,"inteligencia");

        // Habilidades Monje
        DanioCC SaltoAgil = new DanioCC("Salto Ágil","Salta hacia un enemigo, golpeándole con su bastón",15,5,"fuerza");
        CuraCC Meditacion = new CuraCC("Meditación","El monje canaliza energía interna para curarse",12,3,"inteligencia");
        DanioLD MilBrazos = new DanioLD("Mil Brazos","El monje se concentra y aparecen brazos gigantes de su espalda que atacan a distancia.",30,1,"fuerza");

        // Habilidades Paladin
        DanioCC Golpe = new DanioCC("Golpe","Golpe básico pero temible",16,5,"fuerza");
        CuraCC VoluntadInquebrantable = new CuraCC("Voluntad Inquebrantable","La voluntad del paladín hace que recupere vitalidad y luche con más ganas",12,3,"inteligencia");
        DanioLD JuicioDivino = new DanioLD("Juicio Divino","El paladín invoca una espada de luz sagrada que cae del cielo sobre el enemigo",30,1,"fuerza");

        // Habilidades Picaro
        DanioCC Cuchillada = new DanioCC("Cuchillada","Acuchilla al enemigo a alta velocidad",17,5,"velocidad");
        CuraCC SangreRobada = new CuraCC("Sangre Robada","Roba vitalidad del enemigo para curarse",10,3,"inteligencia");
        DanioLD MarcaSombra = new DanioLD("Marca Sombra","Convierte su sombra en clones que atacan al enemigo marcado, los clones no se pueden diferenciar del real",35,1,"destreza");

        // Habilidades Sacerdote
        DanioCC RafagaRadiante = new DanioCC("Ráfaga Radiante","Espada celestial que atraviesa a los enemigos",15,5,"inteligencia");
        CuraCC GraciaCelestial = new CuraCC("Gracia celestial","Al rezar es bendecida por los dioses y le otorgan vitalidad",15,3,"inteligencia");
        DanioLD VeredictoDivino = new DanioLD("Veredicto divino","Al rezar invoca una lluvia de espadas sagradas que purifica la zona",30,1,"inteligencia");

    }

    //---------------------------------------CREAR PJ--------------------------------------
    private Personaje crearPersonaje(String nombre, IRaza raza, Clase clase) {
        Personaje pj = new Personaje(nombre,raza,clase);
        return pj;
    }
    //---------------------------------------ACCEDER A ARRAYLIST--------------------------
    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
