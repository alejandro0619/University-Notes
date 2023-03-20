package lib;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SearchHandler {
  int wordsAmount = 0;
  HashMap<String, Integer> words = new HashMap<String, Integer>();
  public SearchHandler(String path) throws IOException {
    try {
      Scanner sc = new Scanner(new File(path));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] wordsInLine = line.split(" ");
        for (String word : wordsInLine) {
          if (words.containsKey(word)) {
            words.put(word, words.get(word) + 1);
          } else {
            words.put(word, 1);
          }
        }
      }
      wordsAmount = words.size();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public int getWordsAmount() {
    return wordsAmount;
  }

  public void showWordsWithCount() {
    /// loop through the hashmap and print the key and value
    for (String word : words.keySet()) {
      System.out.println(word + " " + words.get(word));
    }
  }
}
