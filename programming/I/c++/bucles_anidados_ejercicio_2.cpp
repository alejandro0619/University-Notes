
#include <iostream>
#include <vector>

using namespace std;
int menu() {
  int respuesta = 0;
  cout << "bienvenido" << endl;
  cout << "1. Ingresar los datos de la matriz" << endl;
  cout << "2. Generar datos automaticamente." << endl;
  cout << "3. Mostrar la diagonal de la primera matriz" << endl;
  cout << "4. Suma de las matrices " << endl;
  cout << "5. Multiplicación de las matrices" << endl;
  cout << "6. SALIR" << endl;

  cin >> respuesta;
  return respuesta;
}

int main() {
  bool appState = true;
  bool isArrayEmpty = true; // We control the render state of the menu
  int page = 0, row = 0, column = 0, autoGenValue = 0;
  vector<int> firstDiag;
  vector<int> secondDiag;

  std::cout << "Cuantas matrices quieres? ";
  std::cin >> page;
  std::cout << "Cuantas filas quieres para ambas matrices? ";
  std::cin >> row;
  std::cout << "Cuantas columnas quieres para ambas matrices? ";
  std::cin >> column;
  int arr[page][row][column];

  do {
    switch (menu()) {
    case 1: {
      if (isArrayEmpty) { // If it's empty we set it to false.
        isArrayEmpty = !isArrayEmpty;
      }

      for (int p = 0; p < page; p++) {
        std::cout << "---- "
                  << "matriz: " << (p + 1) << " ----" << std::endl;
        for (int r = 0; r < row; r++) {
          for (int c = 0; c < column; c++) {
            std::cout << "En la posicion: [ " << r << " : " << c << " ]: ";
            std::cin >> arr[p][r][c];
          }
        }
      }
      break;
    }

    case 2: {
      if (isArrayEmpty) { // If it's empty we set it to false.
        isArrayEmpty = !isArrayEmpty;
      }

      for (int p = 0; p < page; p++) {
        for (int r = 0; r < row; r++) {
          for (int c = 0; c < column; c++) {
            arr[p][r][c] = autoGenValue;
            std::cout << "[ " << p << " : " << r << " : " << c
                      << " ] = " << autoGenValue << std::endl;
            autoGenValue = autoGenValue + 2;
          }
        }
      }
      break;
    }

    case 3:
      break;
    case 4:
      break;
    case 5:
      break;

    case 6:
      appState = !appState;
      std::cout << "Goodbye!" << std::endl;
      break;
    default:
      std::cout << "Invalido, ingrese de nuevo" << std::endl;
      continue;
    }

  } while (appState);
  return 0;
}
