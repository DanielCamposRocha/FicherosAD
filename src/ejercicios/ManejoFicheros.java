package ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/* void crearFichero(String fichero): crea el fichero indicado

    void borrarFichero(String fichero): borra el fichero indicado.

    void crearDirectorio(String ruta): crea el directorio indicado.

    void borrarDirectorio(String ruta): borra el directorio indicado.

    void listarDirectorio(String ruta): lista el contenido del directorio*/
public class ManejoFicheros {
    public static void crearFichero(String fichero) {
        File f=new File(fichero);
        try {
            if(f.createNewFile()) System.out.println("Archivo creado correctamente");
        }catch (IOException e){
            System.out.println("Mieeeeerda");
        }

    }

    public static void borrarFichero(String fichero){
        File f=new File(fichero);
        if(f.delete()) System.out.println("Fichero borrado corectamente");
        else System.out.println("Ups algo no ha ido bien");
    }

    public static void creaDirectorio(String ruta) {
        File f=new File(ruta);
        if(f.mkdir()) System.out.println("Directorio creado correctamente");
        else System.out.println("La has liado parda");
    }
    public  static void borrarDirectorio(String ruta){
        LinkedList<File> cola=new LinkedList<>();
        File f=new File(ruta);
        cola.addLast(f);
        while (!cola.isEmpty()) {
            File f2=cola.removeFirst();
            File[] lista = f2.listFiles();
            if(lista != null)
                for (File archivo : lista) {
                    if(!archivo.delete()) System.out.println(archivo+" no ha podido ser borrado");
                    if(archivo.isDirectory())cola.addLast(archivo);
                }
            if(!f2.delete()) System.out.println(f2+" no ha podido ser borrado");
        }
        System.out.println("Eliminación completada");
    }
    public static void listarDirectorio(String ruta){
        LinkedList<File> cola=new LinkedList<>();
        File f= new File(ruta);
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
