package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.Date;
import java.util.List;

@Repository
public class MockUserMealRepository implements UserMealRepository {
	private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepository.class);

	@Override
	public List<UserMeal> getByUserId(String id) {
		LOG.info("getByUserId " + id);
		return null;
	}

	@Override
	public UserMeal getByUserMealId(String id) {
		LOG.info("getByUserMealId " + id);
		return null;
	}

	@Override
	public List<UserMeal> getFromDateToDate(Date from, Date to) {
		LOG.info("getFromDateToDate " + from + " " + to);
		return null;
	}

	@Override
	public UserMeal get(int id, int userId) {
		return null;
	}

	@Override
	public void delete(int id, int userId) {

	}

	@Override
	public List<UserMeal> getAll(int userId) {
		return null;
	}

	@Override
	public void deleteAll(int userId) {

	}
}
