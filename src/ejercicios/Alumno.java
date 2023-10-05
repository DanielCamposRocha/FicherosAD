package ejercicios;

public class Alumno {
    private String apellido;
    private int edad;
    private double nota;

    public Alumno(String apellido, int edad, double nota) {
        this.apellido = apellido;
        this.edad = edad;
        this.nota = nota;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nota=" + nota +
                '}';
    }
}
