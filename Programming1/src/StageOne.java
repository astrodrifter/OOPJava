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
		System.out.println("Enter your name in the format Firstname Lastname:");
		name = keyboard.readLine();
		System.out.println("Enter your email address:");
		email = keyboard.readLine();
		System.out.println("Enter your home address:");
		address = keyboard.readLine();
		System.out.printf("Name        %s   %s\nEmail           %s\nHome address    %s\n",title,name,email,address);
	}

}
