package lib.stockManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
  ArrayList<Product> Stock = new ArrayList<Product>();

  public Stock() {
    Scanner sc = new Scanner(System.in);
    System.out.print("¿Cuántos productos quiere precargar en el inventario? Respuesta: ");
    int size = sc.nextInt();
    while (size < 10) {
      System.out.print("Mínimo 10 productos para ser precargados en el inventario... Ingrese: ");
      size = sc.nextInt();
    }
    for (int i = 0; i < size; i++) {
      Product prod = new Product();
      Stock.add(prod);
    }
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    int index = 0;
    str.append("\n- - - PRODUCTOS DEL INVENTARIO - - -\n");
    for (Product prod : Stock) {
      index = index + 1;
      str.append(index + ".- " + prod.toString() + "\n");
    }
    str.append("- - - - - -\n");
    return str.toString();
  }

  public ArrayList<Product> getStock() {
    return Stock;
  }
}