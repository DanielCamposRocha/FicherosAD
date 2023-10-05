package ejercicios;

import utilidades.Menu;
import utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

/*Crea una clase FicheroTexto, que represente a un fichero de texto.

La clase tendrá un atributo de tipo File, que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:

    Constructor.
    Getter.
    public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
    public void leer(): muestra por consola el contenido del fichero.

NOTA: Debes usar las clases FileReader y FileWriter.

A continuación, crea una clase ManejoFicheroTexto, que:

    Implemente el método main
    Cree un fichero de texto destino.txt
    Implemente un menú que muestre las siguientes opciones:

1.- Escribir en el fichero.
2.- Leer fichero.
3.- Salir.

En caso de seleccionar la opción 1, el usuario introducirá por consola el texto que quiere escribir en el fichero.
El menú debe mostrarse hasta que el usuario seleccione la opción de salir.*/
public class ManejoFicheroTexto {
    static FicheroTexto fich;
    public static void main(String[] args) {
        fich= new FicheroTexto(crearFichero());
        menu();
    }

    private static File crearFichero() {
        File f=new File("destino.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return f;
    }
    private static void menu() {
        char op;
        Menu m=new Menu("Menu Principal",new String[] {"1.-Escribe en el fichero","2.-Lee el fichero","0.-Sair"},"012",Menu.Direccion.VERTICAL);

        do {
            op=m.getOption();
            switch (op) {
                case '1' :{
                   fich.escribir(Utilidades.pedirString("Introduzca texto a escribir"));
                   break;
                }
                case '2' :{
                    fich.leer();
                    break;
                }
            }
        } while(op!='0');
    }
}
