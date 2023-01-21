package secondEcGrade;
import java.util.Scanner;

public class SecondGradeEc {

	public static void main(String[] args) {
		// We declare our scanner to read from the input.
		Scanner sc = new Scanner(System.in);
		// Here we declare our variables (results and initial variables).
		double a = 0;
		double b = 0;
		double c = 0;
		double resultOne = 0;
		double resultTwo = 0;
		
		// We request data (Our variables to work with).
		System.out.print("Please enter the variable a, b and c in that order separated by a single space. ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		// Sub-radical operations:
		double bSquared = Math.pow(b, 2); // Or just b * b;
		double subradicalOps = bSquared - (4 * a * c);
		double rootOps = Math.sqrt(subradicalOps);
		
		// Numerator operations:
		double numeratorOne = (-1 * b) + rootOps;
		double numeratorTwo = (-1 * b) - rootOps;
		
		// Denominator operations:
		double denominator = 2 * a;
		
		// We divide and get the result:
		resultOne = numeratorOne / denominator;
		resultTwo = numeratorTwo / denominator;
		
		// We print out the result:
		System.out.println("First result is: " + resultOne);
		System.out.println("Second result is: " + resultTwo);
	}

}
