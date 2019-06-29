package javawebinar.topjava.service;

import javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

public interface UserMealService {
	UserMeal get(final int id, final int userId);

	void delete(final int id, final int userId);

	List<UserMeal> getAll(final int userId);

	void deleteAll(final int userId);

	UserMeal update(final UserMeal meal, final int userId);

	UserMeal save(final UserMeal meal, final int userId);

	List<UserMeal> getBetween(final LocalDateTime startDate, final LocalDateTime endDate, final int userId);
}
