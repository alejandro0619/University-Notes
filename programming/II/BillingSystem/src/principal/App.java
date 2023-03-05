package principal;

import lib.stockManagement.Stock;
import lib.clientManagement.Client;
public class App {
    public static void main(String[] args) {
        Stock stock = new Stock();
        System.out.print(stock.toString());
        Client client = new Client();
        System.out.print(client.toString());
    }
}
