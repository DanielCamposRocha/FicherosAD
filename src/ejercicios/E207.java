package ejercicios;

import utilidades.Utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/*Desarrolla un programa Java que:

    Tenga el método clasificarDirectorio(String ruta): lista el contenido del directorio indicado,
    indicando si los elementos de la lista son ficheros o subdirectorios. En el caso de los ficheros, deben aparecer clasificados según su extensión.

    Tenga un método main que permita comprobar el funcionamiento del método anterior.*/
public class E207 {
    public static void main(String[] args) {
        clasificarDirectorio(Utilidades.pedirString("Introduce ruta del directorio"));
    }

    private static void clasificarDirectorio(String introduceRutaDelDirectorio) {
        File f=new File(introduceRutaDelDirectorio);
        LinkedList<File> cola=new LinkedList<>();
        LinkedHashSet<String> tipos=new LinkedHashSet<>();
        ArrayList<Envolvente7> archivos=new ArrayList<>();
        cola.addLast(f);
        while (!cola.isEmpty()) {
            File[] lista = cola.removeFirst().listFiles();
            if(lista != null)
                for (File archivo : lista) {
                    if(archivo.isDirectory()){
                        cola.addLast(archivo);
                        System.out.println(archivo+" es un directorio");
                    }else{
                        String[]varios=archivo.getName().split("\\.");
                        String extension = varios[varios.length-1];
                        Envolvente7 envolvente7=new Envolvente7(extension,archivo);
                        archivos.add(envolvente7);
                        tipos.add(extension);
                    }
                }
        }
        for (String extension:tipos) {
            System.out.println("Archivos de extension: "+extension);
            for (Envolvente7 fichero:archivos) {
                if(extension.equals(fichero.nombre)) System.out.println(fichero.archivo);
            }
        }
    }
}
