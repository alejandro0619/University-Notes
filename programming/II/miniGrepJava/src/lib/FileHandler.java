package lib;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class FileHandler {
  private String path;

  public String getPath() {
    return path;
  }

  public FileHandler(String fileName) throws IOException {
    // creates a file with the given name
    this.path = fileName.concat(".txt");
    try {
      File file = new File(this.path);
      if (file.createNewFile()) {
        System.out.println("Archivo creado: " + file.getName());
      } else {
        System.out.println("El archivo ya existe");
      }
    } catch (IOException e) {
      System.out.println("Un error ha ocurrido. ");
      e.printStackTrace();
    }
  }

  public void write() throws IOException {
    try {
      FileWriter fw = new FileWriter(this.path, true);
      Scanner sc = new Scanner(System.in);
      StringBuilder buf = new StringBuilder();
      
      boolean status = true;

      do {
        System.out.println("(1) Ingresar texto");
        System.out.println("(2) Salir al menú");
        System.out.print("Respuesta: ");
        int op = sc.nextInt();
        sc.nextLine(); // To read the \n char
        /* 
         * Ask for text until the user want to exit the menu.
         * The text is appended to the StringBuilder object.
         * Then the StringBuilder object is converted to a String
         * and written to the file.
         */
        if (op == 1) {
          System.out.print("Escribir aquí: ");
          String txt = sc.nextLine();
          buf.append(txt + "\n");
        } else if (op == 2) {
          status = false;
        } else {
          System.out.print("Opción incorrecta");
        }
      } while (status);

      fw.write(buf.toString());
      fw.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
