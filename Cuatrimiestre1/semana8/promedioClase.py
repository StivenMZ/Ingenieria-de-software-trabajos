# programa determina promedio de notas ponderado de estudiante y definitivo de la clase
# fecha: 27/04/2024
# autor: Stiven Vera Cano
# Licencia: GPL GNU

def mostrar_promedio_y_nombre_todos_los_estudiantes():
    """
    Recorre la lista 'estudiantes' y muestra el nombre de cada estudiante y su promedio

    Paremeters:

    Returns:
    str: nombre- promedio
    """
    for estudiante in estudiantes:
        print(
            f"{estudiante['nombre']} tiene un promedio de {estudiante['promedioNotas']}")


def calcular_nota_promedio_ponderada_estudiante(nota_uno, nota_dos, nota_tres):
    """
    Calcula el promedio ponderado de las notas de un estudiante.

    Parameters:
    nota_uno (float): La primera nota del estudiante que vale el 30%.
    nota_dos (float): La segunda nota del estudiante que vale el 30%.
    nota_tres (float): La tercera nota del estudiante que vale el 40%.

    Returns:
    float: El promedio ponderado de las tres notas.
    """
    return ((nota_uno*0.3) + (nota_dos*0.3) + (nota_tres*0.4))


def devolver_promedio_total_clase():
    """
    Calcula el promedio total de la clase

    Parameters:
    sumatoria_promedios (float): La suma de todos los promedios de la clase
    total_estudiantes (float): El total de estudiante de la clase

    Returns:
    float: El promedio de todos los promedios de la clase
    """
    sumatoria_notas = 0

    for estudiante in estudiantes:
        sumatoria_notas += estudiante["promedioNotas"]

    return sumatoria_notas/(len(estudiantes))


def validar_formato_nota(nota):
    """
    a
    """
    es_primera_vez = True
    es_nota_valida = True

    while es_nota_valida:

        if not es_primera_vez:
            nota = input("Ingrese la nota: ")
            es_primera_vez = False

        if not nota.isdigit:
            print("Debes ingresar un valor numérico entero.")
            es_primera_vez = False
        else:
            nota = int(nota)
            es_primera_vez = False

            if not validar_si_rango_nota_es_valido(nota):
                print("El valor debe estar entre 0 y 5.")
            else:
                es_nota_valida = False
    return nota


def validar_si_rango_nota_es_valido(nota):
    """
    valida que la nota esté entre el rango de 0 y 5 incluyéndolos

    Parameters:
    nota (float): nota para validar

    Returns:
    bool: Si el número es válido o no
    """
    return nota <= 5 and nota >= 0


def insertar_estudiante(nombre, nota_uno, nota_dos, nota_tres, promedio):
    """
    Agrega Diccionario de estudiante a la lista 'estudiantes'

    Parameters:
    nombre (str):
    nota_uno (float): Primera nota del estudiante
    nota_dos (float): Segunda nota del estudiante
    nota_tres (float): Tercera nota del estudiante

    Returns:
    """
    estudiantes.append({"nombre": nombre,
                        "nota1": nota_uno,
                        "nota2": nota_dos,
                        "nota3": nota_tres,
                        "promedioNotas": promedio,
                        "id": len(estudiantes)})


def mostrar_estudiante():
    """
    a
    """

    print("Lista de estudiantes")
    for estudiante in estudiantes:
        print(f"id: {estudiante['id']} - nombre: {estudiante['nombre']}")
    id_estudiante = int(input("Ingresa el id del estudiante para verlo \n"))

    for estudiante in estudiantes:
        if id_estudiante == estudiante["id"]:
            print("\nEstudiante encontrado\n")
            estudiante_encontrado = estudiante

            for clave in estudiante_encontrado:
                print(f"{clave}: {estudiante_encontrado[clave]} ")
            print("\n")
        else:
            print("El id ingresado no existe\n")


def imprimir_menu_principal():
    """
    imprime menú principal
    """
    print("""

Elige alguna de las opciones:
          
1. Ver notas de un estudiante
2. Mostrar todos los promedios de los estudiantes
3. Mostrar promedio de la clase
0. Salir del programa

""")


estudiantes = []


def correr_programa():
    """
    Ejecuta programa
    """

    opcion_usuario = -1
    es_primera_vez = True
    total_estudiantes = 0

    while opcion_usuario != 0:
        if es_primera_vez:
            total_estudiantes = int(
                input("Bienvenido. Por favor ingrese el número total de estudiantes "))

            for estudiante in range(1, total_estudiantes+1):

                print(f"Datos del estudiante {estudiante}")
                nombre = input("Ingrese el nombre del estudiante ")
                nota_uno = validar_formato_nota(
                    input("Ingrese el valor de la nota uno. Rango de 0 a 5. Vale el 30% "))
                nota_dos = validar_formato_nota(
                    input("Ingrese el valor de la nota dos. Rango de 0 a 5. Vale el 30% "))
                nota_tres = validar_formato_nota(
                    input("Ingrese el valor de la nota tres. Rango de 0 a 5. Vale el 40% "))

                promedio = calcular_nota_promedio_ponderada_estudiante(
                    nota_uno, nota_dos, nota_tres)

                insertar_estudiante(
                    nombre, nota_uno, nota_dos, nota_tres, promedio)
            es_primera_vez = False
        else:
            input("Presiona la tecla enter para continuar")
            imprimir_menu_principal()
            opcion_usuario = int(input("ingrese una opción "))

            if opcion_usuario == 1:
                mostrar_estudiante()

            elif opcion_usuario == 2:
                mostrar_promedio_y_nombre_todos_los_estudiantes()

            elif opcion_usuario == 3:
                print(
                    f"El promedio de la clase es de {devolver_promedio_total_clase()}")

            elif opcion_usuario == 0:
                print("saliendo....")

            else:
                print("La opción ingresada es inválida")


correr_programa()
