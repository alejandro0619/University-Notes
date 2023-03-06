package lib.clientManagement;

import java.util.Scanner;
import java.util.ArrayList;

import lib.requests.RequestWrapper;
import lib.stockManagement.Stock;

/*
 * Inner menu to add products.
 */
public class Client {
  ArrayList<NaturalRequests> naturalCustomers = new ArrayList<NaturalRequests>();
  ArrayList<BussinessRequests> bussinessCustomers = new ArrayList<BussinessRequests>();

  public void render(Stock stock) {
    Scanner sc = new Scanner(System.in);
    boolean status = false;

    while (status == false) {
      System.out.print("\n- - - OPCIONES - - -\n");
      System.out.print("(1) Natural\n(2) Jurídico");
      System.out.print("\n- - - - - - - - - - -\n");
      System.out.print("Respuesta: ");
      int option = sc.nextInt();
      switch (option) {
        case 1: {
          Natural cl = new Natural();
          System.out.print(cl.toString());
          NaturalRequests naturalRequests = new NaturalRequests(cl, new RequestWrapper(stock).getRqs());
          naturalCustomers.add(naturalRequests); // We add a natural customer to the list

          status = true; // we leaves the loop once status is true
          break;
        }

        case 2: {
          Bussiness cl = new Bussiness();
          System.out.print(cl.toString());
          BussinessRequests bussinessRequests = new BussinessRequests(cl, new RequestWrapper(stock).getRqs());
          bussinessCustomers.add(bussinessRequests); // We add a bussiness customer to the list
          status = true;
          break;
        }

        default:
          System.out.println("Incorrecto...");
          status = false;
      }
    }
  }

  public void displayRequests() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n- - - CLIENTES NATURALES - - -\n");
    for (int i = 0; i < naturalCustomers.size(); i++) {
      System.out.println(
          (i + 1) + ".-" + naturalCustomers.get(i).getInfo() + " | Número de pedidos: "
              + naturalCustomers.get(i).getRequests().size());
    }
    System.out.println("\n- - - CLIENTES JURÍDICOS - - -\n");
    for (int i = 0; i < bussinessCustomers.size(); i++) {
      System.out.println(
          (i + 1) + ".-" + bussinessCustomers.get(i).getInfo() + " | Número de pedidos: "
              + bussinessCustomers.get(i).getRequests().size());
    }
    System.out.print("\n- - - Seleccione el tipo de cliente - - -\n");
    System.out.print("(1) Natural\n(2) Jurídico\nOpción: ");
    int option = sc.nextInt();
    while (option != 1 && option != 2) {
      System.out.print("Incorrecto... Ingrese una opción válida: ");
      option = sc.nextInt();
    }

    if (option == 1) {
      System.out.print("\n- - - Seleccione el cliente - - -\n");
      int customer = sc.nextInt() - 1;
      while (customer < 0 || customer > naturalCustomers.size()) {
        System.out.print("Incorrecto... Ingrese una opción válida: ");
        customer = sc.nextInt() - 1;
      }
      // We generate the bill for the customer
      System.out.print("\n- - - FACTURA - - -\n");
      System.out.print("Número de factura: " + (customer + 1) + "\n");
      System.out.print("- - - Productos agregados - - -\n");
      naturalCustomers.get(customer).getRequests().forEach((request) -> {
        request.show();
      });
      naturalCustomers.get(customer).getCustomer().toString();
      
    } else {
      System.out.print("\n- - - Seleccione el cliente - - -\n");
      int customer = sc.nextInt() - 1;
      while (customer < 0 || customer > bussinessCustomers.size()) {
        System.out.print("Incorrecto... Ingrese una opción válida: ");
        customer = sc.nextInt();
      }
      // We generate the bill for the customer
      System.out.print("\n- - - FACTURA - - -\n");
      System.out.print("Número de factura: " + (customer + 1) + "\n");
      System.out.print("- - - Productos agregados - - -\n");
      bussinessCustomers.get(customer).getRequests().forEach((request) -> {
        request.show();
      });
      bussinessCustomers.get(customer).getCustomer().toString();
    }
  }
}
