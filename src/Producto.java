public abstract class Producto {
    protected String nombre;
    protected String descripcion;
    protected double precioBase;

    public Producto(String nombre, String descripcion, double precioBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}