
public class BuyItNowSale extends ItemSale{
	private int buyItNowPrice;
	private boolean acceptingNearestOffer;
	
	public BuyItNowSale(String itemNumber, String itemDescription, 
                   String itemCondition, String seller, int buyItNowPrice) {
		super(itemNumber, itemDescription, itemCondition, seller);
		this.buyItNowPrice = buyItNowPrice;
		this.acceptingNearestOffer = false;
	}
	@Override
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
	public boolean acceptNearestOffer() {
		if(acceptingNearestOffer == false) {
			acceptingNearestOffer = true;
		} else {
			acceptingNearestOffer = false;
		}
		return acceptingNearestOffer;
	}
}
