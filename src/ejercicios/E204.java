package ejercicios;

import utilidades.Utilidades;

import java.io.*;

/*Crear un fichero de texto de forma secuencial en el que vaya el siguiente texto:

Ejemplo de escritura en un fichero de texto o txt

Visualizar el contenido del fichero */
public class E204 {
    public static String prueba="Ejemplo de escritura en un fichero de texto o txt";
    static File f;

    public static void main(String[] args) {
        File f=creaArchivo();
        escribir(f);
        leerArchivo(f);
    }

    private static void leerArchivo(File f) {
        try (DataInputStream dis=new DataInputStream(new FileInputStream(f))){
            int i=1;
            while(dis.available()!=0){
                System.out.println(dis.readUTF());
                i++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error con el fichero");
        } catch (IOException ex) {
            System.out.println("Error con el fichero");
        }
    }

    private static void escribir(File f) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))){
            dos.writeUTF(prueba);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File creaArchivo() {
        File f=new File(Utilidades.pedirString("Introduce ruta para crear nuevo archivo"),Utilidades.pedirString("Nombre del archivo"));
        try {
            f.createNewFile();
        }catch (IOException e){
            System.out.println("Mieeeeerda");
        }
        return f;
    }
}
