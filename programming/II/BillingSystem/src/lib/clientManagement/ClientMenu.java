package lib.clientManagement;

import java.util.Scanner;

/*
 * Inner menu to add products.
 */
public class ClientMenu {
  public void render() {
    Scanner sc = new Scanner(System.in);
    boolean status = false;

    while(status == false) {
      System.out.print("\n- - - OPCIONES - - -\n");
      System.out.print("(1) Natural\n(2) Jurídico");
      System.out.print("\n- - - - - - - - - - -\n");
      System.out.print("Respuesta: ");
      int option = sc.nextInt();
      switch(option) {
        case 1:
          Client cl = new Client();
          System.out.print(cl.toString());
          status = true; // we leaves the loop once status is true
          break;
        case 2:
          status = true;
          break;
        default:
          System.out.println("Incorrecto...");
          status = false;
      }
    }
  }
}
