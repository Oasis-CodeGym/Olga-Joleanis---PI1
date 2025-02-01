import java.util.Scanner;

/**
 * Clase que implementa el descifrado mediante brute force.
 */
public class BruteForce {

    public static void descifrarConBruteForce() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del archivo cifrado: ");
        String inputPath = scanner.nextLine();
        System.out.print("Introduce la ruta del archivo donde guardar el texto descifrado: ");
        String outputPath = scanner.nextLine();

        if (!Validador.validarArchivo(inputPath)) {
            System.out.println("El archivo no existe.");
            return;
        }

        try {
            String textoCifrado = FileManager.leerArchivo(inputPath);
            StringBuilder resultado = new StringBuilder();

            for (int clave = 0; clave < CifradoCesar.ALFABETO.length(); clave++) {
                String textoDescifrado = CifradoCesar.aplicarCifrado(textoCifrado, CifradoCesar.ALFABETO.length() - clave);
                resultado.append("Clave ").append(clave).append(": ").append(textoDescifrado).append("\n");
            }

            FileManager.escribirArchivo(outputPath, resultado.toString());
            System.out.println("Texto descifrado guardado en: " + outputPath);
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
