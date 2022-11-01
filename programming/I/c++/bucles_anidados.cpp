/*
1.- Crear y llenar dos matrices bidimensionales.
2.- Calcular su diagonal.
3.- Sumar cada uno de sus elementos.
4.- Sumar diagonales.
*/

#include <iostream>

#include <ostream>
#include <vector>

// we render the menu and asks for an option.
int menu() {
  int answer = 0;
  std::cout << "\n Ingrese alguna de las opciones listadas: \n"
            << "1. Crear y llenar dos matrices bidimensionales \n"
            << "2. Calcular su diagonal \n"
            << "3. Sumar cada uno de sus elementos \n"
            << "4. Sumar sus diagonales. \n"
            << "5. Salir de la aplicacion \n"
            << std::endl;

  std::cin >> answer;
  return answer;
}

int main() {
  bool correctAnswer = true;
  int row = 0, column = 0;
  int accArr = 0;   // The sum of all elements in the arrays.
  int accDiag = 10; // The sum of all elements in the diagonal array.
  int ans = 0;
  std::vector<int> diagonalUno;
  std::vector<int> diagonalDos;
  std::cout << "Ingrese el valor de las filas: ";
  std::cin >> row;
  std::cout << "Ingrese el valor de la columna: ";
  std::cin >> column;

  int array[2][row][column];
  do {
    ans = menu();
    switch (ans) {

    case 1:
      for (int arr = 0; arr < 2; arr++) {
        std::cout << "----- "
                  << "Matriz " << arr << " -----" << std::endl;

        for (int i = 0; i < row; i++)
          for (int j = 0; j < column; j++) {
            std::cout << "En la posicion [" << (i + 1) << " : " << (j + 1)
                      << "] ";
            std::cin >> array[arr][i][j];
          }
      }
      break;
    case 2:
      for (int arr = 0; arr < 2; arr++)
        for (int i = 0; i < row; i++)
          for (int j = 0; j < column; j++) {
            if (i == j) {
              if (arr == 0) {
                diagonalUno.push_back(array[arr][i][j]); //[0,1,2,8]
              } else {
                diagonalDos.push_back(array[arr][i][j]);
              }
            } else {
              continue; // nos va a ayudar a cambiar simplemente de ciclo.
            }
          }

      std::cout << "La diagonal de la primera matriz es: " << std::endl;
      for (int i = 0; i < diagonalUno.size(); i++) {
        std::cout << diagonalUno[i] << " ";
      }

      std::cout << "\nLa diagonal de la segunda matriz es: " << std::endl;
      for (int i = 0; i < diagonalDos.size(); i++) {
        std::cout << diagonalDos[i] << " ";
      }
      break;
    case 3:
      for (int arr = 0; arr < 2; arr++)
        for (int i = 0; i < row; i++)
          for (int j = 0; j < column; j++) {
            accArr += array[arr][i][j];
          }
      std::cout << "La suma de ambas matrices es: " << accArr << std::endl;
      break;
    case 4:
      for (int i = 0; i < diagonalUno.size() && i < diagonalDos.size(); i++) {
        accDiag += (diagonalUno[i] + diagonalDos[i]);
      }
      std::cout << "La suma de ambas diagonales es: " << accDiag << std::endl;
      break;
    case 5:
      std::cout << "Goodbye \n";
      correctAnswer = !correctAnswer;
      break;
    default:
      std::cout << "Invalid option.";
      continue;
    }

  } while (correctAnswer);

  return 0;
}
