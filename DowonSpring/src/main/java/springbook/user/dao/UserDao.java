package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import springbook.user.domain.User;

public abstract class UserDao {
	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDao() {
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	public void add(User user) throws Exception {
		/*
		 * 길게 중복되는 메소드
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "rlaehdnjs123");
		*/
		Connection con = simpleConnectionMaker.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into users(userid ,name, password) values (? ,? ,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public User get(String id) throws Exception{
		/*
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "rlaehdnjs123");
		*/
		Connection con = simpleConnectionMaker.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from users where userid = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("userid"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
	    
		rs.close();
		ps.close();
		con.close();
		
		return user;
		
	}
	
}
