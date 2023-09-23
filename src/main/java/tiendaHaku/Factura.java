package tiendaHaku;

public class Factura implements Documento {
    Pedido pedido;

    Factura(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void imprimir() {
        // Lógica para imprimir la factura
    }
}