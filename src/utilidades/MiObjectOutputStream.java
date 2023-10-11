package utilidades;

import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException {
        // No debe hacer nada, hay que dejar la cabecera tal cual.
    }

    public boolean anhadirObjetos(Object objeto, File fichero) {
        boolean correcto = true;
        try {
            //Si el fichero existe, usamos nuestra clase de Object y sino usamos la original
            if (fichero.exists()) {
                MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                moos.writeObject(objeto);
                moos.close();
            } else {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(objeto);
                oos.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            correcto=false;
        } catch (IOException e) {
            System.out.println("No se ha podido escribir el objeto");
            correcto=false;
        }
        return correcto;
    }
}
