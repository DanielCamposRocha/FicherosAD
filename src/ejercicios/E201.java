package ejercicios;

import utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class E201 {

    public static void main(String[] args) {
        File nuevo=new File("nuevo.txt");
        try {
            nuevo.createNewFile();
        }catch (IOException e){
            System.out.println("Mieeeeerda");
        }

       fichero201(nuevo);
    }

    private static void fichero201(File archivo) {
        System.out.println("1-Solicita el nombre, 2-Ruta relativa, 3-Ruta Absoluta, 4-Premiso de lectura,5-Permiso escritura,6-Tamaño,7-Si es un fichero, 0-salir");
        int op;
            do{
                op= Utilidades.pedirInt("Introduce opcion");
                switch (op) {
                    case 1:
                        System.out.println(archivo.getName());
                        break;
                    case 2:
                        System.out.println(archivo.getPath());
                        break;
                    case 3:
                        System.out.println(archivo.getAbsolutePath());
                        break;
                    case 4:
                        System.out.println("Permiso de lectura: "+archivo.canRead());
                        break;
                    case 5:
                        System.out.println("Permiso de escritura: "+archivo.canWrite());
                        break;
                    case 6:
                        System.out.println("El tamaño del archivo es: "+archivo.length());
                        break;
                    case 7:
                        System.out.println("Es un fichero: "+archivo.isFile());
                        break;
                }
            }while(op!=0);
    }
}