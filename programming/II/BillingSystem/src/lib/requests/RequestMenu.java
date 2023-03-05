package lib.requests;

import java.util.Scanner;

import lib.stockManagement.Stock;

public class RequestMenu {
  public void render(Stock stock) {
    Scanner sc = new Scanner(System.in);
    boolean status = false;
    Request req = new Request();
    while (status == false) {
      System.out.print("\n- - - MENÚ DEL CLIENTE - - -\n");
      System.out.print("(1) Agregar pedido\n(2) Visualizar pedido\n(3) Salir");
      System.out.print("\n- - - - - - - - - - - - - - -\n");
      System.out.print("Respuesta: ");
      int option = sc.nextInt();

      switch (option) {
        case 1:
          req.add(stock);
          break;
        case 2:
          req.show();
          break;
        case 3:
          status = true;
          break;
        default:
          System.out.println("Incorrecto...");
          status = false;
          break;
      }
    }
  }
}
