package supermercado;

import java.util.List;

public class Vendedor extends Persona {
    private int idVendedor;
    private List<Factura> ventasRealizadas;
    private int numeroCaja;

    public Vendedor(String nombre, int id, int edad, String cedula, char sexo, int idVendedor, List<Factura> ventasRealizadas, int numeroCaja) {
        super(nombre, id, edad, cedula, sexo);
        this.idVendedor = idVendedor;
        this.ventasRealizadas = ventasRealizadas;
        this.numeroCaja = numeroCaja;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<Factura> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(List<Factura> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public void registrarVenta(CarritoDeCompras carritoDeCompras, Cliente cliente) {
        Factura nuevaFactura = generarFactura(cliente, carritoDeCompras.getListaProductos());
        this.ventasRealizadas.add(nuevaFactura);
        System.out.println("Gracias por comprar, tu factura es la siguiente:");
        System.out.println("___________________________________________");
        nuevaFactura.mostrarFactura();
        System.out.println("___________________________________________");
    }

    public void obtenerVentas() {
        System.out.println("Se ha realizado un total de "+ this.ventasRealizadas.size() + " ventas");
        System.out.println("____________________________________________");
        for(Factura factura: this.ventasRealizadas){
            factura.mostrarFactura();
        }
        System.out.println("____________________________________________");
    }

    public Factura generarFactura(Cliente cliente, List<Producto> listaDeProductos) {
        Factura factura = new Factura(cliente.getIdCliente(), this.idVendedor, listaDeProductos);
        factura.setTotalPrecio(factura.calcularTotal());
        return factura;
    }
}
