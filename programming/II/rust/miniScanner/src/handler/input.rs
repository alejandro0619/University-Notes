use std::io;

pub struct Input {
    pub words: Vec<String>,
}

impl Input {
    pub fn new() -> Input {
        Input {
            words: Vec::new(),
        }
    }

    pub fn words_to_search(&mut self) {
        println!("Ingrese las palabras a buscar");
        let mut words = String::new();
        io::stdin()
            .read_line(&mut words)
            .expect("Error al leer las palabras");
        words
            .split_whitespace()
            .for_each(|word| self.words.push(word.to_string()));
    }
}

