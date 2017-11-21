
public class BuyItNowSale extends ItemSale{
	private int buyItNowPrice;
	//private boolean acceptingNearestOffer;
	
	public BuyItNowSale(String itemNumber, String itemDescription, 
                   String itemCondition, String seller, int buyItNowPrice) {
		super(itemNumber, itemDescription, itemCondition, seller);
		this.buyItNowPrice = buyItNowPrice;
		//this.acceptingNearestOffer = false;
	}
	
	public boolean recordBid(int bidPrice, String sellerID) {
		boolean recorded = false;
		if(bidPrice > buyItNowPrice) {
			bidPrice = buyItNowPrice;
		} 
		recorded = super.recordBid(bidPrice, sellerID);
		if (!recorded) {
			return recorded; // bid was not recorded
		} else if (bidPrice == buyItNowPrice){ //bid was recorded
			super.closeSale();  //close sale
			recorded = true; // bid was recorded
		}
		return recorded;
	}
}
