package org.example.tiposmetodosref;

import java.util.Arrays;
import java.util.List;

public class TiposMetodosRef {

     /*MÉTODOS REFERENCIADOS - REFERENCIA DE METODOS

    Java realiza la inferencia de datos.
    Toma una clase / objeto, y un método.

    Más ejemplos: en referenceMethods

        4 tipos https://www.youtube.com/watch?v=mSd2qnWlIQQ:
        - Métodos estáticos
        - De un objeto
        - De un objeto arbitrario

      */

    public static void main(String[] args) {



        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Usu 1"),
                new Usuario("Usu 2")
        );

        //Enfoque declarativo para imprimir nombres de usuarios - LAMBDA:
        usuarios.forEach(usuario -> System.out.println(usuario.getNombre()));

        //Referencia a un método estático
        //          nombre clase actual :: método abstracto
        usuarios.forEach(TiposMetodosRef::MostrarNombre);

        //Referencia a un método de un objeto (instancia de clase)
        Prueba prueba = new Prueba();
        //                 objeto :: método
        usuarios.forEach(prueba::MostrarNombreDos);

        //Referencia a un método de un objeto arbitrario
        //                clase :: método
        usuarios.forEach(Usuario::imprimirNombre);

        //Referencia a un constructor - Necesario apoyarse en interfaz
        InterfaceCF cf = Usuario::new;
        Usuario usuario1 = cf.crearUsuario("Clara");
        Usuario usuario2 = cf.crearUsuario("Fran");
        Usuario usuario3 = cf.crearUsuario("Bee");

        System.out.println(usuario1.getNombre());


    }

    public static void MostrarNombre(Usuario usuario){
        System.out.println(usuario.getNombre());
    }

    // se hizo la clase anidada para que sea más sencillo. Puede ser externa
    public static class Prueba{
        public void MostrarNombreDos(Usuario usuario){
            System.out.println(usuario.getNombre());
        }
    }



}
