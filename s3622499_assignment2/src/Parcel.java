//import java.util.Scanner;

public class Parcel
{
   // implement the different elements of this Parcel class as described in
   // Stage 1 of the specification
	
	//Attributes
	private String parcelNumber;
	private String senderName;
	private String returnAddress;
	private String recipientName;
	private String deliveryAddress;
	private String contactNumber;
	private String satchelSize;
	//private boolean deliveryComplete;
	private String trackingHistory = "";
	
	//Parcel class constructor
	public Parcel(String parcNum, String sendName, String retAddress, 
			String recName, String delivAddress, String contNum) {
			
				parcelNumber = parcNum;
				senderName = sendName;
				returnAddress = retAddress;
				recipientName = recName;
				deliveryAddress = delivAddress;
				contactNumber = contNum;
			}
		
	//Accessors
	public String getParcelNumber()
	   {
	      return  parcelNumber;
	   }
	 public String getRecipientName()
	   {
	      return  recipientName;
	   }
	 public String getDeliveryAddress()
	   {
	      return  deliveryAddress;
	   }
	 public String getContactNumber()
	   {
	      return  contactNumber;
	   }
	 public String getSatchelSize()
	   {
	      return  satchelSize;
	   }
	 
	 // calculate postage 
	 public int calculatePostageCost(String satchelSize) {
		 int postageCost = 0, trackingFee = 5; 
		 //selection statement
		 if(satchelSize.equals("Large")) {
			 postageCost = 17;
		 } else if (satchelSize.equals("Medium")) {
			 postageCost = 13;
		 } else if (satchelSize.equals("Small")) {
			 postageCost = 10;
		 } else {
			 System.out.println("Error with post size");
			 postageCost = 0;
		 }
		 // calculate total
		 postageCost += trackingFee;
		 return postageCost;
	 }
	 // Selects satchel size for parcels 
	 public int selectSatchel(int parcelLength, int parcelWidth) {
		 int selection = 10, lenSize = 0, widSize = 0; 
		 int largeLen = 500, medLen = 400, smlLen = 300;
		 int largeWid = 400, medWid = 300, smlWid = 200;
		 int fee = 0; // returns to method call in ParcelPostSystem
		 
		//check if already satchel size is already set
		 if(satchelSize != null) {
			 selection = -1;
			 return selection;
		 }
		
		 
		 /* This section will determine parcel size needed by first checking
		  * against length and width table then selecting the largest */
		 
		 //check length against maximum lengths in table
		if(parcelLength > largeLen) {
			 return 0;
		 } else if(parcelLength <= largeLen && parcelLength > medLen) {
			 lenSize = 3;
		 } else if(parcelLength <= medLen && parcelLength > smlLen) {
			 lenSize = 2;
		 } else if(parcelLength <= smlLen && parcelLength > 0) {
			 lenSize = 1;
		 } else if(parcelLength <= 0) {
			 System.out.println("Parcel length is in a different dimension!");
			 return 0;
		 }
			 
		//check length against maximum lengths in table
		 if(parcelWidth > largeWid) {
			 return 0;
		 } else if(parcelWidth <= largeWid && parcelWidth > medWid) {
			 widSize = 3;
		 } else if(parcelWidth <= medWid && parcelWidth > smlWid) {
			 widSize = 2;
		 } else if(parcelWidth <= smlWid && parcelWidth > 0) {
			 widSize = 1;
		 } else if(parcelLength <= 0) {
			 return 0;
			 
		 }
		 
		 // check length and width, largest will determine size
		 if(lenSize > widSize) {
			 selection = lenSize;
		 } else if (lenSize < widSize){
			 selection = widSize;
		 } else {
			 selection = lenSize;
		 }
		 
		 // now size has been determined fee can be calculated //
		 if(selection == 1) {
			 satchelSize = "Small";
			 fee = calculatePostageCost(satchelSize);
		 } else if(selection == 2) {
			 satchelSize = "Medium";
			 fee = calculatePostageCost(satchelSize);
		 } else if(selection == 3) {
			 satchelSize ="Large";
			 fee = calculatePostageCost(satchelSize);
		 } else {
			 selection = 0; // parcel too large for satchel
		 }
		 
		 /*if selection is less then 1 it is either 0 or -1
		  * 0 means error in parcel dimension
		  * -1 means satchel size already set  */
		 if (selection < 1) {
			 System.out.println("Section 17");
			 return selection;
		 } else {
			 System.out.println("Section 18");
			 return fee;
		 }
		 
	 }
	 // add tracking history to running tracking history string 
	 public boolean updateTrackingHistory(String datetime, String location) {
		 // add all tracking history entries to a string.
		 trackingHistory += "Date: " + datetime + " Location: " + location + ".\n";
		 return true;
	 }
	 // registers delivery as complete and adds details to tracking history string
	 public boolean completeDelivery(String datetime, String signee) {
		 trackingHistory += "Delivery to " + deliveryAddress + " at " + 
				 datetime + " signed for by " + signee +"\n";
		 return true;
	 }
	 // Print parcel details
	 public void printDetails() {
		 System.out.println("Parcel Number:  "+ parcelNumber);
		 System.out.println("Sender:         "+ senderName);
		 System.out.println("Return Address: "+ returnAddress);
		 System.out.println("Recipient:      "+ recipientName);
		 System.out.println("Contact Number: "+ contactNumber);
		 System.out.println("Satchel Size:   "+ satchelSize);
		 System.out.println("Tracking History:\n" + trackingHistory);
	 }
}
