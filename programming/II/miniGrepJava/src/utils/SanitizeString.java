package utils;

public class SanitizeString {
  private String raw;
  private String sanitized;
  private String punctChar;

  private Character[] punctMarks = {
      '!', '?', ',', '.', ';', ':', '"', '(', ')',
      '[', ']', '{', '}', '<', '>', '/', '\\', '|',
      '_', '-', '+', '=', '*', '&', '^', '%', '$',
      '#', '@', '~', '`'
  };

  public SanitizeString(String str) {
    this.raw = str;
    // add punctuation marks to the hashmap
    if (!str.matches("[\\w]+")) {
      for (char c : str.toCharArray()) {
        for (char pm : punctMarks) {
          if (c == pm) {
            this.punctChar = String.valueOf(c);
          }
        }
      }
    }
    // sanitize any punctuation marks, and exclamations, and question marks
    this.sanitized = this.raw.replaceAll("[^\\w\\s]+", "").toLowerCase();
  }

  public String getRaw() {
    return raw;
  }

  public String getSanitized() {
    return sanitized;
  }

  public String getPunctChar() {
    return punctChar;
  }
}
