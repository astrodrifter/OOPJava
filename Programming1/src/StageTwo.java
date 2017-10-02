/* This program is stage one of a toll program
 * 
 * Dhruva OShea 14/09/17
 * 
 */
import java.io.*;
public class StageTwo {

	public static void main(String[] args) throws IOException{
		
		//open buffer reader
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		// get customer details
		String title, name, email, mobile, address;
		System.out.print("Enter Customer Title: ");
		title = keyboard.readLine();
		System.out.print("Enter Customer Name: ");
		name = keyboard.readLine();
		System.out.print("Enter Customer Email Address: ");
		email = keyboard.readLine();
		System.out.print("Enter Customer Mobile Phone No: ");
		mobile = keyboard.readLine();
		System.out.print("Enter Home Address: ");
		address = keyboard.readLine();
		System.out.println();
		
		// get vehicle details
		String state, licPlateNo, makeModel; 
		System.out.print("Enter Registration State: ");
		state = keyboard.readLine();
		System.out.print("Enter Licence Plate Number: ");
		licPlateNo = keyboard.readLine();
		System.out.print("Enter Make / Model Of Vehicle:");
		makeModel = keyboard.readLine();
		System.out.println();
		
		// get credit card details
		String creditNo, expiryDate, ccvString;
		int ccv;
		System.out.print("Enter Credit Card No:");
		creditNo = keyboard.readLine();
		System.out.print("Enter Expiry Date:");
		expiryDate = keyboard.readLine();
		System.out.print("Enter Security Code:");
		ccvString = keyboard.readLine();
		ccv = Integer.parseInt(ccvString);
		System.out.println();
		
		/* Get The number of sectors the vehicle has traveled */
		/* The toll period for the trip (eg. peak, off-peak, evening) 
		   for heavy commercial vehicles */
		/* breakdown? */
		
		// Get sectors Traveled
		String sectorsString;
		int sectors;
		System.out.print("Enter Sectors Travelled: ");
		sectorsString = keyboard.readLine();
		sectors = Integer.parseInt(sectorsString);
		System.out.println();
		
		// get vehicle type
		String vehicleType;
		System.out.print("Enter Vehicle Type (M, C, LCV, HCV): ");
		vehicleType = keyboard.readLine();
		// if HCV we need trip time.
		/*if(vehicleType == "HCV") {
			String tripTime;
			System.out.print("Enter Trip Time (Peak, Off-Peak or Night): ");
			tripTime = keyboard.readLine();
		}*/
		
		/* calculate fee by  checking which vehicle type was entered and 
		 * match it to vehicle type rate. If vehicle type is "HCV" extra 
		 * step is initiated to get period and rate is changed accordingly 
		 */
		double fee, rate;
		String tripTime = null;
		if(vehicleType == "M") {
			rate = 1.40;
			System.out.println("\nentered M rate\n ");
		} else if(vehicleType == "C") {
			rate = 2.40;
			System.out.println("\nentered C rate\n ");
		} else if(vehicleType == "LCV") {
			rate = 3.80;
			System.out.println("\nentered LCV rate\n ");
		} else if(vehicleType == "HCV") {
			rate = 7.20;
			System.out.print("Enter Trip Time (Peak, Off-Peak or Night): ");
			tripTime = keyboard.readLine();
			if(tripTime == "Peak") {
				rate = rate*1.4;
			} else if(tripTime == "Night") {
				rate = rate*0.7;
			}
		} else {
			System.out.println("\n\nThere was a problem entering vehicle type:\n");
		}
		fee = sectors*rate;
		
		/*	Print Invoice Details to Console */
		// Customer Details
		System.out.println("\nCustomer Details:\n");
		System.out.printf("Name: %50s %s\n",title,name);
		System.out.printf("Email Address: %43s\n",email);
		System.out.printf("Mobile Phone Number: %37s\n",mobile);
		System.out.printf("Home Address: %44s\n",address);
		// Vehicle Details
		System.out.println("\nVehicle Details:\n");
		System.out.printf("Registration State: %38s\n",state);
		System.out.printf("Licence Plate Number: %36s\n",licPlateNo);
		System.out.printf("Make / Model: %44s\n",makeModel);
		System.out.printf("Vehicle Type: %44s\n",vehicleType);
		// Credit Card Details
		System.out.printf("\nCard Details:\n\n");
		System.out.printf("Credit Card No: %42s\n",creditNo);
		System.out.printf("Expiry Date: %45s\n",expiryDate);
		System.out.printf("Security Code: %43d\n",ccv);
		// Trip Details
		System.out.println("\nTrip Details:\n");
		System.out.printf("Sectors travelled: %44s\n",sectors);
		System.out.printf("Sector Rate: \t\t$%.2f",rate);
		if(vehicleType == "HCV") {
			System.out.printf("Trip Time: %44s\n",tripTime);
			System.out.printf("Adjusted Sector Rate: \t\t$%d.2f",rate);
		}
		// Toll Fee
		System.out.printf("Toll Invoice Total:     \t\t$%.2f\n",fee);
	}

}
