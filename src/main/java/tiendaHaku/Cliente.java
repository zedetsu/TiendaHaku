package tiendaHaku;

public class Cliente {
    private String codigoCliente;
    private String nombre;
    private String direccion;

    public Cliente(String codigoCliente, String nombre, String direccion) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoCliente='" + codigoCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
