package tiendaHaku;

import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    ArrayList<Producto> productos = new ArrayList<>();

    void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularPrecio();
        }
        return total;
    }
}
