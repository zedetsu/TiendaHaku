package tiendaHaku;

import java.util.Scanner;

public class InputErrorHandler extends Exception {
    public static void handleInputMismatch(Scanner scanner) {
        System.out.println("Error: Debes ingresar un número válido.");
        scanner.nextLine(); // Limpiar el buffer del teclado
    }
}
