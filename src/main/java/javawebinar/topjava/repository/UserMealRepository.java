package javawebinar.topjava.repository;

import javawebinar.topjava.model.UserMeal;

import java.util.Date;
import java.util.List;

public interface UserMealRepository {
	UserMeal save(final UserMeal userMeal, final int userId);

	// null if not found
	UserMeal get(final int id, final int userId);

	boolean delete(final int id, final int userId);

	// null if not found
	List<UserMeal> getAll(final int userId);

	void deleteAll(final int userId);

	UserMeal update(final UserMeal meal, final int userId);

	List<UserMeal> getBetween(final Date startDate, final Date endDate, final int userId);
}
