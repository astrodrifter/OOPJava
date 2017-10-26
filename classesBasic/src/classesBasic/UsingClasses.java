package classesBasic;

public class UsingClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalogueItem shoes = new CatalogueItem();
		shoes.setDescription("Nike Air Jordans");
		shoes.setPrice(250);
		System.out.println("My shoes are " + shoes.getDescription());
		System.out.println("they cost $"+ shoes.getPrice());
		System.out.println("I payed $"+shoes.calculateTax()+ " tax");
	}

}
