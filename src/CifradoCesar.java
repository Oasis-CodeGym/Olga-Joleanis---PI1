
import java.util.Scanner;

/**
 * Clase que implementa el cifrado y descifrado César.
 */
public class CifradoCesar {
    public static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void cifrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo a cifrar: ");
        String inputPath = scanner.nextLine();
        System.out.print("Introduce la ruta del archivo donde guardar el texto cifrado: ");
        String outputPath = scanner.nextLine();
        System.out.print("Introduce la clave de cifrado: ");
        int clave = scanner.nextInt();

        if (!Validador.validarArchivo(inputPath) || !Validador.validarClave(clave, ALFABETO.length())) {
            System.out.println("Entrada no válida. Asegúrate de que el archivo existe y la clave es válida.");
            return;
        }

        try {
            String textoOriginal = FileManager.leerArchivo(inputPath);
            String textoCifrado = aplicarCifrado(textoOriginal, clave);
            FileManager.escribirArchivo(outputPath, textoCifrado);
            System.out.println("Texto cifrado guardado en: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public static void descifrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo a descifrar: ");
        String inputPath = scanner.nextLine();
        System.out.print("Introduce la ruta del archivo donde guardar el texto descifrado: ");
        String outputPath = scanner.nextLine();
        System.out.print("Introduce la clave de descifrado: ");
        int clave = scanner.nextInt();

        if (!Validador.validarArchivo(inputPath) || !Validador.validarClave(clave, ALFABETO.length())) {
            System.out.println("Entrada no válida. Asegúrate de que el archivo existe y la clave es válida.");
            return;
        }

        try {
            String textoCifrado = FileManager.leerArchivo(inputPath);
            String textoDescifrado = aplicarCifrado(textoCifrado, ALFABETO.length() - clave);
            FileManager.escribirArchivo(outputPath, textoDescifrado);
            System.out.println("Texto descifrado guardado en: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    public static String aplicarCifrado(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            int indice = ALFABETO.indexOf(c);
            if (indice >= 0) {
                int nuevoIndice = (indice + clave) % ALFABETO.length();
                resultado.append(ALFABETO.charAt(nuevoIndice));
            } else {
                resultado.append(c); // No cifrar caracteres que no están en el alfabeto
            }
        }
        return resultado.toString();
    }
}
