package grades;

import java.util.Scanner;
import java.util.ArrayList;

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
  // get average
  public double getAverage() {
    double sum = 0;
    for (Grades grade : grades) {
      sum += grade.getGrades();
    }
    return sum / grades.size();
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
    
    String formattedGrades = "";
    String average = " |Promedio: " + this.getAverage();
    for (int i = 0; i < grades.size(); i++) {
      formattedGrades += "  " + (i + 1) + ".- " +
      "Materia: " + grades.get(i).getSubject() +
      " | Nota venezolana: " + grades.get(i).getGrades();
  }
  return formattedGrades + average;
  }
}