import java.io.*;
import java.util.Scanner;
public class EqualsCondition extends ConditonalOperator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your name");
		String myString = console.nextLine();
		
		if (myString.equals("Suryani") || myString.equals("Sarasvati")){
			System.out.println("You are my daughter "+myString);
		} else {
			System.out.println("You are not my daughter, "+myString);
		}
	}

}
