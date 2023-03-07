package lib.clientManagement;

import java.util.ArrayList;

import lib.requests.Request;

public class BussinessRequests {
  private Bussiness customer;
  private ArrayList<Request> requests;
  public BussinessRequests(Bussiness customer, ArrayList<Request> requests) {
    this.customer = customer;
    this.requests = requests;
  }
  public String getInfo() {
    return "";
  }
  public ArrayList<Request> getRequests() {
    return requests;
  }
  public Bussiness getCustomer() {
    return customer;
  }
}
