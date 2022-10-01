/*
Reciba x cantidad de productos
 - Nombre
 - Precio
 - Cantidad
Indique:
 - Mas costoso
 - Mayor cantidad
 - Precio total
 - Precio del producto bruto
 - Precio del producto neto
*/

#include <iostream>
#include <tuple>
#include <unordered_map>
#include <vector>

using namespace std;

// Interfaz

int userInput() {
  int respuesta;

  cout << "Quieres ingresar un producto o salir? " << endl
       << "1: Agregar." << endl
       << "0: Salir." << endl;

  cin >> respuesta;
  return respuesta;
}
bool menu() {
  bool estadoDeLaApp = true;

  int resp = userInput();

  if (resp != 0 && resp != 1) {
    cout << "Opcion incorrecta" << endl;
    userInput();
  } else {
    if (resp == 1) {
      return estadoDeLaApp;
    } else {
      return !estadoDeLaApp;
    }
  }
}

string
mayorCantProd(vector<unordered_map<string, tuple<float, int>>> productos) {
  string nombreProd = "";
  float mayorCantidad = 0.0;

  for (int i = 1; i <= productos.size(); i++) {
    auto prod = productos[i];

    for (auto x : prod) {
      if (get<1>(x.second) > mayorCantidad) {
        mayorCantidad = get<1>(x.second);
        nombreProd = x.first;
      }
    }
  }
  return nombreProd;
}

float precioTotal(vector<unordered_map<string, tuple<float, int>>> productos) {
  float precioTotal = 0.0;
  cout << "Tamano del carrito : " << productos.size() << endl;

  for (int i = 1; i <= productos.size(); i++) {
    auto prod = productos[i];
    for (auto x : prod) {
      precioTotal = precioTotal + get<0>(x.second);
    }
  }
  return precioTotal;
}

string prodCostoso(vector<unordered_map<string, tuple<float, int>>> productos) {
  string nombreProdMasCostoso = "";
  float precioProdMasCostoso = 0.0;

  for (auto prod : productos) {
    for (auto x : prod) {
      if (get<0>(x.second) > precioProdMasCostoso) {
        precioProdMasCostoso = get<0>(x.second);
        nombreProdMasCostoso = x.first;
      }
    }
  }
  return nombreProdMasCostoso;
}
// para comoprbar si el precio es negativo
bool precioNegativo(int precio) {
  if (precio < 1) {
    return true;
  } else {
    return false;
  }
}

void precioBrutoProd(float precioBruto, int cantidad) {
  cout << "Precio bruto del producto " << precioBruto * cantidad << endl;
}

float precioNetoProd(float precioBruto, int cantidad) {
  float neto = (precioBruto * cantidad) + ((precioBruto * cantidad) * 0.16);

  cout << "Precio neto del producto " << neto << endl;
  return neto;
}
// para agregar al carrito.
vector<unordered_map<string, tuple<float, int>>> agregarAlCarrito() {
  string nombre;
  float precio;
  float precioIVA;
  int cantidadDeProd;
  bool esNegativo;

  int cantidad;
  tuple<float, int> precioYCantidad;

  // hashmap de productos en el carrito.
  unordered_map<string, tuple<float, int>> producto;
  vector<unordered_map<string, tuple<float, int>>> productos;

  cout << "Cantidad de productos a agregar: " << endl;
  cin >> cantidadDeProd;
  // pedimos los productos y sus datos
  for (int i = 1; i <= cantidadDeProd; ++i) {
    cout << "Nombre del producto: " << endl;
    cin >> nombre;
    // pedimos precio y comprobamos si es negativo.
    do {
      cout << "Agrege el precio de: " << nombre << " " << endl;
      cin >> precio;
      esNegativo = precioNegativo(precio);
    } while (esNegativo);

    cout << "Agrege la cantidad de: " << nombre << " " << endl;
    cin >> cantidad;

    // precio con IVA";
    precioIVA = precioNetoProd(precio, cantidad);

    // precio bruto:
    precioBrutoProd(precio, cantidad);

    // creamos el hashamp
    producto[nombre] = make_tuple(precioIVA, cantidad);

    // lo agregamos al vector.

    productos.push_back(producto);
  }

  return productos;
}

int main() {

  vector<unordered_map<string, tuple<float, int>>> carrito;
  // renderizamos el menu principal
  while (menu()) {
    carrito = agregarAlCarrito();
  }
  cout << "Hasta luego..." << endl;
  cout << "Producto mas costoso... " << prodCostoso(carrito) << endl;
  cout << "Precio total... " << precioTotal(carrito) << endl;
  cout << "Producto con mayor cantidad..." << mayorCantProd(carrito);
}
