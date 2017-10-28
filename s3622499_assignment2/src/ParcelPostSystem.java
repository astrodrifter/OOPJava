import java.util.Scanner;

public class ParcelPostSystem
{
   // create a Scanner
   private static Scanner sc = new Scanner(System.in);

   // declare Parcel array and parcel count variable
   private static Parcel[] parcels = new Parcel[10];
   private static int parcelCount = 0;

   public static void main(String[] args)
   {

      String selection;

      do
      {

         // display menu options
         System.out.println("   ***** Parcel Post System Menu *****");
         System.out.println("A. Add New Parcel");
         System.out.println("B. Display All Parcels");
         System.out.println("C. View Delivery Details");
         System.out.println("D. Select Satchel");
         System.out.println("E. Update Tracking History");
         System.out.println("F. Complete Delivery");
         System.out.println("X. Exit the program");
         System.out.println();

         // prompt user to enter selection
         System.out.print("Enter selection: ");
         selection = sc.nextLine();

         System.out.println();

         // validate selection input length
         if (selection.length() != 1)
         {
            System.out.println("Error - invalid selection!");
         }
         else
         {

            // process user's selection
            switch (selection.toUpperCase())
            {
               case "A":
                  addNewParcel();
                  break;

               case "B":
                  displayAllParcels();
                  break;

               case "C":
                  viewDeliveryDetails();
                  break;

               case "D":
                  selectSatchel();
                  break;

               case "E":
                  updateTrackingHistory();
                  break;

               case "F":
                  completeDelivery();
                  break;

               case "X":
                  System.out.println("Exiting the program...");
                  break;

               default:
                  System.out.println("Error - invalid selection!");
            }
         }
         System.out.println();

      } while (!selection.equalsIgnoreCase("X"));
   }

   private static void addNewParcel()
   {
	  String parcelID, senderName, senderAddress;
	  String recieverName, recieverAddress, contactNumber;
      System.out.println("Add New Parcel Feature");
      System.out.println();
      
      // code for Stage 2 Requirement A) should go in here
      
      // get parcel details
      System.out.println("Enter Parcel ID:");
      parcelID = sc.nextLine();
      System.out.println("Sender Name:");
      senderName = sc.nextLine();
      System.out.println("Sender Address:");
      senderAddress = sc.nextLine();
      System.out.println("Reciever Name:");
      recieverName = sc.nextLine();
      System.out.println("Reciever Address:");
      recieverAddress = sc.nextLine();
      System.out.println("Contact Number:");
      contactNumber = sc.nextLine();
      System.out.println("Then press enter key.");
      
      //store parcel details in parcel object array
      parcels[parcelCount] = new Parcel(parcelID, senderName, senderAddress, 
    		  recieverName, recieverAddress, contactNumber);
      parcelCount++;
      
   }

   private static void displayAllParcels()
   {
      System.out.println("Display All Parcels Feature");
      System.out.println();

      // code for Stage 2 Requirement B) should go in here
      // print all entries in parcel object array
      for(int i = 0; i < parcelCount; i++) {
    	  	parcels[i].printDetails();
      }
   }

   private static void viewDeliveryDetails()
   {
      System.out.println("Viewing Delivery Details Feature");
      System.out.println();

      // code for Stage 2 Requirement C) should go in here
      
      // find and print parcel delivery details
      String parcelNum;
      System.out.println("Enter parcel ID");
      parcelNum = sc.nextLine();
      // find parcel in system
      for(int i = 0; i < parcelCount; i++) {
    	  	if(parcels[i].getParcelNumber().equals(parcelNum)) {
    	  		System.out.println("Parcel Number "+ parcelNum + " Will be delivered to "+ 
    	  		      parcels[i].getRecipientName()+ " at "+parcels[i].getDeliveryAddress());
    	  	} else {
    	  		System.out.println("Parcel cannot be found by that Parcel Number!");
    	  	}
      }
      
   
   }

   private static void selectSatchel()
   {
      System.out.println("Select Satchel Feature");
      System.out.println();

      // code for Stage 2 Requirement D) should go in here
      
      // locate parcel, check if already assigned, check parcel dimension, assign satchel
      String parcelNum;
      int position = 0;
      
      // find parcel in system
      boolean found = false;
    	  System.out.println("Enter parcel ID");
    	  parcelNum = sc.nextLine();
    	  for(int i = 0; i < parcelCount; i++) {
        	if(parcels[i].getParcelNumber().equals(parcelNum)) {
        		position = i;
        		found = true;
        		// get length and width
        		int length, width, result;
      	    System.out.println("Eneter item length:");
      	    length = sc.nextInt();
      	    System.out.println("Eneter item width:");
      	    width = sc.nextInt();
      	    // send to selectSatchel with length and width
      	    result = parcels[position].selectSatchel(length, width);
      	    // check result
      	    if(result == -1) {
      	    		System.out.println("A satchel size has already been selected for the parcel.\n");
      	    } else if(result == 0) {
      	    		System.out.println("The parcel dimensions are too large to deliver in a satchel.\n");
      	    } else {
      	    		// if all good print cost
      	    		System.out.println("Postage cost = $" + result); 
      	    }
        	}
    	  }
    	// if parcel was not found 
    	  if(!found) {
    		  System.out.println("Parcel cannot be found by that Parcel Number!\n");
  	  		return;
    	  }
    	  
   }

   private static void updateTrackingHistory()
   {
      System.out.println("Update Tracking History Feature");
      System.out.println();

      // code for Stage 2 Requirement E) should go in here
      
      // find parcel
      String parcelNum;
      int position = 0;
      boolean found = false;
      System.out.println("Enter parcel ID");
      parcelNum = sc.nextLine();
      // find parcel in system
      for(int i = 0; i < parcelCount; i++) {
    	  	if(parcels[i].getParcelNumber().equals(parcelNum)) {
    	  		position = i;
    	  		found = true;
    	  	} 
      }
   // if parcel was not found 
      if(!found) {
		  System.out.println("Parcel cannot be found by that Parcel Number!\n");
	  		return;
	  }
      // add tracking details
      String dateTime, location;
      boolean status;
      System.out.println("Enter date/time:");
      dateTime = sc.nextLine();
      System.out.println("Location of parcel:");
      location = sc.nextLine();
      status = parcels[position].updateTrackingHistory(dateTime,location);
      
      if(status) {
    	  	System.out.println("Parcel number "+parcelNum+"Tracking History updated.\n");
      } else {
    	  	System.out.println("Parcel number "+parcelNum+"Cannot update the tracking history for this parcel.\n");
      }
   }

   private static void completeDelivery()
   {
      System.out.println("Complete Delivery Feature");
      System.out.println();

      // code for Stage 2 Requirement F) should go in here
      
      // find parcel
      String parcelNum;
      int position = 0;
      boolean found = false;
      System.out.println("Enter parcel ID");
      parcelNum = sc.nextLine();
      // find parcel in system
      for(int i = 0; i < parcelCount; i++) {
    	  	if(parcels[i].getParcelNumber().equals(parcelNum)) {
    	  		position = i;
    	  		found = true;
    	  	}
      }
      // if parcel was not found 
      if(!found) {
		  System.out.println("Parcel cannot be found by that Parcel Number!\n");
	  		return;
	  }
      // add delivery details
      String dateTime, signee;
      boolean status;
      System.out.println("Enter date/time:");
      dateTime = sc.nextLine();
      System.out.println("Name of signee:");
      signee = sc.nextLine();
      status = parcels[position].completeDelivery(dateTime,signee);
      
      if(status) {
  	  	System.out.println("Parcel number "+parcelNum+", Delivery Complete.\n");
    } else {
  	  	System.out.println("Parcel number "+parcelNum+", delivery cannot be completed for this parcel.\n");
    }

   }

}
