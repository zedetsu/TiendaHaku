package tiendaHaku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HakuApp {
    private Map<String, CuentaUsuario> cuentas;
    private List<Producto> productos;
    private List<Pedido> pedidos;
    private int contadorPedido = 1;

    public HakuApp() {
        cuentas = new HashMap<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();
        empleados = new ArrayList<>();

        // Se agrega un empleado de ejemplo con cuenta de usuario
        Empleado empleadoEjemplo = new Empleado(15472,"Juan Pérez", "Pérez", "Vendedor");
        CuentaUsuario cuentaEjemplo = new CuentaUsuario(empleadoEjemplo.getId(), "empleado");
        cuentas.put("empleado", cuentaEjemplo);
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
            scanner.nextLine(); // Limpiar el buffer

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

        CuentaUsuario cuenta = cuentas.get(nombreUsuario);

        if (cuenta != null && cuenta.getContraseña().equals(contraseña)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + cuenta.getNombreUsuario() + "!");
            Empleado empleado = empleado.getNombre()

            // Redirigir al usuario al menú correspondiente
            menuEmpleado(scanner, e.getNombre(cuenta.getNombreUsuario()cuenta.getNombreUsuario());
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    public void menuEmpleado(Scanner scanner, Empleado empleado) {
        while (true) {
            System.out.println("Panel de Empleado");
            System.out.println("1. Registrar producto");
            System.out.println("2. Gestionar pedidos");
            System.out.println("3. Generar reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarProducto(scanner);
                    break;
                case 2:
                    gestionarPedidos(scanner);
                    break;
                case 3:
                    generarReportes();
                    break;
                case 0:
                    System.out.println("Cerrando sesión de empleado...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public void registrarProducto(Scanner scanner) {
        // Implementa la lógica para registrar un producto aquí
    }

    public void gestionarPedidos(Scanner scanner) {
        // Implementa la lógica para gestionar pedidos aquí
    }

    public void generarReportes() {
        // Implementa la lógica para generar reportes aquí
    }

    // Resto de métodos de la clase HakuApp...
}

