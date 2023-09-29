package tiendaHaku;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TiendaHaku {
    private List<Usuario> usuarios;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Pedido> pedidos;
    private int contadorPedido = 0;

    public TiendaHaku(List<Usuario> usuarios, List<Cliente> clientes, List<Producto> productos, List<Pedido> pedidos) {
        this.usuarios = usuarios;
        this.clientes = clientes;
        this.productos = productos;
        this.pedidos = pedidos;
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Bienvenido a Haku - Tienda Otaku");
                System.out.println("1. Iniciar sesión");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                try {
                    switch (opcion) {
                        case 1:
                            iniciarSesion(scanner);
                            break;
                        case 0:
                            System.out.println("¡Gracias por usar Haku! ¡Hasta pronto!");
                            return;
                        default:
                            throw new OpcionInvalidaException();
                    }
                } catch (OpcionInvalidaException e) {
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e) {
                InputErrorHandler.handleInputMismatch(scanner);
            }
        }
    }

    public void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario cuenta = Usuario.encontrarUsuario(usuarios, nombreUsuario, contraseña);

        if (cuenta != null) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + cuenta.getNombre() + "!");

            // Redirigir al usuario al menú correspondiente
            menuVendedor(scanner);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    public void menuVendedor(Scanner scanner) {
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
                    generarReportes(scanner);
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
        System.out.println("Creación de Pedido para Cliente Nuevo");

        // Solicitar información del cliente nuevo
        System.out.print("Código del cliente: ");
        int codigoCliente = scanner.nextInt();

        System.out.print("Nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.print("Dirección del cliente: ");
        String direccionCliente = scanner.nextLine();

        // Crear un nuevo cliente
        Cliente nuevoCliente = new Cliente(codigoCliente, nombreCliente, direccionCliente);

        // Agregar el nuevo cliente a la lista de clientes
        clientes.add(nuevoCliente);

        // Mostrar la lista de productos disponibles
        System.out.println("Lista de Productos Disponibles:");
        for (Producto producto : productos) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Talla: " + producto.getTalla());
            System.out.println("Cantidad en Stock: " + producto.getCantidad());
            System.out.println("--------------------");
        }

        // Crear una lista de productos para el pedido
        List<Producto> productosPedido = new ArrayList<>();

        // Aquí puedes agregar lógica para permitir al vendedor seleccionar productos y agregarlos al pedido
        while (true) {
            System.out.println("Agregar Producto al Pedido (Ingrese 0 para finalizar):");
            System.out.print("Código del producto: ");
            int codigoProducto = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (codigoProducto == 0) {
                break; // El vendedor ha terminado de agregar productos al pedido
            }

            // Solicitar cantidad del producto
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Aquí debes buscar el producto en tu lista de productos por el código
            // y agregarlo a la lista de productos del pedido
            Producto productoEncontrado = Producto.buscarProductoPorCodigo(productos, codigoProducto);
            if (productoEncontrado != null) {
                // Verificar si hay suficiente cantidad en stock para el pedido
                if (productoEncontrado.getCantidad() >= cantidad) {
                    // Agregar el producto con la cantidad especificada al pedido
                    Producto productoPedido = new Producto(
                            productoEncontrado.getCodigo(),
                            productoEncontrado.getNombre(),
                            productoEncontrado.getColor(),
                            productoEncontrado.getTalla(),
                            cantidad
                    );
                    productosPedido.add(productoPedido);

                    // Actualizar la cantidad en stock del producto
                    productoEncontrado.reducirCantidad(cantidad);
                } else {
                    System.out.println("No hay suficiente cantidad en stock para el producto seleccionado.");
                }
            } else {
                System.out.println("Producto no encontrado. Verifique el código del producto.");
            }
        }

        // Crear un nuevo pedido con el cliente y los productos seleccionados
        Pedido nuevoPedido = new Pedido(contadorPedido++, nuevoCliente, productosPedido, "Pendiente");

        // Agregar el nuevo pedido a la lista de pedidos
        pedidos.add(nuevoPedido);

        System.out.println("Cliente y pedido creados exitosamente.");
    }

    private void crearPedidoClienteRegistrado(Scanner scanner) {
        System.out.println("Creación de Pedido para Cliente Registrado");

        // Solicitar al vendedor el código del cliente registrado
        System.out.print("Ingrese el código del cliente registrado: ");
        int codigoCliente = scanner.nextInt();

        // Buscar el cliente en la lista de clientes
        Cliente clienteExistente = Cliente.buscarClientePorCodigo(clientes, codigoCliente);

        if (clienteExistente != null) {
            // Mostrar la lista de productos disponibles
            System.out.println("Lista de Productos Disponibles:");
            for (Producto producto : productos) {
                System.out.println("Código: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Color: " + producto.getColor());
                System.out.println("Talla: " + producto.getTalla());
                System.out.println("Cantidad en Stock: " + producto.getCantidad());
                System.out.println("--------------------");
            }

            // Crear una lista de productos para el pedido
            List<Producto> productosPedido = new ArrayList<>();

            // Aquí puedes agregar lógica para permitir al vendedor seleccionar productos y agregarlos al pedido
            while (true) {
                System.out.println("Agregar Producto al Pedido (Ingrese 0 para finalizar):");
                System.out.print("Código del producto: ");
                int codigoProducto = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (codigoProducto == 0) {
                    break; // El vendedor ha terminado de agregar productos al pedido
                }

                // Solicitar cantidad del producto
                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                // Aquí debes buscar el producto en tu lista de productos por el código
                // y agregarlo a la lista de productos del pedido
                Producto productoEncontrado = Producto.buscarProductoPorCodigo(productos, codigoProducto);
                if (productoEncontrado != null) {
                    // Verificar si hay suficiente cantidad en stock para el pedido
                    if (productoEncontrado.getCantidad() >= cantidad) {
                        // Agregar el producto con la cantidad especificada al pedido
                        Producto productoPedido = new Producto(
                                productoEncontrado.getCodigo(),
                                productoEncontrado.getNombre(),
                                productoEncontrado.getColor(),
                                productoEncontrado.getTalla(),
                                cantidad
                        );
                        productosPedido.add(productoPedido);

                        // Actualizar la cantidad en stock del producto
                        productoEncontrado.reducirCantidad(cantidad);
                    } else {
                        System.out.println("No hay suficiente cantidad en stock para el producto seleccionado.");
                    }
                } else {
                    System.out.println("Producto no encontrado. Verifique el código del producto.");
                }
            }

            // Crear un nuevo pedido con el cliente registrado y los productos seleccionados
            Pedido nuevoPedido = new Pedido(contadorPedido++, clienteExistente, productosPedido, "Pendiente");

            // Agregar el nuevo pedido a la lista de pedidos
            pedidos.add(nuevoPedido);

            System.out.println("Pedido creado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado. Verifique el código del cliente.");
        }
    }

    private void verListaDeClientesRegistrados() {
        System.out.println("Lista de Clientes Registrados:");

        for (Cliente cliente : clientes) {
            System.out.println("Código de Cliente: " + cliente.getCodigoCliente());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("--------------------");
        }
    }

    private void verListaDePedidos() {
        System.out.println("Lista de Pedidos:");

        for (Pedido pedido : pedidos) {
            System.out.println("Código de Pedido: " + pedido.getCodigoPedido());
            System.out.println("Código de Cliente: " + pedido.getCliente().getCodigoCliente());
            System.out.println("Estado: " + pedido.getEstado());

            System.out.println("Productos en el Pedido:");
            List<Producto> productosPedido = pedido.getProductos();
            for (Producto producto : productosPedido) {
                System.out.println("Código de Producto: " + producto.getCodigo());
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Color: " + producto.getColor());
                System.out.println("Talla: " + producto.getTalla());
                System.out.println("Cantidad: " + producto.getCantidad());
            }

            System.out.println("--------------------");
        }
    }

    private void actualizarEstadoDePedido(Scanner scanner) {
        System.out.println("Actualización de Estado de Pedido");

        // Solicitar al vendedor el código del pedido a actualizar
        System.out.print("Ingrese el código del pedido a actualizar: ");
        int codigoPedido = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Buscar el pedido en la lista de pedidos
        Pedido pedidoExistente = Pedido.buscarPedidoPorCodigo(pedidos, codigoPedido);

        if (pedidoExistente != null) {
            // Mostrar el estado actual del pedido
            System.out.println("Estado Actual del Pedido: " + pedidoExistente.getEstado());

            // Verificar si hay stock suficiente para completar el pedido
            boolean stockSuficiente = pedidoExistente.verificarStockPedido();

            if (stockSuficiente) {
                // Solicitar al vendedor el nuevo estado del pedido
                System.out.print("Ingrese el nuevo estado del pedido (Por ejemplo, 'Completado' o 'Pendiente'): ");
                String nuevoEstado = scanner.nextLine();

                // Actualizar el estado del pedido
                pedidoExistente.setEstado(nuevoEstado);

                System.out.println("Estado del pedido actualizado exitosamente.");
            } else {
                // Mostrar los productos que no tienen stock suficiente
                System.out.println("No se puede completar el pedido debido a la falta de stock en los siguientes productos:");
                pedidoExistente.mostrarProductosSinStock();
            }
        } else {
            System.out.println("Pedido no encontrado. Verifique el código del pedido.");
        }
    }

    public void generarReportes(Scanner scanner) {
        System.out.println("---- Reporte de Clientes ----");
        for (Cliente cliente : clientes) {
            System.out.println("Código de Cliente: " + cliente.getCodigoCliente());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("------------------------------");
        }

        System.out.println("---- Reporte de Pedidos ----");
        for (Pedido pedido : pedidos) {
            System.out.println("Número de Pedido: " + pedido.getCodigoPedido());
            System.out.println("Estado: " + pedido.getEstado());
            System.out.println("Productos:");


            for (Producto producto : pedido.getProductos()) {
                System.out.println("   - " + producto.getNombre());
            }

            System.out.println("------------------------------");
        }

        System.out.println("---- Reporte de Productos ----");
        for (Producto producto : productos) {
            System.out.println("Código de Producto: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Color: " + producto.getColor());
            System.out.println("Talla: " + producto.getTalla());
            System.out.println("Cantidad Disponible: " + producto.getCantidad());
            System.out.println("------------------------------");
        }

        // Esperar una entrada del usuario antes de continuar
        System.out.print("Presione Enter para volver al menú...");
        scanner.nextLine();
    }

    // Resto de métodos de la clase HakuApp...
}
