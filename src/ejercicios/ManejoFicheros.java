package ejercicios;

import utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

/* void crearFichero(String fichero): crea el fichero indicado

    void borrarFichero(String fichero): borra el fichero indicado.

    void crearDirectorio(String ruta): crea el directorio indicado.

    void borrarDirectorio(String ruta): borra el directorio indicado.

    void listarDirectorio(String ruta): lista el contenido del directorio*/
public class ManejoFicheros {
    public static void crearFichero(String fichero) {
        File f=new File(fichero);
        try {
            f.createNewFile();
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
        File f=new File(ruta);
        String [] lista=f.list();
        for (String archivo:lista) {
            File otro=new File(archivo);
            if(otro.isFile())otro.delete();
            if(!otro.isFile()){
                String [] lista2=otro.list();
                for (String fic:lista2) {
                    File otromas=new File(fic);
                    otromas.delete();
                }
            }

        }
        borrarFichero(ruta);
    }
    public static void listarDirectorio(String ruta){
        File f=new File(ruta);
        String [] lista=f.list();
        for (String archivo:lista) {
            File otro=new File(archivo);
            if(otro.isFile())System.out.println(archivo);
            if(!otro.isFile()){
                String [] lista2=otro.list();
                for (String fic:lista2) {
                    System.out.println(otro.getPath()+File.separator+fic);
                }
            }

        }
    }

}
