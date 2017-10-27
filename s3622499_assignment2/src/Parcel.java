
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
	 
	 
	 
	
	//Parcel class constructor
	public Parcel(String parcelNumber, String trackingID, String senderName, 
			String returnAddress, String recipientName, String deliveryAddress,
			String recipientAddress, String contactNumber) {
		
				
			}
   
}
