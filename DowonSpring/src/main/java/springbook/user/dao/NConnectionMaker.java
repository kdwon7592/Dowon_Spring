package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import springbook.user.dao.UserDao.ConnectionMaker;

public class NConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws Exception {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "rlaehdnjs123");
		
		return con;
	}
	
	
}
