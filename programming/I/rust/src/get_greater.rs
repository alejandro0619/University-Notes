// Given an array, return the greatest value.
pub fn get_greater(a: [i32; 3]){
  let mut greater: i32  = 0;

  for n in a {
    if n > greater {
      greater = n;
    } else {
      continue;
    }
  }
  println!("The greater is: {}", greater);
  
}