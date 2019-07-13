package live.hmj.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import live.hmj.entity.PublicMessage;
import live.hmj.util.Conn;

public class PublicMessageDal {
	Conn conn = new Conn();
	/**
	 * 	获取列表 
	 * @return
	 * @throws SQLException
	 */
	public List<PublicMessage> getList() throws SQLException {
		List<PublicMessage> list = new ArrayList<PublicMessage>();
		String sql = "select * from publicMessage";
		ResultSet rs = conn.executeQuery(sql);

		while (rs.next()) {
			PublicMessage message=new PublicMessage();
			message.setId(rs.getInt("id"));
			message.setUserName(rs.getString("userName"));
			message.setDate(rs.getString("date"));
			message.setMessage(rs.getString("message"));
			list.add(message);
		}
		conn.close();
		return list;
	}
	/**
	 * 	列表插入操作 
	 * @param info
	 * @return
	 */
	public int insertPublicMessage(PublicMessage publicMessage) {
		String sql = "insert into publicMessage(userName,date,message) values ";
		sql = sql + " ('" + publicMessage.getUserName()+ "','" + publicMessage.getDate() + "','" + publicMessage.getMessage()+ "')";
		int result = 0;
		System.out.print(sql);
		result = conn.executeUpdate(sql);
		conn.close();
		return result;
	}
	/**
	 * 	列表的删除操作
	 * @param id
	 * @return
	 */
	public int deletePublicMessageById(int id) {
		String sql = "delete from publicMessage where id =" + id + "";
		int result = 0;
		result = conn.executeUpdate(sql);
		conn.close();
		return result;
	}
}
