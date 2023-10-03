package ejercicios;

import utilidades.Menu;
import utilidades.Utilidades;

import java.io.File;
import java.io.IOException;

/*Crea una clase FicheroBinario que represente a un fichero binario. La clase tendrá un atributo de tipo File,
que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:

        Constructor.
        Getter.
public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
public void leer(): muestra por consola el contenido del fichero.
public void copiar(FicheroBinario ficheroDestino): copia el contenido del fichero en el fichero de destino.

        NOTA: Debes usar las clases FileInputStream y FileOutputStream.

        A continuación, se pide crear una clase ManejoFicherosBinarios, que implemente el método main.
        En esta clase debes crear dos ficheros binarios origen.bin y destino.bin y hacer lo siguiente:

        Escribir en el fichero de origen el texto: ESTE ES EL TEXTO DE ORIGEN.
        Leer y mostrar el contenido del fichero por consola.
        Copia el contenido al fichero de destino.*/
public class ManejoFicherosBinarios {
    public static String texto="ESTE ES EL TEXTO DE ORIGEN.";
    public static void main(String[] args) {
        crearFicheros();
        menu();
    }

    private static void menu() {
        char op;
        Menu m=new Menu("Menu Principal",new String[] {"1.-Crea los archivos","2.-Lee los archivos","3.-Copia el archivo","4.-Lee destino","0.-Sair"},"01234",Menu.Direccion.VERTICAL);

        do {
            op=m.getOption();
            switch (op) {
                case '1' :{
                    FicheroBinario.escribir(texto);
                    break;
                }
                case '2' :{
                    FicheroBinario binario=new FicheroBinario(new File("origen.bin"));
                    binario.leer();
                    break;
                }
                case '3':{
                    FicheroBinario.copiar(new FicheroBinario(new File("destino.bin")));
                    break;
                }
                case '4':{
                    FicheroBinario binario=new FicheroBinario(new File("destino.bin"));
                    binario.leer();
                    break;
                }
            }

        } while(op!='0');
    }

    private static void crearFicheros() {
        File f= new File("origen.bin");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("No se ha creado el archivo "+f.getName());;
        }
        File d=new File("destino.bin");
        try {
            d.createNewFile();
        } catch (IOException e) {
            System.out.println("No se ha creado el archivo "+f.getName());;
        }
    }


}
