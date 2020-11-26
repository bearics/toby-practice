package toby.user.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import toby.user.domain.User;

public class UserDaoTest {

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		ApplicationContext context = new GenericXmlApplicationContext("resources/applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		User user = new User();
		user.setId("bearics");
		user.setName("전형린");
		user.setPassword("1234");

		dao.add(user);
		assertThat(dao.getCount(), is(1));

		System.out.println(user.getId() + " 추가 되었습니다.");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println(user2.getId() + " 조회 되었습니다.");

		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}

	@Test
	public void count() throws SQLException, ClassNotFoundException {
		ApplicationContext context = new GenericXmlApplicationContext("resources/applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user1 = new User("userId1", "이름1", "password1");
		User user2 = new User("userId2", "이름2", "password2");
		User user3 = new User("userId3", "이름3", "password3");

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));

	}
}
