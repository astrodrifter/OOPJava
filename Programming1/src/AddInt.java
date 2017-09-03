/* This program takes two integers from the keyboard,
 * adds them and prints the sum to console.
 * 
 * Dhruva O'Shea 02/09/17
 */
import java.io.*;
public class AddInt {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String first, second;
		int firstNum, secondNum, sum;
		
		System.out.print("Input an integer numer: ");
		first = stdin.readLine();
		firstNum = Integer.parseInt(first);
		
		System.out.print("Input another integer numer: ");
		second = stdin.readLine();
		secondNum = Integer.parseInt(second);
		
		sum = firstNum+secondNum;
		System.out.println("The sum is: " + sum);
		
	}

}
