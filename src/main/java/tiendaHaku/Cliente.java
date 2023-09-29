package tiendaHaku;

import java.util.List;

public class Cliente {
    private int codigoCliente;
    private String nombre;
    private String direccion;

    public Cliente(int codigoCliente, String nombre, String direccion) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public static Cliente buscarClientePorCodigo(List<Cliente> clientes, int codigoCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente() == codigoCliente) {
                return cliente;
            }
        }
        return null;
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
