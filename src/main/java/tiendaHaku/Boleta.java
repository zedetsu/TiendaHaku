package tiendaHaku;

public class Boleta implements Documento {
    Pedido pedido;

    Boleta(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void imprimir() {
        // Lógica para imprimir la boleta
    }
}
