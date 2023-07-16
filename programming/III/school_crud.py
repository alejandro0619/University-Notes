"""
Alejandro Lopez | Ci: 30.819.825
Realizar un CRUD del un sistema educativo basico.
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
def add_subject(db, name):
  cursor = db.cursor()
  query = """ 
  INSERT INTO materias VALUES(NULL, %s) 
  """

  cursor.execute(query, (name, ))
  db.commit()


def show_subjects(db):
  cursor = db.cursor()
  query = """ 
  SELECT (nombre) FROM materias
  """
  cursor.execute(query)
  subjects = [subject for subject in cursor.fetchall()]
  subject_count = 1
  print("MATERIAS EN EL SISTEMA: ")
  for subject in subjects:

    print(subject_count, ".-", subject[0])
    subject_count += 1

def subjects():
  db = connect()
  while True:
    op = int(input("Elige una opcion:\n1. Agregar una materia.\n2. Mostrar materias almacenadas.\n3. Buscar materia y mostrar estudiantes inscritos.\n4. Salir\n> Respuesta: "))
    if op == 1:
      subject_name = input("Ingrese el nombre de la materia: ")
      add_subject(db, subject_name)
    elif op == 2:
      show_subjects(db)
    elif op == 3:
      subject_name = input("Ingrese el nombre de la materia: ")
      show_enrrolled_students_by_subject(db, subject_name )
    elif op == 4:
      break
    else:
      print("Opcion incorrecta...")

# Materias inscritas
def assign_subjects_to_student():
  db = connect()
  cursor = db.cursor()
  show_subjects(db)
  subject_name = input("Ingrese la materia el nombre de la materia que quiere agregar: ")
  cursor.execute("SELECT (id) FROM materias WHERE nombre = %s", (subject_name, ))
  subject = cursor.fetchone()
  if subject:
    dni_student = input("Ingrese el DNI del estudiante a agregar: ")
    cursor.execute("SELECT (dni) FROM estudiantes WHERE dni = %s", (dni_student, ))
    student = cursor.fetchone()
    if student:
      query = """ 
      INSERT INTO materias_inscritas VALUES(%s, %s)
      """

      cursor.execute(query, (student[0], subject[0]))
      db.commit()
    else:
      print("Estudiante no existe")
  else:
    print("Materia ingresada invalida.")

def show_enrrolled_students_by_subject(db, subject_name):
  cursor = db.cursor()
  query_subjects_id = """
  SELECT (id) FROM materias WHERE nombre = %s
  """

  query_enrrolled_students = """ 
  SELECT (dni_estudiante) FROM materias_inscritas WHERE id_materia = %s
  """

  query_students_info = """
    SELECT dni, nombre, apellido FROM estudiantes WHERE dni = %s
  """
  cursor.execute(query_subjects_id, (subject_name, ))
  subject_id = cursor.fetchone()

  cursor.execute(query_enrrolled_students, (subject_id[0],))
  dni_enrrolled_students = [dni for dni in cursor.fetchall()]

  print("Estudiantes inscritos en: ", subject_name)
  for (i, dni) in enumerate(dni_enrrolled_students):
    student_dni = dni[0]
    cursor.execute(query_students_info, (student_dni,))
    student = cursor.fetchone()
    print(i + 1, ".-",student[1], student[2], "DNI:", student[0])
    


# Estudiantes
def add_student(db):
  cursor = db.cursor()
  dni = input("Ingrese su DNI: ")
  name = input("Ingrese el nombre: ")
  lastname = input("Ingrese su apellido: ")
  address = input("Ingrese su direccion: ")
  telephone = input("Ingrese su numero: ")
  datebirth = input("Ingrese su fecha de nacimiento con el formato YYYY-MM-DD: ")

  query = """
    INSERT INTO estudiantes VALUES(%s, %s, %s, %s, %s, %s)
  """
  cursor.execute(query, (dni, name, lastname, address, telephone, datebirth))
  db.commit()
  

def show_student(db, student_id):
    cursor = db.cursor()
    query = """ 
    SELECT * FROM estudiantes WHERE dni = %s
    """
    cursor.execute(query, (student_id,))
    student = cursor.fetchone()
    print("Informacion del estudiante: ")
    print("    ", student[1],student[2], "\n     DNI:", student[0],"\n     Direccion:", student[3], "\n     Telefono de contacto:", student[4], "\n     Fecha de nacimiento:", student[5].strftime('%d/%m/%Y'))


def show_all(db):
  cursor = db.cursor()
  query = """
  SELECT * FROM estudiantes
  """
  cursor.execute(query)
  students = [student for student in cursor.fetchall()]
  students_count = 1
  for student in students:
    print(students_count,".-", student[1],student[2], "\n     DNI:", student[0],"\n     Direccion:", student[3], "\n     Telefono de contacto:", student[4], "\n     Fecha de nacimiento:", student[5].strftime('%d/%m/%Y'))
    students_count += 1

def delete_student(db, student_id):
  cursor = db.cursor()
  query_check_if_student_exists = """  
  SELECT * FROM estudiantes WHERE dni = %s
  """
  cursor.execute(query_check_if_student_exists, (student_id, ))
  # Comprueba si el estudiante existe o no.
  if cursor.fetchone():

    query_delete_from_subject = """ 
    DELETE FROM materias_inscritas WHERE dni_estudiante = %s
    """
    cursor.execute(query_delete_from_subject, (student_id, ))

    query_delete_student = """  
    DELETE FROM estudiantes WHERE dni = %s
    """
    cursor.execute(query_delete_student, (student_id, ))

    db.commit()
    print("Estudiante ha sido eliminado correctamente")
  else:
    print("No hay estudiantes relacionados con ese DNI.")


def students():
  db = connect()
  while True:
    op = int(input("Elige una opcion:\n1. Agregar Estudiante.\n2. Mostrar estudiante por su cedula.\n3. Mostrar todos los estudiantes.\n4. Eliminar estudiante por su cedula.\n5. Salir.\n> Respuesta: "))
  
    if op == 1:
      add_student(db)
    elif op == 2:
      dni = input("Ingrese la cedula para realizar la busqueda: ")
      show_student(db, dni)
    elif op == 3:
      show_all(db)
    elif op == 4:
      dni = input("Ingrese la cedula para eliminarlo: ")
      delete_student(db, dni)
    elif op == 5:
      break
    else:
      print("Opcion incorrecta...")

def cli():
  while True:
    op = int(input("1. Ingresar menu estudiantes\n2. Ingresar menu materias.\n3. Ingresar menu inscribir estudiantes\n4. Salir\n > Respuesta: "))
    if op == 1:
      students()
    elif op == 2:
      subjects()
    elif op ==3:
      assign_subjects_to_student()
    elif op == 4: 
      print("Adios")
      break
    else:
      print("Incorrecto.")

if __name__ == "__main__":
  cli()
