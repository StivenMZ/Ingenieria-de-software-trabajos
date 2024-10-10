import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpleadoServicio {
    private List<Empleado> empleados;

    public EmpleadoServicio() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public List<Empleado> obtenerLista(){
        return this.empleados;
    }

    public void mostrarEmpleados(List<Empleado> empleados){
        for (Empleado empleado: empleados){
            System.out.println("-Id: " + empleado.getId()
                    +" Nombre: " + empleado.getNombre()
                    +" Apellido: " + empleado.getApellido()
                    +" Genero: " + empleado.getGenero()
                    +" Salario: " + empleado.getSalario()

            );
        }
    }


   public List<Empleado> obtenerListaOrdenada(List<Empleado> empleados){
       ArrayList<Empleado> listaOrdenada = new ArrayList<>();

       if (empleados.isEmpty()){
           return null;
       }

       for(Empleado empleado: empleados){
           listaOrdenada.add(empleado);
       }

       Collections.sort(listaOrdenada, (e1, e2) -> Float.compare(e1.getSalario(), e2.getSalario()));

       return listaOrdenada;
   }

}
