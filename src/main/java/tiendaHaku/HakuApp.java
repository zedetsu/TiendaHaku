package tiendaHaku;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HakuApp {
    private List<Usuario> usuarios;
    private List<Producto> productos;
    private List<Pedido> pedidos;
    private int contadorPedido = 1;

    public HakuApp() {
        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();

        //Se agregan los Usuarios
        Usuario usuario1 = new Usuario("Oscar Paredes","OscarP", "contrasenia");
        usuarios.add(usuario1);
        Usuario usuario2 = new Usuario("Gabriel","Gabriel", "contrasenia");
        usuarios.add(usuario2);
        Usuario usuario3 = new Usuario("Cristian","Cristian", "contrasenia");
        usuarios.add(usuario3);
        Usuario usuario4 = new Usuario("Oscar Paredes","OscarP", "contrasenia");
        usuarios.add(usuario4);
    }

    public static void main(String[] args) {
        HakuApp app = new HakuApp();
        app.menuPrincipal();
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido a Haku - Tienda Otaku");
            System.out.println("1. Iniciar sesión");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarSesion(scanner);
                    break;
                case 0:
                    System.out.println("¡Gracias por usar Haku! ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario cuenta = encontrarUsuario(nombreUsuario, contraseña);

        if (cuenta != null) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + cuenta.getNombre() + "!");

            // Redirigir al usuario al menú correspondiente
            menuVendedor(scanner, cuenta);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    public Usuario encontrarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null; // Si no se encuentra una coincidencia
    }

    public void menuVendedor(Scanner scanner, Usuario usuario) {
        while (true) {
            System.out.println("Panel de Vendedor");
            System.out.println("1. Registrar un NUEVO producto");
            System.out.println("2. Ingresar producto");
            System.out.println("3. Gestionar pedidos");
            System.out.println("4. Generar reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registraNuevoProducto(scanner);
                    break;
                case 2:
                    ingresarProducto(scanner);
                    break;
                case 3:
                    gestionarPedidos(scanner);
                    break;
                case 4:
                    generarReportes();
                    break;
                case 0:
                    System.out.println("Cerrando sesión de vendedor...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void registraNuevoProducto(Scanner scanner) {
        System.out.println("Registro de Nuevo Producto");

        // Solicitar al vendedor ingresar los datos del nuevo producto
        System.out.print("Ingrese el código del producto: ");
        int codigoProducto = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese el color del producto: ");
        String colorProducto = scanner.nextLine();

        System.out.print("Ingrese la talla del producto: ");
        String tallaProducto = scanner.nextLine();

        System.out.print("Ingrese la cantidad del producto: ");
        int cantidadProducto = scanner.nextInt();

        // Crear una instancia de Producto con los datos proporcionados
        Producto nuevoProducto = new Producto(codigoProducto, nombreProducto, colorProducto, tallaProducto, cantidadProducto);

        // Agregar el nuevo producto a la lista de productos
        productos.add(nuevoProducto);

        System.out.println("Nuevo producto registrado exitosamente.");
    }

    public void ingresarProducto(Scanner scanner) {
        System.out.println("Ingreso de Cantidad a Producto Existente");

        // Solicitar al vendedor el código del producto existente
        System.out.print("Ingrese el código del producto existente: ");
        int codigoProducto = scanner.nextInt();

        // Buscar el producto en la lista de productos
        Producto productoExistente = buscarProductoPorCodigo(codigoProducto);

        if (productoExistente != null) {
            // Solicitar al vendedor la cantidad a ingresar
            System.out.print("Ingrese la cantidad a ingresar: ");
            int cantidadAIngresar = scanner.nextInt();

            // Aumentar la cantidad del producto existente
            productoExistente.aumentarCantidad(cantidadAIngresar);

            System.out.println("Cantidad del producto actualizada exitosamente.");
        } else {
            System.out.println("Producto no encontrado. Verifique el código del producto.");
        }
    }

    // Método para buscar un producto por código
    private Producto buscarProductoPorCodigo(int codigoProducto) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }

    public void gestionarPedidos(Scanner scanner) {
        // Implementa la lógica para gestionar pedidos aquí
    }

    public void generarReportes() {
        // Implementa la lógica para generar reportes aquí
    }

    // Resto de métodos de la clase HakuApp...
}
