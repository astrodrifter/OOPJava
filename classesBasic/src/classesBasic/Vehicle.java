
package classesBasic;

public class Vehicle {
	private static String id;
	private static String make;
	
	public Vehicle(String id) {
		this.id = id;
	}
	
	// getters
	public void setMake(String id, String inMake) {
		make = inMake;
	}
	
	public String getMake(String id) {
		return make;
	}
	
	

}
