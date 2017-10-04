/* This program is stage three of a toll program
 * 
 * Dhruva OShea 04/10/17
 * 
 */
import java.io.*;
import java.util.Scanner;
public class StageThree {

	public static void main(String[] args) throws IOException{
		
		//open buffer reader
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		// open scanner
		Scanner console = new Scanner(System.in);
				
		/*
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
		*/
		// get vehicle type if HCV we need trip time.
		String vehicleType;
		System.out.print("Enter Vehicle Type (M, C, LCV, HCV): "); 
		vehicleType = keyboard.readLine();
		
		
		
		
		/* New code to make multiple list entries 
		 * 
		 * Algorithm
		 * 
		 * Prompt user with menu
		 * 		if user entry is trip 
		 * 				get details
		 * 				if vehicle is was HCV 
		 * 					get time
		 * 				add to list
		 * 
		 * 		if user entry is breakdown
		 * 				get details
		 * 				add to list
		 * 
		 * Print
		 * 
		 * */
		
		
		
		/* A loop menu driven entry
		 * 
		 * 	Toll Road Data Entry Menu
			--------------------------------------------
			A - Record Trip
			B - Record Breakdown Incident 
			X - Exit
			Enter your selection: A 
			Enter trip date: 11/09/2017 
			Enter entry point: 5
			Enter exit point: 1
		 */
		 
		
		Boolean Exit = true;
		String  selection, selectionToUpper, date = null, tripTime = "-"; 
		String breakdownDate = null;
		String tripList = "- ", breakdownList = "- ";
		int entryPoint = 0, exitPoint = 0, sectors = 0, temp, breakdownSector = 0;;
		double fee = 0, rate = 0, recoveryCost = 0;
		while(Exit){
			tripTime = "- ";
			// display menu
			System.out.println("\nToll Road Data Entry Menu\n--------------------------------------------\n");
			System.out.println("A - Record Trip\nB - Record Breakdown Incident\nX - Exit\n");
			System.out.print("Enter your selection: ");
			System.out.println();
			// get user selection
			selection = keyboard.readLine();
			selectionToUpper = selection.toUpperCase();
			char selec = selectionToUpper.charAt(0);
			switch (selec) {
			
				case 'A':								// make new entry
					System.out.print("Enter trip date: ");
					date = keyboard.readLine();
					System.out.println();
					// check if vehicle was HCV
					if(vehicleType.equals("HCV")) {
						System.out.print("Enter trip time (Peak, Off-Peak or Night): ");
						tripTime = keyboard.readLine();
						tripTime = "- "+tripTime;
					}
					// Get entry and exit points
					System.out.print("Enter entry point: ");
					entryPoint = console.nextInt();
					System.out.print("Enter exit point: ");
					exitPoint = console.nextInt();
					// calculate sectors
					temp = exitPoint-entryPoint;
					sectors = Math.abs(temp);
					// get rate and calculate fee
					rate = getRate(vehicleType, tripTime); // takes vehicle type and trip time. returns rate
					fee = Math.round((sectors*rate)*100.00/100.00);
					break;
					
				case 'B':								// breakdown entry
					// breakdown code
					System.out.print("Enter breakdown incident date: ");
					breakdownDate = keyboard.readLine();
					System.out.print("Enter sector breakdown occured: ");
					breakdownSector = console.nextInt();
					System.out.print("Enter vehicle recovery cost: ");
					recoveryCost = console.nextDouble();
					recoveryCost = Math.round(recoveryCost*100.00/100.00);
					break;
					
				case 'X':								// exit menu
					Exit = false;
					break;
					
				default:	
					System.out.println("There has been a problem with your selection.");// fault message
					break;
					
			}
			// Trip list
			tripList += (tripTime + " " + "Trip on " + date + " from sector " + entryPoint 
					+ " to " + exitPoint + " at rate $" + rate + " (toll charge: $" + fee + ")\n");
			
			breakdownList += ("- Breakdown on " + breakdownDate + " in sector "+ breakdownSector 
					+ " (recovery cost: $"+ recoveryCost +")\n");
			
		}
		
		 /* Toll charge List needs to display 
		 * Time (if HCV)
		 * Date
		 * sector (from to)
		 * rate
		 * toll charge: (in brackets)
		 * Toll charge total: in brackets)
		 * 
		 * Breakdown charge list needs to display 
		 * date
		 * sector
		 * recovery cost: (in brackets)
		 * Breakdown total charge: (in Brackets)
		 * 
		 * Toll Invoice Total: (finally)
		 */
		
		
		/*	Print Invoice Details to Console */
		// Customer Details
		/*
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
		*/
		
		/* new list printing code here */
		
		/*
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
		*/
		console.close();
		System.out.println("\nTrip List: \n");
		System.out.println(tripList);
		System.out.println("\nBreakdown List: \n");
		System.out.println(breakdownList);
	}
	
	/* getRate is a function that takes vehicleType and tripTime as inputs to calculate and returns rate */
	public static double getRate(String vehicleType, String tripTime){
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
		return rate;
	}

}
