/* Write a do loop which will continue to read 
		 * positive integers and sum them until two consecutive 
		 * integers entered are identical. The second identical 
		 * integer should not be included in the sum. 
		 * For example, if the user input 10 20 10 30 30 then the 
		 * final value of sum should be 70 (10 + 20 + 10 + 30).
		 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class doWhile {

	public static void main(String[] args) {
		//open scanner for getting inputs from console
		Scanner console = new Scanner(System.in);
		
		//create array for intputs
		int[] num = new int[10];
		int i = 1, sum = 0;
		System.out.println("Enter an integers: ");
		do {
			num[i-1] = console.nextInt();
			System.out.println(num[i-1]);
			sum += num[i-1];
			System.out.println(sum);
			
		} while(num[i-1] != num[i]);
		System.out.println();
		System.out.println(sum);

	}

}
