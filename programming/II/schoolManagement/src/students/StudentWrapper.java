package students;

import grades.GradesManagement;
import utils.MathLib;
import utils.BirthDate;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentWrapper implements MathLib<Student> {
  private Scanner sc = new Scanner(System.in);
  private int size;

  private ArrayList<Student> array = new ArrayList<Student>();

  public StudentWrapper(int size) {
    this.size = size;

    for (int i = 0; i < size; i++) {
      // nombre
      System.out.print("Ingrese el nombre del estudiante: ");
      String name = this.sc.next();
      // apellido
      System.out.print("Ingrese su apellido: ");
      String lastName = this.sc.next();
      // fecha de nacimiento
      BirthDate birth = new BirthDate();

      // Se ingresa el genero, usando alguna de variante del enum Gender
      System.out.print("Ingrese su género, Opciones: \n 1: Masculino \n 2: Femenino \n 3: Otro \n Opción elegida: ");
      int gender = sc.nextInt();
      Gender genderPicked = Gender.Other;
      boolean status = true;
      while (status) {
        switch (gender) {
          case 1:
            genderPicked = Gender.Male;
            status = false;
            break;
          case 2:
            genderPicked = Gender.Female;
            status = false;
            break;
          case 3:
            genderPicked = Gender.Other;
            status = false;
            break;
          default:
            System.out.print("Opción incorrecta, ingrese de nuevo: ");
            gender = sc.nextInt();
            status = true;
        }
      }
      // Ahora pedimos las notas 
      System.out.print("Ingrese la cantidad de notas asociadas al estudiante: ");
      int nGrades = sc.nextInt();
      while (nGrades < 0) {
        System.out.print("La cantidad de notas no puede ser negativa, ingrese de nuevo: ");
        nGrades = sc.nextInt();
      }
      GradesManagement gradesArray = new GradesManagement(nGrades);

      // Creamos el estudiante.
      Student student = new Student(name, lastName, birth, genderPicked, gradesArray);
      this.array.add(student);
    }
  }
  @Override
  public ArrayList<Student> computeGreatest() {
    ArrayList<Student> greatestGradesStudents = new ArrayList<Student>();

    for (int i = 0; i < this.array.size(); i++) {
      double greatestGrade = 0;
      Student currStudent = this.array.get(i);
      currStudent.computeAverage(); // Sacamos el promedio del estudiante

      // Y aqui todos los mejores estudiantes con mejor promedios
      if (currStudent.getAverage() >= greatestGrade) {
        greatestGradesStudents.add(currStudent);
      }
    }
    return greatestGradesStudents;
  }
  @Override
  public ArrayList<Student> computeLowest() {
    ArrayList<Student> lowestGradesStudents = new ArrayList<Student>();

    for (int i = 0; i < this.array.size(); i++) {
      double greatestGrade = 20;
      Student currStudent = this.array.get(i);
      currStudent.computeAverage(); // Sacamos el promedio del estudiante

      // Y aqui todos los  estudiantes con peor promedios
      if (currStudent.getAverage() <= greatestGrade) {
        lowestGradesStudents.add(currStudent);
      }
    }
    return lowestGradesStudents;
  }

  public void displayStadistics() {
    System.out.print("Los estudiantes con mejor promedio son: \n");
    for (Student bestStudent : this.computeGreatest()) {
      System.out.print(
              "Nombre y apellido: " + bestStudent.getName() + " " + bestStudent.getLastName() +
              " con un promedio de: " + bestStudent.getAverage() + "\n"
          );
    }
    
    System.out.print("Los estudiantes con peor promedio son: \n");
    for (Student bestStudent : this.computeGreatest()) {
      System.out.print(
          "Nombre y apellido: " + bestStudent.getName() + " " + bestStudent.getLastName() +
          " con un promedio de: " + bestStudent.getAverage() + "\n"
          );
    }

  }
  public void displayStudents() {
    System.out.println("\nEstudiantes: \n"); // Caption :)
    for (int i = 0; i < size; i++) {
      System.out.println(
              (i + 1) + ".- " + " Nombre: " + array.get(i).getName() +
              " Apellido: " + array.get(i).getLastName() + "\n"
              );
    }
    System.out.print("Seleccione a un estudiante y se le mostrará sus detalles: ");
    int index = this.sc.nextInt() - 1;
    while (index < 0 || index > this.array.size()) {
      System.out.print("No hay estudiante asociado a este número de lista... Ingréselo de nuevo: ");
      index = this.sc.nextInt() - 1;
    }
    System.out.print(
      " Nombre: " + array.get(index).getName() +
      " Apellido: " + array.get(index).getLastName() + "\n" +
      " Fecha de nacimiento: " + array.get(index).getBirthDate() + "\n" +
      " Género: " + array.get(index).getGender() + "\n" +
      " Notas: \n" + array.get(index).getStudentGrades().displayGrades() + "\n"
      );
  }

  public void editStudent() {
    System.out.print(
        "¿Qué quieres editar?\n 1. Nombre. \n 2. Apellido.\n 3. Fecha de nacimiento.\n 4. Género.\n 5. Notas.\n 6. Todo.\n Opción:"
      );
    int opc = this.sc.nextInt();

    while (opc < 0 ) {
      System.out.print("Opción inválida... Ingrese de nuevo: ");
      opc = this.sc.nextInt();
    }

    System.out.print("Ingrese el número de lista del alumno a modificar: ");
    int indexToEdit = this.sc.nextInt() - 1;

    while (indexToEdit < 0 || indexToEdit > this.array.size()) {
      System.out.print("Índice inválido... Ingrese de nuevo: ");
      indexToEdit = this.sc.nextInt() - 1;
    }
    switch(opc) {
      case 1: {
        System.out.print("Ingrese el nuevo nombre: ");
        String newName = this.sc.next(); // Obtenemos el nuevo nombre
        Student student = this.array.get(indexToEdit); // Obtenemos el Student a editar
        student.setName(newName); // Modificamos el field name
        this.array.set(indexToEdit, student); //Introducimos el nuevo Student en ese indice.
        break;
      }
  
      case 2: {
        System.out.print("Ingrese el nuevo apellido: ");
        String newLastName = this.sc.next(); // Obtenemos el nuevo apellido
        Student studentToModify= this.array.get(indexToEdit); // Obtenemos el Student a editar
        studentToModify.setLastName(newLastName); // Modificamos el field latstName
        this.array.set(indexToEdit, studentToModify); // Y lo ponemos en ese indice
        break;
      }

      case 3: {
        System.out.print("Ingrese su nueva fecha de nacimiento en el siguiene formato: dd-mm-yyyy: ");
        BirthDate newBirth = new BirthDate(); // Nueva fecha
        Student studentToModify= this.array.get(indexToEdit); // Obtenemos el student a editar
        studentToModify.setBirthDate(newBirth); // Modificamos el field birthdate
        this.array.set(indexToEdit, studentToModify); // Y lo volvemos a poner en ese indice
        break;
      }
      case 4: {
        System.out.print(
            "¿En serio quieres cambiarte de género? Bueno... Dime cuál: \nOpciones: \n 1: Masculino \n 2: Femenino \n 3: Otro \n Opción elegida: "
          );
        int gender = sc.nextInt();
        Gender newGender = Gender.Other;
        boolean status = true;
        while (status) {
          switch (gender) {
            case 1:
              newGender = Gender.Male;
              status = false;
              break;
            case 2:
              newGender = Gender.Female;
              status = false;
              break;
            case 3:
              newGender = Gender.Other;
              status = false;
              break;
            default:
              System.out.print("Opción incorrecta, ingrese de nuevo: ");
              gender = sc.nextInt();
              status = true;
          }
        }
        Student studentToModify = this.array.get(indexToEdit); // Obtenemos el student a editar
        studentToModify.setGender(newGender); // Modificamos el field gender
        this.array.set(indexToEdit, studentToModify); // Y lo volvemosa poner en ese indice
        break;
      }
      case 5: {
        System.out.print("Ingrese la posición de la nota que quiere modificar: ");
        int indexToModifyGrade = this.sc.nextInt();
        Student studentToModify = this.array.get(indexToEdit);
        while (indexToModifyGrade < 0 || indexToModifyGrade > studentToModify.getStudentGrades().getSize()) {
          System.out.print("La nota no existe en esa posición... Ingrese de nuevo");
          indexToModifyGrade = this.sc.nextInt();
        }
        System.out.print("Ingrese la nueva nota: ");
        double newGrade = this.sc.nextDouble();
        while (newGrade < 0 || newGrade > 20) {
          System.out.print("Nota incorrecta fuera del rango aceptado... Ingrese de nuevo: ");
          newGrade = this.sc.nextDouble();
        }
        GradesManagement gradesToModify = studentToModify.getStudentGrades();
        gradesToModify.getGrades().set(indexToModifyGrade, newGrade);
        
        break;
      }

      case 6:
        break;
      default:
        System.out.print("Opción incorrecta... Regresando al menú.");
        break;
    }
  }
}