import java.util.Scanner;

/**
 * Clase que representa el menú del programa.
 * Se utiliza el patrón Singleton para garantizar una única instancia.
 */

public class Menu {
    private static Menu instance;
    private Scanner scanner = new Scanner(System.in);

    private Menu() {}

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Usar cifrado César");
            System.out.println("2. Descifrar con cifrado César");
            System.out.println("3. Descifrar con brute force");
            System.out.println("4. Salir");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    CifradoCesar.cifrar();
                    break;
                case 2:
                    CifradoCesar.descifrar();
                    break;
                case 3:
                    BruteForce.descifrarConBruteForce();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 4);
    }
}
