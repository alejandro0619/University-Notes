// Get the negatives even numbers in a serie of integers

// recieves a parameter 
pub fn get_average_negatives(numbers_array: [i32; 10]) -> f64{
  let mut sum = 0;
  for n in numbers_array {
    if n % 2 == 0 && n < 0 {
     
      sum = sum + 1; // If the number is even and less than 0, add 1 to sum variable
    } else {
      continue
    }
  }
  return sum as f64 / ( numbers_array.len() as f64); // cast i32 to f64
}
