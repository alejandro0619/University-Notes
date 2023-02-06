// Alejandro Lopez CI 30819825
/*
 * 1. nombre del producto
 * 2. precio (en dolares)
 * 3. cantidad
 *  descuento ( 0 - 20 )
 * Menu:
 * 1. Agregar X cantidad de productos
 * 2. Editar
 * 3. Listarlos
 *  - Elegir divisa.
 * 4. Estadistica
 *  - Producto mas caro (con y sin descuento)
 *  - Producto mas barato (con y sin descuento)
 *  - Productos en 0
 *  - Producto con mayor cantidad
 *  - Precio total del inventario (sin descuento)
 * 5. Configuraciones
 *  - Valor de la divisa (valor inicial 0)
 * 6. Salir
 * 
 * Consideraciones: Precios, cantidades y descuento no pueden ser negativos.
 */
package evaluacion;

import java.util.Scanner;

// Clase que representa un unico producto
class Product {
	// Son nuestros 3 campos que describen un producto.
	String name;
	double price;
	int amount;
	double discount;

	// Creamos el constructor para generar objetos de tipo Product
	public Product(String name, double price, int amount, double discount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.discount = discount;
	}

	public double computeDiscount(double price, double discount) {
		discount = (discount / 100) * price;
		double total = price - discount;
		return total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double computeDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}

/*
 * Es una clase wrapper por encima de products, para no tener que manipularlo
 * directamente,
 * sino que esta clase es un intermediario.
 */
class ArrayProducts {
	Scanner sc = new Scanner(System.in);
	Product[] array;
	double currencyConfig = 0;
	int size;

	public ArrayProducts(int size) {
		this.array = new Product[size]; // Ahora asignamos el espacio al array de productos
		this.size = size; // Guardamos el size para que sirva un como un lenght
	}

	public void setCurrencyConfig() {
		System.out.print("Cual es el valor de la divisa? \n Respuesta: ");
		currencyConfig = sc.nextDouble();
		while (currencyConfig < 0) {
			System.out.print("El valor de la divisa no puede ser negativo... Ingrese de nuevo: ");
			currencyConfig = sc.nextDouble();
		}
	}

	public void displayProducts() {
		boolean currencyStatus = false;
		boolean bs = false;
		boolean usd = false;
		do {
			System.out.print("Elige la divisa con la que listar los productos:\n 1: Bs\n 2: USD\n Opcion a elegir: ");
			int op = sc.nextInt();
			if (op == 1) {
				bs = true;
			} else if (op == 2) {
				usd = true;
			} else {
				System.out.println("Divisa invalida... Ingresa de nuevo.");
				currencyStatus = true;
			}
		} while (currencyStatus);
		if (size == 0) {
			System.out.println("No hay elementos, por favor primero ingreselos.");
		}
		if (usd) {
			// En vez de hacer el tipico for, me lo ahorro y usamos este sugar syntax
			for (Product p : this.array) {
				System.out.println(
						"Producto: " + p.name + "\n Precio sin descuento: " + p.price + "\n Precio con descuento: "
								+ p.computeDiscount(p.price, p.discount) + "\n Cantidad: " + p.amount);
			}
		}
		if (bs) {
			if (currencyConfig > 0) {
				// En vez de hacer el tipico for, me lo ahorro y usamos este sugar syntax
				for (Product p : this.array) {
					System.out.println(
							"Producto: " + p.name + "\n Precio sin descuento: " + p.price * currencyConfig
									+ "\n Precio con descuento: " + p.computeDiscount(p.price, p.discount) * currencyConfig + "\n Cantidad: "
									+ p.amount);
				}
			} else {
				System.out
						.println("No se ha ingresado la tasa de conversion, Vaya a configuraciones");
			}
		}

	}

	public void addProducts() {
		for (int i = 0; i < this.size; i++) {
			System.out.println("Ingrese los datos del producto: " + (i + 1));
			System.out.print("Ingrese el nombre: ");
			String name = sc.next();
			System.out.print("Ingrese su precio: ");
			double price = sc.nextDouble();
			while (price < 0) {
				System.out.print("No puede ser negativo su precio. Ingreselo de nuevo: ");
				price = sc.nextDouble();
			}
			System.out.print("Ingrese la cantidad: ");
			int amount = sc.nextInt();
			while (amount < 0) {
				System.out.print("No puede ser negativo su cantidad. Ingreselo de nuevo: ");
				amount = sc.nextInt();
			}
			System.out.print("ingrese el descuento: ");
			double discount = sc.nextDouble();
			while (discount < 0 || discount > 20) {
				System.out.print("El descuento no esta disponible. Ingreselo de nuevo: ");
				discount = sc.nextDouble();
			}
			Product product = new Product(name, price, amount, discount);
			this.array[i] = product;
		}
	}

	public void menuEditProducts() {
		System.out.print(
				"Que quieres modificar?\n 1: Nombre\n 2: Precio\n 3: Cantidad\n 4: Descuento\n 5: Todo\n Opcion a elegir: ");
		int op = sc.nextInt();
		System.out.print("Posicion del elemento a modificar: ");
		int prodIndex = sc.nextInt();
		// Hacemos early return si no esta en el rango
		if (prodIndex < 0 || prodIndex > this.size) {
			System.out.print("No puedes acceder a un elemento inexistente en esa posicion: ");
			return;
		}
		boolean menuStatus = false;
		do {
			switch (op) {
				case 1:
					menuStatus = false;
					System.out.print("Ingresa el nuevo nombre del producto: ");
					String newName = sc.next();
					// Chequeamos que su nombre sea valido.
					if (!newName.equals(""))
						this.array[prodIndex].setName(newName);
					break;
				case 2:
					menuStatus = false;
					System.out.print("Ingresa el nuevo precio del producto " + this.array[prodIndex].getName() + ": ");
					double newPrice = sc.nextDouble();
					// Comprobamos que sea positivo
					while (newPrice < 0) {
						System.out.print("No puede ser negativo su precio. Ingreselo de nuevo: ");
						newPrice = sc.nextDouble();
					}
					this.array[prodIndex].setPrice(newPrice);
					break;
				case 3:
					menuStatus = false;
					System.out.print("Ingresa la nueva cantidad del producto " + this.array[prodIndex].getName() + ": ");
					int newAmount = sc.nextInt();
					// Comprobamos que sea positivo
					while (newAmount < 0) {
						System.out.print("No puede ser negativo su cantidad. Ingreselo de nuevo: ");
						newAmount = sc.nextInt();
					}
					this.array[prodIndex].setAmount(newAmount);
					break;
				case 4:
					menuStatus = false;
					System.out.print("Ingresa el nuevo descuento del producto " + this.array[prodIndex].getName() + ": ");
					double newDiscount = sc.nextDouble();
					// Comprobamos que este en el rango de 0 a 20
					while (newDiscount < 0 || newDiscount > 20) {
						System.out.print("El descuento no esta disponible. Ingreselo de nuevo: ");
						newDiscount = sc.nextDouble();
					}
					this.array[prodIndex].setDiscount(newDiscount);
					break;
				case 5:
					menuStatus = false;
					System.out.print("Ingrese el nombre: ");
					String name = sc.next();
					System.out.print("Ingrese su precio: ");
					double price = sc.nextDouble();
					while (price < 0) {
						System.out.print("No puede ser negativo su precio. Ingreselo de nuevo: ");
						price = sc.nextDouble();
					}
					System.out.print("Ingrese la cantidad: ");
					int amount = sc.nextInt();
					while (amount < 0) {
						System.out.print("No puede ser negativo su cantidad. Ingreselo de nuevo: ");
						amount = sc.nextInt();
					}
					System.out.print("ingrese el descuento: ");
					double discount = sc.nextDouble();
					while (discount < 0 || discount > 20) {
						System.out.print("El descuento no esta disponible. Ingreselo de nuevo: ");
						discount = sc.nextDouble();
					}
					Product product = new Product(name, price, amount, discount);
					this.array[prodIndex] = product;
					break;
				default:
					menuStatus = true; // Si la respuesta no es la correcta volvemos a renderizar el menu.
					System.out.println("La opcion ingresada es incorrecta...");
					break;
			}
		} while (menuStatus);
	}

	public Product[] sortProductsByPrice(Product[] productsArray, boolean discount) {
		boolean swap = true;
		if (discount) {
			while (swap) {
				swap = false;
				for (int i = 1; i <= (this.size - 1); i++) {
					Product lastProd = productsArray[i - 1];
					Product cProduct = productsArray[i];
					if (lastProd.computeDiscount(lastProd.price, lastProd.discount) > cProduct.computeDiscount(cProduct.price, cProduct.discount)) {
						Product j = productsArray[i - 1];
						productsArray[i - 1] = productsArray[i];
						productsArray[i] = j;
						swap = true;
					}
				}
			}
		} else {
			while (swap) {
				swap = false;
				for (int i = 1; i <= (this.size - 1); i++) {
					if (productsArray[i - 1].price > productsArray[i].price) {
						Product j = productsArray[i - 1];
						productsArray[i - 1] = productsArray[i];
						productsArray[i] = j;
						swap = true;
					}
				}
			}
		}
		return productsArray;
	}

	public void sortProductsByAmount(Product[] productsArray) {
		// We instanciate a default instance of Product
		Product mostStockedProd = new Product(null, Double.MIN_VALUE, Integer.MIN_VALUE, Double.MIN_VALUE);
		System.out.println("--- Productos en cero ---");
		for (Product prod : productsArray) {
			if (prod.amount > mostStockedProd.amount) {
				mostStockedProd = prod;
			}
			if (prod.amount == 0) {
				System.out.println("Producto en cero: " + prod.name);
			}
		}
		System.out.println("--- Producto con mayor cantidad ---");
		System.out.println("Producto con mayor cantidad: " + mostStockedProd.name + "\n");
	}

	public void displayTotalPriceStock(Product[] productsArray) {
		double sum = 0;
		for (Product prod : productsArray) {
			sum += prod.price;
		}
		System.out.println("--- Precio total del inventario sin descuento ---");
		System.out.println("Precio total del inventario sin descuento: " + sum + "\n");
	}
	public void displayStats() {		
		// Mas caro y mas economico sin descuento:
		Product[] sortedProductsWithoutDiscount = sortProductsByPrice(this.array, false);
		System.out.println("--- Mas costoso y mas economico sin descuento ---");
		System.out.println("Producto mas economico es: " + sortedProductsWithoutDiscount[0].name);
		System.out.println("Producto mas costoso es: " + sortedProductsWithoutDiscount[this.size - 1].name + "\n");

		// Mas caro y mas economico con descuento
		System.out.println("--- Mas costoso y mas economico con descuento ---");
		Product[] sortedProductsWithDiscount = sortProductsByPrice(this.array, false);
		System.out.println("Producto mas economico es: " + sortedProductsWithDiscount[0].name);
		System.out.println("Producto mas costoso es: " + sortedProductsWithDiscount[this.size - 1].name + "\n");
		
		// Que producto esta en cero y cual no
		sortProductsByAmount(sortedProductsWithoutDiscount);

		// Precio total del inventario
		displayTotalPriceStock(sortedProductsWithDiscount);

	}
}

public class App {

	private static int displayMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print(
				"Ingrese alguna opcion: \n1: Agregar X cantidad de productos. \n2: Editar productos. \n3: Listar productos \n4: Estadisticas \n5: Configuraciones \n6: Salir\n Opcion a elegir: ");

		return sc.nextInt();
	}

	private static void menuDispatcher() {
		Scanner sc = new Scanner(System.in);
		// Esta variable decide el estado de la ejecucion del programa: Si es cerrado o
		// no
		boolean executionStatus = true;
		// Creamos el arr
		ArrayProducts products = new ArrayProducts(0);

		while (executionStatus) {
			int op = displayMainMenu();
			switch (op) {
				case 1:
					System.out.print("Ingrese la cantidad de productos: ");
					products = new ArrayProducts(sc.nextInt());
					products.addProducts();
					break;

				case 2:
					products.menuEditProducts();
					break;

				case 3:
					products.displayProducts();
					break;

				case 4:
					products.displayStats();
					break;

				case 5:
					products.setCurrencyConfig();
					break;

				case 6:
					System.out.println("Cerrando...");
					executionStatus = !executionStatus; // Cuando se quiera salir, solo se cambia a false;
					break;

				default:
					System.out.println("Opcion incorrecta, por favor ingrese una opcion correcta.");

			}
		}
	}

	public static void main(String[] args) {
		menuDispatcher();
	}

}
