package ejercicios;

import utilidades.Utilidades;

import java.io.File;
import java.util.ArrayList;

public class E202 {
    public static void main(String[] args) {
        directorios();
    }

    private static void directorios() {
        File f=new File(Utilidades.pedirString("Introduce la ruta del directorio"));
        File [] lista=f.listFiles();
        for (File archivo:lista) {
            if(!archivo.isDirectory())System.out.println(archivo);
                if(recurrenteDirectorio(archivo)!=null) {
                    File[] listados = archivo.listFiles();
                    for (File archivados : listados) {
                        System.out.println(archivados);

                    }

                }
        }

    }

    public static File recurrenteDirectorio(File archivo){
       if(archivo.isDirectory())System.out.println(archivo);
       if(archivo.isDirectory()) return archivo;
       return null;
    }
}
