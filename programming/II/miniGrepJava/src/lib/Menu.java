package lib;

import java.util.Scanner;

public class Menu {
  public Menu() throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("- - - MENU - - -\n");
    int option = 0;
    FileHandler fh = null;
    Parser sh = null;
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
          System.out.println("- - - ESTADÍSTICAS DEL ARCHIVO - - -");
          // Scan the file and get the statistics such as the number of words, 
          // the total of words (except the ones that are repeated) 
          // and the most used words.
          sh = new Parser(fh.getPath());
          System.out.println("Número de palabras : " + sh.getWordsAmount());
          System.out.println("Número de palabras total : " + sh.getTotalWords());
          sh.showMostUsedWords();
          break;
        case 3:
          System.out.println("- - - ESTADÍSTICAS GENERALES - - -");
          sh.showWordsWithCount();
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
