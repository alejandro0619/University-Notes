package lib.clientManagement;

import java.util.Scanner;
import java.util.ArrayList;

import lib.requests.RequestWrapper;
import lib.stockManagement.Stock;

/*
 * Inner menu to add products.
 */
public class ClientMenu {
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

    System.out.println("\n- - - CLIENTES NATURALES - - -");
    for (int i = 0; i < naturalCustomers.size(); i++) {
      // We generate the bill for the customer
      System.out.print("\n- - - FACTURA - - -\n");
      System.out.print("Número de factura: " + (i + 1) + "\n");
      System.out.println(naturalCustomers.get(i).getCustomer().toString());
      System.out.print("- - - Productos agregados - - -\n");
      naturalCustomers.get(i).getRequests().forEach((request) -> {
        request.show();
      });
    }
    System.out.println("\n- - - CLIENTES JURÍDICOS - - -");
    for (int i = 0; i < bussinessCustomers.size(); i++) {
      // We generate the bill for the customer
      System.out.print("\n- - - FACTURA - - -\n");
      System.out.print("Número de factura: " + (i + 1) + "\n");
      System.out.println(bussinessCustomers.get(i).getCustomer().toString());
      System.out.print("- - - Productos agregados - - -\n");
      bussinessCustomers.get(i).getRequests().forEach((request) -> {
        request.show();
      });
      
    }    
  }
}
