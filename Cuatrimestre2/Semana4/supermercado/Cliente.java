package supermercado;

import java.util.ArrayList;

public class Cliente extends Persona {
    private int idCliente;
    private int comprasRealizadas;
    private CarritoDeCompras carritoDeCompras;
    private double dineroTotal;

    public Cliente(String nombre, int id, int edad, String cedula, char sexo, int idCliente, int comprasRealizadas, CarritoDeCompras carritoDeCompras, double dineroTotal) {
        super(nombre, id, edad, cedula, sexo);
        this.idCliente = idCliente;
        this.comprasRealizadas = comprasRealizadas;
        this.carritoDeCompras = carritoDeCompras;
        this.dineroTotal = dineroTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
    }

    public CarritoDeCompras getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public void setCarritoDeCompras(CarritoDeCompras carritoDeCompras) {
        this.carritoDeCompras = carritoDeCompras;
    }

    public double getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(double dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public void pagarCompra() {
        double totalCompra = carritoDeCompras.calcularTotal();
        if (this.dineroTotal >= totalCompra) {
            this.dineroTotal -= totalCompra;
            this.carritoDeCompras.setListaProductos(new ArrayList<>());
            this.comprasRealizadas++;
            System.out.println("Compra efectuada exitosamente. Total pagado: $" + totalCompra);
            System.out.println("Ahora tienes un total de: $" + dineroTotal);
        } else {
            System.out.println("No tienes dinero suficiente. La compra cuesta $" + totalCompra + ". Pero dispones de $" + dineroTotal);
        }
    }
}
