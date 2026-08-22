import java.util.ArrayList;

public class Pedido {
    private Mesa mesa;
    private ArrayList<Producto> productos;
    private boolean cerrado;

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.productos = new ArrayList<>();
        this.cerrado = false;
    }

    public void agregarProducto(Producto producto) {
        if (!cerrado) {
            productos.add(producto);
        }
    }

    public double calcularTotal() {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.calcularPrecioFinal();
        }

        return total;
    }

    public void cerrarPedido() {
        cerrado = true;
    }

    public void generarCuenta() {
        System.out.println("----- CUENTA -----");
        System.out.println("Mesa: " + mesa.getNumero());

        for (Producto producto : productos) {
            System.out.println(
                    producto.getNombre() + " - Q" +
                            producto.calcularPrecioFinal()
            );
        }

        System.out.println("Total: Q" + calcularTotal());
    }

    public boolean estaCerrado() {
        return cerrado;
    }
}