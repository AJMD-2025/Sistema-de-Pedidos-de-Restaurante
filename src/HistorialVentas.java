import java.util.ArrayList;

public class HistorialVentas {
    private ArrayList<Pedido> ventas;

    public HistorialVentas() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Pedido pedido) {
        if (pedido.estaCerrado()) {
            ventas.add(pedido);
        }
    }

    public double calcularVentasDelDia() {
        double total = 0;

        for (Pedido pedido : ventas) {
            total += pedido.calcularTotal();
        }

        return total;
    }

    public void mostrarHistorial() {
        System.out.println("----- HISTORIAL DE VENTAS -----");

        for (Pedido pedido : ventas) {
            pedido.generarCuenta();
            System.out.println();
        }

        System.out.println("Ventas del día: Q" + calcularVentasDelDia());
    }
}