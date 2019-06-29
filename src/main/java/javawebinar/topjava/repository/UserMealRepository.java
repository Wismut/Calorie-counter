package javawebinar.topjava.repository;

import javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface UserMealRepository {
	UserMeal save(final UserMeal userMeal, final int userId);

	// null if not found
	List<UserMeal> getByUserId(final String id);

	// null if not found
	UserMeal getByUserMealId(final String id);

	List<UserMeal> getFromDateToDate(final Date from, final Date to);

	// null if not found
	UserMeal get(final int id, final int userId);

	boolean delete(final int id, final int userId);

	// null if not found
	List<UserMeal> getAll(final int userId);

	void deleteAll(final int userId);

	UserMeal update(final UserMeal meal, final int userId);

	UserMeal create(final UserMeal meal, final int userId);

	List<UserMeal> getBetween(final LocalDateTime startDate, final LocalDateTime endDate, final int userId);
}
