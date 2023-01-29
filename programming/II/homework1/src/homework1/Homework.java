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
	static void getGreaterLeastGrade(int[] grades) {
		// Here we sort the array using bubblesort (very slow but easy enough to implement at hand)
		// Harvard CS courses goes vrrrrr
		/*
		 * In BubbleSort we sort an array by the next way:
		 * We start by index = 1 because the array of only 1 element is already sorted
		 * And of course I don't want to face an index out of bound error at runtime
		 * So I'll stick with the loop starting at index = 1
		 * If the element before i is greater than i we swap them
		 * That way I'll be looping through the whole array
		 * And it will end up being sorted in ascending way.
		 * */
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i <= (grades.length - 1); i++) {
				if (grades[i - 1] > grades[i]) {
					int j = grades[i - 1];
					grades[i - 1] = grades[i];
					grades[i] = j;
					swapped = true;
				}
			}
		}
		
		// Now that the array is sorted, we pick the first item for the min and the last for the max
		int min = grades[0];
		int max = grades[grades.length - 1];
		System.out.println("La mayor nota es: " + max + ". La menor nota es: " + min);
		
		americanGrade(min, max);
	}
	
	static void checkDuplicated(int[] grades) {
		/*
		 * As my array is already sorted using Bubblesort
		 * The algorithm used doesn't take care enough to remove duplicated elements
		 * So they'll be stacked all along one after the other
		 * I took kind of advantage to avoid using two loops to "re-order" it, so bye bye to O(n^2)
		 * Anyways I had to loop it so it keeps being O(n) at least linear complexity :D
		 * It checks the actual (i) element against the one before it (i - 1)
		 * If they're the same I'll add 1 to the counter (variable called duplicated)
		 * If they both aren't the same I check if the current counter (duplicated) is greater than the last item duplicated (lastDup)
		 * Note: On the first iteration it will always be greater than the last counter because its zero
		 * But as the we loop through the array we'll ensure that only the most frequent item will remain at lastDup
		 * So the item will be binded to lastCurr too.
		 * Damn I hope it's clear enough.
		 * */
		int lastDup = 1;
		int lastCurr = 0;
		int duplicated = 1;
		int current = 0;
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] == grades[i - 1]) {
				current = grades[i];
				duplicated += 1;
			} else {
				if (duplicated > lastDup) {
					lastDup = duplicated;
					lastCurr = current;
				}
			}
		}
		System.out.println("El numero " + lastCurr + " se repitio: " + lastDup + " veces.");
		
	}
	static double findAverage(int[] grades) {
		/*
		 * Easy as just adding up every grade and dividing against its length
		 * */
		double gradesSum = 0;
		for (int i = 0; i < grades.length; i++) {
			gradesSum += grades[i];
		}
		return gradesSum / grades.length; 
	}
	static int[] requestInput() {
		/*
		 * This function will take care of requesting the grades
		 * And adding it to the array we created before the size of N ( I mean nGrades lol )*/
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingresa la cantidad de notas: ");
		int nGrades = sc.nextInt();
		// An array of grades
		int[] grades = new int[nGrades];
		
		// We request each grade to fulfill the array
		for (int i = 0; i < nGrades; i++) {
			System.out.print("Ingrese la nota número: " + (i + 1) + ": ");
			int grade = sc.nextInt();
			if (grade > 0 && grade <= 20) {
				grades[i] = grade;
			} else {
				i--; // We take back i because the grade is invalid
				System.out.println("Por favor ingresa una nota válida :pppppp");
			}
			
		}
		// We show the grades
		System.out.println("Las notas ingresadas son");
		for (int i = 0; i < nGrades; i++) {
			
			System.out.println(grades[i]);
			
		}
		
		// We execute the corresponding functions
		getGreaterLeastGrade(grades);
		checkDuplicated(grades);
		// Here we find the average (creo que asi se dice promedio xd)
		System.out.println("El promedio es de: " + findAverage(grades));
		return grades;
	}
	static void americanGrade(int greater, int least) {
		int leastAmerican = least / 2;
		int greaterAmerican = greater / 2;
		
		System.out.println("La menor nota en notación Americana es: " + leastAmerican);
		System.out.println("La mayor nota en notación Americana es: " + greaterAmerican);
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
