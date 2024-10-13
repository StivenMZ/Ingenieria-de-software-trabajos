import java.util.ArrayList;
import java.util.Comparator;

public class ListaSencillaEncadenada {
    //cabecera
    Nodo cab;

    public ListaSencillaEncadenada(){};

    public void iniciar_lista( )
    {
        cab = null;
    }

    public void insertarEmpleadoOrdenado(Empleado nuevoEmpleado) {
        Nodo nuevoNodo = new Nodo(nuevoEmpleado);

        if (cab == null || cab.datoEmpleado.getSalario() > nuevoEmpleado.getSalario()) {
            nuevoNodo.sig = cab;
            cab = nuevoNodo;
        } else {
            Nodo nodoActual = cab;
            while (nodoActual.sig != null && nodoActual.sig.datoEmpleado.getSalario() < nuevoEmpleado.getSalario()) {
                nodoActual = nodoActual.sig;
            }
            nuevoNodo.sig = nodoActual.sig;
            nodoActual.sig = nuevoNodo;
        }
    }

    public void mostrarLista() {
        Nodo nodoActual = cab;
        while (nodoActual != null) {
            nodoActual.datoEmpleado.mostrarInfo();
            nodoActual = nodoActual.sig;
        }
    }

    public Empleado busquedaLinealPorId(int id) {
        Nodo nodoActual = cab;
        while (nodoActual != null) {
            if (nodoActual.datoEmpleado.getId() == id) {
                return nodoActual.datoEmpleado;
            }
            nodoActual = nodoActual.sig;
        }
        return null;
    }

    public Nodo busquedaBinariaPorId(int id) {
        ArrayList<Nodo> listaNodos = this.ordenarListaNodosPorId(this.obtenerNodosEnLista());
        Nodo nodoResultado = null;

        int limiteInferior = 0;

        int limiteSuperior = listaNodos.size() -1;
        int indice;

        while (limiteInferior <= limiteSuperior && nodoResultado == null) {
            indice = (limiteInferior + limiteSuperior) / 2;

            if (listaNodos.get(indice).datoEmpleado.getId() == id) {
                nodoResultado = listaNodos.get(indice);
            }else if (id > listaNodos.get(indice).datoEmpleado.getId()){
                limiteInferior = indice + 1;
            }else if (id < listaNodos.get(indice).datoEmpleado.getId()){
                limiteSuperior = indice - 1;
            }
        }

        return nodoResultado;
    }


    public ArrayList<Nodo> obtenerNodosEnLista(){
        ArrayList<Nodo> listaNodos = new ArrayList<>();
        Nodo nodoActual = cab;

        while (nodoActual != null) {
            listaNodos.add(nodoActual);
            nodoActual = nodoActual.sig;
        }

        return listaNodos;
    }

    public ArrayList<Nodo> ordenarListaNodosPorId(ArrayList<Nodo> listaNodos) {
        listaNodos.sort(Comparator.comparingInt(e -> e.datoEmpleado.getId()));
        return listaNodos;
    }


}
