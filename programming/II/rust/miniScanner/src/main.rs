mod file;
mod handler;

use handler::main_menu::Menu;
fn main() {
    Menu::new().display_menu();
}
