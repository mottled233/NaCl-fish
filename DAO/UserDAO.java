package DAO;

import java.util.ArrayList;

import beans.Order;
import beans.User;

public interface UserDAO {
	/**
	 * @see UserDAO#User_checkin(String, String)
	 * 
	 * @param User_ID 用户名
	 * @param password 密码
	 * 
	 * @return 登录成功标志位
	 * 
	 * */
	public boolean User_checkin(String User_ID,String password);//登录确认所用的DAO
	
	/**
	 * @param User_ID 用户名
	 * 
	 * @return 由取回的用户详细信息所构成的User对象
	 * 
	 * */
	public User User_getInf(String User_ID);//初始化用户信息
	/**
	 * @see UserDAO#Rigist(User) 注册用方法
	 * 
	 * @param user 由表单信息所创建的用户对象
	 * 
	 * */
	public void Rigist(User user);
	
	/**
	 * @see UserDAO#User_Update(User) 更新用户信息
	 * @param 更新用户信息时由表单创建的用户对象
	 * */
	public void User_Update(User user);
}
