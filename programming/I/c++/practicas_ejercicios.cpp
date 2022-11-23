#include <iostream>

using namespace std;

// Ask for the size of the array, fill the array automatically and then display
// each item with its index.
void generar_array() {
  int size = 0;
  cout << "Por favor ingresar el tamano del array: ";
  cin >> size;
  int array[size];

  for (int i = 0; i < size; i++) {
    array[i] = (i + 1);
  }
  cout << "A continuacion mostramos el array: " << endl;
  for (int i = 0; i < size; i++) {
    cout << "En el indice [ " << i << " ] = " << array[i] << endl;
  }
}

// Based on the last exercise just change the values being stored and produce
// the sum of each value:
void sumar_elementos_array() {
  int size = 0;
  cout << "Por favor ingresar el tamano del array: ";
  cin >> size;
  int valorArbitrario = 0;
  int sum = 0;
  int array_dos[size];

  // Here we generate numbers automatically but different from the last
  // exercise.
  for (int i = 0; i < size; i++) {
    valorArbitrario = valorArbitrario + 2;
    array_dos[i] = (i + valorArbitrario);
  }

  // Here we loop through the array and we add each item.
  for (int i = 0; i < size; i++) {
    sum = sum + array_dos[i];
  }

  cout << "La suma es: " << sum << endl;
}

// Ask the user to give values as input to fill the array
// Then create another array and fill it automatically
// Calculate the main diagonal
// Add both arrays
// Multiply both arrays.

void diagonal_array() {
  int size = 0;
  cout << "Por favor ingrese la cantidad de columnas y filas de ambas "
          "matrices: ";
  cin >> size;
  int valor_absoluto = 0;
  int array[size][size];
  int array_two[size][size];

  // First array with values given by the user
  for (int i = 0; i < size; i++) {
    for (int j = 1; j < size; j++) {
      cout << "En el indice [ " << i << " : " << j << " ]"
           << " = ";
      cin >> array[i][j];
    }
  }
  // Second array with values generated automatically
  cout << "Generando la segunda matriz: " << endl;
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      valor_absoluto = valor_absoluto + 1;
      array_two[i][j] = valor_absoluto;
      cout << "En el indice [ " << i << " : " << j << " ] = " << valor_absoluto
           << endl;
    }
  }
  // First array's diagonal:
  cout << "La diagonal de la primera matriz: " << endl;
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      if (i == j) {
        cout << "En el indice: [ " << i << " : " << j
             << " ] el valor es: " << array[i][j] << endl;
      }
    }
  }
  // Addition between both arrays
  cout << "La nueva matriz resultante de la suma de ambas: " << endl;

  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      cout << "En el indice: [ " << i << " : " << j
           << " ] tenemos el valor: " << array[i][j] + array_two[i][j] << endl;
    }
  }

  // Now we multiply both arrays:
  cout << "La nueva matriz resultante del producto de ambas: " << endl;

  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      cout << "En el indice: [ " << i << " : " << j
           << " ] tenemos el valor: " << array[i][j] * array_two[i][j] << endl;
    }
  }

  // We calculate the secundary diagonal:
  cout << "La diagonal inversa es: " << endl;
  int c = size - 1;
  for (int i = 0; i < size; i++) {
    cout << "En el indice: [ " << i << " : " << c << " ] = " << array[i][c]
         << endl;
    c--;
  }
}
int main() {
  // generar_array();
  // sumar_elementos_array();
  // diagonal_array();
  return 0;
}
