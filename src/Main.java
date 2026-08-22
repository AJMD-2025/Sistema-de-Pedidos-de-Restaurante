import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Mesa[] mesas = {
                new Mesa(1, "M001"),
                new Mesa(2, "M002"),
                new Mesa(3, "M003"),
                new Mesa(4, "M004"),
                new Mesa(5, "M005")
        };


        HistorialVentas historial = new HistorialVentas();

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n=================================");
            System.out.println("       SISTEMA DE RESTAURANTE");
            System.out.println("=================================");
            System.out.println("1. Agregar nueva cuenta");
            System.out.println("2. Finalizar día");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n========== NUEVA CUENTA ==========");

                    System.out.println("\nMesas disponibles:");

                    for (Mesa mesa : mesas) {
                        System.out.println(
                                mesa.getNumero() +
                                        ". Mesa " + mesa.getNumero() +
                                        " - Mesero: " +
                                        mesa.getIdentificadorMesero()
                        );
                    }

                    System.out.print("\nSeleccione el número de mesa: ");
                    int numeroMesa = scanner.nextInt();


                    if (numeroMesa < 1 || numeroMesa > 5) {
                        System.out.println("Número de mesa inválido.");
                        break;
                    }

                    Mesa mesaSeleccionada = mesas[numeroMesa - 1];


                    Pedido pedido = new Pedido(mesaSeleccionada);

                    boolean agregarProductos = true;


                    while (agregarProductos) {

                        System.out.println("\n========== PRODUCTOS ==========");

                        System.out.println("\n--- ENTRADAS ---");
                        System.out.println("1. Nachos - Q30.00");
                        System.out.println("2. Ensalada - Q25.00");

                        System.out.println("\n--- PLATOS PRINCIPALES ---");
                        System.out.println("3. Hamburguesa - Q50.00");
                        System.out.println("4. Pizza - Q60.00");

                        System.out.println("\n--- POSTRES ---");
                        System.out.println("5. Pastel - Q25.00");
                        System.out.println("6. Helado - Q20.00");

                        System.out.print("\nSeleccione un producto: ");
                        int productoSeleccionado = scanner.nextInt();

                        Producto producto = null;



                        switch (productoSeleccionado) {

                            case 1:
                                producto = new Entrada(
                                        "Nachos",
                                        "Nachos con queso",
                                        30
                                );
                                break;

                            case 2:
                                producto = new Entrada(
                                        "Ensalada",
                                        "Ensalada fresca",
                                        25
                                );
                                break;

                            case 3:
                                producto = new Plato_Principal(
                                        "Hamburguesa",
                                        "Hamburguesa con papas",
                                        50
                                );
                                break;

                            case 4:
                                producto = new Plato_Principal(
                                        "Pizza",
                                        "Pizza de la casa",
                                        60
                                );
                                break;

                            case 5:
                                producto = new Postre(
                                        "Pastel",
                                        "Pastel de chocolate",
                                        25
                                );
                                break;

                            case 6:
                                producto = new Postre(
                                        "Helado",
                                        "Helado de vainilla",
                                        20
                                );
                                break;

                            default:
                                System.out.println(
                                        "Producto inválido."
                                );
                        }


                        if (producto != null) {

                            pedido.agregarProducto(producto);

                            System.out.println(
                                    "\nProducto agregado correctamente."
                            );

                            System.out.printf(
                                    "Precio final: Q%.2f%n",
                                    producto.calcularPrecioFinal()
                            );

                            // Preguntar si quiere agregar otro
                            System.out.println(
                                    "\n¿Desea agregar otro producto?"
                            );
                            System.out.println("1. Sí");
                            System.out.println("2. No");
                            System.out.print("Seleccione: ");

                            int otra = scanner.nextInt();

                            if (otra == 2) {
                                agregarProductos = false;
                            }
                        }
                    }


                    pedido.cerrarPedido();

                    System.out.println(
                            "\n================================="
                    );
                    System.out.println("          CUENTA");
                    System.out.println(
                            "================================="
                    );

                    System.out.println(
                            "Mesa: " +
                                    mesaSeleccionada.getNumero()
                    );

                    System.out.println(
                            "Mesero: " +
                                    mesaSeleccionada.getIdentificadorMesero()
                    );

                    System.out.println(
                            "Total: Q" +
                                    String.format("%.2f", pedido.calcularTotal())
                    );

                    System.out.println(
                            "================================="
                    );

                    // Agregar al historial
                    historial.agregarVenta(pedido);

                    System.out.println(
                            "Cuenta cerrada y agregada al historial."
                    );

                    break;


                case 2:

                    continuar = false;

                    System.out.println("\n");
                    System.out.println(
                            "================================="
                    );
                    System.out.println(
                            "       HISTORIAL DEL DÍA"
                    );
                    System.out.println(
                            "================================="
                    );

                    historial.mostrarHistorial();

                    System.out.println(
                            "\n================================="
                    );
                    System.out.println(
                            "     RESTAURANTE CERRADO"
                    );
                    System.out.println(
                            "================================="
                    );

                    break;


                default:

                    System.out.println(
                            "\nOpción inválida. Intente nuevamente."
                    );
            }
        }

        scanner.close();
    }
}