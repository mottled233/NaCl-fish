package dao;

public interface accountDAO {

	
	
	/*
	 * @see accountDAO#account(int,double)
	 * @param userID 要结算的用户ID
	 * @param cost 本次结算金额
	 * **/
	public boolean account(int userID,double cost);
	
}
