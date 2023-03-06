package lib.requests;

import java.util.ArrayList;
import java.util.Scanner;
import lib.stockManagement.Stock;

public class RequestWrapper {
  private ArrayList<Request> rqs = new ArrayList<Request>();

  public RequestWrapper(Stock stock) {
    Scanner sc = new Scanner(System.in);
    RequestMenu rm = new RequestMenu();
    System.out.print("\n¿Cuántos pedidos quieres agregar?\nRespuesta:");
    int rqAmount = sc.nextInt();
    while (rqAmount < 0) {
      System.out.print("Ingrese un número válido");
      rqAmount = sc.nextInt();
    }
    for (int i = 0; i < rqAmount; i++) {
      System.out.print("\nPedido: #" + (i + 1) + "\n");
      rm.render(stock);
      rqs.add(rm.getReq());
    }
  }

  public ArrayList<Request> getRqs() {
    return rqs;
  }
}
