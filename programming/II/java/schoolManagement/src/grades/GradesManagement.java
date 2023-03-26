package grades;

import java.util.Scanner;
import java.util.ArrayList;
;
public class GradesManagement {
  private Scanner sc = new Scanner(System.in);
  private ArrayList<Double> grades = new ArrayList<Double>();
  private int size;

  public GradesManagement(int size) {
    this.size = size;
    for (int i = 0; i < size; i++) {
      System.out.print((i + 1) + ". Nota: ");
      double grade = this.sc.nextDouble();
      while (grade < 0 || grade > 20) {
        System.out.println("La nota debe ser entre 0 y 20, ingrese de nuevo: ");
        grade = this.sc.nextDouble();
      }
      sc.nextLine();
      grades.add(grade);
    }
  }
  // Obtenemos el promedio.
  public double getAverage() {
    double sum = 0;
    for (double grade : grades) {
      sum += grade;
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

  public ArrayList<Double> getGrades() {
    return grades;
  }
  
  public String displayGrades() {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < grades.size(); i++) {
      strBuilder.append(
          "  " + (i + 1) +
          ".- Nota: " + grades.get(i)+ "\n"
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