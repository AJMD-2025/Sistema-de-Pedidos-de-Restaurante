public class Entrada extends Producto {

    public Entrada(String nombre, String descripcion, double precioBase) {
        super(nombre, descripcion, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase;
    }
}