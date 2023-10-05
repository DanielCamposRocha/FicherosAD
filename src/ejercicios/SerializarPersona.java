package ejercicios;

import utilidades.Menu;
import utilidades.Utilidades;

import java.io.*;
import java.util.ArrayList;

/*A continuación, crea una clase SerializarPersona, que tenga los siguientes métodos:

    public void escribirPersonaEnFichero(Persona persona, File fichero): escribe la información de la persona en el fichero.
    public Persona leerPersonaDeFichero(File fichero): devuelve un objeto Persona con los datos leídos del fichero.

NOTA: debes usar las clases ObjectInputStream y ObjectOutputStream.

Además, debes implementar un método main que haga lo siguiente:

    Crear una persona.
    Crear un fichero persona.txt.
    Escribir los datos de la persona en el fichero.
    Leer los datos y almacenarlos en un objeto diferente.
    Mostrar por consola los datos recuperados.
    */
public class SerializarPersona {
    static Persona personaje;
    static File f;
    static ArrayList<Persona> otrosPersonajes;
    static Persona otroPersonaje;
    public static void escribirPersonaEnFichero(Persona persona, File fichero){
        try (ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(fichero))){
          dos.writeObject(persona);
        }catch (FileNotFoundException e){
            throw new RuntimeException("Error");
        }catch (IOException e){
            throw new RuntimeException("Error");
        }
        System.out.println("Escrito correctamente");
    }

    public static Persona leerPersonaDeFichero(File fichero){
        try(ObjectInputStream dis = new ObjectInputStream(new FileInputStream(fichero))){
            while(true){
                Persona persona = (Persona) dis.readObject();
                System.out.println(persona);
                return persona;
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("Error");
        }catch (IOException e){
            System.out.println("Leido correctamente");;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Persona("No ha leido ninguna persona",150);
    }

    public static void main(String[] args) {
        menu();

    }
    private static void menu() {
        char op;
        Menu m=new Menu("Menu Principal",new String[] {"1.-Crear una persona","2.-crear Fichero persona.txt","3.-Escribir los datos de la persona en el fichero","4.-Leer los datos y almacenarlos en un objeto diferente","5.-Mostrar por consola los datos recuperados.","0.-Sair"},"012345",Menu.Direccion.VERTICAL);

        do {
            op=m.getOption();
            switch (op) {
                case '1' :{
                    personaje=new Persona(Utilidades.pedirString("Introduce nombre de la persona"),Utilidades.pedirInt("Introduce edad de la persona"));
                    System.out.println("creado correctamente");
                    break;
                }
                case '2' :{
                    f=new File("persona.txt");
                    System.out.println("creado correctamente");
                    break;
                }
                case '3' :{
                    escribirPersonaEnFichero(personaje,f);
                    break;
                }
                case '4' :{
                    otroPersonaje=leerPersonaDeFichero(f);
                    //otrosPersonajes.add(otroPersonaje);
                    break;
                }
                case '5' :{
                    System.out.println(otroPersonaje);
                    break;
                }
            }
        } while(op!='0');
    }
}
