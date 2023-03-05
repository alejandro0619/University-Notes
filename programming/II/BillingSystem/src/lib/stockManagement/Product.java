package lib.stockManagement;

import java.util.Scanner;

public class Product {
  private String Name;
  private double Price;
  private int Amount;

  public Product() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el nombre del producto: ");
    this.Name = sc.nextLine();
    System.out.print("Ingrese el precio de " + this.Name + " : ");
    // we check the bounds
    this.Price = sc.nextDouble();
    while (this.Price < 0) {
      System.out.print("El precio no puede ser negativo... Ingrese de nuevo: ");
      this.Price = sc.nextDouble();
    }
    System.out.print("ingrese la cantidad de " + this.Name + " que desea llevar: ");
    // we check the bounds
    this.Amount = sc.nextInt();
    while (this.Amount < 0) {
      System.out.print("La cantidad no puede ser negativa... Ingrese de nuevo: ");
      this.Amount = sc.nextInt();
    }
  }

  @Override
  public String toString() {
    return "Nombre: " + this.Name + ", Precio: " + this.Price + ", Cantidad: " + this.Amount ;
  }
  
}
