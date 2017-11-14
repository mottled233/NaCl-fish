package dao;

import java.util.ArrayList;

import bean.Order;
import bean.Users;

public interface UserDAO {
	/**
	 * @see UserDAO#User_checkin(String, String)
	 * 
	 * @param User_ID �û���
	 * @param password ����
	 * 
	 * @return ��¼�ɹ���־λ
	 * 
	 * */
	public boolean User_checkin(String User_ID,String password);//��¼ȷ�����õ�DAO
	
	/**
	 * @param User_ID �û���
	 * 
	 * @return ��ȡ�ص��û���ϸ��Ϣ�����ɵ�User����
	 * 
	 * */
	public Users User_getInf(String User_ID);//��ʼ���û���Ϣ
	/**
	 * @see UserDAO#Rigist(User) ע���÷���
	 * 
	 * @param user �ɱ���Ϣ���������û�����
	 * 
	 * */
	public void Rigist(Users user);
	
	/**
	 * @see UserDAO#User_Update(User) �����û���Ϣ
	 * @param �����û���Ϣʱ�ɱ��������û�����
	 * */
	public void User_Update(Users user);
}
