/* This program is to demonstrate using Scanner to get input
 * 
 * Dhruva O'Shea 04/09/2017
 */

import java.io.*;
import java.util.Scanner;
public class UsingScanner {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		int num1 = console.nextInt();
		System.out.print("You entered ");
		System.out.println(num1);
		
		System.out.print("Enter an string: ");
		String str1 = console.nextLine();
		System.out.print("You entered ");
		System.out.println(str1);

	}

}
