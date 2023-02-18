package studentsManagement;

import grades.GradesManagement;

public class Student {
  private String name;
  private String lastName;
  private String birthDate;
  private GradesManagement[] grades;

  public Student(String name, String lastName, String birthDate, GradesManagement[] grades) {
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.grades = grades;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public GradesManagement[] getGrades() {
    return grades;
  }

  public void setGrades(GradesManagement[] grades) {
    this.grades = grades;
  }

 
  
}
