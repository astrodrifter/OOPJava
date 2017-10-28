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
	 public String getSatchelSize()
	   {
	      return  satchelSize;
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
		 int fee = 0; // returns to method call in ParcelPostSystem
		 
		//check if already satchel size is already set
		 if(satchelSize != null) {
			 selection = -1;
			 return selection;
		 }
		 
		 //if satchel size already set return "1"
		 //if(satchelSize.equals(null)) {
			 
		 //check length against maximum lengths in table
		if(parcelLength > largeLen) {
			 selection = 0;
		 } else if(parcelLength <= largeLen && parcelLength > medLen) {
			 lenSize = 3;
		 } else if(parcelLength <= medLen && parcelLength > smlLen) {
			 lenSize = 2;
		 } else if(parcelLength <= smlLen && parcelLength > 0) {
			 lenSize = 1;
		 } else if(parcelLength < 0) {
			 System.out.println("Parcel length is in a different dimension.");
			 selection = 0;
		 }
			 
		 //}
		//check length against maximum lengths in table
		 if(parcelWidth > largeWid) {
			 selection = 0;
		 } else if(parcelWidth <= largeWid && parcelWidth > medWid) {
			 widSize = 3;
		 } else if(parcelWidth <= medWid && parcelWidth > smlWid) {
			 widSize = 2;
		 } else if(parcelWidth <= smlWid && parcelWidth > 0) {
			 widSize = 1;
		 } else if(parcelLength < 0) {
			 System.out.println("Parcel width is in a different dimension.");
			 selection = 0;
			 
		 }
		 
		 // check length and width, largest will determine size
		 if(lenSize > widSize && selection != 0) {
			 selection = lenSize;
		 } else {
			 selection = widSize;
		 }
		 
		 if(selection == 1) {
			 satchelSize = "Small";
			 fee = calculatePostageCost(satchelSize);
			 System.out.println(fee);
			 //state = -1;
		 } else if(selection == 2) {
			 satchelSize = "Medium";
			 fee = calculatePostageCost(satchelSize);
			 //state = -1;
		 } else if(selection == 3) {
			 satchelSize ="Large";
			 fee = calculatePostageCost(satchelSize);
			 //state = -1;
		 } else {
			 selection = 0; // parcel too large for satchel
		 }
		 
		 // if result = -1 satchel already set
		 // if result = 0 parcel too large
		 // else calculate fee and return fee 
		 //if(state == -1) {
		//	 return state;
		 if (selection == 0 || selection == -1) {
			 return selection;
		 } else {
			 return fee;
		 }
		 
	 }
	 public boolean updateTrackingHistory(String datetime, String location) {
		 // add all tracking history entries to a string.
		 trackingHistory += "Date: " + datetime + " Location: " + location + ".\n";
		
		 //boolean delivered  = false;
		 return true;
	 }
	 public boolean completeDelivery(String datetime, String signee) {
		 trackingHistory += "Delivery to " + deliveryAddress + " at " + 
				 datetime + " signed for by " + signee +"\n";
		 return true;
	 }
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
