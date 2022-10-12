/*
1. Reciba x cantidad de productos
 - Nombre
 - Precio
 - Cantidad
 - Codigo
 - Descuento
2. Indique:
 - Mas costoso
 - Mayor cantidad
 - Precio total
 - Precio del producto bruto
 - Precio del producto neto
3. Punto 2 pero en USD
4. Configuracion:
  - IVA
  - Tasa dolar
5. Limpiar registro
6. Salir
*/

#include <iostream>
#include <vector>



struct Article {
public:
  std::string name;
  float price;
  int quantity;
  std::string code;
  int discount;

};

struct ListOfArticles {
  std::vector<Article> article;
};
struct Menu {
public:
  int op; // menu option
  bool isValid = true;
  // displays a menu with 6 options
  void display();
  void executeOpt(Article article);
  void validInput();

};

void Menu::display() {
  int ans;
  std::cout
    << "1. Agregar articulo." << std::endl
    << "2. Estadisticas (En BS)." << std::endl
    << "3. Estadisticas (EN USD)." << std::endl
    << "4. Configuracion (IVA y USD)." << std::endl
    << "5. Limpiar registro." << std::endl
    << "6. Salir." << std::endl;
  std::cin >> ans;
  op = ans;
}

void Menu::validInput() {
  if (op >= 1 && op <= 6) {
    isValid = true;
  }
  else {
    isValid = !isValid;
  }
}

void Menu::executeOpt(Article article) {
  // If it's invalid re-render the menu
  while (isValid != 1) {
    std::cout << "Opcion incorrecta" << std::endl;
    Menu::display();
    Menu::validInput();
  }
  switch (op)
  {
  case 1:
    break;
  case 2:

    break;
  case 3:

    break;
  case 4:

    break;
  case 5:

    break;
  case 6:

    break;

  default:
    break;
  }
}

int main()
{
  Menu menu;
  menu.display();
  menu.validInput();
  menu.executeOpt(Article());
  return 0;
}