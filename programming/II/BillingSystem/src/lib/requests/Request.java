package lib.requests;

import java.util.ArrayList;
import java.util.Scanner;

import lib.stockManagement.Product;
import lib.stockManagement.Stock;

public class Request {
  ArrayList<Product> products = new ArrayList<Product>();

  public void add(Stock stock) {
    Scanner sc = new Scanner(System.in);
    // We render the list of products
    System.out.print(stock.toString());
    System.out.print("¿Qué elemento quieres agregar a tu pedido?\n");
    System.out.print("Respuesta: ");
    int prod = sc.nextInt() - 1;
    while (prod < 0 || prod > stock.getStock().size()) {
      System.out.print("Producto de inventario incorrecto... Ingrese de nuevo");
      prod = sc.nextInt() - 1;
    }
    // Chosen product
    Product currentProduct = stock.getStock().get(prod);

    System.out.print("¿Qué cantidad de " + currentProduct.getName() + " quiere?\nRespuesta: ");
    int amount = sc.nextInt();
    while (amount < 0 || amount > currentProduct.getAmount()) {
      System.out.print("Cantidad incorrecta... Ingrese de nuevo: ");
      amount = sc.nextInt();
    }
    // Modify the amount of products in Stock
    currentProduct.setAmount(currentProduct.getAmount() - amount);

    // Add the product to the request
    Product prodToAdd = new Product(currentProduct);
    prodToAdd.setAmount(amount); // we set the amount of the product
    products.add(prodToAdd);

  }

  public void show() {
    if (products.size() == 0) {
      System.out.print("No hay productos en el pedido...");
    } else {
      for (Product prod : products) {
        System.out.print(prod.toString() + "\n");
      }
    }
  }
}
