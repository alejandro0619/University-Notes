use regex;
use std::borrow::Cow;

pub struct Sanitize<'s> {
  pub raw: &'s str,
  pub sanitized: Box<Cow<'s, str>>
}

impl<'s> Sanitize<'s> {
  pub fn new(word: &'s str) -> Self {
    let re = regex::Regex::new("[^\\w\\s]+").unwrap();
    let new_str = re.replace_all(word, "");
    Self {
      raw: word,
      sanitized: Box::new(new_str),
    }
  }
}