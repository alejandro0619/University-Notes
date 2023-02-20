package grades;

enum AmericanGrade {
  A,
  B,
  C,
  D,
  F
}
class Grades {
  private String subject;
  private double grades;
  private AmericanGrade americanGrades;
  
  public AmericanGrade getAmericanGrades() {
    return americanGrades;
  }
  public Grades(String subject, double grades) {
    this.subject = subject;
    this.grades = grades;
  }
  // Get american grade letter of each subject from a 10 based grading system
  public AmericanGrade getAmericanGradeLetter() {
    double grade = this.getAmericanGradeNumber();
    if (grade < 0 || grade > 10) {
      System.err.println("La nota debe ser entre 0 y 10");
      return null;
    }
    if (grade >= 9 && grade <= 10) {
      return AmericanGrade.A;
    } else if (grade >= 8) {
      return AmericanGrade.B;
    } else if (grade >= 7) {
      return AmericanGrade.C;
    } else if (grade >= 6) {
      return AmericanGrade.D;
    } else {
      return AmericanGrade.F;
    }
  }
  // Get american grade number of each subject
  public double getAmericanGradeNumber() {
    return this.grades / 2;
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