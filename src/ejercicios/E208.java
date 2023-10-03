package ejercicios;

import java.io.*;

/*Desarrolla un programa Java que permita:

    Escribir en un fichero binario Empleados.dat de manera secuencial, la siguiente información:

    Departamento "Contabilidad","Informática","Dirección","Análisis","Finanzas","Hardware"
    Nª Empleados 3,10,2,5,4,8

Mostrar la información del fichero anterior de forma secuencial.*/
public class E208 {
    public static String texto="Departamento \"Contabilidad\",\"Informática\",\"Dirección\",\"Análisis\",\"Finanzas\",\"Hardware\"\n" +
            "    Nª Empleados 3,10,2,5,4,8";
    public static void main(String[] args) {
        escribir();
        leer();
    }

    private static void leer() {
        File f= new File("Empleados.dat");
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

    private static void escribir() {
        File f= new File("Empleados.dat");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))){
            dos.writeUTF(texto);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
