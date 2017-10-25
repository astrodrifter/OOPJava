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
      System.out.println("Add New Parcel Feature");
      System.out.println();

      // code for Stage 2 Requirement A) should go in here

      
   }

   private static void displayAllParcels()
   {
      System.out.println("Display All Parcels Feature");
      System.out.println();

      // code for Stage 2 Requirement B) should go in here

   }

   private static void viewDeliveryDetails()
   {
      System.out.println("Viewing Delivery Details Feature");
      System.out.println();

      // code for Stage 2 Requirement C) should go in here

   }

   private static void selectSatchel()
   {
      System.out.println("Select Satchel Feature");
      System.out.println();

      // code for Stage 2 Requirement D) should go in here

   }

   private static void updateTrackingHistory()
   {
      System.out.println("Update Tracking History Feature");
      System.out.println();

      // code for Stage 2 Requirement E) should go in here
   }

   private static void completeDelivery()
   {
      System.out.println("Complete Delivery Feature");
      System.out.println();

      // code for Stage 2 Requirement F) should go in here

   }

}
