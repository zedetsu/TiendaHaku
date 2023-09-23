package tiendaHaku;

public class Cliente extends Usuario {
    String tipoDocumento;

    Cliente(String nombre, String tipoDocumento) {
        super(nombre, "Cliente");
        this.tipoDocumento = tipoDocumento;
    }
}
