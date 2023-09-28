package tiendaHaku;

public class CuentaUsuario {
    private int codigoEmpleado;
    private String nombreUsuario;
    private String contraseña;

    public CuentaUsuario(int codigoEmpleado, String nombreUsuario) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = "contrasenia"; // Contraseña por defecto
    }

    // Getters y setters

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
