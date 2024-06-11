package supermercado;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {

    private int idCarrito;
    private List<Producto> listaProductos;

    public CarritoDeCompras(int idCarrito) {
        this.idCarrito = idCarrito;
        this.listaProductos = new ArrayList<>();
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void eliminarProducto(int idProducto) {
        Producto productoAEliminar = null;
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            listaProductos.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar.getNombre());
        } else {
            System.out.println("No tienes este producto en tu carrito");
        }
    }

    public void verProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("El carrito está vacío, no hay productos");
        } else {
            System.out.println("Productos en el carrito:");
            for (Producto producto : listaProductos) {
                System.out.println("-" + producto.getNombre() + " : $" + producto.getPrecio());
            }
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : listaProductos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
