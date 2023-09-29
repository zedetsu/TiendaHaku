package tiendaHaku;

public class ProductoBuilder {
    private int codigo;
    private String nombre;
    private String color;
    private String talla;
    private int cantidad;

    public ProductoBuilder setCodigo(int codigo) {
        this.codigo = codigo;
        return  this;
    }

    public ProductoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public ProductoBuilder setTalla(String talla) {
        this.talla = talla;
        return this;
    }

    public ProductoBuilder setCantidad(int cantidad) {
        this.codigo = cantidad;
        return  this;
    }

    public Producto build() {
        return new Producto(codigo,nombre,color,talla,cantidad);
    }
}
