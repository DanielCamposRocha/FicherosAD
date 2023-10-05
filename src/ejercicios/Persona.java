package ejercicios;

import java.io.Serializable;

/*Crea una clase Persona, que tenga las siguientes características:

    Dos atributos nombre y edad.
    Getters y setters.
    Constructor con dos parámetros.
    Que la clase sea serializable.
    */
public class Persona implements Serializable {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return  nombre +", tiene " + edad+" años";
    }
}
