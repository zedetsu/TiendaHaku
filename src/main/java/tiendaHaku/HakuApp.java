package tiendaHaku;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HakuApp {
    private List<UserAccount> employees;
    private List<UserAccount> customers;

    private List<Product> products;
    private List<Order> orders;

    private int orderCounter = 1;

    public HakuApp() {
        employees = new ArrayList<>();
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();

        employees.add(new UserAccount("empleado", "contraseña1", Role.EMPLEADO));
        customers.add(new UserAccount("cliente", "contraseña2", Role.CLIENTE));
    }

    public static void main(String[] args) {
        HakuApp app = new HakuApp();
        app.mainMenu();
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido a Haku - Tienda Otaku");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear cuenta de empleado");
            //System.out.println("3. Crear cuenta de cliente");
            //System.out.println("4. Registrar producto");
            //System.out.println("5. Realizar pedido");
            //System.out.println("6. Ver listado de pedidos del día");
            //System.out.println("7. Actualizar estado de pedido");
            //System.out.println("8. Generar reporte de ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    loginUser(scanner);
                    break;
                case 2:
                    createAccount(scanner, Role.EMPLEADO);
                    break;
                case 3:
                    createAccount(scanner, Role.CLIENTE);
                    break;
                case 4:
                    registerProduct(scanner);
                    break;
                case 5:
                    // Lógica para realizar pedido
                    break;
                case 6:
                    // Lógica para ver listado de pedidos del día
                    break;
                case 7:
                    // Lógica para actualizar estado de pedido
                    break;
                case 8:
                    // Lógica para generar reporte de ventas
                    break;
                case 0:
                    System.out.println("¡Gracias por usar Haku! ¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void createAccount(Scanner scanner, Role role) {
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        if (role == Role.EMPLEADO) {
            employees.add(new UserAccount(username, password, role));
        } else {
            customers.add(new UserAccount(username, password, role));
        }

        System.out.println("Cuenta creada exitosamente.");
    }

    private void loginUser(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        UserAccount account = findUserAccount(username, password);

        if (account != null) {
            System.out.println("Bienvenido, " + username + " (" + account.getRole() + ")!");
            if (account.getRole() == Role.EMPLEADO) {
                employeeMenu(scanner);
            } else {
                customerMenu(scanner);
            }
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    private UserAccount findUserAccount(String username, String password) {
        for (UserAccount account : employees) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }

        for (UserAccount account : customers) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }

        return null;
    }

    private void employeeMenu(Scanner scanner) {
        while (true) {
            System.out.println("Panel de Empleado");
            System.out.println("1. Registrar productos");
            System.out.println("2. Gestionar pedidos");
            System.out.println("3. Realizar pedido en nombre de un cliente");
            System.out.println("4. Generar reportes");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    registerProduct(scanner);
                    break;
                case 2:
                    manageOrders(scanner);
                    break;
                case 3:
                    placeOrderForCustomer(scanner);
                    break;
                case 4:
                    generateReports();
                    break;
                case 0:
                    System.out.println("Cerrando sesión de empleado...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void placeOrderForCustomer(Scanner scanner) {
        System.out.println("Realizar Pedido en Nombre de un Cliente");

        // Solicitar el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String customerName = scanner.nextLine();

        // Solicitar detalles del pedido
        placeOrder(scanner, customerName);
    }

    private void placeOrder(Scanner scanner, String customerName) {
        System.out.println("Realizar Pedido");

        // Solicitar los detalles del pedido, como productos, color, talla, modelo, fecha de entrega, etc.
        // ... (código para capturar los detalles del pedido)

        // Generar un código de pedido único (puedes usar tu lógica para esto)
        int orderId = generateUniqueOrderId();

        // Crear un objeto de pedido
        //Order order = new Order(orderId, customerName, /* otros detalles del pedido */);

        // Agregar el pedido a la lista de pedidos
        //orders.add(order);

        //System.out.println("Pedido registrado exitosamente. Código de pedido: " + orderId);
        System.out.println("Pedido registrado exitosamente. Código de pedido: 0101010101" );
    }
    private int generateUniqueOrderId() {

        return 101544;
    }


    private void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("Panel de Cliente");
            System.out.println("1. Ver catálogo de productos");
            System.out.println("2. Realizar pedido");
            System.out.println("3. Ver mis pedidos");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    viewProductCatalog();
                    break;
                case 2:
                    placeOrder(scanner);
                    break;
                case 3:
                    viewMyOrders();
                    break;
                case 0:
                    System.out.println("Cerrando sesión de cliente...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void registerProduct(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String productName = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();

        products.add(new Product(productName, price));
        System.out.println("Producto registrado exitosamente.");
    }

    // Clase interna para representar una cuenta de usuario
    private class UserAccount {
        private String username;
        private String password;
        private Role role;

        public UserAccount(String username, String password, Role role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Role getRole() {
            return role;
        }
    }

    private class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
// Getters y setters
    }

    private class Order {
        private int orderId;
        private UserAccount customer;
        private List<Product> orderedProducts;
        private double totalPrice;

        public Order(int orderId, UserAccount customer, List<Product> orderedProducts, double totalPrice) {
            this.orderId = orderId;
            this.customer = customer;
            this.orderedProducts = orderedProducts;
            this.totalPrice = totalPrice;
        }

        // Getters y setters
    }


    private void manageOrders(Scanner scanner) {
        while (true) {
            System.out.println("Gestionar Pedidos");
            System.out.println("1. Actualizar estado de pedido");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    updateOrderStatus(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void updateOrderStatus(Scanner scanner) {
        System.out.print("Ingrese el número de pedido a actualizar: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Aquí debes implementar la lógica para buscar el pedido y actualizar su estado
        // Puedes utilizar la lista de pedidos "orders" y su método setter correspondiente
        // Por ejemplo: orders.get(orderId).setOrderStatus(newStatus);

        System.out.println("Estado de pedido actualizado exitosamente.");
    }

    private void generateReports() {
        System.out.println("Aqui se ve el reporte de pedidos");
    }

    private void viewProductCatalog() {
        System.out.println("Catálogo de Productos");

        for (Product product : products) {
            System.out.println(product.getName() + " - Precio: " + product.getPrice());
        }
    }

    private void placeOrder(Scanner scanner) {
        System.out.println("Aqui puedes realizar tus pedidos");
        System.out.println("Lista de Modelos");
        System.out.println("Modelo 1 : 1");
        System.out.println("Modelo 2 : 2");
        System.out.println("Modelo 3 : 3");
        System.out.println("Salir de pedidos: 0");
        System.out.println("Escoge el modelo:");
    }

    private void viewMyOrders() {
        System.out.println("Aqui puedes ver tus pedidos");
        System.out.println("Pedido 1 :");
        System.out.println("Modelo: Modelo 1");
        System.out.println("Talla: S");
        System.out.println("Color: Blanco");
    }

    // Enumeración para representar los roles de usuario
    private enum Role {
        EMPLEADO,
        CLIENTE
    }
}
