package ejercicios;


import utilidades.Menu;
import utilidades.Utilidades;

/*Desarrolla un programa Java que defina una clase ManejoFicheros que implemente los siguientes métodos:

    void crearFichero(String fichero): crea el fichero indicado

    void borrarFichero(String fichero): borra el fichero indicado.

    void crearDirectorio(String ruta): crea el directorio indicado.

    void borrarDirectorio(String ruta): borra el directorio indicado.

    void listarDirectorio(String ruta): lista el contenido del directorio

    Clase main que permita comprobar el funcionamiento de los métodos anteriores.

Nota: usa la clase File para realizar el ejercicio*/
public class E205 {
    public static void main(String[] args) {
        menu();

    }

    private static void menu() {
        char op;
        Menu m=new Menu("Menu Principal",new String[] {"1.-Crear fichero ","2.-Borra fichero","3.-Crea Directorio", "4.-Borra directorio","5.-lista ficheros del directorio","0.-Sair"},"012345",Menu.Direccion.VERTICAL);

        do {
            op=m.getOption();
            switch (op) {
                case '1' :
                    ManejoFicheros.crearFichero(Utilidades.pedirString("Introduce ruta completa del fichero a crear"));
                    break;
                case '2' :
                    ManejoFicheros.borrarFichero(Utilidades.pedirString("Introduce ruta completa del fichero a borrar"));
                    break;
                case '3' :
                    ManejoFicheros.creaDirectorio(Utilidades.pedirString("Introduce ruta completa del directorio a crear"));
                    break;
                case '4' :
                    ManejoFicheros.borrarDirectorio(Utilidades.pedirString("Introduce ruta completa del directorio a borrar"));
                    break;
                case '5' :
                    ManejoFicheros.listarDirectorio(Utilidades.pedirString("Introduce ruta completa del directorio a listar"));
                    break;
            }
        } while(op!='0');
    }


}



