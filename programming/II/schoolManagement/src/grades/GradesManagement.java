package grades;

import java.util.Scanner;

public class GradesManagement {
  private Scanner sc = new Scanner(System.in);
  private Grades[] grades;
  private int size;
  
  // constructor
  public GradesManagement(int size) {
    this.grades = new Grades[size];
    this.size = size;
  }

  public void addGrades() {
    for (int i = 0; i < grades.length; i++) {
      System.out.print("Materia: ");
      String subject = this.sc.next();
      System.out.print("Nota de la materia: ");
      double grade = this.sc.nextDouble();
      while (grade < 0 || grade > 20) {
        System.out.println("La nota debe ser entre 0 y 20, ingrese de nuevo: ");
        grade = this.sc.nextDouble();
      }
      sc.nextLine();
      grades[i] = new Grades(subject, grade);
    }
  }
  // get average
  public double getAverage() {
    double sum = 0;
    for (int i = 0; i < grades.length; i++) {
      sum += grades[i].getGrades();
    }
    return sum / grades.length;
  }
  // get subject with the greatest grade
  public String getSubjectWithGreatestGrade() {
    double max = 0;
    String subject = "";
    for (int i = 0; i < grades.length; i++) {
      if (grades[i].getGrades() > max) {
        max = grades[i].getGrades();
        subject = grades[i].getSubject();
      }
    }
    return subject;
  }
  // get subject with the lowest grade
  public String getSubjectWithLowestGrade() {
    double min = 20;
    String subject = "";
    for (int i = 0; i < grades.length; i++) {
      if (grades[i].getGrades() < min) {
        min = grades[i].getGrades();
        subject = grades[i].getSubject();
      }
    }
    return subject;
  }
  public int getSize() {
    return size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  public Grades[] getGrades() {
    return grades;
  }

  public void setGrades(Grades[] grades) {
    this.grades = grades;
  }

  public String displayGrades() {
    String formattedGrades = "";
    for (int i = 0; i < grades.length; i++) {
      formattedGrades += " " + (i + 1) + ".- " + "Materia: " + grades[i].getSubject() + " Nota: " + grades[i].getGrades() + "\n";
  }
  return formattedGrades;
  }
}