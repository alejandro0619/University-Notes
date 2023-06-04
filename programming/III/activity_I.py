# REWRITE PENDING
# ALEJANDRO LOPEZ 30819825
# En una panaderia se elabora 4000 panes diarios,
# De los cuales 1000 son pan frances = 2
# Otros 1000 son de pan dulce = 5
# 500 son pan de perro caliente = 4
# 500 son de pan de hamburguesa = 20
# 700 son pan de sandwich = 10
# 300 pan de queso = 11

# Realizar un sistema de venta, donde se incluya su total según el país

# Cada pan en inventario con un tupla de cantidad en inventario y precio
bread_stock_price = {
  "frances": (1000, 2), "dulce": (1000, 5), "perro caliente": (500, 4),
  "hamburguesa": (500, 20), "sandwich": (700, 10), "queso": (300, 11)
}

# Cada país con su respectivo descuento asociado
countries_disc = {
  "Antigua y Barbuda": 10.3, "Argentina": 5, "Bahamas": 7, "Barbados": 3.4,
  "Belice": 88,"Bolivia": 45, "Brasil": 4, "Canada": 56, "Chile": 33,
  "Colombia": 6, "Costa Rica": 78.2, "Cuba": 90, "Dominica": 45.3,
  "Ecuador": 43, "El Salvador": 1.2, "Estado Unidos": 3.78, "Granada": 22,
  "Guatemala": 20, "Guyana": 12.3, "Haiti": 77, "Honduras": 66,
  "Jamaica": 23.89, "Mexico": 95, "Nicaragua": 9, "Panama": 3.6,
  "Paraguay": 3.7, "Peru": 25.6, "Republica Dominicana": 78.2, "San Cristobal y Nieves": 89.5,
  "San Vicente y las Granadinas": 2.33, "Santa Lucia": 29.2, "Surinam": 21.3, "Trinidad y Tobago": 3,
  "Uruguay": 8, "Venezuela": 98
}

## Aquí mostramos un menú tantas veces como el usuario quiera.
render_menu = True
while render_menu:
  print("1. Agregar compra de panes.\n2. Salir del menú")
  option = int(input(" Respuesta: "))
  if option == 1:
    country = input("Ingrese su país de residencia: ")
    # Si el país se encuentra en el diccionario, entonces se le aplica el descuento
    if country in countries_disc:
      print("Se ha encontrado el país, su compra tiene un descuento de: ",
            countries_disc.get(country), "%")

      # Mostramos el inventario de panes
      render_shopping_car = True
      # Carrito de compras
      shopping_car = []
      while render_shopping_car:
        print("1. Agregar panes al inventario.\n2. Finalizar compra.")
        option_shopping = int(input(" Respuesta: "))
        if option_shopping == 1:
          # Mostramos cada pan en una lista
          for index, item in enumerate(bread_stock_price.keys()):
            print(index + 1, ". ", item, "| Cantidad en inventario:",
                  bread_stock_price.get(item)[0])
            
          bread = input("Ingresa el nombre del pan: ")
          # En caso de que el pan seleccionado exista, pedimos cantidad y lo agregamos al carrito de compras
          if bread in bread_stock_price:
            amount = int(input("Selecciona la cantidad "))
            price = bread_stock_price.get(bread)[1]
            amount_stock = bread_stock_price.get(bread)[0]
            discount = (price * countries_disc.get(country)) / 100
            print(discount)
            if amount <= amount_stock:
              print("Nombre: ", bread, "Cantidad:", amount, "Precio:", price)
              # Agregamos al carrito de compra
              shopping_car.append((bread, amount, price * amount, amount *(price - discount)))
              # Editamos el inventario
              bread_stock_price[bread] = (amount_stock - amount, price)
            else:
              print("Cantidad de", bread, "inválida... Seleccione de nuevo")
          else:
            print("El nombre del pan es incorrecto... Seleccione de nuevo")

        elif option_shopping == 2:
          render_shopping_car = False
          # Mostramos la lista de compra
          for item in shopping_car:
            print("Nombre:", item[0], "\nCantidad:", item[1], "\nPrecio sin descuento:", item[2], "\nPrecio con descuento:", item[3], "\n---")
        else:
          print("Opción incorrecta")

    else:
      print("País seleccionado no encontrado, la compra no tendrá descuento.")
      # Mostramos el inventario de panes
      render_shopping_car = True
      # Carrito de compras
      shopping_car = []
      while render_shopping_car:
        print("1. Agregar panes al inventario.\n2. Finalizar compra.")
        option_shopping = int(input(" Respuesta: "))
        if option_shopping == 1:
          # Mostramos cada pan en una lista
          for index, item in enumerate(bread_stock_price.keys()):
            print(index + 1, ". ", item, "| Cantidad en inventario:",
                  bread_stock_price.get(item)[0])
            
          bread = input("Ingresa el nombre del pan: ")
          # En caso de que el pan seleccionado exista, pedimos cantidad y lo agregamos al carrito de compras
          if bread in bread_stock_price:
            amount = int(input("Selecciona la cantidad "))
            price = bread_stock_price.get(bread)[1]
            amount_stock = bread_stock_price.get(bread)[0]
            if amount <= amount_stock:
              print("Nombre: ", bread, "Cantidad:", amount, "Precio:", price)
              # Agregamos al carrito de compra
              shopping_car.append((bread, amount, price * amount))
              # Editamos el inventario
              bread_stock_price[bread] = (amount_stock - amount, price)
            else:
              print("Cantidad de", bread, "inválida... Seleccione de nuevo")
          else:
            print("El nombre del pan es incorrecto... Seleccione de nuevo")

        elif option_shopping == 2:
          render_shopping_car = False
          for item in shopping_car:
            print("Nombre:", item[0], "\nCantidad:", item[1], "\nPrecio sin descuento:", item[2], "\n---")
        else:
          print("Opción incorrecta")
  elif option == 2:
    render_menu = False
  else:
    print("Opción incorrecta")
