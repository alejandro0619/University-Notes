package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Sort {
  private LinkedHashMap<String, Integer> SortedMap;

  public LinkedHashMap<String, Integer> getSortedMap() {
    return SortedMap;
  }

  public Sort(HashMap<String, Integer> hm) {
    // Sort the hashmap by value
    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : hm.entrySet()) {
      list.add(entry.getValue());
    }
    Collections.sort(list, Collections.reverseOrder());
    for (int num : list) {
      for (Entry<String, Integer> entry : hm.entrySet()) {
        if (entry.getValue().equals(num)) {
          sortedMap.put(entry.getKey(), num);
        }
      }
    }
    this.SortedMap = sortedMap;
  }

  public void showMostFrequent() {
    // loop through the hashmap and show the MOST used words
    ArrayList<WordTuple> MostFrequent = new ArrayList<>();
    int mostFrequent = 0;
    // Get the most frequent word
    for (String word : this.SortedMap.keySet()) {
      if (this.SortedMap.get(word) > mostFrequent) {
        mostFrequent = this.SortedMap.get(word);
      }
    }
    // Add it to the arraylist
    for (String word : this.SortedMap.keySet()) {
      if (this.SortedMap.get(word) == mostFrequent) {
        MostFrequent.add(new WordTuple(word, this.SortedMap.get(word)));
      }
    }
    // Print the arraylist
    System.out.println("Palabras mas usadas: ");
    for (WordTuple word : MostFrequent) {
      System.out.println(word.getWord() + " = " + word.getCount());
    }
  }
}
