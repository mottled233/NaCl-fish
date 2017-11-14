package dao;

import java.util.ArrayList;

import bean.Goods;

public interface ItemDAO {
	
	
	/**
	 *@see ItemDAO#Item_getDetailInf(int) �����Ʒ����
	 *
	 * @param GID ��ƷID
	 * @return ����Ʒ��������������Ʒ����
	 * */
	public Goods Item_getDdtailInf(int GID);
	
	/**
	 * @see ItemDAO#Item_getRank(String) �����Ʒ����
	 * @param Rank �������
	 * 
	 * @return ��Ʒ���б�
	 * */
	
	public ArrayList<Goods> Item_getRank(String Rank);

	
	/**
	 * @see ItemDAO#Item_getListByKeyword(String) ���ݹؼ��������б�
	 * 
	 * @param keyword[] �ؼ���
	 * 
	 * @return ��ѯ������ɵ��б�
	 * */
	public ArrayList<Goods> Item_getListByKeyword(String[] keyword);

	
	/**
	 * @see ItemDAO#Item_getListByClass(String) ���շ��������б�
	 * @param category ����
	 * 
	 * @return ��ѯ������ɵ��б�
	 * */
	public ArrayList<Goods> Item_getListByClass(String category);

	
	/**
	 * @see ItemDAO#Item_getCritisizes(int) ��ȡ����
	 * @param ItemID ��ƷID
	 * 
	 * @return ����Ʒ�����б�
	 * */
	
	public ArrayList<String> Item_getCritisizes(int ItemID);

	
	/**
	 * @see ItemDAO#Item_Issue(Goods) ������Ʒ
	 * @param item ����ҳ����������Ʒ����
	 * 
	 * */
	
	public void Item_Issue(Goods item);
//	��������
	
	/**
	 * @see ItemDAO#Item_LeaveStore(int) �¼���Ʒ
	 * @param ItemID ��ƷID
	 * 
	 * */
	public void Item_LeaveStore(int ItemID);
//	�¼ܻ���

}
