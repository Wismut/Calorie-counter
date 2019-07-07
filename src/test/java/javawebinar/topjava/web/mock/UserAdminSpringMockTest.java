package javawebinar.topjava.web.mock;

import javawebinar.topjava.model.Role;
import javawebinar.topjava.model.User;
import javawebinar.topjava.web.user.AdminUserRestController;
import javawebinar.topjava.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration({"classpath:spring/spring-app.xml",
		"classpath:spring/mock.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {
	@Autowired
	AdminUserRestController controller;

	@Test
	public void testCreate() throws Exception {
		controller.create(new User(null, "Name", "email", "password", true, Role.ROLE_USER));
	}

	@Test
	public void testDelete() throws Exception {
		controller.delete(7);
	}

	@Test(expected = NotFoundException.class)
	public void testDeleteNotFound() throws Exception {
		controller.delete(0);
	}
}
