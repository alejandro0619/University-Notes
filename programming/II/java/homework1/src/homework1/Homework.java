// Alejandro Lopez 30 819 825
// PROGRAMACIÓN II.
// Idk why I'm even commenting in english lol :p
/*
 * Ingrese x cantidad de notas  e indique :
 * 1) nota mayor 
 * 2) nota menor
 * 3) cuál se repite más
 * 4) 1 y 2 Nota americana 0 a 10
 */
package homework1;
import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		displayMenu();

	}	
	static void getGreaterLeastGrade(double[] grades) {
		// Aquí para ordenar usamos el algoritmo BubbleSort (Implementado a mano)
		// Harvard CS courses goes vrrrrr
		/*
		 * En este algortimo ordenamos el arrayd de la siguiente forma:
		 * Comenzamos en el índice 1 porque un array de 0 índices ya está ordenado
		 * ... Y claro, no quiero un error index out of bounds en runtime por hacer i - 1 en el indice 0 jaja
		 * Entonces me quedo con el índice = 1
		 * Si el elemento i es menor al elemento en i - 1, entonces los cambiamos
		 * De tal forma vamos a ordenar todo el array
		 * Y quedará de forma ascendente, así:
		 * [0, 10, 20, 10, 06] 
		 * En la primera pasada verá que 0, 10 están ordenados y los deja quieto
		 * En la segunda pasada verá que 10, 20 están ordenados y de nuevo los deja quieto.
		 * En la tercera pasada 20, 10 está desordenado, ya que 20 es mayor a 10, y los cambia de posición
		 * y nos queda: [0, 10, 10, 20, 06]
		 * En el resto de pasadas se da cuenta que 20 es mayor a 06 y los cambia quedando así: [0, 10, 10, 06, 20]
		 * De esa misma forma se va intercambiando el 06 haciendo: [0, 10, 06, 10, 20] y luego [0, 06, 10, 10, 20]
		 * Y ya está ordenado.
		 * */
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i <= (grades.length - 1); i++) {
				if (grades[i - 1] > grades[i]) {
					double j = grades[i - 1];
					grades[i - 1] = grades[i];
					grades[i] = j;
					swapped = true;
				}
			}
		}
		
		// Ya que el array está ordenado simplemente obtenemos el primer número como el menor y el último como el mayor
		double min = grades[0];
		double max = grades[grades.length - 1];
		System.out.println("La mayor nota es: " + max + ". La menor nota es: " + min);
		
		americanGrade(max, min);
	}
	
	static void checkDuplicated(double[] grades) {
		/*
		 * Ya que mi Array está ordenado con BubbleSort
		 * EL algoritmo no está encargado de eliminar valores repetidos
		 * Así que se apilarán uno detrás del otro
		 * Tomé ventaja de eso, así evitanto que la complejidad computacional de mi programa sea O(n^2) por usar dos bucles anidados
		 * De todas formas tengo que recorrerlo con un bucle pero esta vez tiene complejidad computacional O(n) :P
		 * Comprueba si el actual elemento en i es igual al elemento pasado
		 * En caso de ser los mismos, sumo uno a mi variable acumulador llamada acc
		 * Y la nota entonces será almacenada en mi variable llamada freqGrade
		 * En caso de que mi elemento actual en i no sea igual a mi elemento pasado, es decir, que las notas no sean iguales
		 * tenemos que chequear si mi contador acumulador acc es mayor a la mayor cantidad de veces que se encontró una nota
		 * (Ese valor está en lastFreqGrade)
		 * En caso de que lo sea, entonces habremos encontrado la mayor cantidad de notas repetidas
		 * En caso de que no, simplemente seteamos acc = 1 y seguimos buscando
		 * 
		 * No debería fallar... debería.
		 * */
		double lastFreqGrade = 0;
		int lastAcc = 1;
		int acc = 1;
		double freqGrade = 0;
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] == grades[i - 1]) {
				freqGrade = grades[i];
				acc += 1;
			} else {
				if (lastAcc < acc) {
					lastAcc = acc;
					lastFreqGrade = freqGrade;
					acc = 1;
					
				} 
				acc = 1;
			}
		}
		System.out.println("La nota que se repitio fue: " + lastFreqGrade + " veces: " + lastAcc);
		
	}
	static double findAverage(double[] grades) {
		/*
		 * Tan sencillo como sumando las notas y diviendola entre las cantidades de notas.
		 * */
		double gradesSum = 0;
		for (int i = 0; i < grades.length; i++) {
			gradesSum += grades[i];
		}
		return gradesSum / grades.length; 
	}
	static double[] requestInput() {
		/*
		 * Esta función se encarga de pedir los datos del usuario
		 * Y agregar esos datos a un String, separados por espacios
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingresa la cantidad de notas: ");
		int nGrades = sc.nextInt();
		// EL array de notas
		double[] grades = new double[(int)nGrades];
		
		// Pedimos cada nota para llenar el array
		for (int i = 0; i < nGrades; i++) { // Comprobamos si está en nuestro rango aceptable, es decir, 0 a 20 inclusivo
			System.out.print("Ingrese la nota número: " + (i + 1) + ": ");
			double grade = sc.nextDouble();
			if (grade > 0 && grade <= 20) {
				grades[i] = grade;
			} else {
				i--; // No avanzamos el contador porque no es un número válido
				System.out.println("Por favor ingresa una nota válida :pppppp");
			}
			
		}
		// Mostramos las notas
		System.out.print("Las notas ingresadas son: ");
		String gradesRequested = "";
		for (int i = 0; i < nGrades; i++) {
			
			gradesRequested += (grades[i]) + " ";
			
		}
		System.out.println(gradesRequested);
		
		// Ejecutamos las funciones correpondientes
		getGreaterLeastGrade(grades);
		checkDuplicated(grades);
		// encontramos el promedio: average (creo que asi se dice promedio xd)
		System.out.println("El promedio es de: " + findAverage(grades));
		return grades;
	}
	static void americanGrade(double greater, double least) {
		double leastAmerican = least / 2;
		double greaterAmerican = greater / 2;
		
		System.out.println("La menor nota en notación Americana es: " + leastAmerican);
		System.out.println("La mayor nota en notación Americana es: " + greaterAmerican);
	}
	static void displayMenu() {
		/*
		 * Esta función es responsable de renderizar un menu.
		 * Mientras que el número 2 no sea pulsado, luego de cada procesamiento de notas, volveremos a renderizarlo.
		 * Si el usuario escribe el número dos: adioos!
		 * */
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		do {
			System.out.print("Bienvenido \nOpciones:\n1 = Seguir\n2 = Salir\nOpcion a elegir: ");
			int ans = sc.nextInt();
			if (ans == 1) {
				requestInput();
			} else {
				System.out.println("Adios!");
				op = 2;
			}
		} while(op != 2);
		
	}
	

}
