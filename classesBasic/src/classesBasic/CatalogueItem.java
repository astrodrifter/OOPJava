package classesBasic;

public class CatalogueItem{
	   private String description;
	   private double price;
	   private final double TAXRATE = 0.1;


	   CatalogueItem()
	   {
	      description = "Unknown Item";
	      price = 0.0;
	   }

	   CatalogueItem(String inDesc, double inPrice)
	   {
	      description = inDesc;
	      price = inPrice;
	   }

	   public void setDescription(String inDesc)
	   {
	      description = inDesc;
	   }

	   public void setPrice(double inPrice)
	   {
	      price = inPrice;
	   }

	   public String getDescription()
	   {
	      return description;
	   }

	   public double getPrice()
	   {
	      return price;
	   }

	   public double calculateTax()
	   {
	      return price * TAXRATE;
	   }
	}
