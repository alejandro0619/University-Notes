use std::io;

// Read users input and return a array.
pub fn read_input() -> [i32; 3] {
  let mut input_array = [0, 0, 0];
  let mut index = 0;
  loop {
      if index < input_array.len(){
          println!("Give a value to be evaluated: ");
          let mut input = String::new();
              match io::stdin()
                  .read_line(&mut input) {
                      Ok(_i) => (),
                      Err(_) => {
                          println!("Error ocurred!");
                          continue
                      }
                  };
          let input: i32 = match input.trim().parse() {
              Ok(n) => n,
              Err(_) => {
                  println!("Enter a number!");
                  continue
              }
          };
          input_array[index] = input;
          index = index + 1;
      }  else {
          break;
      }        
  }
  return input_array
}