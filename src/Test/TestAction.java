<<<<<<< HEAD
/**
 * 
 */
/**
 * @author 联想
 *
 */
package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Users;
import dao.User_DAO;

public class TestAction {
	public static void main(String[] args) throws SQLException{
		Users user = new Users();
		user.setUsername("qwe");
		user.setPassword("aasdas");
		user.setAddress("qweqwrx");
		User_DAO.User_Update(user);
	}
}

=======
package Test;

import dao.User_DAO;

public class TestAction {
	public static void main(String[] args){
		User_DAO.User_checkin("张三","123");
		
		
	}
}
>>>>>>> ce13135c36ec94a8fb09b59dcf7686ab2a092629
