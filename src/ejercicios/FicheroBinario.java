package ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FicheroBinario {
    private File archivo;

    public FicheroBinario(File archivo) {
        this.archivo = archivo;
    }

    public File getArchivo() {
        return archivo;
    }
    // escribe en el propio fichero el texto pasado por parámetro.
    public static void escribir(String texto){
        File f= new File("origen.bin");
        try(FileOutputStream fos=new FileOutputStream(f)){
            byte[] flujoBytes=texto.getBytes(StandardCharsets.UTF_8);
            fos.write(flujoBytes);
        }catch(IOException e){
            System.out.println("ERROR al intentar escribir");
        }
        System.out.println("Escritura correcta");
    }

    // muestra por consola el contenido del fichero.
    public void leer(){
        File f= new File(this.archivo.getName());
        try(FileInputStream fis=new FileInputStream(f)){
            int siguiente;
            while((siguiente=fis.read())!=-1){
                System.out.print((char)siguiente);
            }
        }catch(IOException e){
            System.out.println("ERROR al intentar escribir");
        }
        System.out.println("Lectura correcta");
    }

    //copia el contenido del fichero en el fichero de destino.
    public static void copiar(FicheroBinario ficheroDestino){
        File f= new File("origen.bin");
        StringBuilder crecio=new StringBuilder();
        try(FileInputStream fis=new FileInputStream(f)){
            int siguiente;
            while((siguiente=fis.read())!=-1){
                crecio.append((char)siguiente);
            }
        }catch(IOException e){
            System.out.println("ERROR al intentar escribir");
        }
        String copia=String.valueOf(crecio);
        File co= ficheroDestino.archivo;
        try(FileOutputStream fos=new FileOutputStream(co)){
            byte[] flujoBytes=copia.getBytes(StandardCharsets.UTF_8);
            fos.write(flujoBytes);
        }catch(IOException e){
            System.out.println("ERROR al intentar escribir");
        }
        System.out.println("Copia correcta");
    }

}
