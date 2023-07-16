"""
Alejandro Lopez | Ci: 30.819.825
Realizar un CRUD que evite inyecciones SQl en la base de datos.
"""
import mysql.connector

def connect():
  config = {
  'user': 'root',
  'password': '',
  'unix_socket': '/opt/lampp/var/mysql/mysql.sock',
  'database': 'prog3'
  }
  db = mysql.connector.connect(**config)
  return db

# Materias
def add_subject(name):
  print(name)

def show_subjects():
  print("Mostrar todos las materias")

def sujects():
  db = connect()
  while True:
    op = int(input("Elige una opcion:\n1. Agregar una materia.\n2. Mostrar materias almacenadas.\n3. Salir. \n> Respuesta: "))
    if op == 1:
      add_subject("name")
    elif op == 2:
      show_subjects()
    elif op == 3:
      break
    else:
      print("Opcion incorrecta...")

# Estudiantes
def add_student(db):
  cursor = db.cursor()
  dni = input("Ingrese su DNI: ")
  name = input("Ingrese el nombre: ")
  lastname = input("Ingrese su apellido: ")
  address = input("Ingrese su direccion: ")
  telephone = input("Ingrese su numero: ")
  datebirh = input("Ingrese su fecha de nacimiento con el formato YYYY-MM-DD: ")

  query = """
    INSERT INTO estudiantes VALUES(%s, %s, %s, %s, %s, %s)
  """
  cursor.execute(query, (dni, name, lastname, address, telephone, datebirh))
  db.commit()

def assign_subjects_to_student(student_id, subject_id):
  print("lol")
def show_student(student_id):
    print('s')

def show_all(db):
  cursor = db,cursor()
  query = """
  SELECT * FROM estudiantes
  """
  cursor.execute(query)
  students = [student for student in cursor.fetchall()]
  for student in studends:
    print("Nombre completo: ", student['nombre'], student['apelllido'], "\n")

def delete_student(student_id):
  print("Eliminar por", student_id)

def students():
  db = connect()
  while True:
    op = int(input("Elige una opcion:\n1. Agregar Estudiante.\n2. Mostrar estudiante por su cedula.\n3. Mostrar todos los estudiantes.\n4. Eliminar estudiante por su cedula.\n5. Salir.\n> Respuesta: "))
  
    if op == 1:
      add_student(db)
    elif op == 2:
      show_student("30819825")
    elif op == 3:
      show_all(db)
    elif op == 4:
      delete_student("30567136")
    elif op == 5:
      break
    else:
      print("Opcion incorrecta...")

if __name__ == "__main__":
  students()
