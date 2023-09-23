package tiendaHaku;
import java.util.Objects;

public class Producto {
    private int codigo;
    private String nombre;
    private String color;
    private String talla;

    public Producto(int id, String nombre, String color, String talla) {
        this.codigo = id;
        this.nombre = nombre;
        this.color = color;
        this.talla = talla;
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
