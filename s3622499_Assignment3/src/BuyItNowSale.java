
public class BuyItNowSale extends ItemSale{
	private int buyItNowPrice;
	private boolean acceptingNearestOffer;
	
	public BuyItNowSale(String itemNumber, String itemDescription, 
                   String itemCondition, String seller, int buyItNowPrice) {
		super(itemNumber, itemDescription, itemCondition, seller);
		this.buyItNowPrice = buyItNowPrice;
		this.acceptingNearestOffer = false;
	}
	// record bid
	@Override
	public boolean recordBid(int bidPrice, String bidderID) { //in specs say sellerID
		boolean recorded = false;                      // im assuming it's meant to be bidderID
		if(bidPrice > buyItNowPrice) {
			bidPrice = buyItNowPrice;
		} 
		recorded = super.recordBid(bidPrice, bidderID);
		if (!recorded) {
			return recorded; // bid was not recorded
		} else if (bidPrice == buyItNowPrice){ //bid was recorded
			super.closeSale();  //close sale
			recorded = true; // bid was recorded
		}
		return recorded;
	}
	// Close sale
	@Override
	public int closeSale() {
		System.out.println("Entered subclass closeSale");
		int closed = 0;
		if(super.isSaleEnded() == true) {
			System.out.println("super.isSaleEnded()");
			closed = -1;
		} else if (super.getHighestBid() < buyItNowPrice /*&& acceptNearestOffer != true*/) {
			System.out.println("super.getHighestBid() < buyItNowPrice");
			closed = 0;
		} else {
			System.out.println("else");
			closed  = super.closeSale();
			System.out.println(closed);
		}
		return closed;
	}
	// accept nearest offer
	public boolean acceptNearestOffer() {
		if(acceptingNearestOffer == false) {
			acceptingNearestOffer = true;
		} else {
			acceptingNearestOffer = false;
		}
		return acceptingNearestOffer;
	}
	// prints details including buy it now details
	@Override
	public void printDetails() {
		super.printDetails();
		System.out.printf("%-30s %s%n", "Buy It Now Price:", buyItNowPrice);
		System.out.printf("%-30s %s%n", "Accepting Nearest Offer:", acceptingNearestOffer);
	}
}
