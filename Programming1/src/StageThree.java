/* This program is stage three of a toll program 
 * for COSC2135 - Programming 1 Study Period 3, 2017
 * Assignment 1
 * 
 *  Algorithm

 	* 1. Get user details
 	* 
 	* 2. Prompt user with menu
	* 		if user entry is trip 
	* 				get details
	* 				if vehicle is was HCV 
	* 					get time
	* 					calculate fee
	* 				add to list
	* 
	* 		if user entry is breakdown
	* 				get details
	* 				add to list
	* 
	*    Print  total invoice to console
	* 
 * 
 * By Dhruva OShea 04/10/17  student # s3622499 OUA RMIT
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
		
		// get vehicle type if HCV we need trip time.
		String vehicleType;
		System.out.print("Enter Vehicle Type (M, C, LCV, HCV): "); 
		vehicleType = keyboard.readLine();
		 
		/* Menu work is done here with "while" loop. User is prompted. 
		 * Entry is used in a switch to either; add to trip list, 
		 * add to breakdown list or to exit menu.
		 */
		// variables
		Boolean Exit = true;
		String  selection, selectionToUpper, date = null, time = "-", tripTime = null; 
		String breakdownDate = null;
		String tripList = "", breakdownList = "";
		int entryPoint = 0, exitPoint = 0, sectors = 0, temp, breakdownSector = 0;;
		double fee = 0, rate = 0, recoveryCost = 0;
		double tripFeeTotal = 0, breakdownCostTotal = 0, tollInvoiceTotal;
		// Start loop
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
			
				// Add new trip list entry
				case 'A':								                      
					System.out.print("Enter trip date: ");
					date = keyboard.readLine();
					System.out.println();
					
					// check if vehicle was HCV
					if(vehicleType.equals("HCV")) {
						System.out.print("Enter trip time (Peak, Off-Peak or Night): ");
						tripTime = keyboard.readLine();
						time = "- "+tripTime;
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
					fee = sectors*rate;
					//fee = Math.round((temp)*100/100);
					
					// Add to running trip fee total
					tripFeeTotal += fee;
					
					// Update Trip list. This list will print in the end of the program!
					tripList += (time + " " + "Trip on " + date + " from sector " + entryPoint 
							+ " to " + exitPoint + " at rate $" + rate + " (toll charge: $" + fee + ")\n");
					break;
				
				// Add new breakdown list entry	
				case 'B':								
					System.out.print("Enter breakdown incident date: ");
					breakdownDate = keyboard.readLine();
					System.out.print("Enter sector breakdown occured: ");
					breakdownSector = console.nextInt();
					System.out.print("Enter vehicle recovery cost: ");
					
					//recovery cost
					recoveryCost = console.nextDouble();
					recoveryCost = Math.round(recoveryCost*100/100);
					
					// Add to running breakdown cost total
					breakdownCostTotal += recoveryCost;
					
					// Update breakdown list. This list will print in the end of the program!
					breakdownList += ("- Breakdown on " + breakdownDate + " in sector "+ breakdownSector 
							+ " (recovery cost: $"+ recoveryCost +")\n");
					break;
				
				// Exit menu
				case 'X':							
					Exit = false;
					break;
					
				default:	
					System.out.println("There has been a problem with your selection.");// fault message
					break;
					
			}
		}
		
		
		
		
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
		
		// close scanner
		console.close();
		
		// print invoice to console
		System.out.println("\nTrip List: \n");
		System.out.println(tripList);
		System.out.printf("\n(Toll Total charge: $%.2f) \n",tripFeeTotal);
		System.out.println("\nBreakdown List: \n");
		System.out.println(breakdownList);
		System.out.printf("\n(Breakdown charge total: $%.2f) \n",breakdownCostTotal);
		tollInvoiceTotal = tripFeeTotal+breakdownCostTotal;
		System.out.printf("\nToll Invoice Total: \t\t\t\t\t$%.2f\n",tollInvoiceTotal);
		
	}
	
	/* getRate is a function that takes vehicleType and tripTime as inputs to calculate and returns rate */
	public static double getRate(String vehicleType, String tripTime){
		System.out.println("eneter function\n");
		double rate;
		if(vehicleType.equals("HCV")) {  // for HCV vehicle type
			if(tripTime.equals("Peak")) {
				rate = 7.20*1.40;
			} else if(tripTime.equals("Night")) {
				rate = 7.20*0.70;
			} else {
				rate = 7.20;
			}
		} else if(vehicleType.equals("M")) {  // for M vehicle type
			rate = 1.40;
		} else if(vehicleType.equals("C")) { // for C vehicle type
			rate = 2.40;
		} else if(vehicleType.equals("LCV")) { // for LCV vehicle type
			rate = 3.80;
		} else {					// for fault entry
			rate = 0.00;
			System.out.println("\n\nThere was a problem entering vehicle type:\n");
		}
		return rate;
	}

}
