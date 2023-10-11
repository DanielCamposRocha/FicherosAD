package ejercicios;

public class E219 {
    public static void main(String[] args) {

        ManejoFicheros.crearFichero("ejemplo_219.txt");
        ManejoFicheros.copiarFichero("ejemplo_219.txt", "ejemplo_219_1.txt");
        ManejoFicheros.getFileInfo("ejemplo_219_1.txt");
        ManejoFicheros.borrarFichero("ejemplo_219_1.txt");

    }
}
