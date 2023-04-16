use std::io;

use super::input::Input;

pub struct Menu {
    state: bool,
}

impl Menu {
    pub fn new() -> Menu {
        Menu { state: true }
    }

    pub fn display_menu(&mut self) -> std::io::Result<()> {
        while self.state {
            println!("Menú principal");
            println!("(1) Ingresar palabras a buscar");
            println!("(2) Estadísticas del archivo");
            println!("(3) Estadísticas generales");
            println!("(4) Salir");
            let mut option = String::new();
            io::stdin()
                .read_line(&mut option)
                .expect("Error al leer la opción");
            let option: u32 = option.trim().parse().expect("Error al convertir la opción");
            match option {
                1 => {
                    let mut i = Input::new();
                    i.words_to_search();
                    i.search()?;                    
                }
                2 => {
                    println!("Estadísticas del archivo");
                }
                3 => {
                    println!("Estadísticas generales");
                }
                4 => {
                    self.state = false;
                    println!("Salir");
                }
                _ => {
                    println!("Opción inválida");
                }
            }
        }
        Ok(())
    }
}
