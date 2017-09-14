/* This program is stage one of a toll program
 * 
 * Dhruva OShea 14/09/17
 * 
 */
import java.io.*;
public class StageOne {

	public static void main(String[] args) throws IOException{
		
		//open buffer reader
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		// get customer details
		String title, name, email, mobile, address;
		System.out.println("Enter your title Mr, Mrs, Miss, Dr:");
		title = keyboard.readLine();
		System.out.println("Enter your name in the format First Last:");
		name = keyboard.readLine();
		System.out.println("Enter your email address:");
		email = keyboard.readLine();
		System.out.println("Enter your home address:");
		address = keyboard.readLine();
		
		
		// Get number of toll sectors passed and calculate fee
		String sectorsString;
		int sectors;
		double fee;
		System.out.println("How many toll sectors did you pass?");
		sectorsString = keyboard.readLine();
		sectors = Integer.parseInt(sectorsString);
		fee = sectors*2.50;
		System.out.printf("Name        %s   %s\nEmail           %s\nHome address    %s\n",title,name,email,address);
		System.out.printf("Toll fee is     $%.2f\n",fee);
	}

}
