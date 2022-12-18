package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        procesoPrac();
    }

    public static void procesoPrac(){
        System.out.println();
        System.out.println("--PRÁCTICA--\n\nEste programa sirve para generar, llenar y vaciar una cola circular con objetos.");

        int tama = preguntarTama();
        ColaCirc CP = new ColaCirc(tama);
        menInsEl(CP);
        imprimirArr(CP);
    }

    public static int preguntarTama(){
        System.out.println();
        Scanner lector = new Scanner(System.in);
        System.out.println("Defina el tamaño de la cantidad de objetos que registrará: ");
        return lector.nextInt();
    }

    public static void menInsEl(ColaCirc CP) {
        System.out.println();
        Scanner lector = new Scanner(System.in);

         CP.cel2 = new Celular(); //Llamada de la creación de cada uno de los objetos que se guardará en el arreglo de la clase.
        System.out.println();

        int i;
        do {
            System.out.println("Elija 0 para Insertar y 1 para Eliminar elementos de la cola: ");
            int opt = lector.nextInt();
            System.out.println();
            switch (opt) {
                case 0 -> {
                    System.out.println("Ingrese los datos del celular: ");
                    System.out.println("Modelo: ");
                    CP.cel2.modelo = lector.next();
                    System.out.println("Almacenamiento: ");
                    CP.cel2.almacenamiento = lector.next();
                    System.out.println("Procesador: ");
                    CP.cel2.procesador = lector.next(); //Objeto Cola que a su vez invoca a arreglo de objetos Celular y su atributo.
                    System.out.println();
                    CP.insertar(CP.cel2);
                }
                case 1 -> CP.eliminar();
            }
            System.out.println();
            System.out.println("¿Desea finalizar? 1 para Sí. 0 para No.");
            i = lector.nextInt();
            System.out.println();
        } while (i != 1);
    }

    public static void imprimirArr(ColaCirc CP){
        System.out.println();
        System.out.println("Contenido de la cola circular: ");
        CP.imprimirCola();
    }
}

/*
    public static void procesoEj() {
        System.out.println("--EJERCICIO--\n\nEste programa sirve para generar, llenar y vaciar una cola circular predefinidamente con cadenas.");
        ColaCirc C = new ColaCirc(6);

        System.out.println();
        C.insertar("AA");
        System.out.println();
        C.insertar("BB");
        System.out.println();
        C.insertar("CC");
        System.out.println();
        C.eliminar();
        System.out.println();
        C.insertar("DD");
        System.out.println();
        C.insertar("EE");
        System.out.println();
        C.insertar("FF");
        System.out.println();
        C.insertar("GG");
        System.out.println();
        C.insertar("HH");
        System.out.println();
        C.eliminar();
        System.out.println();
        C.eliminar();
        imprimir(C);
        System.out.println();
        System.out.println();
        System.out.println("La cola circular «C» quedó con 4 elementos, siendo «DD, EE, FF» y «GG», pues se eliminaron «AA, BB» y «CC». Además, hubo un desbordamiento con «HH» antes de borrar los componentes previos.\nEste error se debió a que «HH» se almacenaría en la posición n°7, inexistente para el arreglo lleno de tamaño 6 en ese momento.");
    }

    public static void procesoEj2(){
        System.out.println("--EJERCICIO--\n\nEste programa sirve para generar, llenar y vaciar una cola circular predefinidamente con cadenas.");
        ColaCirc C = new ColaCirc(3);

        System.out.println();
        C.insertar("Juan");
        System.out.println();
        C.insertar("Mary");
        System.out.println();
        C.insertar("Antonio");
        System.out.println();
        C.insertar("Ana");
        System.out.println();
        C.eliminar();
        System.out.println();
        C.insertar("Pedro");
        System.out.println();
        C.eliminar();
        imprimir(C);
    }

    public static void imprimir(ColaCirc C){
        System.out.println();
        System.out.println("Contenido de la cola circular: ");
        C.imprimirCola();
    }*/

