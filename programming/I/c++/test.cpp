#include <iostream>

int main() {
  int page = 0, row = 0, column = 0;
  int valuesToFill = 0;
  std::string ans = "";
  bool isEmpty = true; // El array SI esta vacio.
  std::cout << "Ingrese la cantidad de matrices que quieres: ";
  std::cin >> page;
  std::cout << "Ingrese la cantidad de filas: ";
  std::cin >> row;
  std::cout << "Ingrese la cantidad de columnas: ";
  std::cin >> column;

  int array[page][row][column];

  std::cout << "Quieres llenar la matriz? " << std::endl;
  std::cin >> ans;

  if (ans == "si") {
    isEmpty = !isEmpty;
    for (int p = 0; p < page; p++)
      for (int r = 0; r < row; r++)
        for (int c = 0; c < column; c++) {
          array[p][r][c] = valuesToFill;
          valuesToFill = valuesToFill + 2;
        }
  }
  std::cout << sizeof(array) / 4 << std::endl;
  if (isEmpty) {
    std::cout << "No hay elementos dentro del array" << std::endl;
  } else {
    std::cout << "Si tenemos elementos." << std::endl;
  }

  return 0;
}
