package DAO;

import java.util.ArrayList;

import beans.Order;

public interface OrderDAO {
	
	/**
	 * @see OrderDAO#Order_Create(String, String, int) 创建订单
	 * @param saller_ID 卖家ID
	 * @param costumer_ID 买家ID
	 * @param Item_ID 物品ID 
	 * 
	 * @return 订单号
	 * */
	public int Order_Create(String saller_ID,String costumer_ID,int Item_ID);
	
	/**
	 * @see OrderDAO#Item_getListByKeyword() 根据买家与卖家获取买入与卖出订单列表
	 * @param User_ID 用户名
	 * @param category 买家或者卖家 买家costumer 卖家saller
	 * 
	 * @return 所有买/卖订单构成的表
	 * */
	public ArrayList<Order> Order_getList(String User_ID,String category);

	/**
	 * @see OrderDAO#Order_Sent 更新快递单号
	 * @param Order_ID 订单号
	 * @param Sent_ID 快递单号
	 * 
	 * */
	public void Order_Sent(int Order_ID,String Sent_ID);
	
	/**
	 * @see OrderDAO#Order_Pay(int) 支付订单
	 * @param Order_ID 订单号
	 * 
	 * */
	public void Order_Pay(int Order_ID);
	
	/**
	 * @see OrderDAO#Order_getDetails(int) 获取订单详细信息
	 * @param Order_ID 订单号
	 * 
	 * @return 由订单详情构成的订单对象 
	 * */
	public Order Order_getDetails(int Order_ID);
	
	
}
