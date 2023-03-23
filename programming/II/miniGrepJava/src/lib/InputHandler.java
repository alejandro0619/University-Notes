package lib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.SanitizeString;

public class InputHandler {
  private String path;
  private ArrayList<String> wordsToSearch = new ArrayList<String>();

  public String getPath() {
    return path;
  }

  public InputHandler(String fileName) throws IOException {
    // creates a file with the given name or finds it if it already exists
    this.path = fileName.concat(".txt");
    try {
      File file = new File(this.path);
      if (!file.createNewFile()) {
        System.out.println("Archivo encontrado");
      } else {
        System.out.println("No se ha encontrado el archivo. Se ha creado uno nuevo.");
      }
    } catch (IOException e) {
      System.out.println("Un error ha ocurrido. ");
      e.printStackTrace();
    }
  }

  public void requestWords() {
    Scanner sc = new Scanner(System.in);
    boolean status = true;
    do {
      System.out.println("(1) Ingresar texto a buscar");
      System.out.println("(2) Salir al menú principal");
      System.out.print("Respuesta: ");
      int op = sc.nextInt();
      sc.nextLine(); // To read the \n char
      /*
       * Ask for text until the user want to exit the menu.
       * The text is added to the wordsToSearch array.
       * Checks if the text is empty and shows a message if it is.
       * If the user enters two or more words separated by a space, it will be added separately to the array.
       * And of course we sanitize the text before adding it to the array.
       */
      if (op == 1) {
        System.out.print("Escribir aquí: ");
        String txt = sc.nextLine();
        if (txt.isEmpty()) {
          System.out.println("No se ha ingresado texto");
          continue;
        }
        if (txt.split(" ").length > 1) {
          for (String word : txt.split(" ")) {
            this.wordsToSearch.add(new SanitizeString(word).getSanitized());
          }
          continue;
        }
        this.wordsToSearch.add(new SanitizeString(txt).getSanitized());
      } else if (op == 2) {
        status = false;
      } else {
        System.out.print("Opción incorrecta");
      }
    } while (status);
  }

  public void searchWords() throws IOException {
    /*
     * Search the words in the file and show how many times they appear
     * In case the word is not found, show a message
     */
    if (this.wordsToSearch.isEmpty()) {
      System.out.println("No se ha ingresado texto");
      return;
    }
    this.wordsToSearch.forEach(word -> {
      System.out.print("Buscando \"" + word + "\"...");
      
      try {
        new Parser(this.path).showWordsWithCount(word);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
