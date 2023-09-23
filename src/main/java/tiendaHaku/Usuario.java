package tiendaHaku;

public abstract class Usuario {
    String nombre;
    String rol;

    Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }
}
