import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmpleadoServicio empleadoServicio = new EmpleadoServicio();
        List<Empleado> listaEmpleados;
        List<Empleado> listaOrdenada;

        empleadoServicio.agregarEmpleado(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", 'M', 2952670.00f));
        empleadoServicio.agregarEmpleado(new Empleado(2, "Teresa", "Nicolas Otaño", 'F', 2338617.00f));
        empleadoServicio.agregarEmpleado(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", 'F', 2355228.00f));
        empleadoServicio.agregarEmpleado(new Empleado(4, "Ivellisse", "Estévez Ventura", 'M', 1801728.00f));
        empleadoServicio.agregarEmpleado(new Empleado(5, "Margarita", "Núñez de la Cruz", 'F', 3124269.00f));
        empleadoServicio.agregarEmpleado(new Empleado(6, "Belkis Josefina", "Hernández", 'F', 2975450.00f));
        empleadoServicio.agregarEmpleado(new Empleado(7, "Ruth", "Ortega", 'F', 2306902.00f));
        empleadoServicio.agregarEmpleado(new Empleado(8, "Lourdes", "Florentino de la Cruz", 'F', 2583729.00f));
        empleadoServicio.agregarEmpleado(new Empleado(9, "Luisa", "Mejía", 'F', 2160378.00f));
        empleadoServicio.agregarEmpleado(new Empleado(10, "Cándido Mercedes", "Vargas", 'M', 1961114.00f));


        listaEmpleados = empleadoServicio.obtenerLista();

        empleadoServicio.mostrarEmpleados(listaEmpleados);


        System.out.println("********************************");

        listaOrdenada = empleadoServicio.obtenerListaOrdenada(listaEmpleados);
        empleadoServicio.mostrarEmpleados(listaOrdenada);


    }
}