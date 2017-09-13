/* This program simulates an atm
 * user is asked how much they want to withdraw
 * check if enough balance in account if yes process 
 * if no reject
 * 
 * Dhruva O'Shea 13/09/17
 * 
 */
import java.io.*;
public class AccountManagment {
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
		String initialBalanceString, withdrawString;
		int initialBalance, withdrawAmount, newBalance;
		System.out.println("Enter your initial balance: ");
		initialBalanceString = stdin.readLine();
		initialBalance = Integer.parseInt(initialBalanceString);
		System.out.println("How much would you like to withdraw");
		withdrawString = stdin.readLine();
		withdrawAmount = Integer.parseInt(withdrawString);
		
		if(initialBalance > withdrawAmount) {
			System.out.println("Your withdrawal can be processed");
			newBalance = initialBalance - withdrawAmount;
			System.out.println("Your new balance is $"+newBalance);
		} else {
			System.out.println("Your withdrawal cannot be processed");
			System.out.println("Your balance remains  $"+initialBalance);
		}
	}
}
