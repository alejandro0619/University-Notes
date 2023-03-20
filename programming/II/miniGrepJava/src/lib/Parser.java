package lib;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


import utils.*;

public class Parser {
  private int wordsAmount = 0;
  private int totalWords = 0;
  private HashMap<String, Integer> Words = new HashMap<String, Integer>();

  public Parser(String path) throws IOException {
    try {
      Scanner sc = new Scanner(new File(path));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] wordsInLine = line.split(" ");
        for (String word : wordsInLine) {
          // Sanitize the word and then add it to the hashmap if it doesn't exist
          word = new SanitizeString(word).getSanitized();
          if (Words.containsKey(word)) {
            Words.put(word, Words.get(word) + 1);
          } else {
            Words.put(word, 1);
          }
        }
        totalWords += wordsInLine.length;
      }
      wordsAmount = Words.size();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public int getWordsAmount() {
    return wordsAmount;
  }

  public int getTotalWords() {
    return totalWords;
  }
  // What are the most used words?
  public void showMostUsedWords() {
    // loop through the hashmap and show the MOST used words
    new Sort(Words).showMostFrequent();
  }
  public void showWordsWithCount() {
    /// loop through the hashmap and print the key and value
    System.out.println("Palabras con su cantidad de repeticiones:");
    for (String word : Words.keySet()) {
      System.out.println(word + " = " + Words.get(word));
    }
  }
}
