#include <iostream>
int main() {
  int dimensiones = 0;
  int paginas = 0;
  std::cout << "Ingrese las dimensiones para ambas matrices: " << std::endl;
  std::cin >> dimensiones;
  std::cout << "Ingrese la cantidad de matrices que quieres" << std::endl;
  std::cin >> paginas;

  int m[paginas][dimensiones][dimensiones]; // m[2][5][5]
  // --------------- PEDIR VALORES ---------------

  for (int i = 0; i < paginas; i++) {
    for (int j = 0; j < dimensiones; j++) {
      for (int k = 0; k < dimensiones; k++) {
        std::cout << "ingrese los datos de la matriz" << (i + 1)
                  << " En la posicion " << j << " : " << k << " = ";
        std::cin >> m[i][j][k];
      }
    }
  }
  // ---------------  DIAGONAL ---------------
  for (int i = 0; i < paginas; i++) {
    std::cout << "---- MATRIZ " << (i + 1) << " ---- " << std::endl;
    for (int j = 0; j < dimensiones; j++) {
      for (int k = 0; k < dimensiones; k++) {
        // haces lo que quieras.
        // m[i][j][k] asi accedes a cada uno de los valores dentro de la matriz,
        // mediante sus indices. Si j == k significa que ambos indices son
        // iguales: filas (j) es igual columnas (k), por tanto ese elemento,
        // forma parte de la diagonal
        if (j == k) {
          std::cout << "La diagonal en el indice: [" << j << " : " << k
                    << "] es = " << m[i][j][k] << std::endl;
        }
      }
    }
  }
  // --------------- EL PRODUCTO ---------------
  std::cout << "---- Productos -----" << std::endl;
  for (int i = 0; i < paginas; i++) {
    for (int j = 0; j < dimensiones; j++) {
      for (int k = 0; k < dimensiones; k++) {
        // Primera vuelta:
        // i = 0
        // i + 1 => 0 + 1 = 1
        // Segunda vuelta:
        // i = 1
        // i + 1 = 2
        if ((i + 1) != paginas) {
          std::cout << "El producto en el indice: [" << j << " : " << k << "]"
                    << " : " << m[i][j][k] << " x " << m[i + 1][j][k] << " = "
                    << m[i][j][k] * m[i + 1][j][k] << std::endl;
        } else {
          continue;
        }
      }
    }
  }
  for (int i = 0; i < paginas; i++) {
    for (int j = 0; j < dimensiones; j++) {
      for (int k = 0; k < dimensiones; k++) {
        if ((i + 1) != paginas) {
          std::cout << "La suma es :" << m[i][j][k] << "+" << m[i + 1][j][k]
                    << "=" << m[i][j][k] + m[i + 1][j][k] << std::endl;
        }
      }
    }
  }

  for (int i = 0; i < paginas; i++) {
    int k = dimensiones - 1;

    for (int j = 0; j < dimensiones; j++) {
      std::cout << m[i][j][k] << std::endl;
      k--;
    }
  }
  return 0;
}
