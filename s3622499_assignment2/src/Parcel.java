
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
	private boolean deliveryComplete;
	private String trackingHistory;
	
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
	 public String getTrackingHistory()
	   {
		  trackingHistory = "";
	      return  trackingHistory;
	   } 
	 
	 
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
		 int selection = 0;
		 return selection;
	 }
}
