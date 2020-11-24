/**
 * @(#)UserDaoConnectionCountingTest.java 2020. 11. 25
 *
 * Copyright 2020 Naver Corp. All rights Reserved.
 * Naver PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package toby.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import toby.user.domain.User;

/**
 * @author Hyounglin Jun (KR19849)
 */
public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("bearics");
		user.setName("전형린");
		user.setPassword("1234");

		dao.add(user);

		System.out.println(user.getId() + " 추가 되었습니다.");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + " 조회 되었습니다.");

		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());
	}
}