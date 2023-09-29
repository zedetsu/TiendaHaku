package tiendaHaku;

import java.util.List;

public class Usuario {
    private String nombre;
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String nombreUsuario, String contraseña) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
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

    public static Usuario encontrarUsuario(List<Usuario> usuarios, String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

}
