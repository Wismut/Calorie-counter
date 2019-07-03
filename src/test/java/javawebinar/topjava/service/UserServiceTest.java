package javawebinar.topjava.service;


import javawebinar.topjava.model.*;
import javawebinar.topjava.util.DbPopulator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import javawebinar.topjava.util.exception.NotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javawebinar.topjava.model.UserTestData.ADMIN;
import static javawebinar.topjava.model.UserTestData.USER;

@ContextConfiguration({"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	protected UserService userService;

	@Autowired
	private DbPopulator dbPopulator;

	@Before
	public void setUp() throws Exception {
		dbPopulator.execute();
	}

	@Test
	public void testSave() throws Exception {
		TestUser tu = new TestUser("New", "new@gmail.com", "newPass", Role.ROLE_USER);
		User created = userService.save(tu.asUser());
		tu.setId(created.getId());
		UserTestData.MATCHER.assertListEquals(Arrays.asList(ADMIN, tu, USER), userService.getAll());
	}

	@Test(expected = DataAccessException.class)
	public void testDuplicateMailSave() throws Exception {
		userService.save(new TestUser("Duplicate", "user@yandex.ru", "newPass", Role.ROLE_USER).asUser());
	}

	@Test
	public void testDelete() throws Exception {
		userService.delete(BaseEntity.START_SEQ);
		UserTestData.MATCHER.assertListEquals(Collections.singletonList(ADMIN), userService.getAll());
	}

	@Test(expected = NotFoundException.class)
	public void testNotFoundDelete() throws Exception {
		userService.delete(1);
	}

	@Test
	public void testGet() throws Exception {
		User user = userService.get(BaseEntity.START_SEQ);
		UserTestData.MATCHER.assertEquals(USER, user);
	}

	@Test
	public void testGetByEmail() throws Exception {
		User user = userService.getByEmail("user@yandex.ru");
		UserTestData.MATCHER.assertEquals(USER, user);

	}

	@Test
	public void testGetAll() throws Exception {
		List<User> all = userService.getAll();
		UserTestData.MATCHER.assertListEquals(Arrays.asList(ADMIN, USER), all);
	}

	@Test
	public void testUpdate() throws Exception {
		TestUser updated = new TestUser(USER);
		updated.setName("UpdatedName");
		userService.update(updated.asUser());
		UserTestData.MATCHER.assertEquals(updated, userService.get(BaseEntity.START_SEQ));
	}
}
