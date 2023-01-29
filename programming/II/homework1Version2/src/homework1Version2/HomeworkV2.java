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
package homework1Version2;
import java.util.Scanner;
/*
 * DISCLAIMER: Podía no usar Strings, podía resolver directamente sin necesidad de almacenar los datos
 * Pero a lo largo del proceso encontré dos problemas:
 *   1. Chequeo de repeticiones en notas NO consecutivas falla:
 *     Puedo comprobar si mi nota actual es igual a la nota pasada, pero no puedo comprobar si es igual a dos notas pasadas
 *     Por lo tanto no sería una búsqueda minuciosa, es decir, tandas de notas como 10, 12, 10, 10, 20, 20, 20, 10
 *     Arrojarán que 20 es la nota más repetida, si embargo, no lo esb ya que 10 es la nota más repetida.
 *     Entonces caemos en un falso positivo.
 *     */
public class HomeworkV2 {
	static void requestInput() {
		/*
		 * Esta función se encarga de pedir los datos del usuario
		 * Y agregar esos datos a un String, separados por espacios
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingresa la cantidad de notas: ");
		int nGrades = sc.nextInt(); // Solo es la cantidad de datos
		double maxGrade = Double.MIN_VALUE; // Seteamos el valor mínimo posible para un Double, ya que luego lo reescribiremos
						    // Aunque como partimos de donde nuestro mínimo valor aceptable es 0, también lo podemos usar
		
		double minGrade = Double.MAX_VALUE; // Seteamos la variable para el máximo valor posible y sucede lo mismo que arriba
		
		double gradesSum = 0; // La sumatoria de todas las notas se almacena acá
		String repeated = ""; // Guardamos las variables en un String, técnicamente no es un arreglo...(Sí lo es)
		double mostFreqGrade = 0; // La nota que se repite con más frecuencia se almacena acá
		int mostAccRepeated = 1; // Y aquí tenemos un acumulador de cuantas veces esa nota se repite
		
		for (int i = 1; i <= nGrades; i++) {
			System.out.print("Ingrese la nota número: " + i + ": ");
			double grade = sc.nextDouble();
			if (grade >= 0 && grade <= 20) { // Comprobamos si está en nuestro rango aceptable: entre 0 y 20 inclusivo
				// Aquí obtenemos el valor más grande
				if (grade > maxGrade) {
					maxGrade = grade;
				}
				// Aquí obtenemos el valor más pequeño
				if (grade < minGrade) {
					minGrade = grade;
				}
				repeated += grade + " "; // Concatenamos cada nota al String y le agregamos un espacio
				gradesSum += grade; // De una vez obtenemos la sumatoria
			} else {
				i--; // Ya que la nota no es válida, no aumentamos el acumulador, es decir, nuestro índice
				System.out.println("ingresa una nota válida lol");
			}
		}
		//System.out.println("Notas ingresadas: " + repeated);
		/*
		 * repeated.split(" ") devuelve un String[], se encarga de separar el String cada vez que encuentra un espacio
		 * ...El espacio es el delimitador.
		 * repeated.split(" ").length es el tamaño del String[]
		 * ya que en este ejemplo no he ordenado usando BubbleSort ni otro algoritmo, pues String[] no está ordenado
		 * Esta vez si es necesario usar la complejidad computacional O(n^2) ya que estaremos usando doble bucle
		 * La gracia de esto está en que si encontramos una nota repetida:
		 *  1. Aumentamos en 1 nuestro acumulador (accRepeated)
		 *  Por otra parte comprobamos si accRepeated es mayor a mostAccRepeated:
		 *  mostAccRepeated es la variable que almacenará la mayor cantidad de repeticiones encontradas.
		 *  En caso de que sea mayor:
		 *   1. Entonces tenemos que actualizar la variable mostAccRepeated.
		 *   2. Reescribimos nuestra variable mostFreqGrade para almacenar la nota que se ha sido la más repetida.
		 *  En caso de que no sea, significa que esa nota no es la nota que tiene más repeticiones.
		 *  Al final del código tendremos la nota más repetida y la cantidad de veces que se ha repetido.
		 * */
		for (int i = 0; i < repeated.split(" ").length; i++) {
				int accRepeated = 1;
			for (int j = i + 1; j < repeated.split(" ").length; j++) {
				if (repeated.split(" ")[i].equals(repeated.split(" ")[j])) {
					//System.out.println("Se repite: " + repeated.split(" ")[i] + " = " + repeated.split(" ")[j]);
					accRepeated += 1;
				}
				if (accRepeated > mostAccRepeated) {
					mostAccRepeated = accRepeated;
					mostFreqGrade = Double.parseDouble(repeated.split(" ")[i]);
				}
				
			}
		}
		System.out.println("El mayor es: " + maxGrade);
		System.out.println("El menor es: " + minGrade);
		System.out.println("El mas repetido es: " + mostFreqGrade + " estas veces: " + mostAccRepeated);
		System.out.println("La mayor nota en notación americana es: " + maxGrade/2);
		System.out.println("La menor nota en notación americana es: " + minGrade/2);
		System.out.println("Su promedio es: " + gradesSum/nGrades);
		
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
	public static void main(String[] args) {
		// Ejecutamos la funcion para mostrar el menú.
		displayMenu();

	}

}
