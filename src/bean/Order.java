package bean;

public class Order {
	public static final int OSTATUS_WAITING_PAY = 0;
	public static final int OSTATUS_WAITING_POST = 1;
	public static final int OSTATUS_WAITING_RECEIVE = 2;
	public static final int OSTATUS_WAITING_COMMENT = 3;
	public static final int OSTATUS_COMPLETED = 4;
	
	private int oID;
	private String buyer;
	private String seller;
	private String transID; 
	private int oStatus;
	private int gID;
	
	public Order(){
		
	}

	public int getoID() {
		return oID;
	}

	public void setoID(int oID) {
		this.oID = oID;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public int getoStatus() {
		return oStatus;
	}

	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}
	
}
