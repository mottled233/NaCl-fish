package DAO;

import java.util.ArrayList;

import beans.Order;

public interface OrderDAO {
	
	/**
	 * @see OrderDAO#Order_Create(String, String, int) ��������
	 * @param saller_ID ����ID
	 * @param costumer_ID ���ID
	 * @param Item_ID ��ƷID 
	 * 
	 * @return ������
	 * */
	public int Order_Create(String saller_ID,String costumer_ID,int Item_ID);
	
	/**
	 * @see OrderDAO#Item_getListByKeyword() ������������һ�ȡ���������������б�
	 * @param User_ID �û���
	 * @param category ��һ������� ���costumer ����saller
	 * 
	 * @return ������/���������ɵı�
	 * */
	public ArrayList<Order> Order_getList(String User_ID,String category);

	/**
	 * @see OrderDAO#Order_Sent ���¿�ݵ���
	 * @param Order_ID ������
	 * @param Sent_ID ��ݵ���
	 * 
	 * */
	public void Order_Sent(int Order_ID,String Sent_ID);
	
	/**
	 * @see OrderDAO#Order_Pay(int) ֧������
	 * @param Order_ID ������
	 * 
	 * */
	public void Order_Pay(int Order_ID);
	
	/**
	 * @see OrderDAO#Order_getDetails(int) ��ȡ������ϸ��Ϣ
	 * @param Order_ID ������
	 * 
	 * @return �ɶ������鹹�ɵĶ������� 
	 * */
	public Order Order_getDetails(int Order_ID);
	
	
}
