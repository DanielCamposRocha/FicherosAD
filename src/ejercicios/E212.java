package ejercicios;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/*Escribir en un fichero binario alumnos.dat de forma aleatoria la siguiente información:

Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
Edad 17, 20, 18, 17, 19, 21, 20
Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9

Visualizar el contenido del fichero anterior de forma aleatoria*/

/*
* long beforeUsedmem=Runtime.getRuntime().totalmemory().-Runtime.getRuntime().freememory()
* object a= new object
* long afterUsedMem=Runtime.getRuntime().totalMemory-Runtime.getruntime().freeMemory()
* */
public class E212 {
        static RandomAccessFile aleatorio;
    static String[] apellidos= {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
    static int [] anhos={17, 20, 18, 17, 19, 21, 20};
    static double[] notas={7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

        public static void main(String[] args) throws IOException {
            crearAleatorio();
            for(int i=0;i< apellidos.length;i++){escribirAleatorio(apellidos[i],anhos[i],notas[i] );}
            leerAleatorio();
        }

    private static void leerAleatorio() {
    }

    public static void crearAleatorio(){
            try {
                aleatorio = new RandomAccessFile( "aleatoAF.bin","rw" );
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        public static void escribirAleatorio(String s,int edad,double nota){
            try {
                aleatorio.seek( aleatorio.length() );
                aleatorio.writeUTF( s);
                aleatorio.writeInt(edad);
                aleatorio.writeDouble(nota);
                aleatorio.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        
}
