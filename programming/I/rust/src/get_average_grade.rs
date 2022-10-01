// Get the average grades of the course of cs
// 20 student's grade this function will receive.
pub fn get_average_grades(grades_array: [i32; 5]) -> i32 {
  let lenght = grades_array.len();
  let mut sum = 0;

  for g in grades_array {
    sum = sum + g;
  }
  return sum / (lenght as i32);
}