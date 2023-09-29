package tiendaHaku;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        //Se agregan los Usuarios
        Usuario usuario1 = new Usuario("Oscar Paredes","OscarP", "contrasenia");
        usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Gabriel","Gabriel", "contrasenia");
        usuarios.add(usuario2);
        Usuario usuario3 = new Usuario("Cristian","Cristian", "contrasenia");
        usuarios.add(usuario3);
        Usuario usuario4 = new Usuario("Oscar Paredes","OscarP", "contrasenia");
        usuarios.add(usuario4);

        HakuApp app = new HakuApp(usuarios,productos,pedidos);
        app.menuPrincipal();
    }
}
