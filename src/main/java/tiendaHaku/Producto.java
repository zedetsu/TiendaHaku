package tiendaHaku;

public class Producto implements Vendible {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }
}
