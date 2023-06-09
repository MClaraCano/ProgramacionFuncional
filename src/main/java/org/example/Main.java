package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    //JAVA es lenguaje multiparadigma
    //declarativo / POO

    //PROGRAMACION FUNCIONAL:
        /*
        Basado en funciones matemáticas
        Las variables no tienen estado: No cambian; son inmutables
        Los programas se estructuran componiendo expresiones que se evalúan
        como funciones.

        No existen las funciones cíclicas (for, while, etc), SIN EMBARGO
        las seguiremos usando en Java,
        ADEMAS de funciones de alto orden: Permiten iterar a través de serie de
        colecciones y conjunto de datos, apoyándonos en las expreciones
        LAMBDA y otros métodos

        EN lenguajes 100% funcionales, no hay tipos de datos.
        En Java, por medio de expresiones lambda vamos a poder hacer uso de los tipos
        (más bien, vamos a prescindir de declararlos y ese trabajo lo hará el compilador)

        Para todo esto, Java incorporó características como:
        - Expresiones lambda
        - Métodos referenciados
        - Interfaces funcionales

         */
    public static void main(String[] args) {

        System.out.println("");

        // Conocer cuántos num > 10 hay en una lista

        //declaramos lista de números
        //se usa sin instanciarlo. Es estático
        List<Integer> numeros = List.of(11,8,15,39,1,4,83);

        //resolvemos la problemática con ciclos y condicionales,
        // enfoque declarativo

        int contador = 0;

        for(int numero : numeros){
            if (numero > 10){
                contador++;
            }
        }
        System.out.println("Num mayores a diez son: " + contador);

        // enfoque imperativo

        /*
        STREAM: funcionalidad a partir de Java 8.
        Envoltorio para estructuras de datos

            Ayudan a manipular las colecciones.
            DECLARALO:

            Stream<String> valoresString = Stream.of ("Antonio", "Maria");

            .stream() // convierte otra lista en stream
            .filter (expresion lambda) // qué quiero que se filtre
            .contains("a") // filtra si contiene la "s"
            .collect(Collectors.toList() // crea una lista
            .map(s -> s.ToUpperCase()) // el map recorre todos los valores
            .anyMatch(s -> s.contains("M")) // si algún valor lo contiene, da true
            .distinct() // detecta repetidos
            .sorted() // ordena elementos
         */

        //se podría decir que es funcional, ya que delega el control de flujo
        // y condiciones a las funciones filter y count
        Long resultado = numeros.stream().filter(num -> num > 10 ).count();
        System.out.println("Resultado de num mayores a 10: " + resultado);

        Stream<String> streamString = Stream.of("Clara", "Fran", "Ana");
        List<String> listaA = streamString.filter(a -> a.contains("a")).collect(Collectors.toList());
        System.out.println("Palabras con ´a´: " + listaA);

        boolean streamDeBoolean = Stream.of("Antonoio", "Maria", "Jose")
                .filter(s -> s.contains("a"))
                .filter(s -> s.startsWith("M"))
                .anyMatch(s -> s.contains("z"));

        System.out.println("Expresión booleana: " + streamDeBoolean);


        List<String> strings = new ArrayList<>();
        strings.add("enero");
        strings.add("febrero");
        Stream<String> streangs = strings.stream();

        // FOREACH: no se puede encadenar con otra etapa del Stream

        // forma 1: - Con expresion LAMBDA
        streangs.forEach(s -> System.out.println("Mes: "+s));

        // forma 2: - Con REFERENCIA a función
        List<String> strings2 = new ArrayList<>();
        strings2.add("enero");
        strings2.add("febrero");
        Stream<String> streangs2 = strings2.stream();
        //               clase/método // método
        streangs2.forEach(System.out::println);

        //MAP

        //ejemplo 1
        List<String> numerosEnLetra = List.of("1", "2", "3", "4");

        List<Integer> numerosEnNumeros = numerosEnLetra.stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        System.out.println("MAP para conversión de tipo: " + numerosEnLetra);

        //ejemplo 2
        List<String> palabras = List.of("a", "b", "codi");
        palabras = palabras.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("MAP para pasar a mayúsculas: " + palabras);


        List<String> palabras2 = List.of("a", "b", "codi");
        palabras2 = palabras2.stream()
                .map(s -> s + "_MAPPER")
                .collect(Collectors.toList());
        System.out.println("MAP agregando _MAPPER" + palabras2);


        //REDUCE - permiten convertir una lista de elementos X en un resultado Y
        //el método reduce que recibe 2 parámetros:
        // un acumulador como primero y un elemento como segundo .
        //De esta forma realiza una funcionalidad de “reducción” convirtiendo
        // una lista de elementos en un único resultado.
        List<Integer> gastos= new ArrayList<Integer>();
        gastos.add(100);
        gastos.add(200);
        gastos.add(300);

        System.out.println("Resultado REDUCE: ");
        gastos.stream().reduce((acumulador, numero)->
        { return acumulador+numero;
            //ifPresent toma de argumento un Consumer:
            // si no está vacío, "acepta" el método (println)
        }).ifPresent(System.out::println);



        // EJEMPLO varios
        // Mostrar los números pares, de una lista de String,
        // sin repetir y ordenados
        //Devolver lista de STRING
        List<String> lista = new ArrayList<>();
        lista.add("1");
        lista.add("6");
        lista.add("2");
        lista.add("3");
        lista.add("4");
        lista.add("5");
        lista.add("2");


        List<String> listaInteger = lista.stream()
                /* otro modo de Integer a String:
                .map(s -> Integer.valueOf(s) */
                .map(s -> Integer.parseInt(s))
                .filter(s -> s % 2 == 0)
                //.filter(s -> s <= 4)
                .distinct() // quita repetidos
                .sorted() // los ordena
                .map(String::valueOf) // por detrás se crea una expresión lambda (implementación de interfaz funcional)
                .collect(Collectors.toList());

        System.out.println("NUEVA LISTA: " + listaInteger);



        /* INTERFAZ FUNCIONAL
        - Se declaran con @FunctionalInterface
        (hacerlo, ayuda a saber si la declaramos bien)
        - Tienen un solo método abstracto (a dif de las otras, que tiene todas)
        - Ese método abstracto, se representa al implementarlo
        con una expresión lambda o método referenciado

        Las más utilizadas:
        CONSUMER tiene método: void accept(T t) // acepta un objeto, y no devuelve nada
        PREDICATE tiene médoto: boolean test(T t) // devuelve V o F

         */










    }
}