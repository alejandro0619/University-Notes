package students;
import grades.GradesManagement;
import utils.BirthDate;
import java.time.LocalDate;
import java.time.Period;
// enum for the two gender (and a third just for fun)...
enum Gender {
  Male,
  Female,
  Other
}

public class Student {
  private String name;
  private String lastName;
  private BirthDate birthDate;
  private LocalDate age;
  private Gender gender;
  private GradesManagement grades;
  private double average;

  public Student(String name, String lastName, BirthDate birthDate, Gender gender, GradesManagement grades) {
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

  public BirthDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(BirthDate birthDate) {
    this.birthDate = birthDate;
  }

  public int getAge() {
    return Period.between(this.birthDate.getDate(), LocalDate.now()).getYears();
  }
  public GradesManagement getStudentGrades() {
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

  public double getAverage() {
    computeAverage();
    return average;
  }

  private void computeAverage() {
    this.average =  this.grades.getAverage();
  }
}
