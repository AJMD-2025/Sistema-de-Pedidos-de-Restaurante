public class Postre extends Producto {

    public Postre(String nombre, String descripcion, double precioBase) {
        super(nombre, descripcion, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.05;
    }
}