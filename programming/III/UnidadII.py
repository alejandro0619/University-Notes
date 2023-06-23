"""
Alejandro López CI: 30.819.825
Unidad II Actividad 6: 

EN LA EMPRESA XYZ, se realizan mantenimientos preventivo y correctivo, se requiere de un programa que registre la fecha de los eventos e identificar cual es cual
"""

import datetime

lista_eventos = {}

def generar_informe_evento():
  evento = input("INGRESE DESCRIPCIÓN DEL EVENTO: ")
  op = int(input("1) Ingresar fecha\n2) Generar fecha\n > Respuesta: "))

  if op == 1:
    fecha = input("Ingresa la fecha en el formato año-mes-día:")
    lista_eventos[fecha] = evento
  elif op == 2:
    fecha = datetime.datetime.now().date()
    lista_eventos[str(fecha)] = evento

def mostrar_eventos():
  for (fecha, evento) in lista_eventos.items():
    print("Fecha: " + fecha + " Descripción del evento: " + evento)

def menu():
  while True:
    op = int(input("1) Agregar evento\n2) Salir\n > Respuesta: "))
    if op == 1:
      generar_informe_evento()
    elif op == 2:
      mostrar_eventos()
      break
    else:
      print("OPCIÓN INCORRECTA")

menu()