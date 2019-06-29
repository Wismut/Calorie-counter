package javawebinar.topjava.web.mock;

import javawebinar.topjava.model.Role;
import javawebinar.topjava.model.User;
import javawebinar.topjava.web.user.AdminUserRestController;
import javawebinar.util.exception.NotFoundException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class UserAdminMockTest {
	private static ConfigurableApplicationContext appCtx;
	private static AdminUserRestController controller;

	@BeforeClass
	public static void beforeClass() {
		appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
		System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
		controller = appCtx.getBean(AdminUserRestController.class);
	}

	@AfterClass
	public static void afterClass() {
		appCtx.close();
	}

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