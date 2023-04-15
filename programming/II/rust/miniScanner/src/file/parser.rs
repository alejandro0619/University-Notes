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
    fn read() {
        unimplemented!()
    }
    // If the word is found, get the number of coincidences
    fn search_word(word: &str) -> Option<u32> {
        unimplemented!()
    }
}
