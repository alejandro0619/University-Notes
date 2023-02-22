package grades;

import java.util.Scanner;
import java.util.ArrayList;
;
public class GradesManagement {
  private Scanner sc = new Scanner(System.in);
  private ArrayList<Grades> grades = new ArrayList<Grades>();
  private int size;

  public GradesManagement(int size) {
    this.size = size;
    for (int i = 0; i < size; i++) {
      System.out.print("Materia: ");
      String subject = this.sc.next();
      System.out.print("Nota de la materia: ");
      double grade = this.sc.nextDouble();
      while (grade < 0 || grade > 20) {
        System.out.println("La nota debe ser entre 0 y 20, ingrese de nuevo: ");
        grade = this.sc.nextDouble();
      }
      sc.nextLine();
      grades.add(new Grades(subject, grade));
    }
  }
  // Obtenemos el promedio.
  public double getAverage() {
    double sum = 0;
    for (Grades grade : grades) {
      sum += grade.getGrades();
    }
    return sum / grades.size();
  }
  // Obtenemos el promedio americano.
  public double getAmericanAverageNumber() {
    return this.getAverage() / 2;
  }
  // Promedio en nota americana letra.
  public AmericanGrades computeAmericanGradeLetter() {
    double av = this.getAmericanAverageNumber();
    if (av < 0 || av > 10) {
      System.err.println("La nota debe ser entre 0 y 10");
      return null;
    }
    if (av >= 9 && av <= 10) {
      return AmericanGrades.A;
    } else if (av >= 8) {
      return AmericanGrades.B;
    } else if (av >= 7) {
      return AmericanGrades.C;
    } else if (av >= 6) {
      return AmericanGrades.D;
    } else {
      return AmericanGrades.F;
    }
  }
  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }

  public ArrayList<Grades> getGrades() {
    return grades;
  }
  
  public String displayGrades() {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < grades.size(); i++) {
      strBuilder.append(
          "  " + (i + 1) + ".-" +
          " Materia: " + grades.get(i).getSubject() +
          " | Nota: " + grades.get(i).getGrades() + "\n"
          );
    }
    strBuilder.append(
        "Promedio Venezolano total: " + this.getAverage() +
        "\nPromedio Americano total: " + this.getAmericanAverageNumber() +
        "\nPromedio Americano en letras total: " + this.computeAmericanGradeLetter()
    );
        
  return strBuilder.toString();
  }
}