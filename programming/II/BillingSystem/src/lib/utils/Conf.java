package lib.utils;

import java.util.Scanner;

public class Conf {
  double exchange;

  public Conf() {
    Scanner sc = new Scanner(System.in);
    // ask for exchange rate
    // set exchange rate
    System.out.print("Ingrese el tipo de cambio: ");
    this.exchange = sc.nextDouble();
    while (this.exchange < 0) {
      System.out.print("Ingrese un tipo de cambio válido: ");
      this.exchange = sc.nextDouble();
    }
  }
  public double getExchange() {
    return this.exchange;
  }
}
