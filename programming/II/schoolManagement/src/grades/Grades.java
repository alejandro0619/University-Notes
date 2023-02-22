package grades;

public class Grades {
  private String subject;
  private double grades;
  
  public Grades(String subject, double grades) {
    this.subject = subject;
    this.grades = grades;
  }
  
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public double getGrades() {
    return grades;
  }
  public void setGrades(double grades) {
    this.grades = grades;
  }
}