package tiendaHaku;
import java.util.Date;
import java.util.List;

public class Boleta {
    private int numeroBoleta;
    private Date fecha;
    private List<Producto> productos;
    private double total;

    public Boleta(int numeroBoleta, Date fecha, List<Producto> productos, double total) {
        this.numeroBoleta = numeroBoleta;
        this.fecha = fecha;
        this.productos = productos;
        this.total = total;
    }

    // Getters y setters para los atributos

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Número de Boleta: " + numeroBoleta +
                ", Fecha: " + fecha +
                ", Total: " + total;
    }
}
