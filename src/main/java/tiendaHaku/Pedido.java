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

    public Pedido(int codigoPedido, Cliente cliente, List<Producto> productos, String estado) {
        this.codigoPedido = codigoPedido;
        this.cliente = cliente;
        this.productos = productos;
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Pedido{" +
                "codigoPedido=" + codigoPedido +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", estado='" + estado + '\'' +
                '}';
    }

    // Otros métodos relacionados con el pedido
}
