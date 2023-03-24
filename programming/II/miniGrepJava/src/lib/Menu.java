package lib;

import java.util.Scanner;

import utils.FindPunctChars;

public class Menu {
  public Menu() throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("- - - MENU - - -\n");
    int option = 0;
    InputHandler Fh = null;
    Parser Sh = null;
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
            Fh = new InputHandler(fileName);
            Fh.requestWords();
            break;
          
        case 2:
          System.out.println("- - - ESTADÍSTICAS DEL ARCHIVO - - -");
          // Scan the file and get the statistics such as the number of words, 
          // the total of words (except the ones that are repeated) 
          // and the most used words.
          if (Fh == null) {
            System.out.println("No se ha ingresado ningún archivo");
            break;
          }
          Sh = new Parser(Fh.getPath());
          System.out.println("Número de palabras total : " + Sh.getTotalWords());
          Sh.showMostUsedWords();
          new FindPunctChars(Fh.getPath()).show();
          break;

        case 3:
          System.out.println("- - - ESTADÍSTICAS GENERALES - - -");
          if (Fh == null) {
            System.out.println("No se ha ingresado ningún archivo");
            break;
          }
          Fh.searchWords();
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
