/*
Calcula la ecuacion cuadratica dada por el usuario.
*/
#include <iostream>
#include <math.h>

using namespace std;

int entradaDeUsuario() {
  int respuesta;
  cout << "Desea resolver la ecuacion de segundo grado? " << endl
       << "1: Si." << endl
       << "0: No." << endl;
  cin >> respuesta;

  return respuesta;
}

bool menuDelUsuario() {
  int respuesta = entradaDeUsuario();
  bool estadoDeLaApp = true;

  if (respuesta != 1 && respuesta != 0) {
    cout << "Opcion incorrecta." << endl;

    // Ya que no es ninguna de las opciones, volvemos a pedir datos.
    menuDelUsuario();
  } else {
    if (respuesta == 1) {
      return estadoDeLaApp; // return true
    } else {
      return !estadoDeLaApp; // return false
    }
  }
}

void ecuacionSegundoGrado(float a, float b, float c) {

  if (a == 0) {
    cout << "a no puede ser cero." << endl;
  } else {
    double raiz = sqrt((pow(b, 2) - (4 * a * c)));
    double x_1 = (-b + (raiz)) / 2 * a;
    double x_2 = (-b - (raiz)) / 2 * a;

    cout << "Primer resultado: " << x_1 << endl;
    cout << "Segundo resultado: " << x_2 << endl;
  }
}
int main() {
  // renderizamos el menu:

  while (menuDelUsuario()) {
    float a = 0, b = 0, c = 0;

    cout << "Dame a: " << endl;
    cin >> a;
    cout << "Dame b: " << endl;
    cin >> b;
    cout << "Dame c: " << endl;
    cin >> c;
    ecuacionSegundoGrado(a, b, c);
  }
  cout << "Adios..." << endl;
  return 0;
}
