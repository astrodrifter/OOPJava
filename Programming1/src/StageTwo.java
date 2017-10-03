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
		System.out.print("Enter Make / Model Of Vehicle: ");
		makeModel = keyboard.readLine();
		System.out.println();
		
		// get credit card details
		String creditNo, expiryDate, ccvString;
		int ccv;
		System.out.print("Enter Credit Card No: ");
		creditNo = keyboard.readLine();
		System.out.print("Enter Expiry Date: ");
		expiryDate = keyboard.readLine();
		System.out.print("Enter Security Code: ");
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
		String vehicleType, tripTime = null;
		System.out.print("Enter Vehicle Type (M, C, LCV, HCV): ");
		vehicleType = keyboard.readLine();
		// if HCV we need trip time.
		if(vehicleType.equals("HCV")) {
			System.out.print("Enter Trip Time (Peak, Off-Peak or Night): ");
			tripTime = keyboard.readLine();
		}
		
		/* calculate fee by  checking which vehicle type was entered and 
		 * match it to vehicle type rate. If vehicle type is "HCV" extra 
		 * step is initiated to get period and rate is changed accordingly 
		 */
		
		double fee, rate;
		rate = getRate(vehicleType, tripTime);
		fee = sectors*rate;
		
		/*	Print Invoice Details to Console */
		// Customer Details
		name = title + " " + name;
		System.out.println("\nCustomer Details:\n");
		//System.out.printf("Name: %41s %s\n",title,name);
		System.out.printf("Name: %54sm\n",name);
		System.out.printf("Email Address: %46s\n",email);
		System.out.printf("Mobile Phone Number: %40s\n",mobile);
		System.out.printf("Home Address: %47s\n",address);
		// Vehicle Details
		System.out.println("\nVehicle Details:\n");
		System.out.printf("Registration State: %41s\n",state);
		System.out.printf("Licence Plate Number: %39s\n",licPlateNo);
		System.out.printf("Make / Model: %47s\n",makeModel);
		System.out.printf("Vehicle Type: %47s\n",vehicleType);
		// Credit Card Details
		System.out.printf("\nCard Details:\n\n");
		System.out.printf("Credit Card No: %45s\n",creditNo);
		System.out.printf("Expiry Date: %48s\n",expiryDate);
		System.out.printf("Security Code: %46d\n",ccv);
		// Trip Details
		System.out.println("\nTrip Details:\n");
		System.out.printf("Sectors travelled: %42s\n",sectors);
		System.out.printf("Sector Rate: \t\t\t\t\t\t$%.2f",rate);
		if(vehicleType.equals("HCV")) {
			System.out.printf("\nTrip Time: %50s\n",tripTime);
			System.out.printf("Adjusted Sector Rate: \t\t\t\t\t$%.2f",rate);
		}
		// Toll Fee
		System.out.printf("\nToll Invoice Total:   \t\t\t\t$%.2f\n",fee);
	}
	public static double getRate(String vehicleType, String tripTime){
		System.out.println("entered function");
		double rate;
		if(vehicleType.equals("HCV")) {
			rate = 7.20;
			if(tripTime == "Peak") {
				rate = rate*1.4;
			} else if(tripTime == "Night") {
				rate = rate*0.7;
			} else {
				rate = rate*1;
			}
		} else if(vehicleType.equals("M")) {
			rate = 1.40;
			System.out.println("\nentered M rate\n ");
		} else if(vehicleType.equals("C")) {
			rate = 2.40;
			System.out.println("\nentered C rate\n ");
		} else if(vehicleType.equals("LCV")) {
			rate = 3.80;
			System.out.println("\nentered LCV rate\n ");
		} else {
			rate = 0.0;
			System.out.println("\n\nThere was a problem entering vehicle type:\n");
		}
		System.out.println(rate);
		return rate;
	}

}
