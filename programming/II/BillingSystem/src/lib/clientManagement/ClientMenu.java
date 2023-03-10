package lib.clientManagement;

import java.util.Scanner;
import java.util.ArrayList;

import lib.requests.Request;
import lib.requests.RequestWrapper;
import lib.stockManagement.Product;
import lib.stockManagement.Stock;
import lib.utils.Gender;
import lib.utils.IdType;

/*
 * Inner menu to add products and display stadistics
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

  /*
  * It displays the bill with the information of the client and the request
  */
  public void displayRequests() {
    Scanner sc = new Scanner(System.in);
    int j = 0; // It will be used to generate the bill number
    System.out.println("\n- - - CLIENTES NATURALES - - -");
    for (int i = 0; i < naturalCustomers.size(); i++) {
      // We generate the bill for each request of the customer
      for (Request req : naturalCustomers.get(i).getRequests()) {
        System.out.print("\n- - - FACTURA - - -\n");
        System.out.print("Número de factura: 0000" + (j + 1) + "\n");
        System.out.println(naturalCustomers.get(i).getCustomer().toString());
        req.show();
        j = j + 1;
      }
    }

    System.out.println("\n- - - CLIENTES JURÍDICOS - - -");
    for (int i = 0; i < bussinessCustomers.size(); i++) {
      // We generate the bill for the customer
      for (Request req : bussinessCustomers.get(i).getRequests()) {
        System.out.print("\n- - - FACTURA - - -\n");
        System.out.print("Número de factura: 0000" + (j + 1) + "\n");
        System.out.println(bussinessCustomers.get(i).getCustomer().toString());
        req.show();
        j = j + 1;
      }

    }
  }
  //////// STADISTICS ////////
  /*
   * Get total of requests by customers and the total of requests in general
   */
  public void getTotal() {
    int naturalTotalRequests = 0;
    int bussinessTotalRequests = 0;

    for (NaturalRequests naturalCustomer : naturalCustomers) {
      naturalTotalRequests += naturalCustomer.getRequests().size();
    }
    for (BussinessRequests bussinessCustomer : bussinessCustomers) {
      bussinessTotalRequests += bussinessCustomer.getRequests().size();
    }
    System.out.println("Total de ventas de clientes naturales: " + naturalTotalRequests);
    System.out.println("Total de ventas de clientes jurídicos: " + bussinessTotalRequests);
    System.out.println("Total de ventas: " + (naturalTotalRequests + bussinessTotalRequests));
  }
  
  /*
   * Get the total of customers
   */
  public void getCustomers() {
    System.out.println("Total de clientes naturales: " + naturalCustomers.size());
    System.out.println("Total de clientes jurídicos: " + bussinessCustomers.size());
  }
  /*
   * Get the total sold in $ and Bs
   */
  public void getTotalSold(double exchange) {
    double naturalTotalSold = 0;
    double bussinessTotalSold = 0;

    for (NaturalRequests naturalCustomer : naturalCustomers) {
      for (Request req : naturalCustomer.getRequests()) {
        naturalTotalSold += req.getTotalPrice() ;
      }
    }
    for (BussinessRequests bussinessCustomer : bussinessCustomers) {
      for (Request req : bussinessCustomer.getRequests()) {
        bussinessTotalSold += req.getTotalPrice();
      }
    }
    System.out.println("Total de ventas en Dólares: " + (naturalTotalSold + bussinessTotalSold));
    System.out.println("Total de ventas en Bolívares: " + ((naturalTotalSold + bussinessTotalSold) * exchange));
  }
  
  /*
   * Get how many male and female bought products
   */
  public void getTotalByGender(double exchange) {
    ArrayList<NaturalRequests> naturalWomen = new ArrayList<NaturalRequests>();
    int totalRequestWoman = 0;
    ArrayList<NaturalRequests> naturalMen = new ArrayList<NaturalRequests>();
    int totalRequestMen = 0;

    for (NaturalRequests natural : naturalCustomers) {
      if (natural.getCustomer().getGender() == Gender.Female) {
        naturalWomen.add(natural);
      } else {
        naturalMen.add(natural);
      }
    }
    for(NaturalRequests naturalWoman : naturalWomen) {
      totalRequestWoman += naturalWoman.getRequests().size();
    }
    for(NaturalRequests naturalMan : naturalMen) {
      totalRequestMen += naturalMan.getRequests().size();
    }
    System.out.println("Total de clientes naturales mujeres: " + naturalWomen.size() + " Con un total de ventas de: " + totalRequestWoman);
    System.out.println("Total de clientes naturales hombres: " + naturalMen.size() + " Con un total de ventas de: " + totalRequestMen);
    
    
  }
  
  /*
   * Get which product was the most sold between venezuelans, foreigners, business and gov
   */
  public void RequestsByTypeOfId() {
    ArrayList<NaturalRequests> naturalVenezuelans = new ArrayList<NaturalRequests>();
    ArrayList<NaturalRequests> naturalForeigners = new ArrayList<NaturalRequests>();
    ArrayList<BussinessRequests> bussiness = new ArrayList<BussinessRequests>();
    ArrayList<BussinessRequests> bussinessGov = new ArrayList<BussinessRequests>();

    for (NaturalRequests natural : naturalCustomers) {
      if (natural.getCustomer().getIdType() == IdType.Venezolano) {
        naturalVenezuelans.add(natural);
      } else {
        naturalForeigners.add(natural);
      }
    }
    for (BussinessRequests bussinessCustomer : bussinessCustomers) {
      if (bussinessCustomer.getCustomer().getIdType() == IdType.Juridico) {
        bussiness.add(bussinessCustomer);
      } else {
        bussinessGov.add(bussinessCustomer);
      }
    }

    if (naturalVenezuelans.size() == 0) {
      System.out.println("No hay clientes venezolanos agregados...");
    } else {
      // get the product most sold for venezuelans
      Product mostSoldVenezuelans = naturalVenezuelans.get(0).getMostSoldRequest().getMostSold();
      for (NaturalRequests natural : naturalVenezuelans) {
        if (natural.getMostSoldRequest().getMostSold().getAmount() > mostSoldVenezuelans.getAmount()) {
          mostSoldVenezuelans = natural.getMostSoldRequest().getMostSold();
        }
      }
      System.out.print("El producto mas vendido a clientes naturales venezolanos es: " + mostSoldVenezuelans.getName() + "\n");
    }

    if (naturalForeigners.size() == 0) {
      System.out.println("No hay clientes extranjeros agregados...");
    } else {
      // get the product most sold for foreigners
      Product mostSoldForeigners = naturalForeigners.get(0).getMostSoldRequest().getMostSold();
      for (NaturalRequests natural : naturalForeigners) {
        if (natural.getMostSoldRequest().getMostSold().getAmount() > mostSoldForeigners.getAmount()) {
          mostSoldForeigners = natural.getMostSoldRequest().getMostSold();
        }
      }
      System.out.print("El producto mas vendido a clientes naturales extranjeros es: " + mostSoldForeigners.getName() + "\n");
    }

    if (bussiness.size() == 0) {
      System.out.println("No hay clientes jurídicos agregados...");
    } else {
      // get the most sold product for business customers
      Product mostSoldBussiness = bussiness.get(0).getMostSoldRequest().getMostSold();
      for (BussinessRequests bussinessCustomer : bussiness) {
        if (bussinessCustomer.getMostSoldRequest().getMostSold().getAmount() > mostSoldBussiness.getAmount()) {
          mostSoldBussiness = bussinessCustomer.getMostSoldRequest().getMostSold();
        }
      }
      System.out.print("El producto mas vendido a clientes jurídicos es: " + mostSoldBussiness.getName() + "\n");
    }
    if (bussinessGov.size() == 0) {
      System.out.println("No hay clientes jurídicos gubernamentales agregados...");
    } else {
      Product mostSoldBussinessGov = bussinessGov.get(0).getMostSoldRequest().getMostSold();
      for (BussinessRequests bussinessCustomer : bussinessGov) {
        if (bussinessCustomer.getMostSoldRequest().getMostSold().getAmount() > mostSoldBussinessGov.getAmount()) {
          mostSoldBussinessGov = bussinessCustomer.getMostSoldRequest().getMostSold();
        }
      }
      System.out
          .print("El producto mas vendido a clientes jurídicos del gobierno es: " + mostSoldBussinessGov.getName() + "\n");
    }
  }
}
