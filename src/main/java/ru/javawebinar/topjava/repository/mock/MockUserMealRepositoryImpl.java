package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class MockUserMealRepositoryImpl implements UserMealRepository {
	private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepositoryImpl.class);

	@Override
	public UserMeal save(UserMeal userMeal, int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getByUserId(final String id) {
		LOG.info("getByUserId " + id);
		return null;
	}

	@Override
	public UserMeal getByUserMealId(final String id) {
		LOG.info("getByUserMealId " + id);
		return null;
	}

	@Override
	public List<UserMeal> getFromDateToDate(final Date from, final Date to) {
		LOG.info("getFromDateToDate " + from + " " + to);
		return null;
	}

	@Override
	public UserMeal get(final int id, final int userId) {
		return null;
	}

	@Override
	public void delete(final int id, final int userId) {

	}

	@Override
	public List<UserMeal> getAll(final int userId) {
		return null;
	}

	@Override
	public void deleteAll(final int userId) {

	}

	@Override
	public void update(final UserMeal meal, final int userId) {

	}

	@Override
	public void create(final UserMeal meal, final int userId) {

	}

	@Override
	public List<UserMeal> getBetween(final LocalDateTime startDate, final LocalDateTime endDate, final int userId) {
		return null;
	}
}
