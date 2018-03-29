package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.tmax.tibero.jdbc.driver.TbConnection;

import springbook.user.dao.UserDao.ConnectionMaker;

public class NConnectionMaker implements ConnectionMaker{

	@Override
	public Connection makeConnection() throws Exception {
		// TODO Auto-generated method stub
		
		TbConnection con = (TbConnection) DriverManager.getConnection("jdbc:tibero:thin:@192.168.3.81:8629:tibero","b162", "b162");
		
		return con;
	}
	
	
}
