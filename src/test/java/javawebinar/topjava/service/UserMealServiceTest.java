package javawebinar.topjava.service;


import javawebinar.topjava.model.BaseEntity;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.model.UserMealTestData;
import javawebinar.topjava.util.DbPopulator;
import javawebinar.topjava.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@ContextConfiguration({"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
public class UserMealServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		final int userId = BaseEntity.START_SEQ;
		final Integer userMealId = BaseEntity.START_SEQ + 2;
		service.delete(userMealId, userId);
	}

	public void deleteNotFound() {
		thrown.expect(NotFoundException.class);
		final int userId = BaseEntity.START_SEQ;
		final Integer userMealId = BaseEntity.START_SEQ;
		service.delete(userMealId, userId);
	}

	@Test
	public void getAll() {
		final int userId = BaseEntity.START_SEQ;
		final int countLinesInMealsTable = 4;
		assertEquals(countLinesInMealsTable, service.getAll(userId).size());
	}

	@Test
	public void deleteAll() {
		final int userId = BaseEntity.START_SEQ;
		service.deleteAll(userId);
	}

	@Test
	public void update() {
//		final TestUserMeal veryGoodFood = new TestUserMeal(new UserMeal(BaseEntity.START_SEQ + 2, LocalDateTime.now(), "very good food", 100));
		final UserMeal veryGoodFood = new UserMeal(BaseEntity.START_SEQ + 2, new Date(), "very good food", 100);
		final int userId = BaseEntity.START_SEQ;
		final UserMeal userMeal = service.update(veryGoodFood, userId);
		UserMealTestData.MATCHER.assertEquals(veryGoodFood, userMeal);
	}

	@Test
	public void save() {
//		final TestUserMeal veryGoodFood = new TestUserMeal(new UserMeal(BaseEntity.START_SEQ + 2, LocalDateTime.now(), "very good food", 100));
		final UserMeal veryGoodFood = new UserMeal(BaseEntity.START_SEQ + 2, new Date(), "very good food", 100);
		final int userId = BaseEntity.START_SEQ;
		final UserMeal userMeal = service.save(veryGoodFood, userId);
		UserMealTestData.MATCHER.assertEquals(veryGoodFood, userMeal);
	}

	@Test
	public void getBetween() {
		int userId = BaseEntity.START_SEQ;
//		LocalDateTime startDate = LocalDateTime.of(2000, Month.APRIL, 1, 1, 1);
//		LocalDateTime endDate = LocalDateTime.of(2019, Month.APRIL, 1, 1, 1);
		Date startDate = new Date(2000, Calendar.APRIL, 1, 1, 1);
		Date endDate = new Date(2019, Calendar.MAY, 1, 1, 1);
		service.getBetween(startDate, endDate, userId);
	}
}
