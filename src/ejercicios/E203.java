package ejercicios;

import utilidades.Utilidades;

import java.io.File;


/*Desarrolla un programa Java que permita crea un directorio vacío en la ruta dada. Podéis usar la siguiente ruta
 si estáis en Windows C:\\Users\\Antonio\\Descargas\\ficheros,
 si usáis Linux: /home/usuario/Descargas/ficheros
 o bien podéis usar la ruta que queráis. */
public class E203 {
    public static void main(String[] args) {
        creaDirectorio();

    }

    private static void creaDirectorio() {
        File f=new File(Utilidades.pedirString("Introduce ruta para crear nuevo directorio"),Utilidades.pedirString("Nombre del directorio"));
        if(f.mkdir()) System.out.println("Directorio creado correctamente");
        else System.out.println("La has liado parda");

    }
}
