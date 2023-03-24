package lib;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import utils.*;

public class Parser {
  private long totalWords = 0;
  private HashMap<String, Integer> Words = new HashMap<String, Integer>();
  
  private long EmptyLines = 0;

  public Parser(String path) throws IOException {
    try {
      /* Opens the file and reads it line by line
       * Then splits the line into words and adds them to the hashmap
       * It uses the SanitizeString class to remove the punctuation, exclamation and question marks from the String
       * If the word already exists, it adds 1 to the value
       * If it doesn't exist, it adds it to the hashmap with a value of 1
       * Finally, it adds the amount of words in the line to the totalWords variable 
       */
      Scanner sc = new Scanner(new File(path));
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] wordsInLine = line.split(" ");

        for (String word : wordsInLine) {
          word = new SanitizeString(word).getSanitized();

          if (word.isEmpty()) {
            EmptyLines = EmptyLines + 1;
            //continue;
          }
          if (Words.containsKey(word)) {
            Words.put(word, Words.get(word) + 1);
          } else {
            Words.put(word, 1);
          }
        }
        totalWords += wordsInLine.length;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public long getTotalWords() {
    return totalWords - EmptyLines;
  }
  // Sorts the hashmap by value and returns the most frequent word
  public void showMostUsedWords() {
    new Sort(Words).showMostFrequent();
  }
  // Shows the given words and the amount of times they appear
  public void showWordsWithCount(String word) {
    if (this.Words.containsKey(word)) {
      System.out.println(word + " aparece " + this.Words.get(word) + " veces");

    } else {
      System.out.println("La palabra(s) \"" + word + "\" no se encuentra en el archivo");
    }
  }
}
