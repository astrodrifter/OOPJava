
public class TestParcel {
	// create a Scanner
	   
	   public static void main(String[] args){
		   Parcel newParcel = new Parcel("12345", "Dhruva O'Shea", "20 Dorothy St", 
					"Suryani Dayaly", "16 Byangum Rd", "0434629587");
		   newParcel.selectSatchel(100,200);
		   newParcel.updateTrackingHistory("10:00am 29/10/17,", "Murwilumbah Post Office");
		   newParcel.updateTrackingHistory("17:00pm 29/10/17,", "Airport");
		   newParcel.updateTrackingHistory("10:00am 30/10/17,", "Los Angeles Post Office");
		   newParcel.completeDelivery("17:00pm 30/10/17,", "Mr David Spade.");
		   newParcel.printDetails();
	   }
	   
	   

}
