package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class referenceMethods {

    public static <T> void procesar(Consumer<T> expresion, T mensaje) {
        expresion.accept(mensaje);
    }
    // Disponemos de otro metodo en la misma clase que cumple con el patron
    // de la expresion lambda (recibe un parametro y no devuelva nada)
    public static void saludar(String saludo) {
        System.out.println(saludo);
    }

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




        //Ejemplo más sencillo de referencia de métodos:
        List<String> personas = Arrays.asList("Clara", "Belén", "Fran", "");
        List<String> personas2 = Arrays.asList("Clara", "Belén", "Fran");

        System.out.println("Recorrido for each tradicional");
        for (String perso : personas){
            System.out.println(perso);
        }

        System.out.println("Recorrido con expresión Lambda (llama a Consumer)");
        personas.forEach(p -> System.out.println(p));

        System.out.println("Recorrido con método referenciado");
        personas.forEach(System.out::println);

        System.out.println("Búsqueda de persona con Lambda");
        String persona = "Clara";

        List<String> busqueda = personas.stream()
                .filter(s -> s.contains("Clara"))
                .collect(Collectors.toList());
        System.out.println(busqueda);

        System.out.println("Otra variante de búsqueda de persona con Lambda");
        personas2.stream()
                .filter(s -> persona.equals(s))
                .forEach(System.out::println);

        System.out.println("Otra variante de búsqueda de persona con método referenciado");
        personas2.stream()
                .filter(persona::equals)
                .forEach(System.out::println);

        System.out.println("Contar espacios vacíos con Lambda");
        System.out.println(personas.stream().filter(s -> s.isEmpty()).count());

        System.out.println("Contar espacios vacíos con método referenciado");
        //ya que la "s" hace rferencia al stream, y el stream es de String...
        System.out.println(personas.stream().filter(String::isEmpty).count());






    }










}
