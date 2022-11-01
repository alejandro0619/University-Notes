/*
1.- Crear y llenar dos matrices bidimensionales.
2.- Calcular su diagonal.
3.- Sumar cada uno de sus elementos.
4.- Sumar diagonales.
*/

#include <iostream>

#include <vector>

// we render the menu and asks for an option.
int menu() {
  int answer = 0;
  std::cout << "Ingrese alguna de las opciones listadas: \n"
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
  int row = 0, column = 0; // es necesario que los inicialice en cero? No.
  int accArr = 0;
  int ans = 0; // answer
  std::vector<int> diagonalUno;
  std::vector<int> diagonalDos;
  std::cout << "Ingrese el valor de las filas: ";
  std::cin >> row;
  std::cout << "Ingrese el valor de la columna: ";
  std::cin >> column;

  int array[2][row][column]; // y en esta linea de codigo, antes tenia los
                             // valores de row y column  = 0

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
      /*
       |2 4 |
       |3  6|:w

       */
      // Ahora recorremos el vector ya previamente creado.
      std::cout << "La diagonal de la primera matriz es: " << std::endl;
      for (int i = 0; i < diagonalUno.size(); i++) {
        std::cout << diagonalUno[i] << " | ";
      }

      // Ahora recorremos el vector ya previamente creado.
      std::cout << "La diagonal de la segunda matriz es: " << std::endl;
      for (int i = 0; i < diagonalDos.size(); i++) {
        std::cout << diagonalDos[i];
      }
      break;
    case 3:
      break;
    case 4:
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
