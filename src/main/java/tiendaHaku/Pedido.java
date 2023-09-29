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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void marcarComoCompletado() {
        estado = "Completado";
    }

    public static Pedido buscarPedidoPorCodigo(List<Pedido> pedidos, int codigoPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getCodigoPedido() == codigoPedido) {
                return pedido; // Se encontró el pedido con el código especificado
            }
        }
        return null; // No se encontró ningún pedido con el código especificado
    }
    // Método para verificar si hay stock suficiente para completar el pedido
    public boolean verificarStockPedido() {
        List<Producto> productosPedido = this.productos;
        for (Producto producto : productosPedido) {
            if (producto.getCantidad() < 1) {
                return false; // No hay stock suficiente para al menos un producto
            }
        }
        return true; // Hay stock suficiente para todos los productos
    }
    // Método para mostrar los productos que no tienen stock suficiente
    public void mostrarProductosSinStock() {
        List<Producto> productosPedido = this.productos;
        for (Producto producto : productosPedido) {
            if (producto.getCantidad() < 1) {
                System.out.println("Producto: " + producto.getNombre() + " (Código: " + producto.getCodigo() + ") - Cantidad en Stock: " + producto.getCantidad());
            }
        }
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
