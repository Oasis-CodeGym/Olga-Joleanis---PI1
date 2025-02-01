import java.io.File;

/**
 * Clase que se encarga de validar la existencia de archivos y la validez de las claves.
 */
public class Validador {

    /**
     * Valida si el archivo existe en la ruta dada.
     */
    public static boolean validarArchivo(String path) {
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }
    /**
     * Valida si la clave está dentro del rango permitido.
     */
    public static boolean validarClave(int clave, int tamanoAlfabeto) {
        return clave >= 0 && clave < tamanoAlfabeto;
    }
}


