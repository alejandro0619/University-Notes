package students;

import java.util.Scanner;
import grades.GradesManagement;
// enum for the two gender (and a third just for fun)...
enum Gender {
  Male,
  Female,
  Other
}

public class Student {
  private String name;
  private String lastName;
  private String birthDate;
  private Gender gender;
  private GradesManagement grades;

  public Student(String name, String lastName, String birthDate, Gender gender, GradesManagement grades) {
    this.name = name;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.gender = gender;
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

  public  GradesManagement getStudentGrades() {
    return this.grades;
  }

  public void setGrades(GradesManagement grades) {
    this.grades = grades;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
