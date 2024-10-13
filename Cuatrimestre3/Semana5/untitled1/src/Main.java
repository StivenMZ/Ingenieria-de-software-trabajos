import java.io.BufferedReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ListaSencillaEncadenada listaEmpleados = new ListaSencillaEncadenada();

        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", 'M', 2952670.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(2, "Teresa", "Nicolas Otaño", 'F', 2338617.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", 'F', 2355228.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(4, "Ivellisse", "Estévez Ventura", 'M', 1801728.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(5, "Margarita", "Núñez de la Cruz", 'F', 3124269.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(6, "Belkis Josefina", "Hernández", 'F', 2975450.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(7, "Ruth", "Ortega", 'F', 2306902.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(8, "Lourdes", "Florentino de la Cruz", 'F', 2583729.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(9, "Luisa", "Mejía", 'F', 2160378.00f));
        listaEmpleados.insertarEmpleadoOrdenado(new Empleado(10, "Cándido Mercedes", "Vargas", 'M', 1961114.00f));

        menuUsuario(listaEmpleados);
    }

    public static void menuUsuario(ListaSencillaEncadenada listaEmpleados){
        Scanner teclado = new Scanner(System.in);
        int opcionUsuario = -1;
        int idABusucar = -1;


        while (opcionUsuario != 9){

            System.out.println("Elija alguna opción del menú");
            System.out.println("1. Ver lista de empleados ordenada de menor a mayor en base al salario");
            System.out.println("2. Insertar algún ID de empleado para buscarlo en la lista usando el método de búsqueda lineal");
            System.out.println("3. Insertar algún ID de empleado para buscarlo en la lista usando el método de búsqueda binaria");
            System.out.println("9. Salir del Menú");
            System.out.println("¿Cual opción elige? ");

            if (teclado.hasNextInt()) {
                opcionUsuario = teclado.nextInt();
            } else {
                System.out.println("Por favor, ingrese un valor numérico");
                teclado.next();
                continue;
            }


            switch (opcionUsuario) {
                case 1:
                    System.out.println("Listando empleados en base al salario...");
                    System.out.println("Empleados listados correctamente");
                    System.out.println("Lista de empleados ordenados por salario:");
                    listaEmpleados.mostrarLista();
                    break;
                case 2:
                    System.out.println("Por favor inserte el ID del empleado que desea buscar:");
                    if (teclado.hasNextInt()) {
                        idABusucar = teclado.nextInt();
                        System.out.println("Buscando al empleado con id " + idABusucar + "...");
                        Empleado resultadoBusqueda = listaEmpleados.busquedaLinealPorId(idABusucar);

                        if(resultadoBusqueda != null){
                            System.out.println("Empleado encontrado usando la búsqueda lineal.");
                            resultadoBusqueda.mostrarInfo();
                            System.out.println();
                        }else{
                            System.out.println("No se encontró un empleado con ID " + idABusucar);
                            System.out.println();
                        }
                    } else {
                        System.out.println("El ID del empleado debe ser un número entero");
                        teclado.next();
                        continue;
                    }
                    break;

                case 3 :
                    System.out.println("Por favor inserte el ID del empleado que desea buscar:");
                    if (teclado.hasNextInt()) {
                        idABusucar = teclado.nextInt();
                        System.out.println("Buscando al empleado con id " + idABusucar + "...");
                        Nodo resultadoBusqueda = listaEmpleados.busquedaBinariaPorId(idABusucar);

                        if(resultadoBusqueda != null){
                            System.out.println("Empleado encontrado usando la búsqueda binaria.");
                            resultadoBusqueda.datoEmpleado.mostrarInfo();
                            System.out.println();
                        }else{
                            System.out.println("No se encontró un empleado con ID " + idABusucar);
                            System.out.println();
                        }
                    } else {
                        System.out.println("El ID del empleado debe ser un número entero");
                        teclado.next();
                        continue;
                    }
                    break;

                case 9 :
                    System.out.println("Muchas gracias.");
                    System.out.println("Saliendo....");
                    opcionUsuario = 9;
                    break;
                default:
                    System.out.println("La opción ingresada no es válida");
                    System.out.println("Redireccionando al Menú...\n");
                    break;
            }
        }
    }
}