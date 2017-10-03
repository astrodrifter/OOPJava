import java.io.*;
public class rateCalculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String vehicleType, tripTime = null;
		System.out.print("Enter Vehicl Type (M, C, LCV, HCV: ");
		vehicleType = keyboard.readLine();
		if(vehicleType == "HCV") {
			System.out.print("Enter Trip Time: ");
			tripTime = keyboard.readLine();
		}
		
		double rate = 0.0;
		if(vehicleType.equals("HCV")) {
			rate = 7.20;
			if(tripTime == "Peak") {
				rate = rate*1.4;
			} else if(tripTime == "Night") {
				rate = rate*0.7;
			} else {
				rate = rate*1;
			}
		} else if(vehicleType.equals("M")) {
			rate = 1.40;
			System.out.println("\nentered M rate\n ");
		} else if(vehicleType.equals("C")) {
			rate = 2.40;
			System.out.println("\nentered C rate\n ");
		} else if(vehicleType.equals("LCV")) {
			rate = 3.80;
			System.out.println("\nentered LCV rate\n ");
		} 
		System.out.println(rate);
	}

}
