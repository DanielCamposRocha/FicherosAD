package ejercicios;

import utilidades.Utilidades;

import java.io.File;
import java.util.LinkedList;

public class E202 {
    public static void main(String[] args) {
        listadoRecursivo(Utilidades.pedirString("Ruta a listar"));
    }

    private static void listadoRecursivo(String ruta_a_listar) {
        LinkedList<File> cola=new LinkedList<>();
        File f= new File(ruta_a_listar);
        cola.addLast(f);
        while (!cola.isEmpty()) {
            File[] lista = cola.removeFirst().listFiles();
            if(lista != null)
                for (File archivo : lista) {
                    System.out.println(archivo);
                    if(archivo.isDirectory())cola.addLast(archivo);
                }
        }
    }
}
