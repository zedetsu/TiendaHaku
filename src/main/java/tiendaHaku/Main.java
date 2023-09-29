package tiendaHaku;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        //Se agregan los Usuarios
        Usuario usuario1 = new Usuario("Oscar Paredes","OscarP", "op000");
        usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Gabriel Maldonado","GabrielM", "gm000");
        usuarios.add(usuario2);
        Usuario usuario3 = new Usuario("Cristian Bernilla","CristianB", "cb000");
        usuarios.add(usuario3);
        Usuario usuario4 = new Usuario("Yoel Briseno","YoelB", "yb000");
        usuarios.add(usuario4);
        Usuario usuario5 = new Usuario("Victor Cruz","Victor C", "vc000");
        usuarios.add(usuario5);

        //HakuApp app = new HakuApp(usuarios,clientes,productos,pedidos);
        //app.menuPrincipal();

        //productos
        Producto producto1 = new ProductoBuilder()
                .setCodigo(1)
                .setNombre("Camiseta")
                .setColor("Rojo")
                .setTalla("M")
                .setCantidad(10)
                .build();

        Producto producto2 = new ProductoBuilder()
                .setCodigo(2)
                .setNombre("Pantalón")
                .setColor("Azul")
                .setTalla("L")
                .setCantidad(5)
                .build();

        Producto producto3 = new ProductoBuilder()
                .setCodigo(3)
                .setNombre("Zapatos")
                .setColor("Negro")
                .setTalla("42")
                .setCantidad(8)
                .build();

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        //clientes
        Cliente cliente1 = new Cliente(1, "Juan Pérez", "Calle 123");
        Cliente cliente2 = new Cliente(2, "María López", "Avenida 456");
        Cliente cliente3 = new Cliente(3, "Carlos Rodríguez", "Carrera 789");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        Pedido pedido1 = new Pedido(101, cliente1);
        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);

        Pedido pedido2 = new Pedido(102, cliente2);
        pedido2.agregarProducto(producto2);
        pedido2.agregarProducto(producto3);

        Pedido pedido3 = new Pedido(103, cliente3);
        pedido3.agregarProducto(producto1);
        pedido3.agregarProducto(producto3);

        HakuApp app = new HakuApp(usuarios,clientes,productos,pedidos);
        app.menuPrincipal();

    }
}
