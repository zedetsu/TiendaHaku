package tiendaHaku;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "ID: " + codigo +
                ", Nombre: " + nombre +
                ", Color: " + color +
                ", Talla: " + talla;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, color, talla);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto producto = (Producto) obj;
        return codigo == producto.codigo &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(color, producto.color) &&
                Objects.equals(talla, producto.talla);
    }
}
