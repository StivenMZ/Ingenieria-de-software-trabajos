# programa determina promedio de notas ponderado de estudiante y definitivo de la clase
# fecha: 01/05/2024 (día/mes/año)
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
            f"\n{estudiante['nombre']} tiene un promedio de {estudiante['promedioNotas']}")
    print("\n")


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
    return (nota_uno*0.3) + (nota_dos*0.3) + (nota_tres*0.4)


def devolver_promedio_total_clase():
    """
    Calcula el promedio total de la clase acumulando suma de propiedad "promedioNotas"
    de cada estudiante y dividiendo por total de estudiantes

    Parameters:


    Returns:
    float: El promedio de todos los promedios de la clase
    """
    sumatoria_notas = 0

    for estudiante in estudiantes:
        sumatoria_notas += estudiante["promedioNotas"]

    return sumatoria_notas/(len(estudiantes))


def validar_formato_nota(mensaje):
    """
    Valida y solicita nota hasta que sea sea válida => decimal y entre 0 y 5

    Parameters:
    mensaje (str): Mensaje a mostrar cada que se pida la ntoa

    Returns:
    nota (float): Valor de nota
    """
    nota = None
    es_nota_invalida = True

    while es_nota_invalida:
        try:
            entrada = input(f"{mensaje} ")
            nota = float(entrada)
            if not validar_si_rango_nota_es_valido(nota):
                print("El valor debe estar entre 0.0 y 5.0")
            else:
                es_nota_invalida = False
        except ValueError:
            print(
                "Debes ingresar un valor numérico entero o decimal (ej: entero: 4, decimal: 4.3).")
    return nota


def validar_si_rango_nota_es_valido(nota):
    """
    valida que la nota esté entre el rango de 0 y 5 incluyéndolos

    Parameters:
    nota (float): nota para validar

    Returns:
    bool: Si el número está en rango o no.
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
    promedio (float): Promedio ponderado de las notas

    Returns:
    None
    """
    estudiantes.append({"nombre": nombre,
                        "nota1": nota_uno,
                        "nota2": nota_dos,
                        "nota3": nota_tres,
                        "promedioNotas": promedio,
                        "id": len(estudiantes)})


def mostrar_estudiante_por_id():
    """
    Muestra datos de estudiante si usuario ingresa id válida

    Parameters:
    None

    Returns:
    None

    """
    estudiante_encontrado = ""

    id_estudiante = mostrar_estudiantes_retornando_id_estudiante()

    for estudiante in estudiantes:
        if id_estudiante == estudiante["id"]:
            print("\nEstudiante encontrado\n")
            estudiante_encontrado = estudiante

            for clave in estudiante_encontrado:
                print(f"{clave}: {estudiante_encontrado[clave]} ")
            print("\n")
            break
    if estudiante_encontrado == "":
        print(f"No se encontró un estudiante con el id {id_estudiante}")


def mostrar_estudiantes_retornando_id_estudiante():
    """
    Muestra lista de estudiantes con id y nombre.

    Parameters:
    none

    Returns:
    id_estudiante (int): Id ingresada por usuario

    """
    print("\nLista de estudiantes\n")
    for estudiante in estudiantes:
        print(f"id: {estudiante['id']} - nombre: {estudiante['nombre']}")
    id_estudiante = validar_entrada_sea_int(
        "\nIngresa el id del estudiante para verlo ")

    return id_estudiante


def validar_numero_estudiantes_sea_valido(mensaje):
    """
    Valida que entrada de número de estudiantes sea int mayor a 0

    Parameters:
    mensaje (str): Mensaje a mostrar si no es primer intento de ingresar datos

    Returns:
    numero_estudiantes (int): total de estudiantes
    """
    es_valor_invalido = True
    numero_estudiantes = 0
    es_primera_vez = True

    while es_valor_invalido:
        numero_estudiantes = validar_entrada_sea_int(
            mensaje if es_primera_vez else "Ingrese el número total de estudiantes")
        es_primera_vez = False
        if numero_estudiantes > 0:
            es_valor_invalido = False
        else:
            print("Valor inválido. El valor debe ser igual o mayor que 1")
    return numero_estudiantes


def validar_entrada_sea_int(mensaje):
    """
    Valida que la entrada sea int. Retonar sólo si el dato es int,
    sino, se sigue pidiendo dato.

    Parameters:
    mensaje (string): valor a validar

    Returns:
    valor (int): número entero

    """
    es_valor_invalido = True

    while es_valor_invalido:
        try:
            valor = input(f"{mensaje} ")
            valor = int(valor)
            es_valor_invalido = False
        except ValueError:
            print("El dato ingresado no es un número entero \n")

    return valor


def validar_entrada_sea_str(mensaje):
    """
    Valida que la entrada sea str. Retonar sólo si el dato es str,
    sino, se sigue pidiendo dato.

    Parameters:
    mensaje (string): valor a validar

    Returns:
    cadena (str): cadena de texto
    """
    es_str_invalida = True

    cadena = ""

    while es_str_invalida:
        try:
            cadena = input(f"{mensaje} ")
            float(cadena)
            print("Debes ingresar una cadena de texto. (ej: Luis)")
        except ValueError:
            es_str_invalida = False

    return cadena


def imprimir_mensaje_de_bienvenida():
    """
    imprime menú principal

    Parameteres:
    None

    Returns:
    None
    """
    print("""
\nBienvenido
En este programa podrás registrar las notas de los estudiantes de una clase
print("Además, sacar el promedio ponderado en base a 3 notas de cada estudiante
y el promedio total de la clase

""")


def imprimir_menu_principal():
    """
    imprime menú principal

    Parameteres:
    None

    Returns:
    None
    """
    print("""

Elige alguna de las opciones:

1. Ver notas de un estudiante
2. Mostrar todos los promedios de los estudiantes
3. Mostrar promedio de la clase
0. Salir del programa

""")


def imprimir_mensaje_solicitar_nota(num_nota, valor_porcentual):
    """
    Imprime mensaje para solicitar nota de estudiante 

    Parameters:
    num_nota (int): número de nota
    valor_porcentual (int): valor que vale la nota en %

    Returns:
    None
    """
    print(f"""Ingrese el valor de la nota {num_nota}.
           Rango de 0 a 5, se admiten decimales. vale el {valor_porcentual}%""")


# Variable para almacenar los diccionarios de estudiantes
estudiantes = []


def correr_programa():
    """
    Ejecuta programa

    Parameters:
    None

    Returns:
    None
    """

    opcion_usuario = -1
    es_primera_vez = True
    total_estudiantes = 0

    while opcion_usuario != 0:
        if es_primera_vez:
            imprimir_mensaje_de_bienvenida()
            total_estudiantes = validar_numero_estudiantes_sea_valido(
                "\nPor favor ingrese el número total de estudiantes ")

            for estudiante in range(1, total_estudiantes+1):

                print(f"\nDatos del estudiante #{estudiante} \n")
                nombre = validar_entrada_sea_str(
                    "Ingrese el nombre del estudiante ")

                nota_uno = validar_formato_nota(
                    imprimir_mensaje_solicitar_nota(1, 30))

                nota_dos = validar_formato_nota(
                    imprimir_mensaje_solicitar_nota(2, 30))

                nota_tres = validar_formato_nota(
                    imprimir_mensaje_solicitar_nota(3, 40))

                promedio_estudiante = calcular_nota_promedio_ponderada_estudiante(
                    nota_uno, nota_dos, nota_tres)

                insertar_estudiante(
                    nombre, nota_uno, nota_dos, nota_tres, promedio_estudiante)

            print("\nSe ha registrado correctamente a todos los estudiantes")
            es_primera_vez = False
        else:
            input("\nPresiona la tecla enter para continuar ")
            imprimir_menu_principal()
            opcion_usuario = validar_entrada_sea_int("\ningrese una opción \n")

            if opcion_usuario == 1:

                mostrar_estudiante_por_id()

            elif opcion_usuario == 2:
                mostrar_promedio_y_nombre_todos_los_estudiantes()

            elif opcion_usuario == 3:
                print(
                    f"\nEl promedio de la clase es de {devolver_promedio_total_clase()}")

            elif opcion_usuario == 0:
                print("saliendo....")

            else:
                print("La opción ingresada es inválida")


correr_programa()
