package tiendaHaku;
import java.util.Date;

public class Pedido {
    private int numeroPedido;
    private Date fecha;
    private Producto producto;
    private int cantidad;
    private String estado;

    public Pedido(int numeroPedido, Date fecha, Producto producto, int cantidad, String estado) {
        this.numeroPedido = numeroPedido;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    // Getters y setters para los atributos

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Número de Pedido: " + numeroPedido +
                ", Fecha: " + fecha +
                ", Producto: " + producto.getNombre() +
                ", Cantidad: " + cantidad +
                ", Estado: " + estado;
    }
}
