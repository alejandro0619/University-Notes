"""
Alejandro Lopez | 30 819 825 
En la escuela María Chiquinquirá tiene una matrícula de 636 estudiantes. 
Cuentan con 12 salones con capacidad de 30 estudiantes cada uno. 
La escuela trabaja dos turnos: mañana y tarde.  Realizar un programa para acomodar cada estudiante en el aula.
""" 

num_matr = 636
num_salones = 12
capacidad_salon = 30
turnos = 2
secciones_llenas = 0

for i in range((num_salones * turnos)):
  num_matr = num_matr - 30
  # Resultado de la resta
  rest = num_matr
  # Si la cantidad de estudiantes que sobra es menor o igual a cero, 
  # simplemente le sumamos el resultado de la resta y lo llevamos a cero de nuevo.
  if num_matr <= 0:
    num_matr = num_matr + rest
  else:
    secciones_llenas += 1
    continue

print("Cantidad de estudiantes en total: 637")
print("Cantidad de salones disponible por turno: ", str(num_salones))
print("Cantidad de secciones usadas (llenas) en total: ", str(secciones_llenas))