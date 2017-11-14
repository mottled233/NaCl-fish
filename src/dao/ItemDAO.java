package dao;

import java.util.ArrayList;

import bean.Goods;

public interface ItemDAO {
	
	
	/**
	 *@see ItemDAO#Item_getDetailInf(int) 获得物品详情
	 *
	 * @param GID 物品ID
	 * @return 由物品详情所创建的物品对象
	 * */
	public Goods Item_getDdtailInf(int GID);
	
	/**
	 * @see ItemDAO#Item_getRank(String) 获得物品排序
	 * @param Rank 排序类别
	 * 
	 * @return 物品排行表
	 * */
	
	public ArrayList<Goods> Item_getRank(String Rank);

	
	/**
	 * @see ItemDAO#Item_getListByKeyword(String) 根据关键词搜索列表
	 * 
	 * @param keyword[] 关键词
	 * 
	 * @return 查询结果构成的列表
	 * */
	public ArrayList<Goods> Item_getListByKeyword(String[] keyword);

	
	/**
	 * @see ItemDAO#Item_getListByClass(String) 按照分类搜索列表
	 * @param category 种类
	 * 
	 * @return 查询结果构成的列表
	 * */
	public ArrayList<Goods> Item_getListByClass(String category);

	
	/**
	 * @see ItemDAO#Item_getCritisizes(int) 获取评论
	 * @param ItemID 物品ID
	 * 
	 * @return 该物品评论列表
	 * */
	
	public ArrayList<String> Item_getCritisizes(int ItemID);

	
	/**
	 * @see ItemDAO#Item_Issue(Goods) 发布物品
	 * @param item 由网页表单创建的物品对象
	 * 
	 * */
	
	public void Item_Issue(Goods item);
//	发布货物
	
	/**
	 * @see ItemDAO#Item_LeaveStore(int) 下架物品
	 * @param ItemID 物品ID
	 * 
	 * */
	public void Item_LeaveStore(int ItemID);
//	下架货物

}
