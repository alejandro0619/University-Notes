package lib.clientManagement;

import java.util.Scanner;

import lib.requests.RequestMenu;
import lib.stockManagement.Stock;

/*
 * Inner menu to add products.
 */
public class ClientMenu {
  public void render(Stock stock) {
    Scanner sc = new Scanner(System.in);
    boolean status = false;

    while(status == false) {
      System.out.print("\n- - - OPCIONES - - -\n");
      System.out.print("(1) Natural\n(2) Jurídico");
      System.out.print("\n- - - - - - - - - - -\n");
      System.out.print("Respuesta: ");
      int option = sc.nextInt();
      switch(option) {
        case 1: {
          Natural  cl = new Natural();
          System.out.print(cl.toString());
          new RequestMenu().render(stock);
          status = true; // we leaves the loop once status is true
          break;
        }
          
        case 2: {
          Bussiness cl = new Bussiness();
          System.out.print(cl.toString());
          new RequestMenu().render(stock);
          status = true;
          break;
        }
          
        default:
          System.out.println("Incorrecto...");
          status = false;
      }
    }
  }
}
