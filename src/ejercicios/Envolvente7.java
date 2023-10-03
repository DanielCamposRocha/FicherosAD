package ejercicios;

import java.io.File;

public class Envolvente7 {
    public String nombre;
    public File archivo;

    public Envolvente7(String nombre, File archivo) {
        this.nombre = nombre;
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return  archivo +" con extension: "+nombre;
    }
}
