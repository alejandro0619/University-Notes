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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
// Clase wrapper que representa un array de productos
// Idealmente todo lo que tenga que ver con manipular la coleccion de productos
// Se hara por este clase con sus respectivos metodos.
class ArrayProducts {
	Scanner sc = new Scanner(System.in);
	Product[] array;
	int size;
	public ArrayProducts(int size) {
		this.array =  new Product[size]; // Ahora asignamos el espacio al array de productos
		this.size =  size; // Guardamos el size para que sirva un como un lenght
	}
	public void displayProducts() {
		// En vez de hacer el tipico for, me lo ahorro y usamos este sugar syntax
			if ( size == 0) {
				System.out.println("No hay elementos, por favor primero ingreselos.");

			} else {
				for (Product p : this.array) {
					System.out.println(
					"Producto: " + p.name + " precio: " + p.price + " cantidad: " + p.amount);
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
	System.out.print("Que quieres modificar?\n 1: Nombre\n 2: Precio\n 3: Cantidad\n 4: Descuento\n 5: Todo\n Opcion a elegir: ");
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

}
public class App {
	
	private static int displayMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print(
			"Ingrese alguna opcion: \n1: Agregar X cantidad de productos. \n2: Editar productos. \n3: Listar productos \n4: Estadisticas \n5: Configuraciones \n6: Salir\n Opcion a elegir: "
			);
			
		return sc.nextInt();
	}
	private static void menuDispatcher() {
		Scanner sc =  new Scanner(System.in);
		// Esta variable decide el estado de la ejecucion del programa: Si es cerrado o no
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
					System.out.println("Lol opcion 4");
					break;

				case 5: 
					System.out.println("Lol opcion 5");
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
