package ejercicios;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;

/*jercicio 206

Utilizando la interfaz FilenameFilter realiza los siguientes apartados:

    Crear una clase FiltrarNombre que implemente el siguiente método:
        filtrar(String ruta, String extension): lista solo aquellos archivos de la ruta que tienen una determinada extension

    Crear una clase FiltrarTamano que implemente el siguiente método:
        filtrar(String ruta, float minTamano): lista solo aquellos archivos de la ruta que tienen un tamaño mayor que el especificado.

    Realizar un programa main que permita comprobar el funcionamiento de los métodos anteriores*/
public class FiltrarNombre implements FilenameFilter {
    private static String extension;

    public FiltrarNombre(String extension) {
        this.extension = extension;
    }

    public static void filtrar(String ruta, String extension){
        File f= new File(ruta);
        File[] files = f.listFiles(new FiltrarNombre(extension));
        if(files != null)for (File archivo: files) System.out.println(archivo);
    }


    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.extension);
    }
}
