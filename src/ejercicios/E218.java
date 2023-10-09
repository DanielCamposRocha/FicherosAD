package ejercicios;

import utilidades.Utilidades;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/*
* Dado el archivo binario alumnos.dat que tiene el siguiente contenido:

Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
Edad 17, 20, 18, 17, 19, 21, 20
Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9
* Desarrolla un programa Java que permita:

    Convertir el archivo binario a un archivo XML llamado alumnos.xml utilizando DOM.
    Visualizar el archivo alumnos.xml utilizando DOM.
    Visualizar el archivo alumnos.xml utilizando SAX.
    * <Alumnos>
    *   <Alumno>
            <apellido></apellido>
            <edad></edad>
            <nota></nota>
        </Alumno>
      </Alumnos>
*/
public class E218 {
    static String[] apellidos= {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
    static int [] anhos={17, 20, 18, 17, 19, 21, 20};
    static double[] notas={7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};


    private static void escribir() {
        File f= new File("alumnos.dat");
        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(f.toPath()))){
            StringBuilder sb=new StringBuilder();
            for (int i=0;i< apellidos.length;i++){
                sb.append(apellidos[i]+",");
                sb.append(anhos[i]+",");
                sb.append(notas[i]+";");
            }
            dos.writeUTF(sb.toString());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String leer() {
        File f= new File("alumnos.dat");
        String lectura="";
        try (DataInputStream dis=new DataInputStream(Files.newInputStream(f.toPath()))){
            while(dis.available()!=0){
                lectura=dis.readUTF();
                return lectura;
            }

        }catch (IOException ex) {
            System.out.println("Error con el fichero");
        }
        return lectura;
    }

    public static void main(String[] args) {
        escribir();
        String lectura=leer();
        //int a=Utilidades.pedirInt("Si desdea convertir a formato XML pulse 1, visualizar con Dom pulse 2, visualizar con sax pulse3");
        //if(a==1)convertirDOM();
    }

    private static void convertirDOM() {

    }


}
