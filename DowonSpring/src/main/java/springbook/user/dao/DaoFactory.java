package springbook.user.dao;

import springbook.user.dao.UserDao.ConnectionMaker;

public class DaoFactory {
	public UserDao userDao() {
		// ConnectionMaker connectionMaker = new DConnectionMaker();
		// UserDao userDao = new UserDao(connectionMaker);
		// return userDao;

		return new UserDao(connectionMaker());
	}

	public UserDao accountantDao() {

		return new UserDao(connectionMaker());
	}

	public UserDao managerDao() {

		return new UserDao(connectionMaker());
	}
	
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
