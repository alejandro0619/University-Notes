use std::io;

use crate::file::parser;

pub struct Input {
    pub words: Vec<String>,
}

impl Input {
    pub fn new() -> Input {
        Input { words: Vec::new() }
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
    pub fn search(&self) -> std::io::Result<()> {
        let mut p = parser::Parser::new();
        p.parse()?;
        for word in &self.words {
            match p.search_word(word) {
                Some(c) => println!("La palabra {word} fue encontrada {c} veces"),
                None => println!("La palabra {word} no fue encontrada")
            };
        }

        Ok(())
    }
}
