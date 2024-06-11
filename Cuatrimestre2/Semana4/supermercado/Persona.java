package supermercado;

public class Persona {
    private String nombre;
    private int id;
    private int edad;
    private String cedula;
    private char sexo;

    public Persona() {
    }

    public Persona(String nombre, int id, int edad, String cedula, char sexo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.cedula = cedula;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void entrarTienda(){
        System.out.println("Entrando a la tienda..");
        System.out.println("Estás dentro de la tienda");
    }

    public void salidarDeTienda(){
        System.out.println("Saliendo de la tienda..");
        System.out.println("Estás fuera de la tienda");
    }
}
