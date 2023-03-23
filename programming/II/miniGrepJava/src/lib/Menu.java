package lib;

import java.util.Scanner;

public class Menu {
  public Menu() throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("- - - MENU - - -\n");
    int option = 0;
    InputHandler fh = null;
    Parser sh = null;
    do {
      System.out.println(" (1) Buscador de palabras");
      System.out.println(" (2) Estadísticas del archivo");
      System.out.println(" (3) Estadísticas generales");
      System.out.println(" (4) Salir");
      System.out.println("Ingrese una opción: ");
      option = scanner.nextInt();
      switch (option) {
        case 1: 
          System.out.print("Ingrese el nombre del archivo: ");
          String fileName = scanner.next();
            // Once we create the file is created or found we asks for the words to search
            fh = new InputHandler(fileName);
            fh.requestWords();
            break;
          
        case 2:
          System.out.println("- - - ESTADÍSTICAS DEL ARCHIVO - - -");
          // Scan the file and get the statistics such as the number of words, 
          // the total of words (except the ones that are repeated) 
          // and the most used words.
          sh = new Parser(fh.getPath());
          System.out.println("Número de palabras total : " + sh.getTotalWords());
          sh.showMostUsedWords();
          break;

        case 3:
          System.out.println("- - - ESTADÍSTICAS GENERALES - - -");
          fh.searchWords();
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
