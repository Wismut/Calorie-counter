package javawebinar.topjava.service;

import javawebinar.topjava.LoggedUser;
import javawebinar.topjava.model.BaseEntity;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.model.UserMealTestData;
import javawebinar.topjava.util.DbPopulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {

	@Autowired
	protected UserMealService service;

	@Autowired
	private DbPopulator dbPopulator;

	@Before
	public void setUp() throws Exception {
		dbPopulator.execute();
	}

	@Test
	public void get() {
		final Integer userId = BaseEntity.START_SEQ;
		final Integer userMealId = BaseEntity.START_SEQ + 2;
		UserMeal userMeal = service.get(userMealId, userId);
		assertEquals(userId, userMeal.getUser().getId());
		assertEquals(userMealId, userMeal.getId());
	}

	@Test
	public void delete() {
	}

	@Test
	public void getAll() {
		final int userId = BaseEntity.START_SEQ;
		final int countLinesInMealsTable = 4;
		assertEquals(countLinesInMealsTable, service.getAll(userId).size());
	}

	@Test
	public void deleteAll() {
	}

	@Test
	public void update() {
	}

	@Test
	public void save() {
	}

	@Test
	public void getBetween() {
	}
}