package students;

import grades.GradesManagement;
import grades.Grades;
import utils.MathLib;
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
      System.out.print(" Ingrese su fecha de nacimiento en el formato dd-mm-yyyy: ");
      String birth = this.sc.next();

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
      gradesArray.addGrades();

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
          " Nombre: " + array.get(i).getName() + "\n" +
              " Apellido: " + array.get(i).getLastName() + "\n" +
              " Fecha de nacimiento: " + array.get(i).getBirthDate() + "\n" +
              " Género: " + array.get(i).getGender() + "\n" +
              " Notas: \n" + array.get(i).getStudentGrades().displayGrades() + "\n");
    }
  }

  public void editStudent() {
    System.out.print(
        "¿Qué quieres editar?\n 1. Nombre. \n 2. Apellido.\n 3. Fecha de nacimiento.\n 4. Género.\n 5. Notas.\n 6. Todo.\n Opción:"
      );
    int opc = this.sc.nextInt();

    while (opc < 0) {
      System.out.print("Opción inválida... Ingrese de nuevo: ");
      opc = this.sc.nextInt();
    }

    System.out.print("Ingrese el número de lista del alumno a modificar: ");
    int indexToEdit = this.sc.nextInt() - 1;

    while (indexToEdit < 0 || indexToEdit > this.array.size()) {
      System.out.print("Índice inválido... Ingrese de nuevo: ");
      indexToEdit = this.sc.nextInt();
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
        String newBirth = this.sc.next(); // Nueva fecha
        Student studentToModify= this.array.get(indexToEdit); // Obtenemos el student a editar
        studentToModify.setBirthDate(newBirth); // Modificamos el field birthdate
        this.array.set(indexToEdit, studentToModify); // Y lo volvemosa poner en ese indice
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
        System.out.print("¿Qué materia quieres editar? Ingrese el nombre: ");
        String subjectToModify = this.sc.next(); // Obtenemos el nombre de la materia a modficar.
        Student studentToModify = this.array.get(indexToEdit); // Obtenemos el student a editar.
        GradesManagement oldGrades = studentToModify.getStudentGrades(); // Obtenemos todas las notas
        boolean found = false; // la usamos para saber si encontramos o no el usuario
        // Iteramos por cada nota dentro del ArrayList<Grades>
        for (int i = 0; i < oldGrades.getSize(); i++) {
          Grades g = oldGrades.getGrades().get(i); // Obtenemos la nota en el determinado indice.
          // Comprobamos si el nombre de la nota a modificar existe:
          // En caso de existir pedimos la nota, modificamos y guardamos en ese indice.
          // Caso contrario seguimos buscando.
          if (g.getSubject().toLowerCase().equals(subjectToModify.toLowerCase())) {
            System.out.print("Ingrese la nueva nota: ");
            double newGrade = this.sc.nextDouble();
            g.setGrades(newGrade);
            oldGrades.getGrades().set(indexToEdit, g);
            found = true; // Setteamos found to true y asi sabremos que encontramos la nota y la modificamos.
          }
        }
        // En caso de que la nota no fue encontrada, le decimos al usuario que hubo un error buscandola.
        if (found == false) {
          System.out.print("La materia que quiere modificar no existe o su nombre fue ingresado 0de forma incorrecta.");
        }
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