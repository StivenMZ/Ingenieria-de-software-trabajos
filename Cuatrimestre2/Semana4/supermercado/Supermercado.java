package supermercado;
import java.util.ArrayList;


public class Supermercado {

    public static void main(String[] args) {

        Producto producto1 = new Producto(1, "Leche", 2.5, 50);
        Producto producto2 = new Producto(2, "Pan", 1.0, 100);
        Producto producto3 = new Producto(3, "Huevos", 4.0, 30);

        CarritoDeCompras carrito = new CarritoDeCompras(1);

        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);
        carrito.agregarProducto(producto3);

        Cliente cliente = new Cliente("Juan", 1, 30, "1111", 'M', 1, 0, carrito, 50.0);
        Vendedor vendedor = new Vendedor("María", 1, 35, "111333", 'F', 1, new ArrayList<>(), 1);
        System.out.println("__________________________________________");
        producto1.actualizarStock(1);
        producto2.actualizarStock(1);
        producto3.actualizarStock(1);
        System.out.println("__________________________________________");

        vendedor.registrarVenta(carrito, cliente);
        cliente.pagarCompra();

        System.out.println("__________________________________________");
        vendedor.obtenerVentas();
    }
}
