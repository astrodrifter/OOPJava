package classesBasic;

public class Car extends Vehicle {
	private static String model;
	
	public Car(String id, String model) {
		super(id);
		this.model = model;
	}
	
	public String getModel(String id) {
		return model;
	}
	
}
