package menu;

import java.util.Scanner;
import students.StudentWrapper;

public class MenuManagement {
  
  public void displayMenu() {
    Scanner sc = new Scanner(System.in);
    boolean status = false;
    StudentWrapper students = new StudentWrapper(0);
    do {
      System.out.print(
          "Elige una opción: \n 1: Agregar cantidad de estudiantes.\n 2: Editar estudiante.\n 3: Estadísticas.\n 4: Salir.\n Opción a elegir: ");
      int answer = sc.nextInt();

      switch (answer) {
        case 1:
          System.out.print("Ingrese la cantidad de alumnos: ");
          int size = sc.nextInt();
          while (size < 0) {
            System.out.print("Cantidad de alumnos incorrecta, ingrese de nuevo: ");
            size = sc.nextInt();
          }
          students = new StudentWrapper(size);
          
          break;
        case 2:
          students.editStudent();
          break;
        case 3:
        students.displayStudents();
          break;
        case 4:
          System.out.println("Cerrando...");
          status = true;
          break;
        default:
          System.out.println("Opción incorrecta... Ingrese de nuevo: ");
          status = false;
      }
    } while (status != true);
  }
}
