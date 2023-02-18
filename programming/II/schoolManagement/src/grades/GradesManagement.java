package grades;

public class GradesManagement {
  private String subject;
  private double grades;
  
  public GradesManagement(String subject, double grades) {
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
