package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class referenceMethods {
    public static void main(String[] args) {

        // utilizaremos en la interface Consumer que tiene un unico metodo denominado accept
        // el cual recibe un parametro y no devuelve nada
        Consumer<String> consumidor = x -> System.out.println(x);
        consumidor.accept("Bienvenido");

        procesar(x -> System.out.println(x), "Bienvenido2");
        // Pasamos como referencia una funcion que se encuentra en nuestro propio programa
        // :: -> operador de ámbitp
        //clase u objeto del método /  nombre del método
        procesar(referenceMethods::saludar, "Bienvenido3");
    }
    public static <T> void procesar(Consumer<T> expresion, T mensaje) {
        expresion.accept(mensaje);
    }
    // Disponemos de otro metodo en la misma clase que cumple con el patron
    // de la expresion lambda (recibe un parametro y no devuelva nada)
    public static void saludar(String saludo) {
        System.out.println(saludo);
    }





}
