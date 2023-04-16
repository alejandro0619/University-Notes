use std::collections::HashMap;
use std::fs::File;
use std::io::{self, BufRead, BufReader};
use std::path::Path;
use crate::utils::sanitize::Sanitize;

type BufferResult = io::Result<io::Lines<BufReader<File>>>;

pub struct Parser<'a> {
    file_path: &'a str,
    mapped_words: HashMap<&'a str, u32>,
}

impl Parser<'_> {
    pub fn new() -> Self {
        Parser {
            file_path: "test.txt",
            mapped_words: HashMap::new(),
        }
    }
    /// Reads the given file and convert into a buffer for later read
    fn parse_to_buffer<P>(file: P) -> BufferResult
    where
        P: AsRef<Path>,
    {
        let file = File::open(file)?;

        Ok(BufReader::new(file).lines())
    }

    
    pub fn parse(&mut self) -> io::Result<()> {
        Parser::parse_to_buffer::<&str>(self.file_path)?
            .flatten()
            .for_each(|line| self.check_words(line));

        Ok(())
    }

    /// Checks if the word (the key) exists, if so, then increase by one the count,
    /// if doesn't, insert one (because it's the first time the word is found)
    fn check_words(&mut self, line: String) {
        line.split_whitespace().for_each(|w| {
            let sw = Sanitize::new(w).sanitized;
            // Leak the Box to ge a static reference to an str
            let str = Box::leak(sw);
            self.mapped_words.entry(str).and_modify(|n| *n += 1).or_insert(1);
        })
    }
    // If the word is found, get the number of coincidences
    pub fn search_word(&self, word: &str) -> Option<u32> {
        if let Some((_, value)) = self.mapped_words.get_key_value(word) {
            Some(*value)
        } else {
            None
        }
    }
}
