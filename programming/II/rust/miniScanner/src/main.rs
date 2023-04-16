mod file;
mod handler;
pub mod utils;

use handler::main_menu::Menu;
fn main() {
    match Menu::new().display_menu() {
        Ok(_) => (),
        Err(e) => eprintln!("error haha: {e}")
    };
}
