package utils;

public class SanitizeString {
  private String raw;
  private String sanitized;

  public SanitizeString(String str) {
    this.raw = str;
    // sanitize any punctuation marks, and exclamations, and question marks
    this.sanitized = this.raw.replaceAll("[^\\w\\s]+", "").toLowerCase();
  }

  public String getRaw() {
    return raw;
  }

  public String getSanitized() {
    return sanitized;
  }
  
}
