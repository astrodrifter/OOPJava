import java.util.*;

public class OnlineSaleSystem
{
   // shared array used to store ItemSale and BuyItNowSale objects
   private static ItemSale[] sales = new ItemSale[100];
   
   // shared count for number of sale objects currently stored in array
   private static int saleCount = 0;
   
   // shared Scanner that can be accessed from all helper methods in this class
   private static Scanner sc = new Scanner(System.in);

   /* createSampleData()
    * 
    * Helper method which will give you work with when testing the program - you
    * don't need to do anything here.
    */
   
   private static void createSampleData()
   {
      sales[saleCount] = new ItemSale("ITM009", "Extra Large Wooden Dog Kennel",
                                      "New", "AmazingPetSupplies");
      saleCount++;
      
      sales[saleCount] = new ItemSale("ITM005", "Trojan 100L Wheelbarrow",
                                      "Used", "tradie_213");
      saleCount++;

      sales[saleCount] = new ItemSale("ITM102", "Xbox One S 1TB w/ 5 games",
                                      "Used", "gamerkid_97");
      saleCount++;
      
      
      /*
       * The code below will not run until you have completed Stage 3 Requirement B.
       */
      
      /* (remove this line when you are ready to test BuyItNowSale functionality)
     
       
      sales[saleCount] = new BuyItNowSale("BUY013",
                                          "iPhone 7 Plus 128GB Silver 1YR Warranty",
                                          "Manufacturer Refurbished",
                                          "apple_pro_store", 825);
      saleCount++; 
      
      sales[saleCount] = new BuyItNowSale("BUY013", "iPad Pro 10.5\" 256GB Wi-Fi",
                                          "New", "cheap_phone_store", 1100);
      saleCount++;
      
      (remove this line when you are ready to test BuyItNowSale functionality) */

   }

   /*
    * main() method
    * 
    * Contains an implementation of the program menu.
    * 
    *  NOTE:
    *  
    *  You will not need to change anything here unless you implement the bonus 
    *  marks stage file handling functionality. 
    */
   public static void main(String[] args)
   {

      createSampleData();

      String input;
      
      do
      {
         printMenu();

         input = sc.nextLine();

         if (input.length() != 1)
         {
            System.out.println("Error - selection must be a single character!");
         }
         else
         {
            input = input.toUpperCase();
            System.out.println();

            switch (input)
            {
               case "A":
                  addNewItemSale();
                  break;

               case "B":
                  displaySales();
                  break;

               case "C":
                  postMessage();
                  break;

               case "D":
                  recordBid();
                  break;

               case "E":
                  closeSale();
                  break;
                  
               case "F":
                  addNewBuyItNowSale();
                  break;

               case "G":
                  updateAcceptNearestOfferStatus();
                  break;

               case "X":
                  System.out.println("Exiting Program ... Goodbye!");
                  break;

               default:
                  System.out.println("Error, invalid option selected!");
                  System.out.println("Please try Again...");

            }
         }

      } while (!input.equals("X"));
   }

   // helper method to display menu options to the screen
   public static void printMenu()
   {
      System.out
               .printf("\n********** Online Sale System Menu ********** %n%n");
      System.out.printf("A. Add New Item Sale %n");
      System.out.printf("B. Display Sales %n");
      System.out.printf("C. Post Message For Item %n");
      System.out.printf("D. Record Bid %n");
      System.out.printf("E. Close Sale %n");
      System.out.printf("F. Add New Buy It Now Sale %n");
      System.out.printf("G. Update Accept Nearest Offer Status %n");
      System.out.printf("X. Exit Program %n%n");
      System.out.printf("Enter your selection: ");
   }


   // implementation of add new item sale feature
   private static void addNewItemSale()
   {
      System.out.println("Add New Item Sale Feature");
      System.out.println();

      // implement your code for Stage 2 Requirement A) here
      String itemNumber, itemDescription, itemCondition, sellerID;
      // get item details
      System.out.println("Enter new item number:");
      itemNumber = sc.nextLine();
      System.out.println("Enter description for item:");
      itemDescription = sc.nextLine();
      System.out.println("Enter condition for item:");
      itemCondition = sc.nextLine();
      System.out.println("Enter seller name:");
      sellerID = sc.nextLine();
     
      //store item details in sales object array
      sales[saleCount] = new ItemSale(itemNumber, itemDescription, itemCondition, sellerID);
      System.out.println("New sale added for item '"+ sales[saleCount].getItemDescription() + "'!");
      saleCount++;
      
      
   }

   // implementation of the display sales feature
   private static void displaySales()
   {
      System.out.println("Display Sales Feature");
      System.out.println();
      System.out.println("List of all sales in Online Sale System:\n");
      
      // implement your code for Stage 2 Requirement B) here
      for(int i = 0; i < saleCount; i ++) {
    	     sales[i].printDetails();
      }
   }

   // implementation of post message feature
   private static void postMessage()
   {
      System.out.println("Post Message Feature");
      System.out.println();
      
      // implement your code for Stage 2 Requirement C) here
      String id;
      int index;
      System.out.println("Enter item number to post message for: ");
      id = sc.nextLine();
      System.out.println();
      index = findItem(id);
      if(index >= 0) {
    	     String message;
    	     System.out.println("Enter message: ");
    	     message = sc.nextLine();
    	     sales[index].addMessage(message);
    	     System.out.println("\nMessage posted successfully for item "+id);
    	     System.out.println();
      } else {
    	     System.out.println("\nError - item number " +id+ " not found!");
      }
      
   }

   // implementation of record bid feature
   private static void recordBid()
   {
      System.out.println("Record Bid Feature");
      System.out.println();
      
      // implement your code for Stage 2 Requirement D) here
      String id;
      int index;
      
      System.out.print("Enter item number to bid for: ");
      id = sc.nextLine();
      System.out.println();
      index = findItem(id);
      if(index >= 0) {
    	     int bid;
    	     boolean status;
    	     System.out.print("Current bid: $"+sales[index].getHighestBid()+"\n");
    	     System.out.print("Enter new bid: ");
    	     bid = sc.nextInt();
    	     System.out.println();
    	     status = sales[index].recordBid(bid,id);
    	     if(status) {
    	    	    System.out.println("\nBid recorded successfully for item number "+id+".");
         	System.out.println();
    	     } else {
    	    	    System.out.println("\nError - bid could not be recorded for item number "+id+"!");
    	        System.out.println();
    	     }
    	     
      } else {
    	     System.out.println("Error - item number " +id+ " not found!");
      }
      
   }

   // implementation of close sale feature
   private static void closeSale()
   {
      System.out.println("Close Sale Feature");
      System.out.println();
      
      // implement your code for Stage 2 Requirement E) here
      String id;
      int index;
      System.out.print("Enter item number to close sale: ");
      id = sc.nextLine();
      System.out.println();
      index = findItem(id);
      if(index >= 0) {
    	     int bid = 0;
    	     bid = sales[index].closeSale();
    	     if(bid >= 0) {
    	    	    System.out.println("\nSale closed - final sale price: $"+
    	    	    		bid+" item number "+id);
        	    System.out.println();
    	     } else {
    	    	    System.out.println("Error - sale was already closed for item number "+id+"!");
    	     }
    	     
      } else {
    	     System.out.println("\nError - item number " +id+ " not found!");
      }
      
   }
   
   // implementation of add new buy it now sale feature
   private static void addNewBuyItNowSale()
   {
      System.out.println("Add New Buy It Now Sale Feature");
      System.out.println();
      
      // implement your code for Stage 4 Requirement A) here
      String itemNumber, itemDescription, itemCondition, sellerID;
      int buyItNowPrice;
      // get item details
      System.out.println("Enter new item number:");
      itemNumber = sc.nextLine();
      System.out.println("Enter description for item:");
      itemDescription = sc.nextLine();
      System.out.println("Enter condition for item:");
      itemCondition = sc.nextLine();
      System.out.println("Enter seller name:");
      sellerID = sc.nextLine();
      System.out.println("Enter Buy It Now Price:");
      buyItNowPrice = sc.nextInt();
     
      //store item details in sales object array
      sales[saleCount] = new BuyItNowSale(itemNumber, itemDescription, itemCondition, sellerID, buyItNowPrice);
      System.out.println("New sale added for item '"+ sales[saleCount].getItemDescription() + "'!");
      saleCount++;
   }
   
   // implementation of update accept nearest offer status feature
   public static void updateAcceptNearestOfferStatus()
   {
      System.out.println("Update Accept Nearest Offer Status Feature");
      System.out.println();
      
      // implement your code for Stage 4 Requirement B) here
   }
   
   // find item helper method
   public static int findItem(String itemNum) {
      boolean found = false;
	  int i = 0, index = -1;
	  while(!found) {
		  if(sales[i].getItemNumber().equals(itemNum)) {
			  System.out.println(i);
			  index = i;
			  found = true;
		  } 
		  i++;
		  if(!found  && i == saleCount) {
			index = -1;
			return index;
		  }
	  }
	  return index;
   }

}
