import random

"""
Alejandro Lopez | CI: 30.819.825 | Programacion III seccion N-613
Realizar un cajero

Funcionalidades:
 - Registro de usuario (e incio de sesión)
 - Deposito
 - Consulta
 - Retiro

 Nota: La representación de los usuarios será =
 {
  "acc": XXXXXX,
  "name": "John",
  "lastname": "Doe",
  "dni": XXXXX,
  "password": "1234",
  "balance": 000
  }
"""
db = []


def generar_numero_acc():
  # Se encarga de generar un número de cuenta aleatorio
  num_acc = random.randint(10**19, 10**20 - 1)
  return num_acc

def deposito(user):
  option = int(input("OPCIONES DEL DEPÓSITO:\n 1) Mismo titular\n 2) Tercero\nRespuesta: "))

  if option == 1:
    income_balance = float(input("Introduce el dinero a depositar: "))
    old = db[user]
    db[user] = {**old, "balance" : old.get("balance")  + income_balance}

  elif option == 2:
    print("tercero")
  else:
    print("Opción incorrecta")

def menu_usuario(user):
  # Es el menú que se renderiza al usuario iniciar sesión
  print("------------")
  print("¡Bienvenid@ de vuelta " + db[user].get("name") + "!")
  print("Número de cuenta: " + str(db[user].get("acc")))
  while True:
    option = int(input("OPCIONES DISPONIBLES:\n 1) Consulta de saldo\n 2) Depósito\n 3) Retiro\n 4) Salir\nRespuesta: "))

    if option == 1:
      print("Saldo disponible: " + str(db[user].get("balance")))
      continue
    elif option == 2:
      deposito(user)
      continue
    elif option == 3:
      print("Retiro")
      continue
    elif option == 4:
      print("hasta luego, " + db[user].get("name"))
      break
    else:
      print("Opción incorrecta")

def agregar():
  # Agregamos a un usuario, pidiendo sus datos básicos
    name_lastname = input("Ingrese su nombre y apellido: ")
    user_dni = input("Ingrese su cédula: ")
    password = input("Ingrese su contraseña: ")
    num_acc = generar_numero_acc()
    db.append({
        "acc": num_acc,
        "name": name_lastname.split()[0],
        "lastname": name_lastname.split()[1],
        "dni": user_dni,
        "password": password,
        "balance": 0
    })


def iniciar_sesion():
  # Chequeamos si la cédula está en nuestro sistema y posteriormente comprobamos la contraseña
  dni = input("Ingrese su cédula: ")
  password = input("Ingrese su contraseña: ")
  found = False
  for (i, acc) in enumerate(db):
    if dni in acc.values():
      found = True
      if password == acc.get("password"):
        menu_usuario(i)
      else:
        print("Contraseña incorrecta")

  if not found:
    print("El usuario no se encontrado")
    


def menu():
    # Aqui podemos decidir que opcion tomar: 1) Agregar usuario 2) Entrar en cuenta 3) Salir
    while True:
        option = int(input(
            "OPCIONES:\n 1) Agregar usuario\n 2) Iniciar sesión\n 3) Salir\nRespuesta: "))
        if option == 1:
            agregar()
            continue
        elif option == 2:
            iniciar_sesion()
            continue
        elif option == 3:
            print("Adios...")
            break
        else:
            print("Opción incorrecta")


menu()
