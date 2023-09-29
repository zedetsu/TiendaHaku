package tiendaHaku;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int codigoPedido;
    private Cliente cliente;
    private List<Producto> productos;
    private String estado;

    public Pedido(int codigoPedido, Cliente cliente) {
        this.codigoPedido = codigoPedido;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = "Pendiente";
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String getEstado() {
        return estado;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void marcarComoCompletado() {
        estado = "Completado";
    }

    // Otros métodos relacionados con el pedido
}
