package lib.requests;

import java.util.Scanner;

public class RequestMenu {
  public void render() {
    Scanner sc = new Scanner(System.in);
    boolean status = false;
    while (status == false) {
      System.out.print("\n- - - MENÚ DEL CLIENTE - - -\n");
      System.out.print("(1) Agregar pedido\n(2) Visualizar pedido");
      System.out.print("\n- - - - - - - - - - - - - - -\n");
      System.out.print("Respuesta: ");
      int option = sc.nextInt();
      switch (option) {
        case 1:
          System.out.print("Agregar...");
          status = true;
          break;
        case 2:
          System.out.print("Visualizar pedido...");
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
