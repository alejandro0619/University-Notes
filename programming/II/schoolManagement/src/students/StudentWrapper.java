package students;

import grades.GradesManagement;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentWrapper {
  private Scanner sc = new Scanner(System.in);
  private int size;

  private ArrayList<Student> array = new ArrayList<Student>();

  public StudentWrapper(int size) {
    this.size = size;

    for (int i = 0; i < size; i++) {
      System.out.print("Ingrese el nombre del estudiante: ");
      String name = this.sc.next();

      System.out.print("Ingrese su apellido: ");
      String lastName = this.sc.next();

      System.out.print(" Ingrese su fecha de nacimiento en el formato dd-mm-yyyy: ");
      String birth = this.sc.next();
      

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
      while (nGrades< 0) {
        System.out.print("La cantidad de notas no puede ser negativa, ingrese de nuevo: ");
        nGrades = sc.nextInt();
      }
      GradesManagement gradesArray = new GradesManagement(nGrades);
      gradesArray.addGrades();

      // Creamos el estudiante.
      Student student = new Student(name, lastName, birth, genderPicked,  gradesArray);
      this.array.add(student);
    }
  }
  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
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
        "¿Qué quieres editar?\n1. Nombre. \n2. Apellido.\n3. Fecha de nacimiento.\n4. Género.\n5. Notas.\n6. Todo.\n Opción:"
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
        Student student = this.array.get(indexToEdit); // Obtenemos el Student a editar
        student.setLastName(newLastName); // Modificamos el field latstName
        this.array.set(indexToEdit, student); //Introducimos el nuevo Student en ese indice.
        break;
      }

      case 3:
        break;
      case 4:
        break;
      case 5:
        break;
      case 6:
        break;
      default:
        System.out.print("Opción incorrecta... Regresando al menú.");
        break;
    }
  }
}