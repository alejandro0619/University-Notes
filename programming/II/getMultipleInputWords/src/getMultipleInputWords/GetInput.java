package getMultipleInputWords;
import java.util.Scanner;

public class GetInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Administrator account
		String adminAcc = "Admin";
		String adminPwd = "123";
		
		// We read the input:
		System.out.print("Enter the user and the password separated by a space: ");
		String input = sc.nextLine();
		
		// We split it off 
		String[] inputDetails = input.split(" ");
		
		
		if( inputDetails[0].equals(adminAcc) && inputDetails[1].equals(adminPwd)) {
			System.out.println("Welcome admin");
		} else {
			System.out.println("User or password incorrect");
		}
		
	}

}
