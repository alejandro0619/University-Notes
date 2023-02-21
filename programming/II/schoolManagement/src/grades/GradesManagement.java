package grades;

import java.util.Scanner;
import java.util.ArrayList;

public class GradesManagement {
  private Scanner sc = new Scanner(System.in);
  private ArrayList<Grades> grades = new ArrayList<Grades>();
  private int size;

  public GradesManagement(int size) {
    this.size = size;
  }
  
  public void addGrades() {
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
    for (int i = 0; i < grades.size(); i++) {
      sum += grades.get(i).getGrades();
    }
    return sum / grades.size();
  }
  // get subject with the greatest grade
  public String getSubjectWithGreatestGrade() {
    double max = 0;
    String subject = "";
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getGrades() > max) {
        max = grades.get(i).getGrades();
        subject = grades.get(i).getSubject();
      }
    }
    return subject;
  }
  // get subject with the lowest grade
  public String getSubjectWithLowestGrade() {
    double min = 20;
    String subject = "";
    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i).getGrades() < min) {
        min = grades.get(i).getGrades();
        subject = grades.get(i).getSubject();
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

  public ArrayList<Grades> getGrades() {
    return grades;
  }
  
  public String displayGrades() {
    
    String formattedGrades = "";
    for (int i = 0; i < grades.size(); i++) {
      formattedGrades += "  " + (i + 1) + ".- " +
      "Materia: " + grades.get(i).getSubject() +
      " | Nota venezolana: " + grades.get(i).getGrades() +
      " | Nota americana numérica: " + grades.get(i).getAmericanGradeNumber() +
      " | Letra: " + grades.get(i).getAmericanGrades() + "\n";
  }
  return formattedGrades;
  }
}