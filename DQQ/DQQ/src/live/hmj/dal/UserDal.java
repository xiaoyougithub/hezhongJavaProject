package live.hmj.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import live.hmj.entity.User;
import live.hmj.util.Conn;

public class UserDal {
	Conn conn = new Conn();
	/**
	 * 获取博文列表 
	 * @return
	 * @throws SQLException
	 */
	public List<User> getList() throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		ResultSet rs = conn.executeQuery(sql);

		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			list.add(user);
		}
		conn.close();
		return list;
	}
	/**
	 * 博文插入操作 
	 * @param info
	 * @return
	 */
	public int insertUser(User user) {
		String sql = "insert into user(userName,password,email) values ";
		sql = sql + " ('" + user.getUserName()+ "','" + user.getPassword() + "','" + user.getEmail()+ "')";
		int result = 0;
		System.out.print(sql);
		result = conn.executeUpdate(sql);
		conn.close();
		return result;
	}
	public int deleteUserById(int id) {
		String sql = "delete from user where id =" + id + "";
		int result = 0;
		result = conn.executeUpdate(sql);
		conn.close();
		return result;
	}
}
