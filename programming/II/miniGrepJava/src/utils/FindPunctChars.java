package utils;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FindPunctChars {
  

  private Character[] punctMarks = {
    '!', '?', ',', '.', ';', ':', '"', '(', ')',
    '[', ']', '{', '}', '<', '>', '/', '\\', '|',
    '_', '-', '+', '=', '*', '&', '^', '%', '$',
    '#', '@', '~', '`', '¡', '¿'
  };
  private HashMap<String, Integer> punctChars = new HashMap<>();

  public HashMap<String, Integer> getPunctChars() {
    return punctChars;
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
          for (char pm : punctMarks) {
            if (c == pm) {
              if (punctChars.containsKey(String.valueOf(pm))) {
                punctChars.put(String.valueOf(pm), punctChars.get(String.valueOf(pm)) + 1);
              } else {
                punctChars.put(String.valueOf(pm), 1);
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
    for (String key : punctChars.keySet()) {
      System.out.println(key + " aparece " + punctChars.get(key) + " veces");
    }
  }
}
