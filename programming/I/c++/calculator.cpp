/*
Programa que sirva para realizar operaciones basicas
*/
#include <iostream>
#include <math.h>
using namespace std;

int entradausuario() {
  int respuesta;
  cout << "Desea realizar alguna de las siguentes operaciones : " << endl
       << "1: suma " << endl
       << "2: resta" << endl
       << "3: multiplicacion " << endl
       << "4: division" << endl
       << "5: raiz cuadrada" << endl
       << "6: potencia " << endl
       << "7: NO" << endl;
  cout << "La opcion elegida es ";
  cin >> respuesta;
  return respuesta;
}

int suma(float a, float b) { 
  return a + b;
}
int resta(float a, float b) { 
  return a - b;
}
int multiplicacion(float a, float b) { 
  return a * b;
}
int division(float a, float b) { 
  return a / b;
}
int raiz(float a) { 
  return sqrt(a);
}
int potencia(float base, float exponente) { 
  return pow(base, exponente);
}

int main() {
  bool estado = true;
  float a, b,base,exponente;
  
  while (estado) {
    int res = entradausuario();
    switch (res) {
    case 1:
      cout << "Dame a: " << endl;
      cin >> a;
      cout << "Dame b: " << endl;
      cin >> b;

      cout << "La suma es: " << suma(a, b) << endl;
      break;
    case 2:
      cout << "Dame a: " << endl;
      cin >> a;
      cout << "Dame b: " << endl;
      cin >> b;

      cout << "La resta es: " << resta(a, b) << endl;
      break;
    case 3:
      cout << "Dame a: " << endl;
      cin >> a;
      cout << "Dame b: " << endl;
      cin >> b;
      cout << "La multiplicacion  es: " << multiplicacion(a, b) << endl;
      break;
    case 4:
      cout << "Dame a: " << endl;
      cin >> a;
      cout << "Dame b: " << endl;
      cin >> b;

      cout << "La division es: " << division(a, b) << endl;
      break;
    case 5:
      cout << "Dame un numero: " << endl;
      cin >> a;
      cout << "La raiz es: " << raiz(a) << endl;
      break;
    case 6:
      cout << "Dame la base: " << endl;
      cin >> base ;
      cout << "Dame el exponente: " << endl;
      cin >> exponente;
      cout << "La potencia es: " << potencia(base, exponente) << endl;
      break;
    case 7:
      return !estado;
      break;
    default:
      cout << "Opcion incorrecta. " << endl;
      continue;
    }
  }
  return 0;
}
