package utils;

public class WordTuple {
  private String Word;
  private int Count;

  public WordTuple(String word, int count) {
    this.Word = word;
    this.Count = count;
  }

  public String getWord() {
    return Word;
  }
  
  public int getCount() {
    return Count;
  }
  
}
