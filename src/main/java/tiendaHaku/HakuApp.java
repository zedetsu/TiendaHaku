package tiendaHaku;
import java.util.List;
import java.util.Scanner;

public class HakuApp {
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Pedido> pedidos;

    public HakuApp(List<Usuario> usuarios, List<Cliente> clientes, List<Producto> productos, List<Pedido> pedidos) {
        this.usuarios = usuarios;
        this.clientes = clientes;
        this.productos = productos;
        this.pedidos = pedidos;
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
        return null;
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
            scanner.nextLine();

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

        // Buscar el producto en la lista de productos utilizando el método estático
        Producto productoExistente = Producto.buscarProductoPorCodigo(productos, codigoProducto);

        if (productoExistente != null) {
            // Solicitar al vendedor la cantidad a ingresar
            System.out.print("Ingrese la cantidad a ingresar: ");
            int cantidadAIngresar = scanner.nextInt();

            // Utilizar el método de la clase Producto para aumentar la cantidad del producto existente
            productoExistente.aumentarCantidad(cantidadAIngresar);

            System.out.println("Cantidad del producto actualizada exitosamente.");
        } else {
            System.out.println("Producto no encontrado. Verifique el código del producto.");
        }
    }


    public void gestionarPedidos(Scanner scanner) {
        while (true) {
            System.out.println("Gestión de Pedidos");
            System.out.println("1. Crear Nuevo Pedido");
            System.out.println("2. Ver Lista de Pedidos");
            System.out.println("3. Actualizar Estado de un Pedido");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcionGestionPedidos = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcionGestionPedidos) {
                case 1:
                    crearNuevoPedido(scanner);
                    break;
                case 2:
                    verListaDePedidos();
                    break;
                case 3:
                    actualizarEstadoDePedido(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo de la gestión de pedidos...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void crearNuevoPedido(Scanner scanner) {
        System.out.println("Crear Nuevo Pedido");
        System.out.println("1. Pedido Cliente Nuevo");
        System.out.println("2. Pedido Cliente Registrado");
        System.out.println("3. Ver Lista de Clientes Registrados");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");

        int opcionCrearPedido = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcionCrearPedido) {
            case 1:
                crearPedidoClienteNuevo(scanner);
                break;
            case 2:
                crearPedidoClienteRegistrado(scanner);
                break;
            case 3:
                verListaDeClientesRegistrados();
                break;
            case 4:
                System.out.println("Volviendo al menú de gestión de pedidos...");
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

    private void crearPedidoClienteNuevo(Scanner scanner) {
        // Lógica para crear un pedido con un cliente nuevo
    }

    private void crearPedidoClienteRegistrado(Scanner scanner) {
        // Lógica para crear un pedido con un cliente registrado
    }

    private void verListaDeClientesRegistrados() {
        // Lógica para mostrar la lista de clientes registrados
    }

    private void verListaDePedidos() {
        // Lógica para mostrar la lista de pedidos
    }

    private void actualizarEstadoDePedido(Scanner scanner) {
        // Lógica para actualizar el estado de un pedido
    }

    public void generarReportes() {
        // Implementa la lógica para generar reportes aquí
    }

    // Resto de métodos de la clase HakuApp...
}
