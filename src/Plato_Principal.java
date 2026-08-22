public class Plato_Principal extends Producto {

    public Plato_Principal(String nombre, String descripcion, double precioBase) {
        super(nombre, descripcion, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12;
    }
}
