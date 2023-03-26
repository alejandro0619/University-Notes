package lib;

import java.util.Scanner;
import lib.clientManagement.ClientMenu;
import lib.stockManagement.Stock;
import lib.utils.Conf;

public class Menu {
  ClientMenu client = new ClientMenu();
  public void render(Stock stock) {
    Scanner sc = new Scanner(System.in);
    Conf exchange = null; // Temporal value
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
        case 2: {
          client.displayRequests();
          break;
        }
        case 3: {
          System.out.print("\n- - - ESTADÍSTICAS - - -\n");
          if (exchange == null) {
            System.out.print("Ingrese la tasa de cambio en configuraciones antes de acceder a esta opción");
            break;
          }
          // We display the statistics
          // Total of requests.
          client.getTotal();
          // Total sold
          client.getTotalSold(exchange.getExchange());
          // total sold for natural customers and bussiness customers
          client.getCustomers();
          // Total sold by gender
          client.getTotalByGender(exchange.getExchange());
          // Total sold by id type
          client.RequestsByTypeOfId();
          break;
        }
        case 4: {
          exchange = new Conf(); 
          break;
        }
        case 5: {
          System.out.print("- - - Cerrando el sistema... - - -");
          break;
        }
        default:{
          System.out.print("Incorrecto... Ingrese una opción válida");
          break;
        }
      }
    } while (option != 5);
  }
}
