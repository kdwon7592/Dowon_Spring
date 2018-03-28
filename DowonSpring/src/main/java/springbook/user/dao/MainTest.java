package springbook.user.dao;

import springbook.user.domain.User;

public class MainTest {
	public static void main(String[] args) throws Exception {
		User user = new User();
		
		UserDao dao = new NUserDao();
		
		user.setId("dowon");
		user.setName("dowon");
		user.setPassword("123456");
		
		dao.add(user);
		
		User user2 = dao.get("dowon");
		
		System.out.println(user2.getId() + " " + user2.getName() + " " + user2.getPassword());
		
	}
}
