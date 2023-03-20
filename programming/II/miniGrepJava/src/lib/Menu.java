package lib;

import java.util.Scanner;

public class Menu {
  public Menu() throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("- - - MENU - - -\n");
    int option = 0;
    FileHandler fh = null;
    do {
      System.out.println(" (1) Crear archivo e ingresar palabras");
      System.out.println(" (2) Estadísticas del archivo");
      System.out.println(" (3) Estadísticas generales");
      System.out.println(" (4) Salir");
      System.out.println("Ingrese una opción: ");
      option = scanner.nextInt();
      switch (option) {
        case 1: {
          System.out.print("Ingrese el nombre del archivo: ");
          String fileName = scanner.next();
            // Once we create the file we need to write in it.
            fh = new FileHandler(fileName);
            fh.write();
          break;
        }
        case 2:
          System.out.println("Estadísticas del archivo");
          // Scan the file and get the statistics such as the number of words
          SearchHandler sh = new SearchHandler(fh.getPath());
          System.out.println("Número de palabras: " + sh.getWordsAmount());
          sh.showWordsWithCount();
          break;
        case 3:
          System.out.println("Estadísticas generales");
          break;
        case 4:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opción inválida");
          break;
      }
    } while (option != 4);
    scanner.close();
  }
}
