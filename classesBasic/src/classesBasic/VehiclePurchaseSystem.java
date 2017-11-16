package classesBasic;
public class VehiclePurchaseSystem {
	public static void main(String[] args) {
		// declare Parcel array and parcel count variable
		Vehicle[] vehiclesArray = new Vehicle[10];
		vehiclesArray[0] = new Vehicle("1");
		vehiclesArray[1] = new Vehicle("2");
		//vehiclesArray[2] = new Car("3","Commador");
		//vehiclesArray[3] = new Car("4","Falcon");
		vehiclesArray[0].setMake("1","Ford");
		vehiclesArray[1].setMake("2","Toyota");
		//vehiclesArray[2].setMake("3", "Holden");
		//vehiclesArray[3].setMake("4","Ford");
		System.out.println("Vehicle 1: " + vehiclesArray[0].getMake("1"));
		System.out.println("Vehicle 2: " + vehiclesArray[1].getMake("2"));
		//System.out.println("Vehicle 3: " + vehiclesArray[2].getMake("3") + " " + vehiclesArray[2].getModel("3"));
		//System.out.println("Vehicle 4: " + vehiclesArray[3].getMake("4") + " " + vehiclesArray[3].getModel("4)"));
	    
	}

}
