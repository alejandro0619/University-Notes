use std::fs::File;
use std::io::{self, Read};

struct Parser<'a> {
    file_path: &'a str
}

impl Parser<'_> {
    fn new() -> Self {
        Parser {
            file_path: "test.txt"
        }
    }
    // This should return a hashmap
    fn read(&self) -> io::Result<()>{
        let mut file = File::open(self.file_path)?;
        let mut content = String::new();

        file.read_to_string(&mut content)?;
        
        unimplemented!()
    }
    // If the word is found, get the number of coincidences
    fn search_word(word: &str) -> Option<u32> {
        unimplemented!()
    }
}
