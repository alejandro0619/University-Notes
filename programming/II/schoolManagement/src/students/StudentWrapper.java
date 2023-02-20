package students;

import grades.GradesManagement;
import java.util.Scanner;

public class StudentWrapper {
  private Scanner sc = new Scanner(System.in);
  private int size;

  private Student[] array;

  public StudentWrapper(int size) {
    this.size = size;
    array = new Student[size];

    for (int i = 0; i < size; i++) {
      System.out.print("Ingrese el nombre del estudiante: ");
      String name = this.sc.next();

      System.out.print("Ingrese su apellido: ");
      String lastName = this.sc.next();

      System.out.print(" Ingrese su fecha de nacimiento en el formato: dd-mm-yyyy: ");
      String birth = this.sc.next();
      String[] birthDate = birth.split("-");
      int day = Integer.parseInt(birthDate[0]);
      int month = Integer.parseInt(birthDate[1]);
      int year = Integer.parseInt(birthDate[2]);

      while (day <= 0 && month <= 0 && year <= 0) {
        System.out.print("Fecha incorrecta, no se puede procesar una fecha en negativo... Ingrese de nuevo: ");
        birth = this.sc.next();
      }

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
      this.array[i] = student;
    }
  }
  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
  public void displayStudents() {
    for (int i = 0; i < size; i++) {
      System.out.println(
          "Nombre: " + array[i].getName() + "\n" +
          " Apellido: " + array[i].getLastName() + "\n" +
          " Fecha de nacimiento: " + array[i].getBirthDate() + "\n" +
          " Género: " + array[i].getGender() + "\n" +
          " Notas: \n" + array[i].getStudentGrades().displayGrades() + "\n"
          );
    }
  }
}