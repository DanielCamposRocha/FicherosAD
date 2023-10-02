package ejercicios;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Filtartamano implements FilenameFilter {
    public static float tamano;

    public Filtartamano(float tamano) {
        this.tamano=tamano;
    }

    public static void filtrar(String ruta, float minTamano){
        File f= new File(ruta);
        File[] files = f.listFiles(new Filtartamano(minTamano));
        if(files != null)for (File archivo: files) System.out.println(archivo.getName()+" tiene el siguiente tamaño "+archivo.length());
    }


    public static ArrayList<File> listarDirectorio(String ruta){
        LinkedList<File> cola=new LinkedList<>();
        ArrayList<File> archivos=new ArrayList<>();
        File f= new File(ruta);
        cola.addLast(f);
        while (!cola.isEmpty()) {
            File[] lista = cola.removeFirst().listFiles();
            if(lista != null)
                for (File archivo : lista) {
                    archivos.add(archivo);
                    if(archivo.isDirectory())cola.addLast(archivo);
                }
        }
        return archivos;
    }

    @Override
    public boolean accept(File dir, String name) {
        return new File(dir, name).length() >= this.tamano;
    }
}
