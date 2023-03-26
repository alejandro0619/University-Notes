package lib.clientManagement;

import java.util.ArrayList;

import lib.requests.Request;

public class NaturalRequests {
  private Natural customer;
  private ArrayList<Request> requests;
  public NaturalRequests(Natural customer, ArrayList<Request> requests) {
    this.customer = customer;
    this.requests = requests;
  }

  public String getInfo() {
    return customer.getName() + " " + customer.getLastName();
  }
  
  public ArrayList<Request> getRequests() {
    return requests;
  }

  public Natural getCustomer() {
    return customer;
  }
  // Request with most amount of products
  public Request getMostSoldRequest() {
    Request mostSold = requests.get(0);
    for (Request req : requests) {
      if (req.getMostSold().getAmount() > mostSold.getMostSold().getAmount()) {
        mostSold = req;
      }
    }
    return mostSold;
  }
}
