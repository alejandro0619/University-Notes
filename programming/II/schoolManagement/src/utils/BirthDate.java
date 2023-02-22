package utils;

import java.util.Scanner;

public class BirthDate {
  private Scanner sc = new Scanner(System.in);
  private int day;
  private int month;
  private int year;

  public BirthDate() {
    // Dia
    System.out.print("Ingrese su día de nacimiento: ");
    int day = this.sc.nextInt();
    while (day < 0 || day > 31) {
      System.out.print("Día incorrecto... Ingrese de nuevo: ");
      day = this.sc.nextInt();
    }

    // Mes
    System.out.print("Ingrese su mes de nacimiento: ");
    int month = this.sc.nextInt();
    while (month < 0 || month > 12) {
      System.out.print("Mes incorrecto... Ingrese de nuevo: ");
      month = this.sc.nextInt();
    }

    // Año
    System.out.print("Ingrese su año de nacimiento: ");
    int year = this.sc.nextInt();
    while (year < 0 || day > 2023) {
      System.out.print("Año incorrecto... Ingrese de nuevo: ");
      year = this.sc.nextInt();
    }

    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Scanner getSc() {
    return sc;
  }

  public void setSc(Scanner sc) {
    this.sc = sc;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return  day + " - " + month + " - " + year;
  }
  
}
