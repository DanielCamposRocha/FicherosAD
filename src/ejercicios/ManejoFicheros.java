package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    public static void copiarFichero(String origen,String destino){
        File f=new File(destino);
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        escribir(f,leerArchivo(origen));
    }

    private static String leerArchivo(String f) {
        String texto="";
        File archivo= new File(f);
        try (DataInputStream dis=new DataInputStream(Files.newInputStream(archivo.toPath()))){
            while(dis.available()!=0){texto=dis.readUTF();}
        } catch (IOException ex) {
            System.out.println("Error con el fichero");
        }
        return texto;
    }

    private static void escribir(File f,String prueba) {
        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(f.toPath()))){
            dos.writeUTF(prueba);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getFileInfo(String ruta){
        File f= new File(ruta);
        System.out.println("Nombre del archivo: "+f.getName());
        System.out.println("Ruta absoluta al archivo: "+f.getAbsolutePath());
        System.out.println("Ultima modificiación: "+f.lastModified());
        System.out.println("Tamaño: "+f.length());
    }

}
