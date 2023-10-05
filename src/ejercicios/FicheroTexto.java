package ejercicios;

import java.io.*;

/*La clase tendrá un atributo de tipo File, que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:

    Constructor.
    Getter.
    public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
    public void leer(): muestra por consola el contenido del fichero.

NOTA: Debes usar las clases FileReader y FileWriter.*/
public class FicheroTexto {
    private static File archivo;

    public FicheroTexto(File file) {
        archivo=file;
    }

    public static File getArchivo() {
        return archivo;
    }
    public void escribir(String texto){

        try (FileWriter fw = new FileWriter(archivo.getAbsoluteFile())){
           fw.write(texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leer(){
        StringBuilder text=new StringBuilder();
        try (FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr)) {
        String s;
        while ((s = br.readLine()) != null) {
            text.append(s);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(text);
    }
}
