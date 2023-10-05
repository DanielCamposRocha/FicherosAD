package ejercicios;

import utilidades.Utilidades;


public class E206 {
    public static void main(String[] args) {
        int op;
        do{
            op= Utilidades.pedirInt("1 por nombre, 2 por tamaño, 0 salir");
            if(op==1)FiltrarNombre.filtrar(Utilidades.pedirString("ruta al directorio"),Utilidades.pedirString("extension a buscar"));
            if(op==2) {
                Filtartamano.filtrar(Utilidades.pedirString("ruta al directorio"), Utilidades.pedirFloat("tamaño minimo a comprobar"));
            }
        }while (op!=0);
    }
}
