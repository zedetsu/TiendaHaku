package tiendaHaku;
import java.util.List;

public class Producto {
    private int codigo;
    private String nombre;
    private String color;
    private String talla;
    private int cantidad;

    public Producto(int id, String nombre, String color, String talla, int cantidad) {
        this.codigo = id;
        this.nombre = nombre;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getTalla() {
        return talla;
    }

    public int getCantidad() { return cantidad; }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void aumentarCantidad(int cantidadAIngresar) {
        if (cantidadAIngresar > 0) {
            this.cantidad += cantidadAIngresar;
            System.out.println("Cantidad aumentada a " + this.cantidad);
        } else {
            System.out.println("La cantidad a ingresar debe ser mayor que cero.");
        }
    }

    public void reducirCantidad(int cantidadAReducir) {
        if (cantidadAReducir >= 0 && this.cantidad >= cantidadAReducir) {
            this.cantidad -= cantidadAReducir;
        } else {
            System.out.println("Error: No se puede reducir la cantidad. Cantidad actual: " + this.cantidad);
        }
    }

    public static Producto buscarProductoPorCodigo(List<Producto> productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ID: " + codigo +
                ", Nombre: " + nombre +
                ", Color: " + color +
                ", Talla: " + talla;
    }
}
