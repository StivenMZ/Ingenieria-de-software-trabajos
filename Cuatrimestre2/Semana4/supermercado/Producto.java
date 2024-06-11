package supermercado;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void actualizarStock(int cantidad) {
        if (cantidad < 0 && Math.abs(cantidad) > this.stock) {
            System.out.println("No quedan productos de este tipo para venderte");
        } else {
            this.stock -= cantidad;
            System.out.println("Stock actualizado. Nuevo stock: " + this.stock);
        }
    }

    public void obtenerInformacion() {
        System.out.println("ID del Producto: " + this.idProducto);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Stock disponible: " + this.stock);
    }
}
