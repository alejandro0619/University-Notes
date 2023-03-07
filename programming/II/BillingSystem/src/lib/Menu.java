package lib;

import java.util.Scanner;
import lib.clientManagement.ClientMenu;
import lib.stockManagement.Stock;

public class Menu {
  ClientMenu client = new ClientMenu();
  public void render(Stock stock) {
    Scanner sc = new Scanner(System.in);
    int option = 0;
    do {
      System.out.print("\n- - - MENU - - -\n");
      System.out.print("(1) Agregar Cliente\n(2) Pedidos registrados\n(3) Estadísticas\n(4) Configuraciones\n(5) Salir");
      System.out.print("\n- - - - - - - - -\n");
      System.out.print("Opción: ");
      option = sc.nextInt();
      switch (option) {
        case 1: {
          client.render(stock);
          break;
        }
        case 2:
          client.displayRequests();
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          System.out.print("- - - Cerrando el sistema... - - -");
          break;
        default:
          System.out.print("Incorrecto... Ingrese una opción válida");
          break;
      }
    } while (option != 5);
  }
}
