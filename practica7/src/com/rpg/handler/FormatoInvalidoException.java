package com.rpg.handler;

public class FormatoInvalidoException extends RPGDataException{
    // PARA ERRORES DE SINTAXIS EN JSON O TXT
    public FormatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
