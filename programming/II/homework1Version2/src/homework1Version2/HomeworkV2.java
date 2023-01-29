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
public class HomeworkV2 {
	static void requestInput() {
		/*
		 * This function will take care of requesting the grades
		 * And adding it to the array we created before the size of N ( I mean nGrades lol )
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingresa la cantidad de notas: ");
		int nGrades = sc.nextInt();
		double maxGrade = Double.MIN_VALUE; // we set the greatest value to the minimum to overwrite it
		double minGrade = Double.MAX_VALUE; // we set the minimum value to the max to overwrite it
		double gradesSum = 0;
		String repeated = ""; // We store the values... we are TECHNICALLY NOT USING ARRAYS C'MOOON :p
		double mostFreqGrade = 0;
		int mostAccRepeated = 1;
		
		for (int i = 1; i <= nGrades; i++) {
			System.out.print("Ingrese la nota número: " + i + ": ");
			double grade = sc.nextDouble();
			if (grade >= 0 && grade <= 20) {
				// Here we pick the greatest value.
				if (grade > maxGrade) {
					maxGrade = grade;
				}
				if (grade < minGrade) {
					minGrade = grade;
				}
				repeated += grade + " ";
				gradesSum += grade;
			} else {
				i--;
				System.out.println("ingresa una nota válida lol");
			}
		}
		//System.out.println("Notas ingresadas: " + repeated);
		
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
		 * This function is responsible to displaying a menu.
		 * As long as the number 2 is not typed it will display the menu
		 * If the user enters the number two, idk, adiooos*/
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
		// Here we display our menu to add student's note.
		displayMenu();

	}

}
