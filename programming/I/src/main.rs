mod read_input;
mod get_greater;

fn main() {
    let inputs: [i32;3] = read_input::read_input();
    get_greater::get_greater(inputs);
}
