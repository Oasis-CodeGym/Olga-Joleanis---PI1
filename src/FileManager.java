import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Clase encargada de la gestión de archivos (lectura y escritura).
 */

public class FileManager {
    /**
     * Lee el contenido de un archivo.
     */
    public static String leerArchivo(String path) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }

    /**
     * Escribe contenido en un archivo.
     */
    public static void escribirArchivo(String path, String contenido) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(contenido);
        }
    }
}

