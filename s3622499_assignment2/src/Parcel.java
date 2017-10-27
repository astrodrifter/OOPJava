//import java.util.Scanner;

public class Parcel
{
   // implement the different elements of this Parcel class as described in
   // Stage 1 of the specification
	
	// create a Scanner
	// private static Scanner sc = new Scanner(System.in);
	   
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
	 /*public String getTrackingHistory()
	   {
		  trackingHistory = "";
	      return  trackingHistory;
	   } */
	 
	 
	 // calculate postage
	 public int calculatePostageCost(String satchelSize) {
		 int postageCost = 0, trackingFee = 5; 
		 
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
		 postageCost += trackingFee;
		 return postageCost;
	 }
	 
	 // select parcel size
	 public int selectSatchel(int parcelLength, int parcelWidth) {
		 int selection = 0, lenSize = 0, widSize = 0;
		 int largeLen = 500, medLen = 400, smlLen = 300;
		 int largeWid = 400, medWid = 300, smlWid = 200;
		 
		 //if satchel size already set return "1"
		 //if(satchelSize.equals(null)) {
			 
			 //check length against maximum lengths in table
			 if(parcelLength > largeLen) {
				 System.out.println("Parcel length to large to send.");
				 lenSize = 0;
				 return 0;
			 } else if(parcelLength < largeLen && parcelLength >= medLen) {
				 lenSize = 3;
			 } else if(parcelLength < medLen && parcelLength >= smlLen) {
				 lenSize = 2;
			 } else if(parcelLength < smlLen && parcelLength >= 0) {
				 lenSize = 1;
			 } else if(parcelLength < 0) {
				 System.out.println("Parcel has no postive length");
				 lenSize = 0;
				 return 0;
			 }
			 
		 //}
		//check length against maximum lengths in table
		 if(parcelWidth > largeWid) {
			 System.out.println("Parcel length to large to send.");
			 widSize = 0;
			 return 0;
		 } else if(parcelWidth < largeWid && parcelWidth >= medWid) {
			 widSize = 3;
		 } else if(parcelWidth < medWid && parcelWidth >= smlWid) {
			 widSize = 2;
		 } else if(parcelWidth < smlWid && parcelWidth >= 0) {
			 widSize = 1;
		 } else if(parcelLength < 0) {
			 System.out.println("Parcel has no postive length");
			 widSize = 0;
			 return 0;
		 }
		 
		 // check length and width, largest will determine size
		 if(lenSize > widSize) {
			 selection = lenSize;
		 } else {
			 selection = widSize;
		 }
		 
		 if(selection == 1) {
			 satchelSize = "Small";
		 } else if(selection == 2) {
			 satchelSize = "Medium";
		 } else if(selection == 3) {
			 satchelSize ="Large";
		 } else {
			 System.out.println("Failed to detrmine parcel size.");
			 return 0;
		 }
		 calculatePostageCost(satchelSize);
		 return selection;
	 }
	 public boolean updateTrackingHistory(String datetime, String location) {
		 // add all tracking history entries to a string.
		 trackingHistory += "Date: " + datetime + " Location: " + location + ".\n";
		 /*If the satchel size has not been set for the Parcel, or if it has 
		 already been delivered then the method should immediately return false.
		 Otherwise the method should construct a new tracking entry noting the date/time 
		 and the location, after which the new tracking entry should be appended to the 
		 tracking history on a new line. Once the tracking history has been updated the 
		 method should return true, indicating that the tracking update was recorded successfully.*/
		 //boolean delivered  = false;
		 return true;
	 }
	 public boolean completeDelivery(String datetime, String signee) {
		 trackingHistory += "Delivery to " + deliveryAddress + " at " + 
				 datetime + " signed for by " + signee;
		 return true;
	 }
	 public void printDetails() {
		 System.out.println("Parcel Number: "+ parcelNumber);
		 System.out.println("Sender: "+ senderName);
		 System.out.println("Return Address: " + returnAddress);
		 System.out.println("Recipient: " + recipientName);
		 System.out.println("Contact Number: " + contactNumber);
		 System.out.println("Satchel Size: " + satchelSize);
		 System.out.println("Tracking History:\n" + trackingHistory);
	 }
}
