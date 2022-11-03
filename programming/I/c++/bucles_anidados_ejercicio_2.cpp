/*
desarrollar un programa que pida al usuario las dimensiones de una matriz m*n.
De esa matriz mostrar los elementos de la diagonal principal,rellenar otra
matriz n*m y realizar la suma y la multiplicación
*/
#include <iostream>
using namespace std;
int menu() {
  int respuesta = 0;
  cout << "bienvenido" << endl;
  cout << "1. Ingresar los datos de la matriz" << endl;
  cout << "2. Generar datos automaticamente." << endl;
  cout << "3. Mostrar la diagonal de la primera matriz" << endl;
  cout << "4. Suma de las matrices " << endl;
  cout << "5. Multiplicación de las matrices" << endl;
  cin >> respuesta;
  return respuesta;
}

int main() {
  bool appState = true;
  int page = 0, row = 0, column = 0, valorArbitrario = 0;
  std::cout << "Cuantas matrices quieres? ";
  std::cin >> page;
  std::cout << "Cuantas filas quieres para ambas matrices? ";
  std::cin >> row;
  std::cout << "Cuantas columnas quieres para ambas matrices? ";
  std::cin >> column;
  int arr[page][row][column];
  do {
    switch(menu()){
      case 1: {
        for(int p = 0; p < page; p++) {
          std::cout << "---- " << "matriz: " << ( p + 1)<< " ----" << std::endl;
          for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
              std::cout << "En la posicion: [ " << r << " : " << c << " ]: "; 
              std::cin >> arr[p][r][c];
            }
          }
        }
        break;
      }
        
      case 2: {
        for(int p = 0; p < page; p++) {
          for(int r = 0; r < row; r++){
            for(int c = 0; c < column; c++){
              arr[p][r][c] = (valorArbitrario + 1);
              valorArbitrario = valorArbitrario + 1;
            }
          }
        }
        break;
      }
        
      case 3: {
        for(int p = 0; p < page; p++) { 
          for(int r = 0; r < row; r++){ 
            for(int c = 0; c < column; c++){ /
              std::cout << "En la posicion: [ " << r << " : " << c << " ]: " << arr[p][r][c] << std::endl;
            }
          }
        }
        break;
      }
      
      case 4: 
        break;
      case 5: 
        break;
      default:
        std::cout << "Invalido, ingrese de nuevo" << std::endl;
        continue;
    }
    
  } while(appState);
      return 0;
}
