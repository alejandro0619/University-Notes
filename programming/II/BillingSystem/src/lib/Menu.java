package lib;

import java.util.Scanner;
import lib.clientManagement.ClientMenu;

public class Menu {
  public void render() {
    Scanner sc = new Scanner(System.in);
    int option = 0;
    do {
      System.out.print("\n- - - MENU - - -\n");
      System.out.print("(1) Agregar Cliente\n(2) Pedidos registrados\n(3) Estaísticas\n(4) Configuraciones\n(5) Salir");
      System.out.print("\n- - - - - - - - -\n");
      System.out.print("Opción: ");
      option = sc.nextInt();
      switch (option) {
        case 1: {
          new ClientMenu().render();
          break;
        }
        case 2:
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
