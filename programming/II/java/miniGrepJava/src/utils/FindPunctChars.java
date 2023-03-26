package utils;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FindPunctChars {

  private Character[] PunctMarks = {
    '!', '?', ',', '.', ';', ':', '"', '(', ')',
    '[', ']', '{', '}', '<', '>', '/', '\\', '|',
    '_', '-', '+', '=', '*', '&', '^', '%', '$',
    '#', '@', '~', '`', '¡', '¿'
  };
  private HashMap<String, Integer> PunctChars = new HashMap<>();

  public HashMap<String, Integer> getPunctChars() {
    return PunctChars;
  }
  
  /*
   *  Opens the file and reads it line by line
   * Then splits the line into words and words into chars
   * Checks if the chars appears in the punctMarks array
   * If it does, it adds it to the hashmap
   * If it doesn't, it continues
   */
  public FindPunctChars(String file) throws IOException {
    try {
      Scanner sc = new Scanner(new File(file));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        for (char c : line.trim().toCharArray()) {
          for (char pm : PunctMarks) {
            if (c == pm) {
              if (PunctChars.containsKey(String.valueOf(pm))) {
                PunctChars.put(String.valueOf(pm), PunctChars.get(String.valueOf(pm)) + 1);
              } else {
                PunctChars.put(String.valueOf(pm), 1);
              }
              continue;
            }
          }
          continue;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void show() {
    for (String key : PunctChars.keySet()) {
      System.out.println(key + " aparece " + PunctChars.get(key) + " veces");
    }
  }
}
