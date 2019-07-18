package javawebinar.topjava.repository.mock;

import javawebinar.topjava.LoggerWrapper;
import javawebinar.topjava.model.UserMeal;
import javawebinar.topjava.repository.UserMealRepository;
import org.springframework.stereotype.Repository;

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
	public UserMeal get(final int id, final int userId) {
		return null;
	}

	@Override
	public boolean delete(final int id, final int userId) {
		return true;
	}

	@Override
	public List<UserMeal> getAll(final int userId) {
		return null;
	}

	@Override
	public void deleteAll(final int userId) {

	}

	@Override
	public UserMeal update(final UserMeal meal, final int userId) {
		return null;
	}

	@Override
	public List<UserMeal> getBetween(final Date startDate, final Date endDate, final int userId) {
		return null;
	}
}
