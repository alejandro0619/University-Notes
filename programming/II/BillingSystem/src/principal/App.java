package principal;

import lib.Menu;
import lib.stockManagement.Stock;
public class App {
    public static void main(String[] args) {
        Stock stock = new Stock();
        System.out.print(stock.toString());
        new Menu().render();
    }
}
