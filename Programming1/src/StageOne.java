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
		System.out.println("Enter Customer Title:");
		title = keyboard.readLine();
		System.out.println("Enter Customer Name:");
		name = keyboard.readLine();
		System.out.println("Enter Customer Email Address:");
		email = keyboard.readLine();
		System.out.println("Enter Customer Mobile Phone No:");
		mobile = keyboard.readLine();
		System.out.println("Enter Home Address:");
		address = keyboard.readLine();
		
		// get vehicle details
		String state, licPlateNo, makeModel; 
		
		System.out.println("Enter Registration State:");
		state = keyboard.readLine();
		System.out.println("Enter Licence Plate Number:");
		licPlateNo = keyboard.readLine();
		System.out.println("Enter Make / Model Of Vehicle:");
		makeModel = keyboard.readLine();
		
		// get credit card details
		String creditNo, expiryDate, ccvString;
		int ccv;
		System.out.println("Enter Credit Card No:");
		creditNo = keyboard.readLine();
		System.out.println("Enter Expiry Date:");
		expiryDate = keyboard.readLine();
		System.out.println("Enter ccv:");
		ccvString = keyboard.readLine();
		ccv = Integer.parseInt(ccvString);
		
		
		// Get number of toll sectors passed and calculate fee
		String sectorsString;
		int sectors;
		double fee;
		System.out.println("How many toll sectors did you pass?");
		sectorsString = keyboard.readLine();
		sectors = Integer.parseInt(sectorsString);
		fee = sectors*2.50;
		
		//	print details
		System.out.printf("Customer Details:\n\n");
		System.out.printf("Name: %50s %s\n",title,name);
		System.out.printf("Email Address: %43s\n",email);
		System.out.printf("Mobile Phone Number: %37s\n",mobile);
		System.out.printf("Home Address: %44s\n",address);
		System.out.printf("\nVehicle Details:\n\n");
		System.out.printf("Registration State: %38s\n",state);
		System.out.printf("Licence Plate Number: %36s\n",licPlateNo);
		System.out.printf("Make / Model: %44s\n",makeModel);
		System.out.printf("\nCard Details:\n\n");
		System.out.printf("Credit Card No: %42s\n",creditNo);
		System.out.printf("Expiry Date: %45s\n",expiryDate);
		System.out.printf("Security Code: %43d\n",ccv);
		System.out.printf("Toll fee is:     \t\t$%d.2f\n",fee);
	}

}
