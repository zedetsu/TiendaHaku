package tiendaHaku;

public class OpcionInvalidaException extends Exception {
    public OpcionInvalidaException(String mensaje) {
        super(mensaje);
    }
    public OpcionInvalidaException() {
        super("Opción inválida. Por favor, seleccione una opción válida.");
    }
}
