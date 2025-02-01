/**
 * Clase principal del programa, que ejecuta el menú y controla la lógica del programa.
 */
public class Main {
    private static Menu menu = Menu.getInstance();

    public static void main(String[] args) {
        menu.showMenu();
    }
}