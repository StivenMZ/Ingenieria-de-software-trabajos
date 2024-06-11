package supermercado;

import java.util.List;

public class Factura {
    private static int contadorFacturas = 0;

    private int idFactura;
    private int idCliente;
    private int idVendedor;
    private List<Producto> listaProductos;
    private double totalPrecio;

    public Factura(int idCliente, int idVendedor, List<Producto> listaProductos) {
        this.idFactura = ++contadorFacturas;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.listaProductos = listaProductos;
        this.totalPrecio = calcularTotal();
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : this.listaProductos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostrarFactura() {
        System.out.println("Id Factura: " + this.idFactura);
        System.out.println("ID Cliente: " + this.idCliente);
        System.out.println("Id Vendedor: " + this.idVendedor);
        System.out.println("Productos:");
        for (Producto producto : listaProductos) {
            System.out.println("-" + producto.getNombre() + " : $" + producto.getPrecio());
        }
        System.out.println("Total Precio: $" + this.totalPrecio);
    }
}
